package com.biostatus.v10.model.dto;

import com.biostatus.v10.model.entity.Dados;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DadosDto {

    @Min(0)
    private Long id;

    @Min(0)
    @Max(500)
    private BigDecimal peso;
    @Min(0)
    @Max(50)
    private BigDecimal pressao_sistolica;
    @Min(0)
    @Max(50)
    private BigDecimal pressao_diastolica;

    @Min(0)
    private BigDecimal glicemia;
    @Min(0)
    @Max(300)
    private Integer frequencia_cardiaca;

    @NotNull
    private char sexo;

    public Dados asBean(){
        return Dados.builder()
                .peso(this.peso)
                .pressao_sistolica(this.pressao_sistolica)
                .pressao_diastolica(this.pressao_diastolica)
                .glicemia(this.glicemia)
                .frequencia_cardiaca(this.frequencia_cardiaca)
                .sexo(this.sexo)
                .build();
    }

}
