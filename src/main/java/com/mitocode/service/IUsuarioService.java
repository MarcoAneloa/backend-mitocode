package com.mitocode.service;


import java.util.List;

import com.mitocode.dto.UsuarioRolDTO;
import com.mitocode.model.Usuario;

public interface IUsuarioService extends ICRUD<Usuario, Integer>{
	Integer registrarUsuarioRol(List<UsuarioRolDTO> lstUsuarioRol);
}
