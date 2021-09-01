package capstone.videochat.service;

import capstone.videochat.DTO.*;
import capstone.videochat.domain.User;

import java.util.Date;

public interface UserService {
    void join(UserJoinDTO userJoinDTO); //회원가입
    boolean duplicateIdCheck(UserJoinDTO userJoinDTO); //중복된 ID인가 검사
    User checkUserWithSessionKey(String sessionId); //유효한 쿠키인지 검사
    void automaticLogin(String userId, String sessionId, Date sessionLimit); //DB에 쿠키 저장
    UserIdDTO recallUserId(UserSessionIdDTO userSessionIdDTO); //user id 불러오기
    UserNameDTO recallUserName(UserIdDTO userIdDTO); //user 이름 불러오기
    boolean login(UserLoginDTO userLoginDTO); //로그인
}

