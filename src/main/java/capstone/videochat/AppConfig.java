package capstone.videochat;

import capstone.videochat.repository.MeetingRepository;
import capstone.videochat.repository.MemoryMeetingRepository;
import capstone.videochat.repository.MemoryUserRepository;
import capstone.videochat.repository.UserRepository;
import capstone.videochat.service.MeetingService;
import capstone.videochat.service.MeetingServiceImpl;
import capstone.videochat.service.UserService;
import capstone.videochat.service.UserServiceImpl;
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
    public UserRepository userRepository() {
        return new MemoryUserRepository();
    }

    @Bean
    public MeetingRepository meetingRepository() {
        return new MemoryMeetingRepository();
    }
}
