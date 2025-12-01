package K23CNT2.nvh.WebBanQuanAo.Nvh_Server;


import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Category;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Product;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Repository.Nvh_ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Nvh_ProductService {
    List<Nvh_Product> getAll();
    Nvh_Product getById(Integer id);
    Nvh_Product save(Nvh_Product product);
    void delete(Integer id);
    List<Nvh_Product> getByCategory(Nvh_Category cat);
    List<Nvh_Product> getByStatus(Integer status);
}

@Service
class Nvh_ProductServiceImpl implements Nvh_ProductService {

    @Autowired
    private Nvh_ProductRepository repo;

    @Override
    public List<Nvh_Product> getAll() {
        return repo.findAll();
    }

    @Override
    public Nvh_Product getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Nvh_Product save(Nvh_Product product) {
        return repo.save(product);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public List<Nvh_Product> getByCategory(Nvh_Category cat) {
        return repo.findByCategory(cat);
    }

    @Override
    public List<Nvh_Product> getByStatus(Integer status) {
        return repo.findByStatus(status);
    }
}
