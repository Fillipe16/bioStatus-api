package com.biostatus.v10.controller;

import com.biostatus.v10.model.dto.FiltroDto;
import com.biostatus.v10.model.dto.StatusDto;
import com.biostatus.v10.service.StatusService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService service;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody StatusDto dto){
        try{
            service.save(dto);
            return ResponseEntity.status(201).build();
        }catch (RuntimeException e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable @Min(0) Long id, @RequestBody @Valid StatusDto dto){
        try{
            service.update(id,dto);
            return ResponseEntity.status(201).build();
        }catch (RuntimeException e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<StatusDto>> getAll(){
        try{
            var status = service.all();
            return ResponseEntity.ok().body(status);
        }catch (RuntimeException e){
            return ResponseEntity.internalServerError().body(new ArrayList<>());
        }
    }


    // TODO: fazer getByFiltro(filtro tem os parametros id_usuario, id_dados, data_inicial, data_final)

    @PostMapping("/search")
    public ResponseEntity<List<StatusDto>> search(@RequestBody @Valid FiltroDto filtro){
        try{
            var status = service.search(filtro);
            return ResponseEntity.ok().body(status);
        }catch (RuntimeException e){
            return ResponseEntity.internalServerError().body(new ArrayList<>());
        }
    }

}
