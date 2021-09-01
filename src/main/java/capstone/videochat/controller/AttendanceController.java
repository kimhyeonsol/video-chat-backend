package capstone.videochat.controller;



import capstone.videochat.DTO.AttendanceDTO;
import capstone.videochat.DTO.FaceImageDTO;
import capstone.videochat.domain.Attendance;
import capstone.videochat.service.AttendanceService;
import capstone.videochat.domain.User;

import capstone.videochat.service.FaceDetectionService;
import capstone.videochat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class AttendanceController {

    @Autowired AttendanceService attendanceService;
    @Autowired FaceDetectionService faceDetectionService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @CrossOrigin("*")
    @PostMapping("attendance/checkFaceId")
    @ResponseBody
    public boolean processCheckFaceId(@RequestBody FaceImageDTO faceImageDTO) throws IOException {
        final boolean isHuman = faceDetectionService.checkUserAttendance(faceImageDTO);
        return isHuman;
    }

    @PostMapping("attendance/attend")
    @ResponseBody
    public void processAttend(@RequestBody AttendanceDTO attendanceDTO){
        attendanceService.attend(attendanceDTO);
    }
}
