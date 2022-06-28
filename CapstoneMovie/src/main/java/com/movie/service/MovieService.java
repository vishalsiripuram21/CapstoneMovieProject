package com.movie.service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.CapstoneMovieApplication;
import com.movie.MovieAndDirectorDTO.MovieAndDirectorDTO;

import com.movie.entity.*;
import com.movie.repository.DirectorRepository;
import com.movie.repository.MovieRepository;
import com.movie.entity.*;
import com.movie.Exception.*;

@Transactional
@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepo;

	@Autowired
	DirectorRepository directorRepo;

	@Autowired
	MovieAndDirectorDTO obj;

	public List<Movie> get(){
		return movieRepo.findAll();
	}
	public void addMovie(MovieAndDirectorDTO d) throws MovieInsertionException{
		Movie m = new Movie();
		m.setMovie_Title(d.getMovie_Title());
		m.setRelease_date(LocalDate.parse(d.getRelease_date()));
		m.setMovie_Running_Time(Time.valueOf(d.getMovie_Running_Time()));
		Movie movieDbObj = movieRepo.findMovie(d.getMovie_Title(), LocalDate.parse(d.getRelease_date()),
				Time.valueOf(d.getMovie_Running_Time()));
		Director dire = new Director();
		dire.setFirst_Name(d.getDirector_First_Name());
		dire.setLast_Name(d.getDirector_Last_Name());
		java.util.Set<Director> setDirector = new HashSet<>();
		dire.setEmail(d.getDirector_Email());
		dire.setContact_Number(d.getDirector_Contact_Number());
		dire.setAddress(d.getDirector_Address());
		Director directorObj = directorRepo.findMovieByDirector(d.getDirector_First_Name(),
				d.getDirector_Last_Name());
		if (movieDbObj == null) {
			if (directorObj == null) {
				setDirector.add(dire);
				m.setDirectorSet(setDirector);
				movieRepo.save(m);
			} else {
				setDirector.add(directorObj);
				m.setDirectorSet(setDirector);
				movieRepo.save(m);
				System.out.println("movie added successfully");
			}
		} else if (directorObj == null) {

			java.util.Set<Movie> setMovie = new HashSet<>();
			setMovie.add(movieDbObj);
			dire.setMovieList(setMovie);
			directorRepo.save(dire);
			System.out.println("movie added successfully");
		} else {
			throw new MovieInsertionException("movie already existed");
		}

	}

	public void searchMovieusingTitle(MovieAndDirectorDTO dtoObj) throws InvalidMovieTitle {
		List<Movie> movies = movieRepo.findByMovieTitle(dtoObj.getMovie_Title());
		if(movies.size()==0)
			throw new InvalidMovieTitle("Movie title not matching");
		else {
			for (Movie movie : movies) {
				java.util.Set<Director> dobj = movie.getDirectorSet();
				System.out.println(movie);
				dobj.stream().forEach(System.out::println);
			}
		}
	}
	public void searchMovieUsingDirector(MovieAndDirectorDTO dtoObj) throws InvalidMovieTitle{
		Director director = directorRepo.findMovieByDirector(dtoObj.getDirector_First_Name(),dtoObj.getDirector_Last_Name());
		if(director == null)
			throw new InvalidMovieTitle("director not found");
		else {
			java.util.Set<Movie> movieObj = director.getMovieList();
			movieObj.stream().forEach(System.out::println);
		}
	}
	public void searchDirectorUsingMovieTitle(MovieAndDirectorDTO dtoObj) throws InvalidMovieTitle{
		List<Movie> movies = movieRepo.findByMovieTitle(dtoObj.getMovie_Title());
		if(movies.size()==0)
			throw new InvalidMovieTitle("Movie title not matching");
		else {
			movies.stream().map(e->e.getDirectorSet()).forEach(System.out::println);
		}
	}
	public void updateMovieReleaseDate(MovieAndDirectorDTO dtoObj)throws InvalidMovieTitle {
		Integer ret = movieRepo.updateMovieReleaseDate(LocalDate.parse(dtoObj.getRelease_date()),dtoObj.getMovie_Title());
		if(ret == 1)
			System.out.println("Release date updated successfully");
		else
			throw new InvalidMovieTitle("director details not matching");
	}
	public void updateDirectorDetails(MovieAndDirectorDTO dtoObj) throws InvalidDirectorName{
		Integer ret = directorRepo.updateDirectorDetails(dtoObj.getDirector_First_Name(),dtoObj.getDirector_Last_Name(),dtoObj.getDirector_Address(),dtoObj.getDirector_Contact_Number());
		if(ret == 1)
			System.out.println("director details update successfully");
		else
			throw new InvalidDirectorName("director details not matching");
	}
	public void removeMovie(MovieAndDirectorDTO dtoObj)throws InvalidMovieTitle {
		Integer ret = movieRepo.removeMovie(dtoObj.getMovie_Title());
		if(ret == 1)
			System.out.println("Movie deleted successfully");
		else
			throw new InvalidMovieTitle("movie title not matching");
	}
}
