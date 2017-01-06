package com.sgc.util;

public enum Constantes {
	
	ACTIVO("1"),
	INACTIVO("0"),
	SISTEMA("SGC"),
	INFO("INFO"),
	WARN("WARN"),
	ERROR("ERROR"),
	FATAL("FATAL"),
	;
	
	private final String valor;
	
	Constantes(String valor){
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}

}
