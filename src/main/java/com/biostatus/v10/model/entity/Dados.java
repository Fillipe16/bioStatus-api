package com.biostatus.v10.model.entity;

import com.biostatus.v10.model.dto.DadosDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public ",name = "dados")
public class Dados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private BigDecimal peso;
    private BigDecimal pressao_sistolica;
    private BigDecimal pressao_diastolica;
    private BigDecimal glicemia;
    private Integer frequencia_cardiaca;
    private char sexo;

    public DadosDto asDto(){
        return DadosDto.builder()
                .id(this.id)
                .peso(this.peso)
                .pressao_sistolica(this.pressao_sistolica)
                .pressao_diastolica(this.pressao_diastolica)
                .frequencia_cardiaca(this.frequencia_cardiaca)
                .glicemia(this.glicemia)
                .sexo(this.sexo)
                .build();
    }

    public BigDecimal getIndice() {
        // Calculo ficticio
        return BigDecimal.valueOf(this.pressao_diastolica.floatValue()/this.pressao_sistolica.floatValue()*this.peso.floatValue());
    }

    public void update(Dados dadosNovos) {
        if(dadosNovos.getPeso() != null){
            this.peso = dadosNovos.getPeso();
        }if(dadosNovos.getPressao_sistolica() != null){
            this.pressao_sistolica = dadosNovos.getPressao_sistolica();
        }if(dadosNovos.getPressao_diastolica() != null){
            this.pressao_diastolica = dadosNovos.getPressao_diastolica();
        }if(dadosNovos.getFrequencia_cardiaca() != null){
            this.frequencia_cardiaca = dadosNovos.getFrequencia_cardiaca();
        }if(dadosNovos.getGlicemia() != null){
            this.glicemia = dadosNovos.getGlicemia();
        }if(String.valueOf(dadosNovos.getSexo()) != null){
            this.sexo = dadosNovos.getSexo();
        }
    }
}
