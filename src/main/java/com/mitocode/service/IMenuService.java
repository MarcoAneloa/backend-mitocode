package com.mitocode.service;

import java.util.List;
import com.mitocode.model.Menu;
import com.mitocode.dto.MenuRolDTO;

public interface IMenuService extends ICRUD<Menu, Integer>{
	
	List<Menu> listarMenuPorUsuario(String nombre);
	
	Integer registrarMenuRol(List<MenuRolDTO> lstMenuRol);

}
