package K23CNT2.nvh.WebBanQuanAo.Nvh_Repository;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Cart;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Category;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Nvh_CartRepository extends JpaRepository<Nvh_Cart, Integer> {
    Optional<Nvh_Cart> findByNvhUserId(Nvh_Users nvhUsers);

    // nếu muốn tìm theo ID số nguyên:
    Optional<Nvh_Cart> findByNvhUserId_Nvh_id(Integer nvhId);

}
