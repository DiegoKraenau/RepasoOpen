package edu.Parcial.ParcialApp.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.Parcial.ParcialApp.entities.Actividad;
import edu.Parcial.ParcialApp.repository.IActividadRepository;
import edu.Parcial.ParcialApp.services.IActividadService;

@Service
public class ActividadServiceImpl implements IActividadService{

	@Autowired
	private IActividadRepository actividadRepository;
	
	@Override
	public Actividad save(Actividad t) throws Exception {
		// TODO Auto-generated method stub
		return actividadRepository.save(t);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		actividadRepository.deleteById(id);
	}

	@Override
	public Optional<Actividad> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return actividadRepository.findById(id);
	}

	@Override
	public List<Actividad> findAll() throws Exception {
		// TODO Auto-generated method stub
		return actividadRepository.findAll();
	}

}
