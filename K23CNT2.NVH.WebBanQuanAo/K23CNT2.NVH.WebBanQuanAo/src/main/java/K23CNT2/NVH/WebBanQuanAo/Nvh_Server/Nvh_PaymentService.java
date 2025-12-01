package K23CNT2.nvh.WebBanQuanAo.Nvh_Server;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.*;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Repository.Nvh_PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Nvh_PaymentService {
    Nvh_Payment save(Nvh_Payment p);
    List<Nvh_Payment> findByOrder(Nvh_Order o);
}

@Service
@RequiredArgsConstructor
class Nvh_PaymentServiceImpl implements Nvh_PaymentService {

    private final Nvh_PaymentRepository repo;

    @Override
    public Nvh_Payment save(Nvh_Payment p) {
        return repo.save(p);
    }

    @Override
    public List<Nvh_Payment> findByOrder(Nvh_Order o) {
        return repo.findByOrder(o);
    }
}
