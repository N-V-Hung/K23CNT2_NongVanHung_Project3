package K23CNT2.nvh.WebBanQuanAo.Nvh_Server;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Product;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_StockImport;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Repository.Nvh_StockImportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Nvh_StockImportService {
    List<Nvh_StockImport> getAll();
    List<Nvh_StockImport> getByProduct(Nvh_Product product);
    Nvh_StockImport save(Nvh_StockImport stockImport);
    void delete(Integer id);
    Nvh_StockImport getById(Integer id);
}

@Service
class Nvh_StockImportServiceImpl implements Nvh_StockImportService {

    @Autowired
    private Nvh_StockImportRepository repo;

    @Override
    public List<Nvh_StockImport> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Nvh_StockImport> getByProduct(Nvh_Product product) {
        return repo.findByProduct(product);
    }

    @Override
    public Nvh_StockImport save(Nvh_StockImport stockImport) {
        return repo.save(stockImport);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Nvh_StockImport getById(Integer id) {
        return repo.findById(id).orElse(null);
    }
}

