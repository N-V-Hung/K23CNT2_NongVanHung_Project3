package K23CNT2.nvh.WebBanQuanAo.Nvh_Repository;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Nvh_PromotionRepository extends JpaRepository<Nvh_Promotion, Integer> {
    Optional<Nvh_Promotion> findByCode(String nvhCode);
}