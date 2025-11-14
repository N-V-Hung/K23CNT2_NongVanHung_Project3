package K23CNT2.nvhDay05.K23CNT2.nvhDay05.controller;


import K23CNT2.nvhDay05.K23CNT2.nvhDay05.entity.Info;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class HomeController {
    @GetMapping
    public String index(){
        return "index";
    }


    @GetMapping("/profile")
    public  String profile(Model model){
        List<Info> profile = new ArrayList<>();
        //tao thong tin
        profile.add(new Info("Devmaster Academy",
                "dev",
                "contact@devmaster.edu.vn",
                "https://devmaster.edu.vn"));

        // uda profile vao model
        model.addAttribute("nvhProfile",profile);
        return "profile";
    }
}
