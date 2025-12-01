package K23CNT2.nvh.WebBanQuanAo.Nvh_Server;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Users;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Repository.Nvh_UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Nvh_UserService {
    List<Nvh_Users> getAll();
    Nvh_Users getById(Integer id);
    Nvh_Users save(Nvh_Users user);
    void delete(Integer id);
    Nvh_Users findByEmail(String email);
    Nvh_Users findByUsername(String username);
}

@Service
class Nvh_UserServiceImpl implements Nvh_UserService {

    @Autowired
    private Nvh_UserRepository repo;

    @Override
    public List<Nvh_Users> getAll() {
        return repo.findAll();
    }

    @Override
    public Nvh_Users getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Nvh_Users save(Nvh_Users user) {
        return repo.save(user);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Nvh_Users findByEmail(String email) {
        return repo.findByEmail(email);
    }

    @Override
    public Nvh_Users findByUsername(String username) {
        return repo.findByUsername(username);
    }
}
