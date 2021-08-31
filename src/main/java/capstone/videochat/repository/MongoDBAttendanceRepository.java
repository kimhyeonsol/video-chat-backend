package capstone.videochat.repository;

import capstone.videochat.domain.Attendance;
import capstone.videochat.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoDBAttendanceRepository implements AttendanceRepository{

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void save(Attendance attendance) {
        mongoTemplate.insert(attendance, "attendance");
    }
}
