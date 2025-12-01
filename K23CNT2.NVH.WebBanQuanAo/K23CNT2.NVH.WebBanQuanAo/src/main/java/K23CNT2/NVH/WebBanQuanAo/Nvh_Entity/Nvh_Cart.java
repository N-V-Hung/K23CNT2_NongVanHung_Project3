package K23CNT2.nvh.WebBanQuanAo.Nvh_Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "nvh_cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Nvh_Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nvh_id")
    private Integer nvh_id;

    @ManyToOne
    @JoinColumn(name = "nvh_user_id")
    private Nvh_Users nvhUserId;

    @Column(name = "created_at")
    private Date createdAt;
}

