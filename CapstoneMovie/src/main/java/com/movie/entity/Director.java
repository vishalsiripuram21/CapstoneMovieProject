package com.movie.entity;

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
@Table(name = "Director")
public class Director {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Director_Id;
	private String First_Name;
	private String Last_Name;
	private String Address;
	private String Contact_Number;
	private String Email;
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "Movie_Director", 
            joinColumns = @JoinColumn(name = "Director_Id", referencedColumnName = "Director_Id"),
            inverseJoinColumns = @JoinColumn(name = "Movie_Id", referencedColumnName = "Movie_Id"))
	private Set<Movie> movieList = new HashSet<Movie>();
	
	public Set<Movie> getMovieList() {
		return movieList;
	}
	public void setMovieList(Set<Movie> movieList) {
		this.movieList = movieList;
	}
	public Director() {
	}
	public Director(String first_Name, String last_Name, String address, String contact_Number, String email) {
		super();
		First_Name = first_Name;
		Last_Name = last_Name;
		Address = address;
		Contact_Number = contact_Number;
		Email = email;
//		this.movieList = movieList;
	}
	public Integer getDirector_Id() {
		return Director_Id;
	}
	public void setDirector_Id(Integer director_Id) {
		Director_Id = director_Id;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getContact_Number() {
		return Contact_Number;
	}
	public void setContact_Number(String contact_Number) {
		Contact_Number = contact_Number;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@Override
	public String toString() {
		return "\nDirector\n Director_Id=" + Director_Id + ",\n First_Name=" + First_Name + ", Last_Name=" + Last_Name
				+ ",\n Address=" + Address + ",\n Contact_Number=" + Contact_Number + ",\n Email=" + Email;
	}
	

}
