package capstone.videochat.repository;

import capstone.videochat.DTO.UserDTO;

public interface AttendanceRepository {
    void save(UserDTO userdto);
}
