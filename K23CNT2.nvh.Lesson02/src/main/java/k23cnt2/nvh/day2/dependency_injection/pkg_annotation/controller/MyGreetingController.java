package k23cnt2.nvh.day2.dependency_injection.pkg_annotation.controller;



import k23cnt2.nvh.day2.dependency_injection.pkg_annotation.service.MyGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyGreetingController {

    private final MyGreetingService myGreetingService;

    @Autowired
    public MyGreetingController(MyGreetingService myGreetingService) {
        this.myGreetingService = myGreetingService;
    }

    @GetMapping("/greeting")
    public String greeting() {
        return myGreetingService.greeting("Chung Trịnh");
    }
}

