package K23CNT2.nvh.WebBanQuanAo.Nvh_Controller;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Server.Nvh_ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class Nvh_HomeController {

    private final Nvh_ProductService productService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", productService.getAll());
        return "nvh_index"; // index.html
    }
}

