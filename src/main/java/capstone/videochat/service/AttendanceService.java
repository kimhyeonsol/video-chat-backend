package capstone.videochat.service;

import capstone.videochat.DTO.AttendanceDTO;
import capstone.videochat.DTO.FaceImageDTO;
import capstone.videochat.domain.Attendance;
import capstone.videochat.domain.User;

import java.io.IOException;

public interface AttendanceService {
    boolean checkFaceId(FaceImageDTO faceImageDTO) throws IOException;
    boolean attend(AttendanceDTO attendanceDTO);
}
