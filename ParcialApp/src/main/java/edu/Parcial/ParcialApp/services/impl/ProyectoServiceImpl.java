package edu.Parcial.ParcialApp.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.Parcial.ParcialApp.entities.Proyecto;
import edu.Parcial.ParcialApp.repository.IProyectoRepository;
import edu.Parcial.ParcialApp.services.IProyectoService;

@Service
public class ProyectoServiceImpl implements IProyectoService {

	@Autowired
	private IProyectoRepository proyectoRepository;
	
	@Override
	public Proyecto save(Proyecto t) throws Exception {
		// TODO Auto-generated method stub
		return proyectoRepository.save(t);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		proyectoRepository.deleteById(id);
	}

	@Override
	public Optional<Proyecto> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return proyectoRepository.findById(id);
	}

	@Override
	public List<Proyecto> findAll() throws Exception {
		// TODO Auto-generated method stub
		return proyectoRepository.findAll();
	}

}
