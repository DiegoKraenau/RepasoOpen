package edu.Parcial.ParcialApp.controller;

import java.text.ParseException;
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

import edu.Parcial.ParcialApp.entities.Proyecto;
import edu.Parcial.ParcialApp.services.IProyectoService;

@Controller
@RequestMapping("/proyectos")
public class ProyectoController {
	
	@Autowired
	private IProyectoService proyectoService;
	
	@GetMapping("/list")
	public String listarProyecto(Model model) {
		
		try {
			model.addAttribute("listadoProyecto", proyectoService.findAll());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "/proyecto/list";
	}
	
	@GetMapping("/agregar")
	public String agregarProyecto(Model model) {
		
		
		return "/proyecto/agregar";
	}
	
	@PostMapping("/agregar")
	public String agregarProyecto(Model model,String nombre,String descripcion,String fechaInicio,String fechaFin) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		Date date2;
		try {
			date=formato.parse(fechaInicio);
			date2=formato.parse(fechaFin);
			
			Proyecto p1=new Proyecto();
			p1.setNombre(nombre);
			p1.setDescripcion(descripcion);
			p1.setFechaInicio(date);
			p1.setFechaFin(date2);
			
			try {
				model.addAttribute("registrarProyecto", proyectoService.save(p1));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		
		
		return "/proyecto/agregar";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalleProyecto(@PathVariable(value="id") Integer id,Model model ) {
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
		
		return "/proyecto/detalle";
	}
	

}
