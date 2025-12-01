package K23CNT2.nvh.WebBanQuanAo.Nvh_Entity;



import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "nvh_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Nvh_Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nvh_id")
    private Integer nvh_id;

    @Column(name = "nvh_username")
    private String nvh_username;

    @Column(name = "nvh_full_name")
    private String fullName;


    @Column(name = "nvh_email")
    private String nvh_email;


    @Column(name = "nvh_password")
    private String nvh_password;


    @Column(name = "nvh_phone")
    private String nvh_phone;


    @Column(name = "nvh_address")
    private String nvh_address;


    @Column(name = "nvh_role")
    private String nvh_role;


    @Column(name = "nvh_status")
    private Integer nvh_status;


    @Column(name = "created_at")
    private Date createdAt;


    @Column(name = "updated_at")
    private Date updatedAt;

    public Nvh_Users(Integer nvh_id) {
        this.nvh_id = nvh_id;
    }
}