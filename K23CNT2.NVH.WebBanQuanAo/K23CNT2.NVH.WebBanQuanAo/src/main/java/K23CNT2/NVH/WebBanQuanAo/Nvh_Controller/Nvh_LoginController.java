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
public class Nvh_LoginController {

    private final Nvh_UserService userService;

    // Hiển thị trang login
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // Xử lý login
    @PostMapping("/login")
    public String loginProcess(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ) {

        Nvh_Users user = userService.findByUsername(username);

        if (user == null) {
            model.addAttribute("error", "Sai tên đăng nhập!");
            return "login";
        }

        if (!user.getNvh_password().equals(password)) {
            model.addAttribute("error", "Sai mật khẩu!");
            return "login";
        }

        model.addAttribute("success", "Đăng nhập thành công!");
        return "redirect:/"; // chuyển sang trang chủ
    }
}
