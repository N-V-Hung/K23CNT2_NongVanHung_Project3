package K23CNT2.nvh.WebBanQuanAo.Nvh_Server;


import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.*;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Repository.Nvh_CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Nvh_CartItemService {
    List<Nvh_Cart_Item> findByCart(Nvh_Cart nvhCart);
    Nvh_Cart_Item save(Nvh_Cart_Item item);
    void delete(Integer id);
}

@Service
@RequiredArgsConstructor
class Nvh_CartItemServiceImpl implements Nvh_CartItemService {

    private final Nvh_CartItemRepository repo;

    @Override
    public List<Nvh_Cart_Item> findByCart(Nvh_Cart nvhCart) {
        return repo.findByNvhCart(nvhCart);
    }

    @Override
    public Nvh_Cart_Item save(Nvh_Cart_Item item) {
        return repo.save(item);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
