package edu.colegio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.colegio.entities.Alumno;
import edu.colegio.service.IAlumnoService;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

	@Autowired
	private IAlumnoService alumnoService;
	
	@GetMapping("/list")
	public String listarAlumnos(Model model) {
		try {
			model.addAttribute("listadoAlumnos", alumnoService.findAll());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "/alumno/list";
	}
	
	@GetMapping("/searchByApellidos")
	public String buscarAlumnosPorApellidos(Model model,
			@RequestParam("apellido") String apellido) {
		try {
			if(!apellido.isEmpty()){
				List<Alumno> alumnos = alumnoService.findByApellidos(apellido);
				if(!alumnos.isEmpty())
					model.addAttribute("listadoAlumnos",alumnos);
				else {
					model.addAttribute("info","No existen alumnos con ese apellido");
					model.addAttribute("listadoAlumnos",alumnoService.findAll());
				}
			}
			else {
				model.addAttribute("info","Ingrese un apellido");
				model.addAttribute("listadoAlumnos",alumnoService.findAll());
			}
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "/alumno/list";
	}
	
	@GetMapping("/search")
	public String buscarAlumnosPorDNI(Model model,
			@RequestParam("dni") String dni) {
		try {
			if(!dni.isEmpty() && dni.length()==8){
				Alumno alumno = alumnoService.findByDni(dni);
				if(alumno!=null)
					model.addAttribute("listadoAlumnos",alumno);
				else {
					model.addAttribute("info","No existen un alumno con ese DNI");
					model.addAttribute("listadoAlumnos",alumnoService.findAll());
				}
			}
			else {
				model.addAttribute("info","Ingrese un DNI correcto");
				model.addAttribute("listadoAlumnos",alumnoService.findAll());
			}
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "/alumno/list";
	}
	
	@GetMapping("/details/{id}")
	public String detallesAlumnoPorId(@PathVariable(value="id") Integer id,
			Model model) {
		try {
			Optional<Alumno> alumno = alumnoService.findById(id);
			
			if(!alumno.isPresent()) {
				model.addAttribute("info", "Alumno no existe");
				return "redirect:/alumnos/list";
			}
			else
				model.addAttribute("alumno",alumno.get());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "/alumno/details";
	}
}
