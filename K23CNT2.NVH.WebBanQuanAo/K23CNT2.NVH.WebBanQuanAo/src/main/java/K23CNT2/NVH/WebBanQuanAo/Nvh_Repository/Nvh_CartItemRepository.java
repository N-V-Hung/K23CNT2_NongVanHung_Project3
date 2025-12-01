package K23CNT2.nvh.WebBanQuanAo.Nvh_Repository;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Cart;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Cart_Item;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface Nvh_CartItemRepository extends JpaRepository<Nvh_Cart_Item, Integer> {
    List<Nvh_Cart_Item> findByNvhCart(Nvh_Cart nvhCart);
    Optional<Nvh_Cart_Item> findByNvhCartAndNvhProduct(Nvh_Cart nvhCart, Nvh_Product nvhProduct);

}
