package k23cnt2.nvh.day2.dependency_injection.ioc_spring;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {
    public String greet(String name) {
        return "<h2>Spring Boot says:</h2> <h1 style='color:red'>" + name + "</h1>";
    }
}

