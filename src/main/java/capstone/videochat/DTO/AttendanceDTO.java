package capstone.videochat.DTO;

public class AttendanceDTO {
    String meetingRoomNum;
    String userSessionId;

    public String getMeetingRoomNum() {
        return meetingRoomNum;
    }

    public void setMeetingRoomNum(String meetingRoomNum) {
        this.meetingRoomNum = meetingRoomNum;
    }

    public String getUserSessionId() {
        return userSessionId;
    }

    public void setUserSessionId(String userSessionId) {
        this.userSessionId = userSessionId;
    }

}
