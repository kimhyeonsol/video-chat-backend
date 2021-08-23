package capstone.videochat.repository;

import capstone.videochat.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoDBAttendanceRepository implements AttendanceRepository{

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void save(User user) {
        mongoTemplate.insert(user, "attendance");
    }
}
