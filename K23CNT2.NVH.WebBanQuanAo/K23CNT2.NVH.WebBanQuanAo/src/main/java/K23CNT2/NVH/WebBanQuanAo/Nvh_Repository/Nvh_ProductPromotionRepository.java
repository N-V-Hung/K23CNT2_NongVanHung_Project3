package K23CNT2.nvh.WebBanQuanAo.Nvh_Repository;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Product;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_ProductPromotion;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Nvh_ProductPromotionRepository extends JpaRepository<Nvh_ProductPromotion, Integer> {
    List<Nvh_ProductPromotion> findByProduct(Nvh_Product nvhProduct);
    List<Nvh_ProductPromotion> findByPromotion(Nvh_Promotion nvhPromotion);
}
