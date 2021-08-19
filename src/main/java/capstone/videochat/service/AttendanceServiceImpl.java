package capstone.videochat.service;

import capstone.videochat.DTO.UserDTO;
import capstone.videochat.repository.MongoDBAttendanceRepository;


public class AttendanceServiceImpl implements AttendanceService{

    MongoDBAttendanceRepository attendanceRepository;

    public AttendanceServiceImpl(MongoDBAttendanceRepository attendanceRepository){
        this.attendanceRepository= attendanceRepository;
    }

    @Override
    public boolean checkFaceId(UserDTO userdto) {
        //opencv 기능
        return true;
    }

    @Override
    public boolean attend(UserDTO userdto) {
        this.attendanceRepository.save(userdto);
        return true;
    }
}
