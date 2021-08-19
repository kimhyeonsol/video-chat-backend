package capstone.videochat.controller;

import capstone.videochat.DTO.UserDTO;
import capstone.videochat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public class AttendanceController<AttendanceService> {
    AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("attendance/checkFaceId")
    @ResponseBody
    public void processCheckFaceId(@RequestBody UserDTO userdto){
        //faceid check
    }

    @PostMapping("attendance/attend")
    @ResponseBody
    public void processAttend(UserDTO userdto){
        //faceid check
    }
}
