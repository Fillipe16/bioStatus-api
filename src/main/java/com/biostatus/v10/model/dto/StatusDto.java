package com.biostatus.v10.model.dto;

import com.biostatus.v10.model.entity.Status;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatusDto {

    @Valid
    private UsuarioDto usuario;
    @Valid
    private DadosDto dados;
    private Date data;
}
