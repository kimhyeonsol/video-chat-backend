package capstone.videochat;

import capstone.videochat.repository.MeetingRepository;
import capstone.videochat.repository.MemoryMeetingRepository;
import capstone.videochat.repository.MemoryUserRepository;
import capstone.videochat.repository.UserRepository;
import capstone.videochat.repository.MongoDBAttendanceRepository;

import capstone.videochat.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository());
    }

    @Bean
    public MeetingService meetingService() {
        return new MeetingServiceImpl(meetingRepository());
    }

    @Bean
    public AttendanceService attendanceService() {
        return new AttendanceServiceImpl(attendanceRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new MemoryUserRepository();
    }

    @Bean
    public MeetingRepository meetingRepository() {
        return new MemoryMeetingRepository();
    }

    @Bean
    public MongoDBAttendanceRepository attendanceRepository() {
        return new MongoDBAttendanceRepository();
    }
}
