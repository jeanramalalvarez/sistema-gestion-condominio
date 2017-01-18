package com.sgc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sgc.util.UtilJpa;

@Repository
public class ConfiguracionDao extends UtilJpa{
	
	public <T> T buscar(String query, Map<String, Object> parametros){
		return namedQuerySingleRresult(query, parametros);
	}
	
	public <T> List<T> buscarLista(String query, Map<String, Object> parametros){
		return namedQueryResultList(query, parametros);
	}

}