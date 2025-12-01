package K23CNT2.nvh.WebBanQuanAo.Nvh_Repository;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Category;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Nvh_ProductRepository extends JpaRepository<Nvh_Product, Integer> {
    List<Nvh_Product> findByCategory(Nvh_Category nvhCategory);
    List<Nvh_Product> findByStatus(Integer nvhStatus);
}
