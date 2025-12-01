package K23CNT2.nvh.WebBanQuanAo.Nvh_Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "nv_review")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Nvh_Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nvh_id")
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "nvh_user_id")
    private Nvh_Users nvh_user_id;


    @ManyToOne
    @JoinColumn(name = "nvh_product_id")
    private Nvh_Product nvh_product_id;


    @Column(name = "nvh_rating")
    private Integer nvh_rating;


    @Column(name = "nvh_comment")
    private String nvh_comment;


    @Column(name = "nvh_created_at")
    private Date createdAt;
}
