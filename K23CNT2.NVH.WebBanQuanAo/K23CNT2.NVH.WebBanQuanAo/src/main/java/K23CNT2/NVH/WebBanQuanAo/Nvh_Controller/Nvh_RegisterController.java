package K23CNT2.nvh.WebBanQuanAo.Nvh_Controller;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Users;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Server.Nvh_UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class Nvh_RegisterController {

    private final Nvh_UserService userService;

    // Hiển thị trang đăng ký
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    // Xử lý đăng ký
    @PostMapping("/register")
    public String registerProcess(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String confirm,
            Model model) {

        if (!password.equals(confirm)) {
            model.addAttribute("error", "Mật khẩu không trùng khớp!");
            return "register";
        }

        if (userService.findByUsername(username) != null) {
            model.addAttribute("error", "Tên đăng nhập đã tồn tại!");
            return "register";
        }

        if (userService.findByEmail(email) != null) {
            model.addAttribute("error", "Email đã tồn tại!");
            return "register";
        }

        // Tạo user mới
        Nvh_Users newUser = new Nvh_Users();
        newUser.setNvh_username(username);
        newUser.setNvh_email(email);
        newUser.setNvh_password(password);
        newUser.setNvh_role("USER"); // mặc định là khách hàng

        userService.save(newUser);

        model.addAttribute("success", "Đăng ký thành công! Mời bạn đăng nhập.");
        return "login";
    }
}

