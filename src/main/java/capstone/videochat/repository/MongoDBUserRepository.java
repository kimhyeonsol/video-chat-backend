package capstone.videochat.repository;

import capstone.videochat.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class MongoDBUserRepository implements UserRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void save(User user) {
        mongoTemplate.insert(user, "user");
    }

    @Override
    public User findById(String id) {
        User findUser;

        Criteria criteria = new Criteria("id");
        criteria.is(id);

        Query query = new Query(criteria);
        findUser = mongoTemplate.findOne(query, User.class, "user");

        return findUser;
    }
}
