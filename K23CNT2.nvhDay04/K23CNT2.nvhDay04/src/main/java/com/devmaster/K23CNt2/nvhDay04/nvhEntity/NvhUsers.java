package com.devmaster.K23CNt2.nvhDay04.nvhEntity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Getter
@Setter
public class NvhUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long nvhId;
    String nvhUsername;
    String nvhPassword;
    String nvhFullname;
    LocalDate nvhBirtDay;
    String nvhEmail;
    String nvhPhone;
    int nvhAge;
    boolean nvhStatus;
}
