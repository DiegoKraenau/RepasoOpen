package edu.Examen.ExamenApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.Examen.ExamenApp.entities.Joke;

@Repository
public interface IJokeRepository extends JpaRepository<Joke, Integer>{

}
