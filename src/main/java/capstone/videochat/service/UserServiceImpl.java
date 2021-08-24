package capstone.videochat.service;

import capstone.videochat.domain.User;
import capstone.videochat.repository.MongoDBUserRepository;
import capstone.videochat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void join(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean duplicateIdCheck(User user) {
        User findUser;
        System.out.println("service:"+user.getId());

        findUser = userRepository.findById(user.getId());
        if(findUser!=null){
            System.out.println("이미 존재하는 ID입니다!");
            return false;
        }
        return true;
    }

    @Override
    public boolean login(User user) {
        User findUser;
        findUser = userRepository.findById(user.getId());

        if(Objects.equals(findUser.getPassword(), user.getPassword())){
            System.out.println("로그인 성공!");
            return true;
        }

        return false;
    }

    @Override
    public void logOut() {

    }
}
