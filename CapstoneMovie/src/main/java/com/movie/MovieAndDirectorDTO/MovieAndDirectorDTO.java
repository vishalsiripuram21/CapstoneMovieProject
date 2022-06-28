package com.movie.MovieAndDirectorDTO;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movie.entity.Director;
import com.movie.entity.Movie;
import com.movie.service.MovieService;

@Component
public class MovieAndDirectorDTO {


	private String Movie_Title;
	private String release_date;
	private String Movie_Running_Time;
	private Set<Director> directorSet;
	private String Director_First_Name;
	private String Director_Last_Name;
	private String Director_Address;
	private String Director_Contact_Number;
	private String Director_Email;
	private Set<Movie> movieSet;
	public MovieAndDirectorDTO() {
	}
	public MovieAndDirectorDTO(String movie_Title, String release_date, String movie_Running_Time,
			Set<Director> directorSet, String director_First_Name, String director_Last_Name, String director_Address,
			String director_Contact_Number, String director_Email, Set<Movie> movieSet) {
		super();
		Movie_Title = movie_Title;
		this.release_date = release_date;
		Movie_Running_Time = movie_Running_Time;
		this.directorSet = directorSet;
		Director_First_Name = director_First_Name;
		Director_Last_Name = director_Last_Name;
		Director_Address = director_Address;
		Director_Contact_Number = director_Contact_Number;
		Director_Email = director_Email;
		this.movieSet = movieSet;
	}
	
	public String getMovie_Title() {
		return Movie_Title;
	}
	public void setMovie_Title(String movie_Title) {
		Movie_Title = movie_Title;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getMovie_Running_Time() {
		return Movie_Running_Time;
	}
	public void setMovie_Running_Time(String movie_Running_Time) {
		Movie_Running_Time = movie_Running_Time;
	}
	public Set<Director> getDirectorSet() {
		return directorSet;
	}
	public void setDirectorSet(Set<Director> directorSet) {
		this.directorSet = directorSet;
	}
	public String getDirector_First_Name() {
		return Director_First_Name;
	}
	public void setDirector_First_Name(String director_First_Name) {
		Director_First_Name = director_First_Name;
	}
	public String getDirector_Last_Name() {
		return Director_Last_Name;
	}
	public void setDirector_Last_Name(String director_Last_Name) {
		Director_Last_Name = director_Last_Name;
	}
	public String getDirector_Address() {
		return Director_Address;
	}
	public void setDirector_Address(String director_Address) {
		Director_Address = director_Address;
	}
	public String getDirector_Contact_Number() {
		return Director_Contact_Number;
	}
	public void setDirector_Contact_Number(String director_Contact_Number) {
		Director_Contact_Number = director_Contact_Number;
	}
	public String getDirector_Email() {
		return Director_Email;
	}
	public void setDirector_Email(String director_Email) {
		Director_Email = director_Email;
	}
	public Set<Movie> getMovieSet() {
		return movieSet;
	}
	public void setMovieSet(Set<Movie> movieSet) {
		this.movieSet = movieSet;
	}
	
}
