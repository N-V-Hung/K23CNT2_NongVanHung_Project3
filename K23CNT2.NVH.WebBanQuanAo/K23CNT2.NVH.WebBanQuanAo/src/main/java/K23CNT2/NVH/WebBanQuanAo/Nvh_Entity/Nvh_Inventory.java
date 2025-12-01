package K23CNT2.nvh.WebBanQuanAo.Nvh_Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "nvh_inventory")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Nvh_Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nvh_id")
    private Integer nvh_id;


    @ManyToOne
    @JoinColumn(name = "nvh_product_id")
    private Nvh_Product nvh_product_id;


    @Column(name = "nvh_size")
    private String nvh_size;


    @Column(name = "nvh_color")
    private String nvh_color;


    @Column(name = "nvh_quantity")
    private Integer nvh_quantity;


    @Column(name = "nvh_updated_at")
    private Date nvh_updated_at;
}