package capstone.videochat;

import capstone.videochat.repository.*;

import capstone.videochat.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.MongoDbFactoryParser;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

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
        return new MongoDBUserRepository();
    }

    @Bean
    public MeetingRepository meetingRepository() {
        return new MemoryMeetingRepository();
    }

    @Bean
    public MongoDBAttendanceRepository attendanceRepository() {
        return new MongoDBAttendanceRepository();
    }


    //mongo db config

    @Value("${mongodb.test.connectionString}")
    private String connectionString;

    @Bean
    public MongoDatabaseFactory mongoDatabaseFactory(){
        return new SimpleMongoClientDatabaseFactory(connectionString);
    }

    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoDatabaseFactory());
    }

}
