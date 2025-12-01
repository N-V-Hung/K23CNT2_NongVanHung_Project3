package K23CNT2.nvh.WebBanQuanAo.Nvh_Repository;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Order;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Order_Detail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Nvh_OrderDetailRepository extends JpaRepository<Nvh_Order_Detail, Integer> {
    List<Nvh_Order_Detail> findByOrder(Nvh_Order nvhOrder);
}