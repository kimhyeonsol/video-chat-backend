package capstone.videochat.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "attendance") //컬렉션 이름
public class Attendance {
    @Id
    String _id; //PRIMARY KEY
    String meetingRoom_id;
    String studentId; //Member 컬렉션의 학번 저장
    String date;
    String attendance_status;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getMeetingRoom_id() {
        return meetingRoom_id;
    }

    public void setMeetingRoom_id(String meetingRoom_id) {
        this.meetingRoom_id = meetingRoom_id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAttendance() {
        return attendance_status;
    }

    public void setAttendance(String attendance_status) {
        this.attendance_status = attendance_status;
    }
}
