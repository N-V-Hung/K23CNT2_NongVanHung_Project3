package K23CNT2.nvh.WebBanQuanAo.Nvh_Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "nvh_order")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Nvh_Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nvh_id")
    private Integer nvh_id;

    @ManyToOne
    @JoinColumn(name = "nvh_user_id")
    private Nvh_Users nvh_user_id;

    @Column(name = "nvh_total", nullable = false)
    private Double nvh_total;

    @Column(name = "nvh_address")
    private String nvh_address;

    @Column(name = "nvh_phone")
    private String nvh_phone;

    @Column(name = "nvh_order_date")
    private LocalDateTime nvh_order_date;

    @Column(name = "nvh_status")
    private  String nvh_status;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

}

