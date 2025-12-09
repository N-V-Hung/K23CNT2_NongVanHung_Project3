package K23CNT2.nvh.WebBanQuanAo.Nvh_Service;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.NvhCoupon;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.NvhCouponType;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Repository.NvhCouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NvhCouponService {

    @Autowired
    private NvhCouponRepository couponRepo;

    public List<NvhCoupon> nvhFindAll() {
        return couponRepo.findAll();
    }

    public NvhCoupon nvhFindById(Long id) {
        return couponRepo.findById(id).orElse(null);
    }

    public NvhCoupon nvhSave(NvhCoupon coupon) {
        return couponRepo.save(coupon);
    }

    public void nvhDelete(Long id) {
        couponRepo.deleteById(id);
    }

    public NvhCoupon nvhFindByCode(String code) {
        return couponRepo.findByNvhCode(code).orElse(null);
    }

    /** ==========================
     *  TÍNH GIẢM GIÁ
     *  ========================== */
    public Double nvhCalculateDiscount(NvhCoupon coupon, Double orderTotal) {

        if (coupon == null || orderTotal == null) return 0.0;

        Date now = new Date();

        // 1) Check ngày bắt đầu
        if (coupon.getNvhStartDate() != null && now.before(coupon.getNvhStartDate())) {
            return 0.0;
        }

        // 2) Check ngày hết hạn
        if (coupon.getNvhEndDate() != null && now.after(coupon.getNvhEndDate())) {
            return 0.0;
        }

        // 3) Check số lượng còn lại
        if (coupon.getNvhQuantity() != null && coupon.getNvhUsedCount() != null) {
            if (coupon.getNvhUsedCount() >= coupon.getNvhQuantity()) {
                return 0.0;
            }
        }

        // 4) Check tổng tiền tối thiểu
        if (coupon.getNvhMinOrderAmount() != null &&
                orderTotal < coupon.getNvhMinOrderAmount()) {
            return 0.0;
        }

        // 5) Tính giảm giá
        double discount = 0.0;

        if (coupon.getNvhType() == NvhCouponType.PERCENT) {
            discount = orderTotal * coupon.getNvhValue() / 100;

        } else if (coupon.getNvhType() == NvhCouponType.AMOUNT) {
            discount = coupon.getNvhValue();
        }

        // Không để giảm quá tổng tiền
        if (discount > orderTotal) {
            discount = orderTotal;
        }

        return discount;
    }
}
