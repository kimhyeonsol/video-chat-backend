package capstone.videochat.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "attendance") //컬렉션 이름
public class Attendance {
    @Id
    String _id; //PRIMARY KEY
<<<<<<< Updated upstream
    String meetingRoom_id; //미팅룸 번호
    String studentId; //User 컬렉션의 학번 저장
    String date; //미팅룸 출석 날짜
=======
    String meetingRoom_id;
    String studentId; //Member 컬렉션의 학번 저장
    Date date;

>>>>>>> Stashed changes

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
<<<<<<< Updated upstream
}
=======

}
>>>>>>> Stashed changes
