package K23CNT2.nvh.WebBanQuanAo.Nvh_Server;



import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Promotion;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Repository.Nvh_PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Nvh_PromotionService {
    List<Nvh_Promotion> getAll();
    Nvh_Promotion getById(Integer id);
    Nvh_Promotion save(Nvh_Promotion promotion);
    void delete(Integer id);
    Nvh_Promotion findByCode(String code);
}

@Service
class PromotionServiceImpl implements Nvh_PromotionService {

    @Autowired
    private Nvh_PromotionRepository repo;

    @Override
    public List<Nvh_Promotion> getAll() {
        return repo.findAll();
    }

    @Override
    public Nvh_Promotion getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Nvh_Promotion save(Nvh_Promotion promotion) {
        return repo.save(promotion);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Nvh_Promotion findByCode(String code) {
        return repo.findByCode(code).orElse(null);
    }
}

