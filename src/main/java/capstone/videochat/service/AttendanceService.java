package capstone.videochat.service;

import capstone.videochat.DTO.UserDTO;

public interface AttendanceService {
    boolean checkFaceId(UserDTO userdto);
    boolean attend(UserDTO userdto);
}
