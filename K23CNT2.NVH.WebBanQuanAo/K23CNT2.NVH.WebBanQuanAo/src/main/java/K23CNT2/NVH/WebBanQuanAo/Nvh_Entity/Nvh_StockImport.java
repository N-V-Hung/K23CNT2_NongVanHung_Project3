package K23CNT2.nvh.WebBanQuanAo.Nvh_Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "nvh_stock_import")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Nvh_StockImport {
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

    @Column(name = "nvh_note")
    private String nvh_note;

    @Column(name = "created_at")
    private Date created_at;
}