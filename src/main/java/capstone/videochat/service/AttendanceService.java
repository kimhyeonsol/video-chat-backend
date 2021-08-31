package capstone.videochat.service;

import capstone.videochat.domain.Attendance;
import capstone.videochat.domain.User;

public interface AttendanceService {
    boolean checkFaceId(User user);
    boolean attend(Attendance attendance);
}
