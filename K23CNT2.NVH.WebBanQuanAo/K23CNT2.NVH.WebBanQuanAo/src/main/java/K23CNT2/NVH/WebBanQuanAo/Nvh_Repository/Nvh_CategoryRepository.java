package K23CNT2.nvh.WebBanQuanAo.Nvh_Repository;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Nvh_CategoryRepository extends JpaRepository<Nvh_Category, Integer> {
    List<Nvh_Category> findByStatus(Integer nvhStatus);
}
