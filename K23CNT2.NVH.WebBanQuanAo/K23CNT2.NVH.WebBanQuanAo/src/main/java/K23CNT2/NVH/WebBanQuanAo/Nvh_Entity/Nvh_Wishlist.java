package K23CNT2.nvh.WebBanQuanAo.Nvh_Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "nvh_wishlist")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Nvh_Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "nvh_id")
    private Integer nvh_id;


    @ManyToOne
    @JoinColumn(name = "nvh_user_id")
    private Nvh_Users nvh_user_id;


    @ManyToOne
    @JoinColumn(name = "nvh_product_id")
    private Nvh_Product nvh_product_id;

    @Column(name = "created_at")
    private Date created_at;
}
