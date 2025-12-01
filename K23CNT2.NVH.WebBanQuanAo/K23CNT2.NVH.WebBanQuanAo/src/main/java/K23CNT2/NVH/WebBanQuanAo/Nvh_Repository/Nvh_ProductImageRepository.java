package K23CNT2.nvh.WebBanQuanAo.Nvh_Repository;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Product;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Product_Image;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Nvh_ProductImageRepository extends JpaRepository<Nvh_Product_Image, Integer> {
    List<Nvh_Product_Image> findByProduct(Nvh_Product product);
}
