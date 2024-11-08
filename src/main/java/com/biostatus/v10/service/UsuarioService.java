package com.biostatus.v10.service;

import com.biostatus.v10.model.dto.UsuarioDto;
import com.biostatus.v10.model.entity.Usuario;
import com.biostatus.v10.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;


    public void save(UsuarioDto dto) {
        Usuario usuario = dto.toBean();
        try{
            usuarioRepository.save(usuario);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Erro ao salvar os dados do usuario",e);
        }
    }

    // TODO: fazer login() com getToken() e spring boot security

}
