package capstone.videochat.service;

import capstone.videochat.DTO.AttendanceDTO;
import capstone.videochat.domain.Attendance;
import capstone.videochat.domain.User;

public interface AttendanceService {
    boolean checkFaceId(User user);
    boolean attend(AttendanceDTO attendanceDTO);
}
