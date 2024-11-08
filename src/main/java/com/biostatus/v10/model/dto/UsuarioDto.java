package com.biostatus.v10.model.dto;

import com.biostatus.v10.model.entity.Usuario;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

    @Min(0)
    private Long id;

    @NotNull
    @Size(min = 0,max = 100)
    private String nome;

    @NotNull
    @Email()
    private String email;

    @NotNull
    @Size(min = 0,max = 100)
    private String password;

    public Usuario toBean(){
        return Usuario.builder()
                .nome(this.getNome())
                .email(this.getEmail())
                .password(this.getPassword())
                .build();
    }

}
