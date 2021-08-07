package capstone.videochat.service;

import capstone.videochat.repository.MeetingRepository;

public class MeetingServiceImpl implements MeetingService{
    MeetingRepository meetingRepository;

    public MeetingServiceImpl(MeetingRepository meetingRepository){
        this.meetingRepository = meetingRepository;
    }

    @Override
    public void createMeeting() {

    }

    @Override
    public void getMeetingNumber() {

    }

    @Override
    public void joinMeeting() {

    }

    @Override
    public void getAttendees() {

    }
}
