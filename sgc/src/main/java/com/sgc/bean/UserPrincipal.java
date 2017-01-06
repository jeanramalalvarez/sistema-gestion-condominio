package com.sgc.bean;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.sgc.domain.GcTabMstSegUsua;

public class UserPrincipal extends User {
	
	private static final long serialVersionUID = 1L;
	
	private GcTabMstSegUsua usuario;

	public UserPrincipal(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, GcTabMstSegUsua usuario) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
		this.usuario = usuario;
	}

	public GcTabMstSegUsua getUsuario() {
		return usuario;
	}
	
	public void setUsuario(GcTabMstSegUsua usuario) {
		this.usuario = usuario;
	}

}
