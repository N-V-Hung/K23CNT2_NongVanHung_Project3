package K23CNT2.nvh.WebBanQuanAo.Nvh_Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "nvh_payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Nvh_Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "nvh_id")
    private Integer nvh_id;


    @ManyToOne
    @JoinColumn(name = "nvh_order_id")
    private Nvh_Order order;

    @Column(name = "nvh_amount")
    private Double nvh_amount;

    @Column(name = "nvh_method")
    private String nvh_method;

    @Column(name = "nvh_status")
    private String nvh_status;

    @Column(name = "nvh_payload")
    private String nvh_payload;

    @Column(name = "created_at")
    private Date created_at;
}
