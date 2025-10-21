package k23cnt2.nvh.day2.dependency_injection.pkg_annotation.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/my-param")
public class MyParamController {

    // Ví dụ: http://localhost:8080/my-param/query?name=Chung
    @GetMapping("/query")
    public String getQueryParam(@RequestParam String name) {
        return "Giá trị query param là: " + name;
    }

    // Ví dụ: http://localhost:8080/my-param/path/2209
    @GetMapping("/path/{id}")
    public String getPathParam(@PathVariable int id) {
        return "Giá trị path variable là: " + id;
    }
}
