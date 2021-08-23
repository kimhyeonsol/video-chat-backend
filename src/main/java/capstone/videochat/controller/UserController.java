package capstone.videochat.controller;

import capstone.videochat.domain.User;
import capstone.videochat.service.MeetingService;
import capstone.videochat.service.UserService;
import capstone.videochat.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/user/new-account")
//    @ResponseBody
//    public void displayCreateAccountPage(){
//        //회원가입 페이지 렌더링
//    }

    @PostMapping("/user/new-account")
    @ResponseBody
    public boolean processCreateAccount(@RequestBody final User user){
        //중복체크
        if (userService.duplicateIdCheck(user)==false){
            return false;
        }
        //회원가입
        userService.join(user);
        return true;
    }

//    @GetMapping("/user/login")
//    @ResponseBody
//    public void displayLogInPage(){
//        //로그인 페이지 렌더링
//    }

    @PostMapping("/user/login")
    @ResponseBody
    public boolean processLogIn(@RequestBody final User user, HttpServletRequest request) {
        //로그인
        HttpSession session = request.getSession();
        session.setAttribute("user", user); //세션에 user 정보 저장
        return userService.login(user);
    }

    @GetMapping("/user/logout")
    @ResponseBody
    public void logOut(HttpServletRequest request){
        //로그아웃 로그인 페이지 렌더링
        HttpSession session = request.getSession();
        session.removeAttribute("user"); //세션에 유지된 user 정보 삭제
        session.invalidate();
    }
}
