package com.sgc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sgc.domain.GcTabMstUtlPara;
import com.sgc.util.UtilJpa;

@Repository
public class ConfiguracionDao extends UtilJpa{
	
//	public GcTabMstUtlPara obtenerParametro(String query, Map<String, Object> parametros){
//		return namedQuerySingleRresult(query, parametros);
//	}
	
	public List<GcTabMstUtlPara> obtenerListaParametro(String query, Map<String, Object> parametros){
		return namedQueryResultList(query, parametros);
	}

}
