package K23CNT2.nvh.WebBanQuanAo.Nvh_Server;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.*;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface Nvh_CartService {
    Nvh_Cart getCartByUser(Nvh_Users nvhUsers);
    Nvh_Cart_Item addItem(Nvh_Users nvhUsers, Nvh_Product nvhProduct, int qty);
    List<Nvh_Cart_Item> getItems(Nvh_Cart nvhCart);
    void clearCart(Nvh_Cart nvhCart);
}

@Service
@RequiredArgsConstructor
class Nvh_CartServiceImpl implements Nvh_CartService {

    private final Nvh_CartRepository nvhCartRepo;
    private final Nvh_CartItemRepository nvhItemRepo;
    private final Nvh_ProductRepository nvhProductRepo;

    @Override
    public Nvh_Cart getCartByUser(Nvh_Users nvhUser) {
        return nvhCartRepo.findByNvhUserId(nvhUser).orElse(null);
    }

    @Override
    public Nvh_Cart_Item addItem(Nvh_Users nvhUser, Nvh_Product nvhProduct, int qty) {

        // lấy cart hoặc tạo mới
        Nvh_Cart cart = nvhCartRepo.findByNvhUserId(nvhUser).orElseGet(() -> {
            Nvh_Cart c = new Nvh_Cart();
            c.setNvhUserId(nvhUser);
            return nvhCartRepo.save(c);
        });

        // tìm item trong cart
        Nvh_Cart_Item item = nvhItemRepo.findByNvhCart(cart).stream()
                .filter(i -> i.getNvh_product().getNvh_id().equals(nvhProduct.getNvh_id()))
                .findFirst()
                .orElse(null);

        if (item == null) {
            item = new Nvh_Cart_Item();
            item.setNvhCart(cart);
            item.setNvh_product(nvhProduct);
            item.setNvh_quantity(qty);
        } else {
            item.setNvh_quantity(item.getNvh_quantity() + qty);
        }

        return nvhItemRepo.save(item);
    }

    @Override
    public List<Nvh_Cart_Item> getItems(Nvh_Cart nvhCart) {
        return nvhItemRepo.findByNvhCart(nvhCart);
    }

    @Override
    public void clearCart(Nvh_Cart nvhCart) {
        List<Nvh_Cart_Item> items = nvhItemRepo.findByNvhCart(nvhCart);
        nvhItemRepo.deleteAll(items);
    }
}
