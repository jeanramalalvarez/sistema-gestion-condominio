package com.sgc.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sgc.bean.UserPrincipal;
import com.sgc.domain.GcTabMstSegOpcn;
import com.sgc.domain.GcTabMstSegRolOpcn;
import com.sgc.domain.GcTabMstSegUsua;
import com.sgc.domain.GcTabMstSegUsuaRol;
import com.sgc.util.Constantes;

@Service
public class UserLoginService implements UserDetailsService {
	
	@Inject
	private ServiceFactory serviceFactory;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("coUsua", username);
		GcTabMstSegUsua usuario = serviceFactory.seguridadService.buscarUsuarioPorCodigoUsuario(parametros);

		if (usuario == null) {
			throw new UsernameNotFoundException("User " + username + " not found");
		}

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		List<GcTabMstSegUsuaRol> roles = usuario.getGcTabMstSegUsuaRols();
		for (GcTabMstSegUsuaRol gcTabMstSegUsuaRol : roles) {
			authorities.add(new SimpleGrantedAuthority(gcTabMstSegUsuaRol.getGcTabMstSegRol().getCoRolIntr()));
		}
		String contrasena = usuario.getDeCont();
		usuario.setDeCont(null);
		
		List<GcTabMstSegOpcn> gcTabMstSegOpcns = new ArrayList<GcTabMstSegOpcn>();
		List<GcTabMstSegOpcn> gcTabMstSegOpcnHijos = new ArrayList<GcTabMstSegOpcn>();
		
		roles = usuario.getGcTabMstSegUsuaRols();
		for (GcTabMstSegUsuaRol gcTabMstSegUsuaRol : roles) {
			List<GcTabMstSegRolOpcn> rolOpcionList = gcTabMstSegUsuaRol.getGcTabMstSegRol().getGcTabMstSegRolOpcns();

			rolOpcionList = rolOpcionList.stream()
			.filter((p) -> p.getGcTabMstSegOpcn().getInRegiActi().equals(Constantes.ACTIVO.getValor()))
			.sorted(Comparator.comparing((p) -> p.getGcTabMstSegOpcn().getNuOrdn()))
			.collect(Collectors.toList());
			
			for (GcTabMstSegRolOpcn gcTabMstSegRolOpcn : rolOpcionList) {
				parametros = new HashMap<String, Object>();
				parametros.put("idOpcnPadr", gcTabMstSegRolOpcn.getGcTabMstSegOpcn().getIdOpcn());
				List<GcTabMstSegOpcn> opcionList = serviceFactory.seguridadService.buscarOpcionPorOpcionPadre(parametros);
				opcionList.sort(Comparator.comparing((p) -> p.getNuOrdn()));
				
				gcTabMstSegOpcnHijos = new ArrayList<GcTabMstSegOpcn>();
				for (GcTabMstSegOpcn gcTabMstSegOpcn : opcionList) {
					gcTabMstSegOpcnHijos.add(gcTabMstSegOpcn);
				}
				gcTabMstSegRolOpcn.getGcTabMstSegOpcn().setGcTabMstSegOpcnHijos(gcTabMstSegOpcnHijos);
				gcTabMstSegOpcns.add(gcTabMstSegRolOpcn.getGcTabMstSegOpcn());
			}
		}
		
		usuario.setGcTabMstSegOpcns(gcTabMstSegOpcns);
		
		return new UserPrincipal(username, contrasena, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities, usuario);
	}

}
