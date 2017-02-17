package com.sgc.pruebas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sgc.domain.GcTabMstPers;
import com.sgc.domain.GcTabMstSegOpcn;
import com.sgc.domain.GcTabMstSegRolOpcn;
import com.sgc.domain.GcTabMstSegUsua;
import com.sgc.domain.GcTabMstSegUsuaRol;
import com.sgc.domain.GcTabMstUtlPara;
import com.sgc.service.ServiceFactory;

public class Pruebas extends AbstractBaseUnitTest {

	@Autowired
	ServiceFactory serviceFactory;

	//@Test
	public void obtenerListaParametro() throws Exception {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("coPara", null);
		parametros.put("coGrupPara", "TIPO_UNID");
		List<GcTabMstUtlPara> lista = serviceFactory.configuracionService.obtenerListaParametro(parametros);
		for (GcTabMstUtlPara gcTabMstUtlPara : lista) {
			System.out.println(gcTabMstUtlPara);			
		}
	}
	
	@Test
	public void buscarUsuarioPorCodigoUsuario() throws Exception {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("coUsua", "admin");
		GcTabMstSegUsua usuario = serviceFactory.seguridadService.buscarUsuarioPorCodigoUsuario(parametros);
		System.out.println(usuario);
		GcTabMstPers persona = usuario.getGcTabMstPer();
		System.out.println(persona);
		
		System.out.println("Obtener roles");
		List<GcTabMstSegUsuaRol> roles = usuario.getGcTabMstSegUsuaRols();
		for (GcTabMstSegUsuaRol gcTabMstSegUsuaRol : roles) {
			System.out.println("- " + gcTabMstSegUsuaRol.getGcTabMstSegRol().getCoRol());
			System.out.println("\t" + "Obtener Opciones");
			List<GcTabMstSegRolOpcn> rolOpcion = gcTabMstSegUsuaRol.getGcTabMstSegRol().getGcTabMstSegRolOpcns();
			for (GcTabMstSegRolOpcn gcTabMstSegRolOpcn : rolOpcion) {
				System.out.println("\t - " + gcTabMstSegRolOpcn.getGcTabMstSegOpcn().getDeOpcn());
				Map<String, Object> parametros2 = new HashMap<String, Object>();
				parametros2.put("idOpcnPadr", gcTabMstSegRolOpcn.getGcTabMstSegOpcn().getIdOpcn());
				List<GcTabMstSegOpcn> opciones = serviceFactory.seguridadService.buscarOpcionPorOpcionPadre(parametros2);
				System.out.println("\t\t" + "Obtener sub Opciones");
				for (GcTabMstSegOpcn gcTabMstSegOpcn : opciones) {
					System.out.println("\t\t- " + gcTabMstSegOpcn.getDeOpcn());
				}
			}
		}
		
	}

}
