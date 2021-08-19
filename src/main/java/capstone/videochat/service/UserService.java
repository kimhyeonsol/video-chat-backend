package capstone.videochat.service;


import capstone.videochat.domain.User;

public interface UserService {
    void join(User user);
    boolean duplicateIdCheck(User user); //중복된 ID인가 검사
    boolean login(User user);
    void logOut();
}
