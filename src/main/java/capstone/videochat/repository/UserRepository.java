package capstone.videochat.repository;

import capstone.videochat.domain.User;

import java.util.Date;

public interface UserRepository {
    void save(User user);       //user 정보 저장
    User findById(String id);   //ID로 회원 찾음
    User findBySessionId(String sessionId); //sessionId로 회원 찾음
    User checkUserWithSessionKey(String sessionId);
    void update(String userId, String sessionId, Date sessionLimit);
}
