package K23CNT2.nvh.WebBanQuanAo.Nvh_Service;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Order_Detail;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Repository.Nvh_OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Nvh_OrderDetailService {

    private final Nvh_OrderDetailRepository repository;

    public List<Nvh_Order_Detail> getByOrder(Integer orderId) {
        return repository.findByOrder_Nvh_id(orderId);
    }

    public Nvh_Order_Detail save(Nvh_Order_Detail detail) {
        return repository.save(detail);
    }
}
