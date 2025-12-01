package K23CNT2.nvh.WebBanQuanAo.Nvh_Repository;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Order;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Order_Status_Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Nvh_OrderStatusLogRepository extends JpaRepository<Nvh_Order_Status_Log, Integer> {
    List<Nvh_Order_Status_Log> findByOrder(Nvh_Order nvhOrder);
}