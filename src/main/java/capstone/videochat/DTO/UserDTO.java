package capstone.videochat.DTO;

public class UserDTO {
    String id;
    String password;
    String name;
    String major;
    String studentId;
    byte[] faceFront;
    byte[] faceLeft;
    byte[] faceRight;

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

    public byte[] getFaceFront() {
        return faceFront;
    }

    public void setFaceFront(byte[] faceFront) {
        this.faceFront = faceFront;
    }

    public byte[] getFaceLeft() {
        return faceLeft;
    }

    public void setFaceLeft(byte[] faceLeft) {
        this.faceLeft = faceLeft;
    }

    public byte[] getFaceRight() {
        return faceRight;
    }

    public void setFaceRight(byte[] faceRight) {
        this.faceRight = faceRight;
    }

}
