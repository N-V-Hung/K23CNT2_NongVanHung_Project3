package K23CNT2.nvh.WebBanQuanAo.Nvh_Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "nvh_banner")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Nvh_Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nvh_id")
    private Integer nvh_id;


    @Column(name = "nvh_title")
    private String nvh_title;


    @Column(name = "nvh_image")
    private String nvh_image;


    @Column(name = "nvh_link")
    private String nvh_link;


    @Column(name = "nvh_status")
    private Integer nvh_status;
}
