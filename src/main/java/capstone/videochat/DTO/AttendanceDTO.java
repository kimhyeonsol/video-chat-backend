package capstone.videochat.DTO;

public class AttendanceDTO {
    String meetingRoomNum; //미팅룸 번호
    String userSessionId; //user 세션 id

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
