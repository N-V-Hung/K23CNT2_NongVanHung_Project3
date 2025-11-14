package com.devmaster.K23CNt2.nvhDay04.nvhDto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class NvhUserDTO {
    @NotBlank(message = "Username cannot be blank")
    @Size(min = 3, max = 20,message =  "Username must be between 3 and 20 characters")
    @Column(unique = true)
    String nvhUsername;

    @NotBlank(message = "Password canot be blank")
    @Size(min = 8,max =30, message = "Password must be beiween 8 and 30 characters")
    @Pattern(regexp = "(?=.*[0-9]) (?=.*[a-zA-Z]).(8,30)",
            message = "Password must contain at least letter and one number")
    String nvhPassword;

    @NotBlank(message = "Fullname cannot be blank")
    @Size(min = 2, max = 50,message =  "Fullname  must be between 3 and 20 characters")
    String nvhFullname;

    @Past(message = "BirtDay must be in the past")
    LocalDate nvhBirtDay;

    @Email(message =  "Email shoul be vaid")
    @NotBlank(message =  "Email canot be blank")
    @Column(unique = true)
    String nvhEmail;

    @Pattern(regexp = "\\+?[0-9. ()-]{7,25}$", message = "phone number is invalid")
    @NotBlank(message = "Phone number cannot be blank")
    String nvhPhone;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 100, message = "Age must be less than or equal to 100")
    int nvhAge;

    @NotBlank(message = "Status cannot be null")
    Boolean nvhStatus;

}
