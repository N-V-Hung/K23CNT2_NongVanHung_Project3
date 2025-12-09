package K23CNT2.nvh.WebBanQuanAo.Nvh_Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NvhAdminHomeController {

    @GetMapping("/nvh-admin-home")
    public String nvhAdminHome(HttpSession session) {

        // Chỉ cho admin vào
        if (session.getAttribute("nvhUserRole") == null ||
                !"ADMIN".equalsIgnoreCase(session.getAttribute("nvhUserRole").toString())) {
            return "redirect:/nvh-login";
        }

        return "nvhAdmin/nvh_admin_home";
    }
}
