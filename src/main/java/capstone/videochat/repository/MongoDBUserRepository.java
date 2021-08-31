package capstone.videochat.repository;

import capstone.videochat.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Date;

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

        Criteria criteria = new Criteria("_id");
        criteria.is(id);

        Query query = new Query(criteria);
        findUser = mongoTemplate.findOne(query, User.class, "user");

        return findUser;
    }

    @Override
    public User findBySessionId(String sessionId) {
        User findUser;

        Criteria criteria = new Criteria("sessionId");
        criteria.is(sessionId);

        Query query = new Query(criteria);
        findUser = mongoTemplate.findOne(query, User.class, "user");

        return findUser;
    }

    @Override
    public User checkUserWithSessionKey(String sessionId) {
        User findUser;

        Criteria criteria = new Criteria("sessionId");
        criteria.is(sessionId);

        Query query = new Query(criteria);
        findUser = mongoTemplate.findOne(query, User.class, "user");

        Date currentTime = new Date();
        if(currentTime.before(findUser.getValidTime())){ //현재 시간이 유효 시간보다 전인 경우 true
            return findUser;
        }

        return null;
    }

    @Override
    public void update(String userId, String sessionId, Date sessionLimit) {
        Criteria criteria = new Criteria("_id");
        criteria.is(userId);

        Query queryId = new Query(criteria);
        Update updateId = new Update();
        updateId.set("sessionId", sessionId);

        mongoTemplate.updateMulti(queryId, updateId, "user");

        Query queryLimit = new Query(criteria);
        Update updateLimit = new Update();
        updateLimit.set("validTime", sessionLimit);

        mongoTemplate.updateMulti(queryLimit, updateLimit, "user");
    }
}
