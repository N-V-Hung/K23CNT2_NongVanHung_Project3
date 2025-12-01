package K23CNT2.nvh.WebBanQuanAo.Nvh_Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "nvh_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Nvh_Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nvh_id")
    private Integer nvh_id;

    @Column(name = "nvh_name", nullable = false, length = 200)
    private String nvh_name;

    @Column(name = "nvh_price", nullable = false)
    private BigDecimal nvh_price;

    @Column(name = "nvh_description", columnDefinition = "TEXT")
    private String nvh_description;

    @Column(name = "nvh_size", length = 100)
    private String nvh_size;

    @Column(name = "nvh_color", length = 100)
    private String nvh_color;

    @Column(name = "nvh_quantity")
    private Integer nvh_quantity;

    @Column(name = "nvh_image", length = 255)
    private String nvh_image;

    @Column(name = "nvh_status")
    private Integer nvh_status;

    // many-to-many -> product_category join table
    @ManyToMany
    @JoinTable(
            name = "nvh_product_category",
            joinColumns = @JoinColumn(name = "nvh_product_id"),
            inverseJoinColumns = @JoinColumn(name = "nvh_category_id")
    )
    private Set<Nvh_Category> nvh_categories = new HashSet<>();
}
