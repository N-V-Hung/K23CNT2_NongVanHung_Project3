package K23CNT2.nvh.WebBanQuanAo.Nvh_Controller;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.NvhOrders;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Service.NvhOrdersService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/nvh-user")
public class NvhUserOrdersController {

    @Autowired
    private NvhOrdersService nvhOrdersService;

    @GetMapping("/orders")
    public String nvhUserOrders(HttpSession session, Model model) {

        Long userId = (Long) session.getAttribute("nvhUserId");
        if (userId == null) return "redirect:/nvh-login";

        List<NvhOrders> orders = nvhOrdersService.nvhFindByCustomerId(userId);

        model.addAttribute("orders", orders);
        return "nvhUser/nvh_orders_user";
    }
}
