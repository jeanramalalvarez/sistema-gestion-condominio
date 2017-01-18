package com.sgc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sgc.domain.GcTabMstSegOpcn;
import com.sgc.domain.GcTabMstSegUsua;
import com.sgc.util.UtilJpa;

@Repository
public class SeguridadDao extends UtilJpa{
	
	public GcTabMstSegUsua obtenerUsuario(String query, Map<String, Object> parametros){
		return namedQuerySingleRresult(query, parametros);
	}
	
	public List<GcTabMstSegUsua> obtenerListaUsuario(String query, Map<String, Object> parametros){
		return namedQuerySingleRresult(query, parametros);
	}
	
	public List<GcTabMstSegOpcn> obtenerListaOpcion(String query, Map<String, Object> parametros){
		return namedQueryResultList(query, parametros);
	}

}
