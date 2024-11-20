package com.pblgllgs.restfulapi.dto;
/*
 *
 * @author pblgl
 * Created on 19-11-2024
 *
 */

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        name = "UserDTO",
        description = "UserDTO model information"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    @Schema(
            name = "firstName",
            description = "firstName variable"
    )
    @NotEmpty(message = "User first name should not be null or empty")
    private String firstName;
    @Schema(
            name = "lastName",
            description = "firstName variable"
    )
    @NotEmpty(message = "User last name should not be null or empty")
    private String lastName;
    @Schema(
            name = "Email",
            description = "Email variable"
    )
    @NotEmpty(message = "Email last name should not be null or empty")
    @Email(message = "Email should be valid")
    private String email;
}
