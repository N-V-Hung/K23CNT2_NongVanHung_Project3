package K23CNT2.nvh.WebBanQuanAo.Nvh_Repository;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Order;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Nvh_OrderRepository extends JpaRepository<Nvh_Order, Integer> {
    List<Nvh_Order> findByUser(Nvh_Users nvhUser);
}
