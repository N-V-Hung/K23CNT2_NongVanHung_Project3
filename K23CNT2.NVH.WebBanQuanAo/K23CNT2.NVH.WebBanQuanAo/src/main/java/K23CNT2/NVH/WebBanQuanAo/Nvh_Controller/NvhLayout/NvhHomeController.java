package K23CNT2.nvh.WebBanQuanAo.Nvh_Controller;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.*;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class NvhHomeController {

    @Autowired
    private NvhCategoryService nvhCategoryService;

    @Autowired
    private NvhProductService nvhProductService;

    @Autowired
    private NvhNewsService nvhNewsService;

    @GetMapping({"/", "/nvh-home"})
    public String nvhHome(Model model) {

        model.addAttribute("nvhCategories", nvhCategoryService.nvhFindAll());
        model.addAttribute("nvhProducts", nvhProductService.nvhFindAll());
        model.addAttribute("nvhNews", nvhNewsService.nvhFindAll());

        return "nvhLayout/nvh_home";
    }

    @GetMapping("/nvh-new-products")
    public String nvhNewProducts(Model model) {

        // Danh mục cho menu
        model.addAttribute("nvhCategories", nvhCategoryService.nvhFindAll());

        // Tất cả sản phẩm
        model.addAttribute("nvhProducts", nvhProductService.nvhFindAll());

        // Biến dùng để highlight menu "Mẫu Mới"
        model.addAttribute("nvhActiveMenu", "new");

        return "nvhLayout/nvh_new_products";

    }

}
