package K23CNT2.nvh.WebBanQuanAo.Nvh_Repository;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Product;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Users;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Nvh_WishlistRepository extends JpaRepository<Nvh_Wishlist, Integer> {
    List<Nvh_Wishlist> findByUser(Nvh_Users nvhUser);
    Optional<Nvh_Wishlist> findByUserAndProduct(Nvh_Users nvhUser, Nvh_Product nvhProduct);
}
