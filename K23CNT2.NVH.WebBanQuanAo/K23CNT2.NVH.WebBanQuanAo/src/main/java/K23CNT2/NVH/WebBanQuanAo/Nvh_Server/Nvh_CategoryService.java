package K23CNT2.nvh.WebBanQuanAo.Nvh_Server;



import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Category;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Repository.Nvh_CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Nvh_CategoryService {
    List<Nvh_Category> getAll();
    Nvh_Category getById(Integer id);
    Nvh_Category save(Nvh_Category category);
    void delete(Integer id);
    List<Nvh_Category> getByStatus(Integer status);
}

@Service
class Nvh_CategoryServiceImpl implements Nvh_CategoryService {

    @Autowired
    private Nvh_CategoryRepository repo;

    @Override
    public List<Nvh_Category> getAll() {
        return repo.findAll();
    }

    @Override
    public Nvh_Category getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Nvh_Category save(Nvh_Category category) {
        return repo.save(category);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public List<Nvh_Category> getByStatus(Integer status) {
        return repo.findByStatus(status);
    }
}
