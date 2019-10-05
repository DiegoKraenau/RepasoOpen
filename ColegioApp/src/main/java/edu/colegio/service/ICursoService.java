package edu.colegio.service;

import java.util.List;

import edu.colegio.entities.Curso;
import edu.colegio.entities.Grado;

public interface ICursoService extends CrudService<Curso> {
	List<Curso> findByGrado(Grado grado) throws Exception;
}
