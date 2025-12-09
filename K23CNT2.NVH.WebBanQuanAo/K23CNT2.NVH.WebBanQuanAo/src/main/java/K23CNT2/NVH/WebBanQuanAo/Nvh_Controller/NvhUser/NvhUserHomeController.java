package K23CNT2.nvh.WebBanQuanAo.Nvh_Controller;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.NvhCategory;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.NvhNews;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.NvhProduct;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Service.NvhCategoryService;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Service.NvhNewsService;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Service.NvhProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NvhUserHomeController {

    @Autowired
    private NvhCategoryService nvhCategoryService;

    @Autowired
    private NvhProductService nvhProductService;

    @Autowired
    private NvhNewsService nvhNewsService;

    @GetMapping("/nvh-user-home")
    public String nvhUserHome(HttpSession session, Model model) {

        model.addAttribute("nvhCategories", nvhCategoryService.nvhFindAll());
        model.addAttribute("nvhProducts", nvhProductService.nvhFindAll());
        model.addAttribute("nvhNews", nvhNewsService.nvhFindAll());

        model.addAttribute("nvhUserName", session.getAttribute("nvhUserName"));

        return "nvhUser/nvh_user_home";
    }

    @GetMapping("/nvh-search")
    public String nvhSearch(
            @RequestParam String keyword,
            Model model,
            HttpSession session) {

        model.addAttribute("nvhCategories", nvhCategoryService.nvhFindAll());
        model.addAttribute("nvhNews", nvhNewsService.nvhFindAll());
        model.addAttribute("nvhProducts", nvhProductService.searchByKeyword(keyword));
        model.addAttribute("nvhUserName", session.getAttribute("nvhUserName"));

        return "nvhUser/nvh_user_home";
    }
}
