package K23CNT2.nvh.WebBanQuanAo.Nvh_Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "nvh_order_status_log")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Nvh_Order_Status_Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "nvh_id")
    private Integer nvh_id;

    @ManyToOne
    @JoinColumn(name = "nvh_order_id")
    private Nvh_Order nvh_order_id;

    @Column(name = "nvh_status")
    private  String nvh_status;

    @Column(name = "nvh_note")
    private String nvh_note;

    @Column(name = "created_at")
    private Date created_at;



}
