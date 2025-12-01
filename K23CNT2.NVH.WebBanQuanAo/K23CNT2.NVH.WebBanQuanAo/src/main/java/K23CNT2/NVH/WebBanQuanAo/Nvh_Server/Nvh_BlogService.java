package K23CNT2.nvh.WebBanQuanAo.Nvh_Server;


import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Blog;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Repository.Nvh_BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Nvh_BlogService {
    List<Nvh_Blog> getAll();
    List<Nvh_Blog> getByStatus(Integer status);
    Nvh_Blog getById(Integer id);
    Nvh_Blog save(Nvh_Blog blog);
    void delete(Integer id);
}

@Service
class Nvh_BlogServiceImpl implements Nvh_BlogService {

    @Autowired
    private Nvh_BlogRepository repo;

    @Override
    public List<Nvh_Blog> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Nvh_Blog> getByStatus(Integer status) {
        return repo.findByStatus(status);
    }

    @Override
    public Nvh_Blog getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Nvh_Blog save(Nvh_Blog blog) {
        return repo.save(blog);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}

