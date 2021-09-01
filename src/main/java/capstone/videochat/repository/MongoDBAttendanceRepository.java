package capstone.videochat.repository;

import capstone.videochat.DTO.AttendanceDTO;
import capstone.videochat.domain.Attendance;
import capstone.videochat.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class MongoDBAttendanceRepository implements AttendanceRepository{
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public String findById(String userId) {
        User findUser;

        Criteria criteria = new Criteria("_id");
        criteria.is(userId);

        Query query = new Query(criteria);
        findUser = mongoTemplate.findOne(query, User.class, "user");

        return findUser.getStudentId();
    }


    @Override
    public void save(AttendanceDTO attendanceDTO) {
        mongoTemplate.insert(attendanceDTO, "attendance");
    }
}
