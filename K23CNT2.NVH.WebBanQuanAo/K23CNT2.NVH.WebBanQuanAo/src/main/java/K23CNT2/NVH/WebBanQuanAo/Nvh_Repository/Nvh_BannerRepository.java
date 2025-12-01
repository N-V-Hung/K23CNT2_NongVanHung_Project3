package K23CNT2.nvh.WebBanQuanAo.Nvh_Repository;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Banner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Nvh_BannerRepository extends JpaRepository<Nvh_Banner, Integer> {
    List<Nvh_Banner> findByStatus(Integer nvhStatus);
}
