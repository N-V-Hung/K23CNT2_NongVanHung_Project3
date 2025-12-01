package K23CNT2.nvh.WebBanQuanAo.Nvh_Repository;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Product;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Review;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Nvh_ReviewRepository extends JpaRepository<Nvh_Review, Integer> {
    List<Nvh_Review> findByProduct(Nvh_Product nvhProduct);
    List<Nvh_Review> findByUser(Nvh_Users nvhUser);
}
