package com.sgc.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sgc.dao.ConfiguracionDao;
import com.sgc.domain.GcTabMstUtlPara;

@Service
public class ConfiguracionService {
	
	@Inject
	private ConfiguracionDao configuracionDao;
	
	public GcTabMstUtlPara buscarUsuarioPorCodigoUsuario(Map<String, Object> parametros){
		return configuracionDao.buscar("buscarUsuarioPorCodigoUsuario", parametros);
	}
	
	public List<GcTabMstUtlPara> obtenerListaParametro(Map<String, Object> parametros){
		return configuracionDao.buscarLista("buscarParametroPorCodigoGrupo", parametros);
	}

}
