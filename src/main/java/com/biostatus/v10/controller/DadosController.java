package com.biostatus.v10.controller;

import com.biostatus.v10.model.dto.DadosDto;
import com.biostatus.v10.service.DadosService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dados")
public class DadosController {

    @Autowired
    private DadosService service;

    @GetMapping("")
    public ResponseEntity<List<DadosDto>> getALl(){
        try{
            var dados = service.all();
            return ResponseEntity.ok().body(dados);
        }catch (RuntimeException e){
            return ResponseEntity.internalServerError().body(new ArrayList<>());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable @Min(0) Long id){
        if(id == null){
            return ResponseEntity.badRequest().body("O id não pode ser NULL");
        }
        try{
            var dado = service.one(id);
            if(dado ==  null){
                return ResponseEntity.ok().body("Não há dados com o id enviado!");
            }
            return ResponseEntity.ok().body(dado);
        }catch (RuntimeException e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}/calcularIndice")
    public ResponseEntity calculaIndice(@PathVariable @Min(0) Long id){
        if(id == null){
            return ResponseEntity.badRequest().body("O id não pode ser NULL");
        }
        try{
            var indice = service.calculaIndice(id);
            if(indice ==  null){
                return ResponseEntity.ok().body("Não há dados com o id enviado!");
            }
            return ResponseEntity.ok().body(indice);
        }catch (RuntimeException e){
            return ResponseEntity.internalServerError().build();
        }
    }

}
