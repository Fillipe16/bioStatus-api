package com.biostatus.v10.service;

import com.biostatus.v10.model.dto.FiltroDto;
import com.biostatus.v10.model.dto.StatusDto;
import com.biostatus.v10.model.entity.Dados;
import com.biostatus.v10.model.entity.Status;
import com.biostatus.v10.model.entity.Usuario;
import com.biostatus.v10.repository.DadosRepository;
import com.biostatus.v10.repository.StatusParamsRepository;
import com.biostatus.v10.repository.StatusRepository;
import com.biostatus.v10.repository.UsuarioRepository;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StatusService {

    @Autowired
    private StatusRepository repository;

    @Autowired
    private DadosRepository dadosRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private StatusParamsRepository paramsRepository;

    public List<StatusDto> all() {
        try{
            return repository.findAll().stream()
                    .map(Status::asDto).toList();
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Erro ao consultar os status",e);
        }
    }

    public void save(StatusDto dto) {
        Dados dados = dto.getDados().asBean();
        try{

            Long idUsuario = dto.getUsuario().getId();
            Usuario usuario = null;
            if(idUsuario != null){
                usuario = usuarioRepository.getReferenceById(idUsuario);
            }
            dadosRepository.save(dados);

            Status status = new Status();
            status.setDados(dados);
            // TODO: ver uma forma de capturar o usuario logado
            status.setUsuario(usuario);
            status.setData(new Date());

            repository.save(status);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Erro ao salvar o status",e);
        }
    }

    public void update(Long id, StatusDto dto) {
        Dados dadosNovos = dto.getDados().asBean();
        try{
            Status status = repository.getReferenceById(id);
            if (status == null) {
                throw new NullPointerException("O id enviado não está associado a um status");
            }

            Dados dadosSalvos = status.getDados();
            dadosSalvos.update(dadosNovos);
            status.setDados(dadosSalvos);

            repository.save(status);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Erro ao salvar o status",e);
        }
    }

    public List<StatusDto> search(FiltroDto filtro) {
        try{
            return paramsRepository.searchByFilter(filtro)
                    .stream()
                    .map(Status::asDto).toList();
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Erro ao consultar os status pelo filtro",e);
        }
    }
}
