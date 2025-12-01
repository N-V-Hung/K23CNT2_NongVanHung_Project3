package K23CNT2.nvh.WebBanQuanAo.Nvh_Controller;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Server.Nvh_ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class Nvh_ProductController {

    private final Nvh_ProductService productService;

    @GetMapping("/products/{id}")
    public String productDetail(@PathVariable Integer id, Model model) {

        var product = productService.getById(id);
        if (product == null) {
            return "redirect:/"; // nếu không có sản phẩm thì quay về trang chủ
        }

        model.addAttribute("product", product);
        return "product-detail"; // trỏ đến file HTML
    }
}
