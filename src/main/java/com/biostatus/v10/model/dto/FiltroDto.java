package com.biostatus.v10.model.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FiltroDto {

    @Min(0)
    private Long id_usuario;
    @Min(0)
    private Long id_dados;
    private Date data_inicial;
    private Date data_final;

}
