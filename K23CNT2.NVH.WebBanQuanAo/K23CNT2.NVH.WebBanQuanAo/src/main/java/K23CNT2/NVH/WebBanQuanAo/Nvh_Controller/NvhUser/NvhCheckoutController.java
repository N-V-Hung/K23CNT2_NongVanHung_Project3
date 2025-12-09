package K23CNT2.nvh.WebBanQuanAo.Nvh_Controller;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.*;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class NvhCheckoutController {

    @Autowired
    private NvhCartService nvhCartService;

    @Autowired
    private NvhPaymentMethodService nvhPaymentService;

    @Autowired
    private NvhTransportMethodService nvhTransportService;

    @Autowired
    private NvhOrdersService nvhOrdersService;

    @Autowired
    private NvhOrdersDetailsService nvhOrdersDetailsService;


    // =============================
    //  HIỂN THỊ TRANG CHECKOUT
    // =============================
    @GetMapping("/nvh-checkout")
    public String nvhCheckoutPage(HttpSession session, Model model) {

        Long customerId = (Long) session.getAttribute("nvhUserId");
        if (customerId == null) return "redirect:/nvh-login";

        List<NvhCart> cartItems = nvhCartService.nvhGetCartByCustomer(customerId);

        double total = cartItems.stream()
                .mapToDouble(NvhCart::getNvhTotal)
                .sum();

        model.addAttribute("nvhCartItems", cartItems);
        model.addAttribute("nvhTotal", total);
        model.addAttribute("nvhPayments", nvhPaymentService.nvhFindAll());
        model.addAttribute("nvhTransports", nvhTransportService.nvhFindAll());

        return "nvhUser/nvh_checkout";
    }


    // =============================
    //  XỬ LÝ THANH TOÁN
    // =============================
    @PostMapping("/nvh-checkout")
    public String nvhCheckoutAction(
            @RequestParam Long nvhPayment,
            @RequestParam Long nvhTransport,
            HttpSession session,
            Model model
    ) {

        Long customerId = (Long) session.getAttribute("nvhUserId");
        if (customerId == null) return "redirect:/nvh-login";

        List<NvhCart> cartItems = nvhCartService.nvhGetCartByCustomer(customerId);

        if (cartItems.isEmpty()) {
            model.addAttribute("nvhMessage", "Giỏ hàng trống. Không thể thanh toán.");
            return "nvhUser/nvh_checkout_done";
        }

        double total = cartItems.stream()
                .mapToDouble(NvhCart::getNvhTotal)
                .sum();

        // ===== Tạo Order =====
        NvhOrders order = new NvhOrders();
        order.setNvhCode("HD" + System.currentTimeMillis());
        order.setNvhOrdersDate(new Date());
        order.setNvhIdcustomer(customerId);
        order.setNvhIdpayment(nvhPayment);
        order.setNvhIdtransport(nvhTransport);
        order.setNvhTotalMoney(total);
        order.setNvhIsdelete(0);
        order.setNvhIsactive(1);

        NvhOrders savedOrder = nvhOrdersService.nvhSave(order);

        // ===== Tạo Order Details =====
        for (NvhCart cart : cartItems) {

            NvhOrdersDetails d = new NvhOrdersDetails();
            d.setNvhIdord(savedOrder.getNvhId());
            d.setNvhIdproduct(cart.getNvhIdproduct());
            d.setNvhPrice(cart.getNvhPrice());
            d.setNvhQty(cart.getNvhQuantity());
            d.setNvhTotal(cart.getNvhTotal());

            nvhOrdersDetailsService.nvhSave(d);

            // Xóa giỏ sau thanh toán
            nvhCartService.nvhDeleteCart(cart.getNvhId());
        }

        model.addAttribute("nvhOrderCode", savedOrder.getNvhCode());
        return "nvhUser/nvh_checkout_done";
    }
}
