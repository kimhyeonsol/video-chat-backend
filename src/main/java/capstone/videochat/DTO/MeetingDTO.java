package capstone.videochat.DTO;

import java.sql.Date;
import java.util.HashMap;

public class MeetingDTO {
    String meetingNumber;
    Date StartTime;
    HashMap<String,Boolean> Attendance;

    public String getMeetingNumber() {
        return meetingNumber;
    }

    public void setMeetingNumber(String meetingNumber) {
        this.meetingNumber = meetingNumber;
    }

    public Date getStartTime() {
        return StartTime;
    }

    public void setStartTime(Date startTime) {
        StartTime = startTime;
    }

    public HashMap<String, Boolean> getAttendance() {
        return Attendance;
    }

    public void setAttendance(HashMap<String, Boolean> attendance) {
        Attendance = attendance;
    }
}
