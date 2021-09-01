package capstone.videochat.controller;

import capstone.videochat.DTO.*;
import capstone.videochat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin("*")
    @PostMapping("/user/new-account")
    @ResponseBody
    public boolean processCreateAccount(@RequestBody final UserJoinDTO userJoinDTO){
        //중복체크
        if (userService.duplicateIdCheck(userJoinDTO)==false){
            return false;
        }
        //회원가입
        userService.join(userJoinDTO);

        return true;
    }

    @CrossOrigin("*")
    @PostMapping("/user/login")
    @ResponseBody
    public UserCookieDTO processLogIn(@RequestBody final UserLoginDTO userLoginDTO, HttpServletRequest request, HttpServletResponse response) {
        //로그인
        UserCookieDTO userCookieDTO = new UserCookieDTO();

        boolean result = userService.login(userLoginDTO);

        userCookieDTO.setLoginResult(result);
        userCookieDTO.setCookieName(null);
        userCookieDTO.setSessionId(null);
        userCookieDTO.setValidTime(null);

        if(result) { //로그인 성공 시
            HttpSession session = request.getSession();
            session.setAttribute("userId", userLoginDTO.getId()); //세션에 user 정보 저장

            if (session.getAttribute("userId") !=null){ //userID 세션 값 존재하면
                session.removeAttribute("userId");// 기존값 제거
            }

            if(userLoginDTO.getUseCookie()) { //자동 로그인 체크했을 시
                //Cookie cookie = new Cookie("loginCookie", session.getId());
                //cookie.setPath("/");
                int amount = 60*60*24*7;
                //cookie.setMaxAge(amount); //쿠키 유효시간 7일
                //response.addCookie(cookie); //쿠키 적용

                Date sessionLimit = new Date(System.currentTimeMillis() + (1000*amount));

                userService.automaticLogin(userLoginDTO.getId(), session.getId(), sessionLimit);

                userCookieDTO.setCookieName("loginCookie");
                userCookieDTO.setSessionId(session.getId());
                userCookieDTO.setValidTime(sessionLimit);
            }
            else if(userLoginDTO.getUseCookie() == false) { //자동 로그인 해제했을 시
                Date sessionLimit =new Date(System.currentTimeMillis());
                userService.automaticLogin(userLoginDTO.getId(), session.getId(), sessionLimit);
            }
        }

        return userCookieDTO;
    }

    @CrossOrigin("*")
    @PostMapping("/user/getName")
    @ResponseBody
    public UserNameDTO responseUserName(@RequestBody final UserIdDTO UserIdDTO){
        return userService.recallUserName(UserIdDTO);
    }

    @CrossOrigin("*")
    @PostMapping("/user/rememberId")
    @ResponseBody
    public UserIdDTO responseUserId(@RequestBody final UserSessionIdDTO userSessionIdDTO){
        return userService.recallUserId(userSessionIdDTO);
    }

    @CrossOrigin("*")
    @GetMapping("/user/logout")
    @ResponseBody
    public void logOut(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Logout!");
        HttpSession session = request.getSession();
        session.invalidate(); //세션에 유지된 정보 삭제
    }
}