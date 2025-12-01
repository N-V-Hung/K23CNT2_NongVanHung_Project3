package K23CNT2.nvh.WebBanQuanAo.Nvh_Controller;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.*;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Server.Nvh_CartService;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Server.Nvh_ProductService;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Server.Nvh_UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class Nvh_CartController {

    private final Nvh_CartService cartService;
    private final Nvh_UserService userService;   // dùng để lấy user hiện tại
    private final Nvh_ProductService productService; // lấy sản phẩm theo id

    // Hiển thị giỏ hàng
    @GetMapping
    public String viewCart(Model model) {
        Nvh_Users currentUser = userService.getById(1); // giả lập user đăng nhập
        Nvh_Cart cart = cartService.getCartByUser(currentUser);

        List<Nvh_Cart_Item> items = cart == null ? List.of() : cartService.getItems(cart);

        double total = items.stream()
                .mapToDouble(i -> i.getNvh_product().getNvh_price()
                        .multiply(BigDecimal.valueOf(i.getNvh_quantity()))
                        .doubleValue())
                .sum();


        model.addAttribute("cartItems", items);
        model.addAttribute("total", total);

        return "cart"; // trỏ tới cart.html
    }

    // Thêm sản phẩm vào giỏ
    @PostMapping("/add/{productId}")
    public String addToCart(@PathVariable Integer productId,
                            @RequestParam("quantity") int quantity) {

        Nvh_Users currentUser = userService.getById(1); // giả lập user đăng nhập
        Nvh_Product product = productService.getById(productId);

        if (product != null) {
            cartService.addItem(currentUser, product, quantity);
        }

        return "redirect:/nvh_cart";
    }

    // Xóa toàn bộ giỏ hàng
    @PostMapping("/clear")
    public String clearCart() {
        Nvh_Users currentUser = userService.getById(1); // giả lập user đăng nhập
        Nvh_Cart cart = cartService.getCartByUser(currentUser);
        if (cart != null) {
            cartService.clearCart(cart);
        }
        return "redirect:/nvh_cart";
    }
}
