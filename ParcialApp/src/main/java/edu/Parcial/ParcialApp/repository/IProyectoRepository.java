package edu.Parcial.ParcialApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.Parcial.ParcialApp.entities.Proyecto;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Integer>{

	
}
