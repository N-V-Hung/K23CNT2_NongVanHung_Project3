package K23CNT2.nvh.WebBanQuanAo.Nvh_Server;


import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.*;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface Nvh_InventoryService {
    List<Nvh_Inventory> findByProduct(Nvh_Product p);
    Nvh_Inventory updateStock(Nvh_Product p, int change);
    Nvh_Inventory save(Nvh_Inventory inv);
}

@Service
@RequiredArgsConstructor
class Nvh_InventoryServiceImpl implements Nvh_InventoryService {

    private final Nvh_InventoryRepository repo;
    private final Nvh_ProductRepository productRepo;

    @Override
    public List<Nvh_Inventory> findByProduct(Nvh_Product p) {
        return repo.findByProduct(p);
    }

    @Override
    public Nvh_Inventory updateStock(Nvh_Product p, int change) {

        Nvh_Inventory inv = repo.findByProduct(p).stream().findFirst().orElse(null);

        if (inv == null) {
            inv = new Nvh_Inventory();
            inv.setNvh_product_id(p);
            inv.setNvh_quantity(0);
        }

        inv.setNvh_quantity(inv.getNvh_quantity() + change);
        inv.setNvh_updated_at(new Date());

        return repo.save(inv);
    }


    @Override
    public Nvh_Inventory save(Nvh_Inventory inv) {
        return repo.save(inv);
    }
}

