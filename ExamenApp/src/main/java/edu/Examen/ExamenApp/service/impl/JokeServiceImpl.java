package edu.Examen.ExamenApp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.Examen.ExamenApp.entities.Joke;
import edu.Examen.ExamenApp.repository.IJokeRepository;
import edu.Examen.ExamenApp.service.IJokeService;

@Service
public class JokeServiceImpl implements IJokeService{

	@Autowired
	private IJokeRepository jokeRepository;
	
	@Override
	public Joke save(Joke t) throws Exception {
		// TODO Auto-generated method stub
		return jokeRepository.save(t);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		jokeRepository.deleteById(id);
	}

	@Override
	public Optional<Joke> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return jokeRepository.findById(id);
	}

	@Override
	public List<Joke> findAll() throws Exception {
		// TODO Auto-generated method stub
		return jokeRepository.findAll();
	}

}
