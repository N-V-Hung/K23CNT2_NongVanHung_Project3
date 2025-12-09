package K23CNT2.nvh.WebBanQuanAo.Nvh_Controller;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.NvhCustomer;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Service.NvhCustomerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NvhLoginController {

    @Autowired
    private NvhCustomerService nvhCustomerService;

    // ===============================
    // LOGIN PAGE
    // ===============================
    @GetMapping("/nvh-login")
    public String nvhLoginPage(Model model) {
        model.addAttribute("nvhLoginForm", new NvhCustomer());
        return "nvhLayout/nvh_login";
    }

    // ===============================
    // LOGIN ACTION
    // ===============================
    @PostMapping("/nvh-login")
    public String nvhLoginAction(
            @RequestParam("nvhEmail") String nvhEmail,
            @RequestParam("nvhPassword") String nvhPassword,
            HttpSession session,
            Model model) {

        NvhCustomer nvhUser = nvhCustomerService.nvhLogin(nvhEmail, nvhPassword);

        if (nvhUser == null) {
            model.addAttribute("nvhError", "Sai email hoặc mật khẩu!");
            return "nvhLayout/nvh_login";
        }


        if (nvhUser.getNvhStatus() != null && nvhUser.getNvhStatus() == 0) {
            model.addAttribute("nvhError", "Tài khoản đã bị khóa!");
            return "nvhLayout/nvh_login";
        }


        // Lưu SESSION
        session.setAttribute("nvhUserId", nvhUser.getNvhId());
        session.setAttribute("nvhUserEmail", nvhUser.getNvhEmail());
        session.setAttribute("nvhUserName", nvhUser.getNvhName());
        session.setAttribute("nvhUserRole", nvhUser.getNvhRole());

        // Chuyển trang theo ROLE
        if ("ADMIN".equalsIgnoreCase(nvhUser.getNvhRole())) {
            return "redirect:/nvh-admin-home";
        } else {
            return "redirect:/nvh-user-home";
        }

    }

    // ===============================
    // REGISTER PAGE
    // ===============================
    @GetMapping("/nvh-register")
    public String nvhRegisterPage(Model model) {
        model.addAttribute("nvhRegisterForm", new NvhCustomer());
        return "nvhLayout/nvh_register";
    }

    // ===============================
    // REGISTER ACTION
    // ===============================
    @PostMapping("/nvh-register")
    public String nvhRegisterAction(
            @ModelAttribute("nvhRegisterForm") NvhCustomer req,
            Model model) {

        if (nvhCustomerService.existsByEmail(req.getNvhEmail())) {
            model.addAttribute("nvhError", "Email đã tồn tại!");
            return "nvhLayout/nvh_register";
        }

        req.setNvhRole("USER");
        req.setNvhStatus(1);
        nvhCustomerService.nvhSave(req);

        return "redirect:/nvh-login";
    }

    // ===============================
    // LOGOUT
    // ===============================
    @GetMapping("/nvh-logout")
    public String nvhLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/nvh-login";
    }
}
