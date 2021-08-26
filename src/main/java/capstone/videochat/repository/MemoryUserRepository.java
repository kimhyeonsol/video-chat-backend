package capstone.videochat.repository;

import capstone.videochat.domain.User;

import java.util.Date;

public class MemoryUserRepository implements UserRepository {

    @Override
    public void save(User user) {
    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public User findBySessionId(String sessionId) {
        return null;
    }

    @Override
    public User checkUserWithSessionKey(String sessionId) {
        return null;
    }

    @Override
    public void update(String userId, String sessionId, Date sessionLimit) {

    }
}
