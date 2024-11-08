package com.biostatus.v10.model.entity;

import com.biostatus.v10.model.dto.StatusDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public ",name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne()
    @JoinColumn(name = "id_dados", referencedColumnName = "id")
    private Dados dados;

    private Date data;

    public StatusDto asDto() {
        return StatusDto.builder()
                .data(this.data)
                .dados(this.dados.asDto())
                .usuario(this.usuario.asDto())
                .build();
    }
}
