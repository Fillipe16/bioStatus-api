package com.biostatus.v10.repository;

import com.biostatus.v10.model.dto.FiltroDto;
import com.biostatus.v10.model.entity.Status;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StatusParamsRepository {

    public static final String ID_USUARIO = "ID_USUARIO";
    public static final String ID_DADOS = "ID_DADOS";
    public static final String DATA_INICIAL = "DATA_INICIAL";
    public static final String DATA_FINAL = "DATA_FINAL";
    @PersistenceContext
    private EntityManager em;

    public List<Status> searchByFilter(FiltroDto filtro){
        StringBuilder sql = new StringBuilder("SELECT s FROM Status s WHERE 1=1");
        List<String> params = new ArrayList<>();

        sql.append(this.montarClausulaWhere(filtro,params));

        final TypedQuery<Status> query = em.createQuery(sql.toString(),Status.class);
        this.addParams(query,params, filtro);

        return query.getResultList();
    }

    private void addParams(TypedQuery<Status> query, List<String> params, FiltroDto filtro) {
        if(params.contains(ID_USUARIO)){
            query.setParameter("id_usuario",filtro.getId_usuario().toString());
        }if(params.contains(ID_DADOS)){
            query.setParameter("id_dados",filtro.getId_dados());
        }if(params.contains(DATA_INICIAL)){
            query.setParameter("data_inicial",filtro.getData_inicial());
        }if(params.contains(DATA_FINAL)){
            query.setParameter("data_final",filtro.getData_final());
        }
    }

    private String montarClausulaWhere(FiltroDto filtro, List<String> params) {
        StringBuilder sql = new StringBuilder("");
        if(filtro.getId_usuario() != null){
            params.add(ID_USUARIO);
            sql.append(" AND usuario.id = :id_usuario");
        }
        if(filtro.getId_dados() != null){
            params.add(ID_DADOS);
            sql.append(" AND dados.id = :id_dados");
        }
        if(filtro.getData_inicial() != null){
            params.add(DATA_INICIAL);
            sql.append(" AND data >= :data_inicial");
        }
        if(filtro.getData_final() != null){
            params.add(DATA_FINAL);
            sql.append(" AND data <= :getData_final");
        }
        return sql.toString();
    }

}
