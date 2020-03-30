package com.mitocode.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Rol;
import com.mitocode.service.IRolService;

@RestController
@RequestMapping("/roles")
public class RolController {
	 @Autowired
	 private IRolService service;
	 
	 @GetMapping
		public ResponseEntity<List<Rol>> listar(){
			List<Rol> lista = service.listar();
			return new ResponseEntity<List<Rol>>(lista, HttpStatus.OK);
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Rol> listarPorId(@PathVariable("id") Integer id) {
			Rol obj = service.listarPorId(id);
			if(obj.getIdRol() == null) {
				throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
			}
			return new ResponseEntity<Rol>(obj, HttpStatus.OK);
		}
		
		@PostMapping
		public ResponseEntity<Object> registrar(@Valid @RequestBody Rol objeto) {
			Rol pac = service.registrar(objeto);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pac.getIdRol()).toUri();
			return ResponseEntity.created(location).build();
		}
		
		@PutMapping
		public ResponseEntity<Rol> modificar(@Valid @RequestBody Rol objeto) {
			Rol obj = service.modificar(objeto);
			return new ResponseEntity<Rol>(obj, HttpStatus.OK);
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
			service.eliminar(id);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}
}

