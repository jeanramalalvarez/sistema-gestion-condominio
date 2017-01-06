package com.sgc.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.sgc.bean.UserPrincipal;
import com.sgc.domain.GcTabMstSegUsua;
import com.sgc.service.ServiceFactory;
import com.sgc.util.Constantes;
import com.sgc.util.FacesUtil;

@Named
@SessionScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private ServiceFactory serviceFactory;
	
	private GcTabMstSegUsua usuario = new GcTabMstSegUsua();

	@PostConstruct
	public void init() {
	}

	//@PreAuthorize(value = "hasRole('ADMIN')")
	public void delete(ActionEvent e) {
	}

	public String login() {
		logger.info("Starting to login");
		try {
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(usuario.getCoUsua(), usuario.getDeCont());
			Authentication authenticate = serviceFactory.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
			SecurityContextHolder.getContext().setAuthentication(authenticate);
			UserPrincipal userPrincipal = (UserPrincipal)authenticate.getPrincipal();
			usuario = userPrincipal.getUsuario();
			System.out.println(usuario);
			return "principal";
		} catch (Exception e) {
			logger.error("Error logger in " + e.getMessage());
			FacesUtil.addMessage(Constantes.ERROR, null, "Credenciales incorrectos. Intenta nuevamente");
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Login invalido", "Credenciales incorrectos. Intenta nuevamente"));
		}

		return null;
	}

	public String logout() {
		SecurityContextHolder.clearContext();
		return "login";
	}
	
	public GcTabMstSegUsua getUsuario() {
		return usuario;
	}
	
	public void setUsuario(GcTabMstSegUsua usuario) {
		this.usuario = usuario;
	}

}
