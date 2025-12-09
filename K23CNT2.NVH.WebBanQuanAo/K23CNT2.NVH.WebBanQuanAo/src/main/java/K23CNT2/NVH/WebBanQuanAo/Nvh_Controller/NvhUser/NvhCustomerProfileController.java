package K23CNT2.nvh.WebBanQuanAo.Nvh_Controller.NvhUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class NvhUserController {

    @Autowired
    private NvhUserService userService;

    // Hiển thị Profile
    @GetMapping("/nvh-profile")
    public String showProfile(Model model, Principal principal) {

        String email = principal.getName();  // lấy email đăng nhập
        NvhUsers user = userService.findByEmail(email);

        model.addAttribute("nvhUser", user);
        return "user/nvh-profile";
    }

    // Cập nhật Profile
    @PostMapping("/nvh-profile/update")
    public String updateProfile(@ModelAttribute("nvhUser") NvhUsers user) {

        userService.updateUser(user);
        return "redirect:/nvh-profile?success";
    }
}

