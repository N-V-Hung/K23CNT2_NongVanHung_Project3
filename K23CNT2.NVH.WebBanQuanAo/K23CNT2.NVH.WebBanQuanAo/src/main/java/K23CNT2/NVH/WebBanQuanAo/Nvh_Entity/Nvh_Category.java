package K23CNT2.nvh.WebBanQuanAo.Nvh_Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "nvh_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Nvh_Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nvh_id")
    private Integer nvh_id;

    @Column(name = "nvh_name", nullable = false, length = 100)
    private String nvh_name;

    @Column(name = "nvh_description", columnDefinition = "TEXT")
    private String nvh_description;

    // mappedBy is the field name in Nvh_Product
    @ManyToMany(mappedBy = "nvh_categories")
    private Set<Nvh_Product> nvh_products = new HashSet<>();
}
