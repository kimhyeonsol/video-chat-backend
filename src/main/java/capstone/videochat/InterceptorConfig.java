package capstone.videochat;

import capstone.videochat.interceptor.AutomaticLoginInterceptor;
import capstone.videochat.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    UserService userService;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AutomaticLoginInterceptor(userService))
                .addPathPatterns("/user/login");
    }
}
