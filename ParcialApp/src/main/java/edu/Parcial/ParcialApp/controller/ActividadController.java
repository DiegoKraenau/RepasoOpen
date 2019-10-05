package edu.Parcial.ParcialApp.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.Parcial.ParcialApp.entities.Actividad;
import edu.Parcial.ParcialApp.entities.Proyecto;
import edu.Parcial.ParcialApp.services.IActividadService;
import edu.Parcial.ParcialApp.services.IProyectoService;

@Controller
@RequestMapping("/actividades")
public class ActividadController {

	@Autowired
	private IActividadService actividadService;
	
	@Autowired
	private IProyectoService proyectoService;
	
	@GetMapping("/agregar/{id}")
	public String agregarActividad(@PathVariable(value="id") Integer id,Model model) {
		try {
			Optional<Proyecto> proyecto = proyectoService.findById(id);
			
			if(!proyecto.isPresent()) {
				model.addAttribute("info", "Proyecto no existe");
				return "redirect:/proyecto/list";
			}
			else
				model.addAttribute("proyecto",proyecto.get());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		
		return "/actividad/agregar";
	}

	@PostMapping("/agregar")
	public String agregarActividad(Model model,String prioridad,String descripcion,String fechaInicio,String fechaFin,int idproyecto,int estado,String programador) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		Date date2;
		
		try {
			date=formato.parse(fechaInicio);
			date2=formato.parse(fechaFin);
			Optional<Proyecto> proyecto = proyectoService.findById(idproyecto);
			Actividad a1=new Actividad();
			a1.setPrioridad(prioridad);
			a1.setDescripcion(descripcion);
			a1.setFechaInicio(date);
			a1.setFechaFin(date2);
			a1.setEstado(1);
			a1.setProgramador(programador);
			a1.setProyecto(proyecto.get());
			
			model.addAttribute("registrarActividad",actividadService.save(a1));
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	
		
		
		return "/proyecto/list";
	}
}
