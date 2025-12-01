package K23CNT2.nvh.WebBanQuanAo.Nvh_Repository;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Nvh_BlogRepository extends JpaRepository<Nvh_Blog, Integer> {
    List<Nvh_Blog> findByStatus(Integer nvhStatus);
}
