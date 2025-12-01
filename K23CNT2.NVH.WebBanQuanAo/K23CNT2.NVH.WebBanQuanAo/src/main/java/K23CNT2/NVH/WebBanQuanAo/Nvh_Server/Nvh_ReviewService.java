package K23CNT2.nvh.WebBanQuanAo.Nvh_Server;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Product;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Review;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Users;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Repository.Nvh_ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Nvh_ReviewService {
    List<Nvh_Review> getByProduct(Nvh_Product product);
    List<Nvh_Review> getByUser(Nvh_Users user);
    Nvh_Review save(Nvh_Review review);
    void delete(Integer id);
    Nvh_Review getById(Integer id);
}

@Service
class Nvh_ReviewServiceImpl implements Nvh_ReviewService {

    @Autowired
    private Nvh_ReviewRepository repo;

    @Override
    public List<Nvh_Review> getByProduct(Nvh_Product product) {
        return repo.findByProduct(product);
    }

    @Override
    public List<Nvh_Review> getByUser(Nvh_Users user) {
        return repo.findByUser(user);
    }

    @Override
    public Nvh_Review save(Nvh_Review review) {
        return repo.save(review);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Nvh_Review getById(Integer id) {
        return repo.findById(id).orElse(null);
    }
}

