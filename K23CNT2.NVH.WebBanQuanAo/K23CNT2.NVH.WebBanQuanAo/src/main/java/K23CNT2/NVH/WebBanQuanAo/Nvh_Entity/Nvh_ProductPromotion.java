package K23CNT2.nvh.WebBanQuanAo.Nvh_Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "nvh_product_promotion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Nvh_ProductPromotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer nvh_id;


    @ManyToOne
    @JoinColumn(name = "nvh_product_id")
    private Nvh_Product nvh_product_id;


    @ManyToOne
    @JoinColumn(name = "nvh_promotion_id")
    private Nvh_Promotion nvh_promotion_id;
}
