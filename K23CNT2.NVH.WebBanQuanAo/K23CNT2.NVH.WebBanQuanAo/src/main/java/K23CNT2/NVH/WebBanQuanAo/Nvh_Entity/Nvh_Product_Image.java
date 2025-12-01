package K23CNT2.nvh.WebBanQuanAo.Nvh_Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "nvh_product_image")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Nvh_Product_Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "nvh_id")
    private Integer nvh_id;

    @ManyToOne
    @JoinColumn(name = "nvh_product_id")
    private Nvh_Product nvh_product_id;

    @Column(name = "nvh_image")
    private String nvh_image;

    @Column(name = "nvh_alt")
    private String nvh_alt;

    @Column(name = "nvh_order")
    private String nvh_order;
}
