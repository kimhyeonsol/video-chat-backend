package capstone.videochat.service;

import capstone.videochat.DTO.MainRoomDTO;
import capstone.videochat.DTO.SelectRoomDTO;
import capstone.videochat.domain.Room;
import capstone.videochat.util.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.socket.WebSocketSession;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class RoomService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Parser parser;
    // repository substitution since this is a very simple realization
    private final Set<Room> rooms = new TreeSet<>(Comparator.comparing(Room::getId));

    @Autowired
    public RoomService(final Parser parser) {
        this.parser = parser;
    }


    public MainRoomDTO displayMainPageElement(final Long roomId, final String uuid) {
        final MainRoomDTO mainRoomDTO = new MainRoomDTO();

        mainRoomDTO.setId(roomId);
        mainRoomDTO.setRooms(this.getRooms());
        mainRoomDTO.setUuid(uuid);

        return mainRoomDTO;
    }

    public MainRoomDTO processRoomSelection(final String sid, final String uuid, final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // simplified version, no errors processing
            return new MainRoomDTO();
        }

        Optional<Long> optionalId = parser.parseId(sid);
        optionalId.ifPresent(id -> Optional.ofNullable(uuid).ifPresent(name -> this.addRoom(new Room(id))));

        return displayMainPageElement(optionalId.orElse(null), uuid);
    }


    public SelectRoomDTO displaySelectedRoom(final String selectId, final String uuid) {
        // redirect to main page if provided data is invalid

        SelectRoomDTO selectRoomDTO = new SelectRoomDTO();

        if (parser.parseId(selectId).isPresent()) {
            Room room = this.findRoomByStringId(selectId).orElse(null);
            if(room != null && uuid != null && !uuid.isEmpty()) {
                logger.debug("User {} is going to join Room #{}", uuid, selectId);
                // open the chat room
                selectRoomDTO.setSelectId(selectId);
                selectRoomDTO.setUuid(uuid);
            }
        }

        return selectRoomDTO;
    }

    public MainRoomDTO processRoomExit(final String selectId, final String uuid) {
        if(selectId != null && uuid != null) {
            logger.debug("User {} has left Room #{}", uuid, selectId);
            // implement any logic you need
        }
        return displayMainPageElement(parser.parseId(selectId).get(),uuid);
    }

    public MainRoomDTO requestRandomRoomNumber(final String uuid) {
        return this.displayMainPageElement(randomValue(), uuid);
    }

    private Long randomValue() {
        return ThreadLocalRandom.current().nextLong(0, 100);
    }

    public Set<Room> getRooms() {
        final TreeSet<Room> defensiveCopy = new TreeSet<>(Comparator.comparing(Room::getId));
        defensiveCopy.addAll(rooms);

        return defensiveCopy;
    }

    public Boolean addRoom(final Room room) {
        return rooms.add(room);
    }

    public Optional<Room> findRoomByStringId(final String sid) {
        // simple get() because of parser errors handling
        return rooms.stream().filter(r -> r.getId().equals(parser.parseId(sid).get())).findAny();
    }

    public Long getRoomId(Room room) {
        return room.getId();
    }

    public Map<String, WebSocketSession> getClients(final Room room) {
        return Optional.ofNullable(room)
                .map(r -> Collections.unmodifiableMap(r.getClients()))
                .orElse(Collections.emptyMap());
    }

    public WebSocketSession addClient(final Room room, final String name, final WebSocketSession session) {
        return room.getClients().put(name, session);
    }

    public WebSocketSession removeClientByName(final Room room, final String name) {
        return room.getClients().remove(name);
    }
}
