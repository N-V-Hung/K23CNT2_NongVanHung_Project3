package K23CNT2.nvh.WebBanQuanAo.Nvh_Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "nvh_blog")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Nvh_Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nvh_id")
    private Integer nvh_id;


    @Column(name = "nvh_title")
    private String nvh_title;


    @Column(name = "nvh_content")
    private String nvh_content;


    @Column(name = "nvh_image")
    private String nvh_image;


    @Column(name = "nvh_created_at")
    private Date createdAt;
}