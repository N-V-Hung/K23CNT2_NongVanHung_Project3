package K23CNT2.nvh.WebBanQuanAo.Nvh_Controller.NvhAdmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nvh-admin/users")
public class NvhAdminUserController {

    @Autowired
    private NvhUsersService userService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("nvhUsers", userService.findAllUsers());
        return "admin/nvh-users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/nvh-admin/users";
    }
}
