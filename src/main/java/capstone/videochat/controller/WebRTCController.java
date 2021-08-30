package capstone.videochat.controller;

import capstone.videochat.DTO.MainRoomDTO;
import capstone.videochat.DTO.SelectRoomDTO;
import capstone.videochat.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebRTCController {

    RoomService roomService;

    @Autowired
    public WebRTCController(RoomService roomService) {
        this.roomService = roomService;
    }

    /*
     * 메인 화면
     * id - 방넘버, rooms - 방 리스트, uuid - 유저 아이디
     * */

    @GetMapping(value = "/room")
    @ResponseBody
    public MainRoomDTO createRoom(final Long id, final String uuid) {
        System.out.println("id = " + id + ", uuid = " + uuid);
        return this.roomService.displayMainPageElement(id, uuid);
    }

    /*
     * 새로운 방 생성
     * */
    @PostMapping(value = "/room")
    @ResponseBody
    public MainRoomDTO processRoomSelection(@ModelAttribute("id") final String sid, @ModelAttribute("uuid") final String uuid, final BindingResult binding) {
        return this.roomService.processRoomSelection(sid, uuid, binding);
    }

    /*
     *  방 입장
     *  main.html 에서 방에 입장 하는 버튼을 클릭 하면, main.js에서 기존에 href 로 설정 되어있는 'room/{sid}' url에 user/{uuid} 를 더해 아래 메서드로 매핑된다.
     * */
    @GetMapping("/room/{sid}/user/{uuid}")
    @ResponseBody
    public SelectRoomDTO displaySelectedRoom(@PathVariable("sid") final String sid, @PathVariable("uuid") final String uuid) {
        return this.roomService.displaySelectedRoom(sid, uuid);
    }

    /*
     * 방 나가기
     * */
    @GetMapping("/room/{sid}/user/{uuid}/exit")
    @ResponseBody
    public MainRoomDTO processRoomExit(@PathVariable("sid") final String sid, @PathVariable("uuid") final String uuid) {
        return this.roomService.processRoomExit(sid, uuid);
    }

    @GetMapping("/room/random")
    @ResponseBody
    public MainRoomDTO requestRandomRoomNumber(@ModelAttribute("uuid") final String uuid) {
        return roomService.requestRandomRoomNumber(uuid);
    }

    @GetMapping("/offer")
    public String displaySampleSdpOffer() {
        return"sdp_offer";
    }

    @GetMapping("/stream")
    public String displaySampleStreaming() {
        return "streaming";
    }
}
