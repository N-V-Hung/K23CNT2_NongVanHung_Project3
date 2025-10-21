package k23cnt2.nvh.day2.dependency_injection.pkg_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public String appName() {
        return "Spring Boot Annotation Demo";
    }
}
