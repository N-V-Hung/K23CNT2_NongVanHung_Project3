package K23CNT2.nvh.WebBanQuanAo.Nvh_Controller;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.*;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Server.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/checkout")
public class Nvh_CheckoutController {

    private final Nvh_CartService cartService;
    private final Nvh_OrderService orderService;
    private final Nvh_UserService userService;

    @GetMapping
    public String checkoutPage(Model model) {
        Nvh_Users user = userService.getById(1); // giả lập user đăng nhập
        Nvh_Cart cart = cartService.getCartByUser(user);

        List<Nvh_Cart_Item> items = cart == null ? List.of() : cartService.getItems(cart);
        BigDecimal total = items.stream()
                .map(i -> i.getNvh_product().getNvh_price().multiply(BigDecimal.valueOf(i.getNvh_quantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        model.addAttribute("cartItems", items);
        model.addAttribute("total", total);

        return "checkout";
    }

    @PostMapping("/confirm")
    public String confirmCheckout(@RequestParam String name,
                                  @RequestParam String phone,
                                  @RequestParam String address) {
        Nvh_Users user = userService.getById(1);
        Nvh_Order order = orderService.createOrder(user);

        if(order != null){
            Nvh_Cart cart = cartService.getCartByUser(user);
            if(cart != null){
                cartService.clearCart(cart);
            }
        }
        // bạn có thể lưu thông tin nhận hàng vào order nếu cần
        return "redirect:/"; // thanh toán xong về trang chủ
    }
}

