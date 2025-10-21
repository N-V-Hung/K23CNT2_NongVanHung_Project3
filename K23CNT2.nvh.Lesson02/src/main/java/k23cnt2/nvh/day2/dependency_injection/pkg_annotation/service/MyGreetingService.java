package k23cnt2.nvh.day2.dependency_injection.pkg_annotation.service;

import org.springframework.stereotype.Service;

@Service
public class MyGreetingService {
    public String greeting(String name) {
        return "Xin chào " + name + " đến với Devmaster!";
    }
}
