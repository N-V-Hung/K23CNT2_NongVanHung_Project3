package K23CNT2.nvh.WebBanQuanAo.Nvh_Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "nvh_cart_item")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Nvh_Cart_Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nvh_id")
    private Integer nvh_id;

    @ManyToOne
    @JoinColumn(name = "nvh_cart_id")
    private Nvh_Cart nvhCart;

    @ManyToOne
    @JoinColumn(name = "nvh_product_id")
    private Nvh_Product nvh_product;

    @Column(name = "nvh_quantity")
    private Integer nvh_quantity;
}

