package capstone.videochat.service;

import capstone.videochat.DTO.UserIdDTO;
import capstone.videochat.DTO.UserSessionIdDTO;
import capstone.videochat.DTO.UserJoinDTO;
import capstone.videochat.DTO.UserLoginDTO;
import capstone.videochat.domain.User;

import java.util.Date;

public interface UserService {
    void join(UserJoinDTO userJoinDTO);
    boolean duplicateIdCheck(UserJoinDTO userJoinDTO); //중복된 ID인가 검사
    User checkUserWithSessionKey(String sessionId);
    void automaticLogin(String userId, String sessionId, Date sessionLimit);
    String recallName(String userId);
    UserIdDTO recallUserId(UserSessionIdDTO userSessionIdDTO);
    boolean login(UserLoginDTO userLoginDTO);
}

