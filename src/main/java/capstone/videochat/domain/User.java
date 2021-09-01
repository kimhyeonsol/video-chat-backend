package capstone.videochat.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "user") //컬렉션 이름
public class User {
    @Id
    private String id; //PRIMARY KEY
    private String password; //비밀번호
    private String name; //이름
    private String major; //학과
    private String studentId; //학번
    private String faceImage_1; //정면사진 1
    private String faceImage_2; //정면사진 2
    private String faceImage_3; //정면사진 3
    private String sessionId; //세션 id
    private Date validTime; //유효시간

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFaceImage_1() {
        return faceImage_1;
    }

    public void setFaceImage_1(String faceImage_1) {
        this.faceImage_1 = faceImage_1;
    }

    public String getFaceImage_2() {
        return faceImage_2;
    }

    public void setFaceImage_2(String faceImage_2) {
        this.faceImage_2 = faceImage_2;
    }

    public String getFaceImage_3() {
        return faceImage_3;
    }

    public void setFaceImage_3(String faceImage_3) {
        this.faceImage_3 = faceImage_3;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }
}
