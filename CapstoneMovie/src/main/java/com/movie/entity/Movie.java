package com.movie.entity;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Movie")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Movie_Id;
	private String Movie_Title;
	private LocalDate release_date;
	private Time Movie_Running_Time;
//	@ManyToMany(mappedBy = "movieList",fetch = FetchType.LAZY)
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "Movie_Director", 
            joinColumns = @JoinColumn(name = "Movie_Id", referencedColumnName = "Movie_Id"),
            inverseJoinColumns = @JoinColumn(name = "Director_Id", referencedColumnName = "Director_Id"))
	private Set<Director> directorSet = new HashSet<>();

	
	public Integer getMovie_Id() {
		return Movie_Id;
	}

	public void setMovie_Id(Integer movie_Id) {
		Movie_Id = movie_Id;
	}

	public Set<Director> getDirectorSet() {
		return directorSet;
	}

	public void setDirectorSet(Set<Director> directorSet) {
		this.directorSet = directorSet;
	}

	public Movie() {

	}

	public Movie(String movie_Title, LocalDate release_date, Time movie_Running_Time) {
		super();
//		Movie_Id = movie_Id;
		Movie_Title = movie_Title;
		this.release_date = release_date;
		Movie_Running_Time = movie_Running_Time;
	}

	

	public String getMovie_Title() {
		return Movie_Title;
	}

	public void setMovie_Title(String movie_Title) {
		Movie_Title = movie_Title;
	}

	public LocalDate getRelease_date() {
		return release_date;
	}

	public void setRelease_date(LocalDate release_date) {
		this.release_date = release_date;
	}

	public Time getMovie_Running_Time() {
		return Movie_Running_Time;
	}

	public void setMovie_Running_Time(Time movie_Running_Time) {
		Movie_Running_Time = movie_Running_Time;
	}

	@Override
	public String toString() {
		return "Movie\n"
				+ " Movie_Id=" + Movie_Id + ",\n Movie_Title=" + Movie_Title + ",\n release_date=" + release_date
				+ ",\n Movie_Running_Time=" + Movie_Running_Time;
	}

}
