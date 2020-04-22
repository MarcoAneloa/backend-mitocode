package com.mitocode.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.dto.MenuRolDTO;
import com.mitocode.dto.UsuarioRolDTO;
import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Menu;
import com.mitocode.model.Usuario;
import com.mitocode.service.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private IUsuarioService service;

	@GetMapping
	public ResponseEntity<List<Usuario>> listar() {
		List<Usuario> lista = service.listar();
		return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> listarPorId(@PathVariable("id") Integer id) {
		Usuario obj = service.listarPorId(id);
		if (obj.getIdUsuario() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Usuario>(obj, HttpStatus.OK);
	}

	@PostMapping("/roles")
	public ResponseEntity<Object> registrarUsuarioRol(@Valid @RequestBody List<UsuarioRolDTO> lstUsuarioRol) {
		service.registrarUsuarioRol(lstUsuarioRol);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
