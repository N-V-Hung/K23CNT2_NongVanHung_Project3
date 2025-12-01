package K23CNT2.nvh.WebBanQuanAo.Nvh_Repository;


import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Inventory;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Nvh_InventoryRepository extends JpaRepository<Nvh_Inventory, Integer> {
    List<Nvh_Inventory> findByProduct(Nvh_Product nvhProduct);
    Optional<Nvh_Inventory> findByProductAndSizeAndColor(Nvh_Product p, String size, String color);
}
