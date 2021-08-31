package capstone.videochat.service;

import capstone.videochat.domain.Attendance;
import capstone.videochat.domain.User;
import capstone.videochat.repository.MongoDBAttendanceRepository;


public class AttendanceServiceImpl implements AttendanceService{

    MongoDBAttendanceRepository attendanceRepository;

    public AttendanceServiceImpl(MongoDBAttendanceRepository attendanceRepository){
        this.attendanceRepository= attendanceRepository;
    }

    @Override
    public boolean checkFaceId(User user) {
        //opencv 기능
        return true;
    }

    @Override
    public boolean attend(Attendance attendance) {
        this.attendanceRepository.save(attendance);
        return true;
    }
}
