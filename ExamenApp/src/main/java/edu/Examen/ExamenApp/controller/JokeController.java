package edu.Examen.ExamenApp.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.Examen.ExamenApp.entities.Joke;
import edu.Examen.ExamenApp.service.IJokeService;

@Controller
@RequestMapping("/jokes")
public class JokeController {

	@Autowired
	private IJokeService jokeService;
	
	@GetMapping("/list")
	public String listarJoke(Model model) {
		try {
			model.addAttribute("listadoJoke", jokeService.findAll());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "/joke/list";
	}
	
	@GetMapping("/agregar")
	public String agregarJoke(Model model) {
		
		return "/joke/agregar";
	}
	
	@PostMapping("/agregar")
	public String agregarJoke(Model model,String content) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String fecha=dateFormat.format(date);
	
			try {
				
				date=dateFormat.parse(fecha);
				Joke j1=new Joke();
				j1.setContent(content);
				j1.setContentAt(date);
				
				int k=0;
				List<Joke> jokes=jokeService.findAll();
				for (Joke joke : jokes) {
					if(content.equals(joke.getContent()))
					{
						k++;
					}
				}
				if(k==0) {
					jokeService.save(j1);
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		return "/joke/agregar";
	}
}
