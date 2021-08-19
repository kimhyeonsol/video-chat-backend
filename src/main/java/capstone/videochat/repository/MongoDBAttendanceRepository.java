package capstone.videochat.repository;

import capstone.videochat.DTO.UserDTO;
import capstone.videochat.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoDBAttendanceRepository implements AttendanceRepository{

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void save(UserDTO userdto) {
        mongoTemplate.insert(userdto, "attendance");
    }
}
