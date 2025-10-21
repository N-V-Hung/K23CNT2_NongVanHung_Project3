package k23cnt2.nvh.day2.dependency_injection.pkg_annotation.controller;

import k23cnt2.nvh.day2.dependency_injection.pkg_annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired  // Spring sẽ tự động inject bean UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<String> getAllUsers() {
        return userService.getUsers();
    }
}