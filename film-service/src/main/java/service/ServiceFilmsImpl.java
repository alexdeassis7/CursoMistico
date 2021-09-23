package service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.FilmDao;
import model.Film;

@Service
public class ServiceFilmsImpl implements ServiceFilms {

	@Autowired
	FilmDao dao;
	
	
	@Override
	public List<Film> getFilms() {
		
		List<Film> films = dao.getFilms();
		Collections.shuffle(films, new Random(System.nanoTime()));
		
		return films;
	}

	@Override
	public Film getFilmById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Film getFilmByName(String name) {
		return null;
	}

	@Override
	public List<Film> getFilmsByGenre(String genre) {
		return null;
	}

	@Override
	public List<Film> getTopFilms() {
		return null;
	}







}
