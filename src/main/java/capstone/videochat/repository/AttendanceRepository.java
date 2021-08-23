package capstone.videochat.repository;

import capstone.videochat.domain.User;

public interface AttendanceRepository {
    void save(User user);
}
