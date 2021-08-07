package capstone.videochat.service;

import capstone.videochat.repository.UserRepository;

public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void join() {

    }

    @Override
    public void login() {

    }

    @Override
    public void loginByFaceId() {

    }

    @Override
    public void logOut() {

    }
}
