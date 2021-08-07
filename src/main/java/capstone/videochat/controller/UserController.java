package capstone.videochat.controller;

import capstone.videochat.service.MeetingService;
import capstone.videochat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user/new-account")
    @ResponseBody
    public void createAccount(){

    }

    @RequestMapping("/user/login")
    @ResponseBody
    public void logIn(){

    }

    @RequestMapping("/user/login-face")
    @ResponseBody
    public void logInByFaceId(){

    }

    @RequestMapping("/user/logout")
    @ResponseBody
    public void logOut(){

    }
}
