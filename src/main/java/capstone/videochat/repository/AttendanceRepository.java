package capstone.videochat.repository;

import capstone.videochat.DTO.AttendanceDTO;
import capstone.videochat.domain.Attendance;


public interface AttendanceRepository {
    void save(AttendanceDTO attendanceDTO);
    String findBySessionId(String sessionId);
}
