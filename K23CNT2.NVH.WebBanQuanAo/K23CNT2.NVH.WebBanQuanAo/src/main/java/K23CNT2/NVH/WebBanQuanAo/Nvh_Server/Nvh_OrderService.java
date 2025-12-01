package K23CNT2.nvh.WebBanQuanAo.Nvh_Server;


import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.*;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Nvh_OrderService {
    Nvh_Order createOrder(Nvh_Users nvhUsers);
    Nvh_Order findById(Integer id);
    List<Nvh_Order> findByUser(Nvh_Users nvhUsers);
}

@Service
@RequiredArgsConstructor
class Nvh_OrderServiceImpl implements Nvh_OrderService {

    private final Nvh_OrderRepository orderRepo;
    private final Nvh_OrderDetailRepository detailRepo;
    private final Nvh_CartRepository cartRepo;
    private final Nvh_CartItemRepository itemRepo;

    @Override
    public Nvh_Order createOrder(Nvh_Users nvhUser) {

        // Lấy giỏ hàng
        Nvh_Cart nvhCart = cartRepo.findByNvhUserId(nvhUser).orElse(null);
        if (nvhCart == null) return null;

        // Lấy item trong giỏ
        List<Nvh_Cart_Item> items = itemRepo.findByNvhCart(nvhCart);
        if (items.isEmpty()) return null;

        // Tạo đơn hàng
        Nvh_Order nvhOrder = new Nvh_Order();
        nvhOrder.setNvh_user_id(nvhUser);
        nvhOrder = orderRepo.save(nvhOrder);

        double total = 0;

        for (Nvh_Cart_Item ci : items) {

            Nvh_Order_Detail d = new Nvh_Order_Detail();
            d.setNvh_order_id(nvhOrder);
            d.setNvh_product_id(ci.getNvh_product());
            d.setNvh_quantity(ci.getNvh_quantity());

            // BigDecimal -> double
            d.setNvh_price(ci.getNvh_product().getNvh_price().doubleValue());

            detailRepo.save(d);

            total += d.getNvh_price() * d.getNvh_quantity();
        }

        // Cập nhật tổng tiền đơn hàng
        nvhOrder.setNvh_total(total);
        orderRepo.save(nvhOrder);

        // Xóa giỏ hàng
        itemRepo.deleteAll(items);

        return nvhOrder;
    }

    @Override
    public Nvh_Order findById(Integer id) {
        return orderRepo.findById(id).orElse(null);
    }

    @Override
    public List<Nvh_Order> findByUser(Nvh_Users nvhUser) {
        return orderRepo.findByUser(nvhUser);
    }
}


