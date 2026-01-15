package com.skald.ats.inventory.api.dto;

import com.skald.ats.inventory.api.model.users.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "O login deve ser informado")
    private String login;

    @NotBlank(message = "A senha deve ser informada")
    private String password;

    @NotNull(message = "O perfil do usuario deve ser informado")
    private String role;

    UserDTO(){}

}
