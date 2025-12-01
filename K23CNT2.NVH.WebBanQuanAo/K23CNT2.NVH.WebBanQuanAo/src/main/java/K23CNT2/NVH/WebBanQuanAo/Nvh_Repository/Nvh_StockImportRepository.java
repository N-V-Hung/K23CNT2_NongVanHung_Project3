package K23CNT2.nvh.WebBanQuanAo.Nvh_Repository;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Product;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_StockImport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Nvh_StockImportRepository extends JpaRepository<Nvh_StockImport, Integer> {
    List<Nvh_StockImport> findByProduct(Nvh_Product nvhProduct);
}
