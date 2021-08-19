package capstone.videochat.repository;

import capstone.videochat.domain.User;

public class MemoryUserRepository implements UserRepository {

    @Override
    public void save(User user) {
    }

    @Override
    public User findById(String id) {
        return null;
    }
}
