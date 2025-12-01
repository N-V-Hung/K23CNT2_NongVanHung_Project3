package K23CNT2.nvh.WebBanQuanAo.Nvh_Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "nvh_promotion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Nvh_Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nvh_id")
    private Integer nvh_id;


    @Column(name = "nvh_code")
    private String nvh_code;


    @Column(name = "nvh_discount")
    private Double nvh_discount;


    @Column(name = "nvh_start")
    private Date nvh_startDate;


    @Column(name = "nvh_end")
    private Date nvh_endDate;


    @Column(name = "nvh_status")
    private Integer nvh_status;
}