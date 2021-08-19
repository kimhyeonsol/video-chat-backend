package capstone.videochat.repository;

import capstone.videochat.domain.User;

public interface UserRepository {
    void save(User user);       //user 정보 저장
    User findById(String id);   //ID로 회원 찾음
}
