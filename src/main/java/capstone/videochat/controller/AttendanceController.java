package capstone.videochat.controller;



import capstone.videochat.DTO.AttendanceDTO;
import capstone.videochat.domain.Attendance;
import capstone.videochat.service.AttendanceService;
import capstone.videochat.domain.User;

import capstone.videochat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AttendanceController {
    AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("attendance/checkFaceId")
    @ResponseBody
    public void processCheckFaceId(@RequestBody User user){
        //faceid check
    }

    @PostMapping("attendance/attend")
    @ResponseBody
    public void processAttend(@RequestBody AttendanceDTO attendanceDTO){
        attendanceService.attend(attendanceDTO);
    }
}
