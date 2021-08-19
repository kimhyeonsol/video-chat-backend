package capstone.videochat.DTO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "member") //컬렉션 이름
public class UserDTO {
    @Id
    String id; //PRIMARY KEY
    String password;
    String name;
    String major;
    String studentId;
    byte[] faceFront_1;
    byte[] faceFront_2;
    byte[] faceFront_3;


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

    public byte[] getFaceFront_1() {
        return faceFront_1;
    }

    public void setFaceFront_1(byte[] faceFront_1) {
        this.faceFront_1 = faceFront_1;
    }

    public byte[] getFaceFront_2() {
        return faceFront_2;
    }

    public void setFaceFront_2(byte[] faceFront_2) {
        this.faceFront_2 = faceFront_2;
    }

    public byte[] getFaceFront_3() {
        return faceFront_3;
    }

    public void setFaceFront_3(byte[] faceFront_3) {
        this.faceFront_3 = faceFront_3;
    }

}