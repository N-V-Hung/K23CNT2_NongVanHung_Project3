package K23CNT2.nvh.WebBanQuanAo.Nvh_Repository;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Order;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Nvh_PaymentRepository extends JpaRepository<Nvh_Payment, Integer> {
    List<Nvh_Payment> findByOrder(Nvh_Order nvhOrder);
}
