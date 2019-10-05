package edu.colegio.service;

import java.util.List;

import edu.colegio.entities.Alumno;

public interface IAlumnoService extends CrudService<Alumno> {
	List<Alumno> findByApellidos(String apellidos) throws Exception;
	Alumno findByDni(String dni) throws Exception;
}
