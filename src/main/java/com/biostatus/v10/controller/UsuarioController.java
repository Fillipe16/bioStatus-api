package com.biostatus.v10.controller;

import com.biostatus.v10.model.dto.UsuarioDto;
import com.biostatus.v10.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService service;

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar(@RequestBody UsuarioDto dto){
        try{
            service.save(dto);
            return ResponseEntity.status(201).build();
        }catch (RuntimeException e){
            return ResponseEntity.internalServerError().build();
        }
    }

}
