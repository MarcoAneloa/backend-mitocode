package com.mitocode.dto;

import java.io.Serializable;

public class UsuarioRolDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer idUsuario;
	private Integer idRol;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idMenu) {
		this.idUsuario = idMenu;
	}
	public Integer getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	
	
}
