package K23CNT2.nvh.WebBanQuanAo.Nvh_Controller;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.NvhCart;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.NvhProduct;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Service.NvhCartService;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Service.NvhProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class  NvhCartController {

    @Autowired
    private NvhCartService nvhCartService;

    @Autowired
    private NvhProductService nvhProductService;

    // ===============================
    // 1) Thêm vào giỏ hàng
    // ===============================
    @PostMapping("/nvh-cart-add")
    public String nvhAddToCart(
            @RequestParam("nvhIdproduct") Long nvhIdproduct,
            @RequestParam(defaultValue = "1") Integer nvhQuantity,
            HttpSession session) {

        Long customerId = (Long) session.getAttribute("nvhUserId");
        if (customerId == null) {
            return "redirect:/nvh-login"; // chưa login -> bắt login
        }

        // lấy thông tin sản phẩm
        NvhProduct product = nvhProductService.nvhFindById(nvhIdproduct);
        if (product == null) {
            return "redirect:/nvh-user-home";
        }

        // tạo giỏ hàng
        NvhCart cart = new NvhCart();
        cart.setNvhIdcustomer(customerId);
        cart.setNvhIdproduct(nvhIdproduct);
        cart.setNvhPrice(product.getNvhPrice());
        cart.setNvhQuantity(nvhQuantity);
        cart.setNvhTotal(product.getNvhPrice() * nvhQuantity);
        cart.setNvhCreatedDate(new Date());
        cart.setNvhIsactive(1);
        cart.setNvhIsdelete(0);

        nvhCartService.nvhAddToCart(cart);

        return "redirect:/nvh-cart"; // chuyển sang trang giỏ hàng
    }

    // ===============================
    // 2) Xem giỏ hàng
    // ===============================
    @GetMapping("/nvh-cart")
    public String nvhViewCart(HttpSession session, Model model) {

        Long customerId = (Long) session.getAttribute("nvhUserId");
        if (customerId == null) {
            return "redirect:/nvh-login";
        }

        List<NvhCart> nvhCartItems = nvhCartService.nvhGetCartByCustomer(customerId);

        double totalAmount = 0;
        for (NvhCart item : nvhCartItems) {
            totalAmount += item.getNvhTotal();
        }

        model.addAttribute("nvhCartItems", nvhCartItems);
        model.addAttribute("nvhCartTotal", totalAmount);
        model.addAttribute("nvhUserName", session.getAttribute("nvhUserName"));

        return "nvhUser/nvh_cart"; // đúng folder
    }


    // ===============================
    // 3) Cập nhật số lượng
    // ===============================
    @PostMapping("/nvh-cart-update")
    public String nvhUpdateCart(
            @RequestParam("nvhId") Long nvhId,
            @RequestParam("nvhQuantity") Integer nvhQuantity) {

        NvhCart cart = nvhCartService.nvhGetCartByCustomer(0L)
                .stream()
                .filter(c -> c.getNvhId().equals(nvhId))
                .findFirst()
                .orElse(null);

        // Nếu muốn tối ưu, bạn nên bổ sung service findById()

        if (cart != null) {
            cart.setNvhQuantity(nvhQuantity);
            cart.setNvhTotal(cart.getNvhPrice() * nvhQuantity);
            cart.setNvhUpdatedDate(new Date());
            nvhCartService.nvhUpdateCart(cart);
        }

        return "redirect:/nvh-cart";
    }


    // ===============================
    // 4) Xóa khỏi giỏ hàng
    // ===============================
    @GetMapping("/nvh-cart-remove/{id}")
    public String nvhRemoveItem(@PathVariable Long id, HttpSession session) {

        if (session.getAttribute("nvhUserId") == null) {
            return "redirect:/nvh-login";
        }

        nvhCartService.nvhDeleteCart(id);

        return "redirect:/nvh-cart";
    }
}
