package capstone.videochat.interceptor;

import capstone.videochat.domain.User;
import capstone.videochat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AutomaticLoginInterceptor extends HandlerInterceptorAdapter {
    UserService userService;

    @Autowired
    public AutomaticLoginInterceptor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //컨트롤러보다 먼저 수행되는 메서드
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("userId");

        if (obj ==null){ // 로그인된 세션이 없는 경우
            Cookie loginCookie = WebUtils.getCookie(request,"loginCookie"); //쿠키 꺼내옴
            if ( loginCookie !=null ){// 쿠키가 존재하는 경우
                String sessionId = loginCookie.getValue(); //저장했었던 session id 꺼내옴
                User user = userService.checkUserWithSessionKey(sessionId); //유효시간 지나지 않으면 user 반환

                if (user !=null){
                    session.setAttribute("userId", user.getId()); //세션 생성
                    return true;
                }
            }
            return true;
        }

        return true;
    }
}
