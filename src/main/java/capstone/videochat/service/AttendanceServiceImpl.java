package capstone.videochat.service;

import capstone.videochat.DTO.AttendanceDTO;
import capstone.videochat.domain.Attendance;
import capstone.videochat.domain.User;
import capstone.videochat.repository.MongoDBAttendanceRepository;
import capstone.videochat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


public class AttendanceServiceImpl implements AttendanceService{

    @Autowired
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
    public boolean attend(AttendanceDTO attendanceDTO) {
        Attendance attendance=new Attendance();
        Date attendTime =new Date(System.currentTimeMillis());

        attendance.setMeetingRoom_id(attendanceDTO.getMeetingRoomNum());
        attendance.setStudentId(attendanceRepository.findById(attendanceDTO.getUserId()));
        attendance.setDate(attendTime);
        this.attendanceRepository.save(attendanceDTO);
        return true;
    }
}
