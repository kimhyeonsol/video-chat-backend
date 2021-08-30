package capstone.videochat.service;

import capstone.videochat.DTO.*;
import capstone.videochat.domain.User;
import capstone.videochat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Objects;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void join(UserJoinDTO userJoinDTO) {
        User user = new User();
        user.setId(userJoinDTO.getId());
        user.setPassword(userJoinDTO.getPassword());
        user.setName(userJoinDTO.getName());
        user.setMajor(userJoinDTO.getMajor());
        user.setStudentId(userJoinDTO.getStudentId());
        user.setFaceImage_1(userJoinDTO.getFaceImage_1());
        user.setFaceImage_2(userJoinDTO.getFaceImage_2());
        user.setFaceImage_3(userJoinDTO.getFaceImage_3());

        userRepository.save(user);
    }

    @Override
    public boolean duplicateIdCheck(UserJoinDTO userJoinDTO) {
        User findUser;

        findUser = userRepository.findById(userJoinDTO.getId());
        if(findUser!=null){
            System.out.println("이미 존재하는 ID입니다!");
            return false;
        }
        return true;
    }

    @Override
    public User checkUserWithSessionKey(String sessionId) {
        return userRepository.checkUserWithSessionKey(sessionId);
    }

    @Override
    public void automaticLogin(String userId, String sessionId, Date sessionLimit) {
        userRepository.update(userId, sessionId, sessionLimit);
    }

    @Override
    public String recallName(String userId) {
        User findUser;

        findUser = userRepository.findById(userId);

        return findUser.getName();
    }

    @Override
    public UserIdDTO recallUserId(UserSessionIdDTO userSessionIdDTO) {
        User findUser;
        UserIdDTO userIdDTO = new UserIdDTO();

        findUser = userRepository.findBySessionId(userSessionIdDTO.getSessionId());
        userIdDTO.setId(findUser.getId());

        return userIdDTO;
    }

    @Override
    public UserNameDTO responseUserName(UserIdDTO userIdDTO) {
        User findUser;
        UserNameDTO userNameDTO = new UserNameDTO();

        findUser = userRepository.findById(userIdDTO.getId());
        userNameDTO.setName(findUser.getName());

        return userNameDTO;
    }

    @Override
    public boolean login(UserLoginDTO userLoginDTO) {
        User findUser;

        findUser = userRepository.findById(userLoginDTO.getId());

        if(findUser == null){
            System.out.println("아이디 없음!");
            return false;
        }
        if(Objects.equals(findUser.getPassword(), userLoginDTO.getPassword())){
            System.out.println("로그인 성공!");
            return true;
        }

        return false;
    }
}
