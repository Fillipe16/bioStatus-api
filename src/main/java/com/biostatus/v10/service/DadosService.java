package com.biostatus.v10.service;

import com.biostatus.v10.model.dto.DadosDto;
import com.biostatus.v10.model.entity.Dados;
import com.biostatus.v10.model.entity.Status;
import com.biostatus.v10.repository.DadosRepository;
import com.biostatus.v10.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class DadosService {

    @Autowired
    private DadosRepository dadosRepository;

    @Autowired
    private StatusRepository statusRepository;


    private void saveStatus(Dados dados) {

    }

    public List<DadosDto> all() {
        try{
            return dadosRepository.findAll().stream()
                    .map(Dados::asDto).toList();
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Erro ao consultar os dados",e);
        }
    }

    public DadosDto one(Long id) {
        try{
            Dados dado = dadosRepository.getReferenceById(id);
            if(dado != null){
                return dado.asDto();
            }
            return null;
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Erro ao consultar os dados",e);
        }
    }

    public BigDecimal calculaIndice(Long id) {
        Dados dados = this.one(id).asBean();
        if(dados == null){
            return null;
        }
        return dados.getIndice();
    }
}
