package K23CNT2.nvh.WebBanQuanAo.Nvh_Controller;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Service.*;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nvh-admin")
public class NvhAdminOrdersController {

    @Autowired
    private NvhOrdersService nvhOrdersService;

    @Autowired
    private NvhOrdersDetailsService nvhDetailsService;

    // ============ DANH SÁCH ĐƠN HÀNG =============
    @GetMapping("/orders")
    public String nvhAdminOrdersList(Model model) {

        List<NvhOrders> list = nvhOrdersService.nvhFindAll();
        model.addAttribute("orders", list);

        return "nvhAdmin/nvh_orders_list"; // đúng folder
    }

    // ============ CHI TIẾT ĐƠN HÀNG =============
    @GetMapping("/orders/{id}")
    public String nvhAdminOrdersDetail(@PathVariable Long id, Model model) {

        NvhOrders order = nvhOrdersService.nvhFindById(id);
        List<NvhOrdersDetails> details = nvhDetailsService.nvhFindByOrderId(id);

        model.addAttribute("order", order);
        model.addAttribute("details", details);

        return "nvhAdmin/nvh_orders_detail";
    }
}
