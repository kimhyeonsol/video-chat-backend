package capstone.videochat.DTO;


import capstone.videochat.domain.Room;

import java.util.Set;

public class MainRoomDTO {
    private Long id;
    private Set<Room> rooms;
    private String uuid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
