package k23cnt2.nvh.day2.dependency_injection.pkg_annotation.service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    public List<String> getUsers() {
        return List.of("An", "Bình", "Chung", "Dương");
    }
}
