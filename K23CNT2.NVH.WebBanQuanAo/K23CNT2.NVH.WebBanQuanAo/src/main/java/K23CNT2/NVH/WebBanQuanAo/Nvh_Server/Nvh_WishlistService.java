package K23CNT2.nvh.WebBanQuanAo.Nvh_Server;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Product;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Users;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Wishlist;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Repository.Nvh_WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Nvh_WishlistService {
    List<Nvh_Wishlist> getByUser(Nvh_Users user);
    Nvh_Wishlist save(Nvh_Wishlist wishlist);
    void delete(Integer id);
    Nvh_Wishlist findByUserAndProduct(Nvh_Users user, Nvh_Product product);
}

@Service
class WishlistServiceImpl implements Nvh_WishlistService {

    @Autowired
    private Nvh_WishlistRepository repo;

    @Override
    public List<Nvh_Wishlist> getByUser(Nvh_Users user) {
        return repo.findByUser(user);
    }

    @Override
    public Nvh_Wishlist save(Nvh_Wishlist wishlist) {
        return repo.save(wishlist);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Nvh_Wishlist findByUserAndProduct(Nvh_Users user, Nvh_Product product) {
        return repo.findByUserAndProduct(user, product).orElse(null);
    }
}
