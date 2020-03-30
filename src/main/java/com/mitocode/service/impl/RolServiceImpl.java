package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Especialidad;
import com.mitocode.model.Rol;
import com.mitocode.repo.IRolRepo;
import com.mitocode.service.IRolService;

@Service
public class RolServiceImpl implements IRolService{
	
	@Autowired
	private IRolRepo repo;

	@Override
	public Rol registrar(Rol obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public Rol modificar(Rol obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public List<Rol> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Rol listarPorId(Integer id) {
		// TODO Auto-generated method stub
		Optional<Rol> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Rol();
	}

	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return true;
	}

}
