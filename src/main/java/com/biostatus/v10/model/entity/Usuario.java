package com.biostatus.v10.model.entity;

import com.biostatus.v10.model.dto.UsuarioDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public ",name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;

    private String email;

    private String password;

    public UsuarioDto asDto() {
        return UsuarioDto.builder()
                .id(this.id)
                .nome(this.nome)
                .email(this.email)
                .password(this.password)
                .build();
    }
}
