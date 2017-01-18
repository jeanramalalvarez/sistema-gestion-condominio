package com.sgc.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sgc.dao.SeguridadDao;
import com.sgc.domain.GcTabMstSegOpcn;
import com.sgc.domain.GcTabMstSegUsua;

@Service
public class SeguridadService {
	
	@Inject
	private SeguridadDao seguridadDao;
	
	public GcTabMstSegUsua buscarUsuarioPorCodigoUsuario(Map<String, Object> parametros){
		return seguridadDao.buscar("buscarUsuarioPorCodigoUsuario", parametros);
	}
	
	public List<GcTabMstSegOpcn> buscarOpcionPorOpcionPadre(Map<String, Object> parametros){
		return seguridadDao.buscarLista("buscarOpcionPorOpcionPadre", parametros);
	}

}
