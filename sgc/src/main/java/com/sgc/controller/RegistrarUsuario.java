package com.sgc.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sgc.service.ServiceFactory;

@Named
@ViewScoped
public class RegistrarUsuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private ServiceFactory serviceFactory;
//
//	private Usuario usuario = new Usuario();
//	
//	public void preparar(){
//		logger.info("");
//	}
//
//	public void registrarUsuario() {
//		logger.info("");
//		FacesContext context = FacesContext.getCurrentInstance();
//
//		try {
//
//			Calendar fechaCrea = Calendar.getInstance();
//
//			usuario.setInRegiActi(Constantes.ACTIVO.getValor());
//			usuario.setCoUsuaCrea("ADMIN");
//			usuario.setFeUsuaCrea(fechaCrea.getTime());
//			usuario.setIpUsuaCrea("192.168.1.5");
//
//			serviceFactory.usuarioService.registrar(usuario);
//			usuario = new Usuario();
//			context.addMessage(null, new FacesMessage("Se registro correctamente"));
//			
//		} catch (NegocioException e) {
//			FacesMessage mensagem = new FacesMessage(e.getMessage());
//			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
//			context.addMessage(null, mensagem);
//		} catch (Exception e) {
//			FacesMessage mensagem = new FacesMessage("Se produjo un error.");
//			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
//			context.addMessage(null, mensagem);
//			e.printStackTrace();
//		} 
//	}
//
//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}

}
