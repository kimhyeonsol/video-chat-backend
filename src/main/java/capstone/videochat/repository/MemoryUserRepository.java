package capstone.videochat.repository;

import capstone.videochat.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Optional;

public class MemoryUserRepository implements UserRepository {

    @Override
    public void save(User user) {
    }

    @Override
    public User findById(String id) {
        return null;
    }
}
