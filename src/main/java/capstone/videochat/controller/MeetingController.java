package capstone.videochat.controller;

import capstone.videochat.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class MeetingController {
    MeetingService meetingService;

    @Autowired
    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @RequestMapping("/meeting/new")
    @ResponseBody
    public void startMeeting(){

    }

    @RequestMapping("meeting/number")
    @ResponseBody
    public void getMeetingNumber(){

    }

    @RequestMapping("meeting/join")
    @ResponseBody
    public void joinMeeting(){

    }

    @RequestMapping("meeting//attendance")
    @ResponseBody
    public void getAttendance(){

    }
}
