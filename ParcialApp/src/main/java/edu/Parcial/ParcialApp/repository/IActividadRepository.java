package edu.Parcial.ParcialApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.Parcial.ParcialApp.entities.Actividad;

@Repository
public interface IActividadRepository extends JpaRepository<Actividad, Integer>{

	
}
