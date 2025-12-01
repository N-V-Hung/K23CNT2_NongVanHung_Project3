package K23CNT2.nvh.WebBanQuanAo.Nvh_Entity;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "nvh_order_detail")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Nvh_Order_Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nvh_id")
    private Integer nvh_id;

    @ManyToOne
    @JoinColumn(name = "nvh_order_id")
    private Nvh_Order nvh_order_id;

    @ManyToOne
    @JoinColumn(name = "nvh_product_id")
    private Nvh_Product nvh_product_id;

    @Column(name = "nvh_price")
    private Double nvh_price;

    @Column(name = "nvh_quantity")
    private Integer nvh_quantity;
}

