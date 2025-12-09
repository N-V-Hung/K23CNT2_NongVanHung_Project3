package K23CNT2.nvh.WebBanQuanAo.Nvh_Controller;


import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.NvhProduct;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Service.NvhProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NvhProductController {

    @Autowired
    private NvhProductService nvhProductService;

    @GetMapping("/nvh-product/{id}")
    public String nvhProductDetail(@PathVariable Long id,
                                   HttpSession session,
                                   Model model) {

        NvhProduct product = nvhProductService.nvhFindById(id);

        if (product == null) {
            return "redirect:/nvh-home";   // sản phẩm không tồn tại
        }

        model.addAttribute("nvhProduct", product);
        model.addAttribute("nvhUserName", session.getAttribute("nvhUserName"));

        return "nvhProduct/nvh_product_detail";
    }

}

