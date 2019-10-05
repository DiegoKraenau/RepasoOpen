package edu.colegio.service;

import java.util.Date;
import java.util.List;

import edu.colegio.entities.Matricula;

public interface IMatriculaService extends CrudService<Matricula> {
	List<Matricula> findMatriculasEntreFechas(Date fechaInicio, Date fechaFinal) throws Exception;
}
