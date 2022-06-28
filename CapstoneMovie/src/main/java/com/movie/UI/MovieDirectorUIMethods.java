package com.movie.UI;


import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.movie.Exception.InvalidDirectorName;
import com.movie.Exception.InvalidMovieTitle;
import com.movie.Exception.MovieInsertionException;
import com.movie.MovieAndDirectorDTO.MovieAndDirectorDTO;
import com.movie.service.MovieService;

@Component
public class MovieDirectorUIMethods {

	@Autowired
	MovieAndDirectorDTO dtoObj;
	@Autowired
	MovieService service;
	static Scanner sc = new Scanner(System.in);

	public void movieAndDirectorDetailsInsertion() {
		String Movie_Title;
		String release_date;
		String Movie_Running_Time;
		String Director_First_Name;
		String Director_Last_Name;
		String Director_Address;
		String Director_Contact_Number;
		String Director_Email;
		System.out.println("enter Movie title");
		Movie_Title = sc.nextLine();
		System.out.println("enter movie release date in YYYY-MM-DD format");
		release_date = sc.nextLine();
		System.out.println("enter movie running time HH:MM:SS");
		Movie_Running_Time = sc.nextLine();
		System.out.println("enter director first name");
		Director_First_Name = sc.nextLine();
		System.out.println("enter director last name");
		Director_Last_Name = sc.nextLine();
		System.out.println("enter director address");
		Director_Address = sc.nextLine();
		System.out.println("enter director contact number");
		Director_Contact_Number = sc.nextLine();
		System.out.println("enter director email");
		Director_Email = sc.nextLine();
		dtoObj.setDirector_Address(Director_Address);
		dtoObj.setDirector_Contact_Number(Director_Contact_Number);
		dtoObj.setDirector_Email(Director_Email);
		dtoObj.setDirector_First_Name(Director_First_Name);
		dtoObj.setDirector_Last_Name(Director_Last_Name);
		dtoObj.setMovie_Running_Time(Movie_Running_Time);
		dtoObj.setMovie_Title(Movie_Title);
		dtoObj.setRelease_date(release_date);
		try {
		service.addMovie(dtoObj);
		}
		catch (MovieInsertionException e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}

	public void searchMovieusingTitle(String title) throws InvalidMovieTitle {
		dtoObj.setMovie_Title(title);
		try {
		service.searchMovieusingTitle(dtoObj);
		}
		catch (InvalidMovieTitle e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		
	}
	public void searchMovieUsingDirector(String firstName,String lastName) throws InvalidDirectorName{
		dtoObj.setDirector_First_Name(firstName);
		dtoObj.setDirector_Last_Name(lastName);
		try {
		service.searchMovieUsingDirector(dtoObj);
		}
		catch(InvalidMovieTitle e) {
			System.err.println("Invalid Movie Title");
		}
		
	}
	public void searchDirectorUsingMovieTitle(String movieTitle) throws InvalidMovieTitle{
		dtoObj.setMovie_Title(movieTitle);
		try {
		service.searchDirectorUsingMovieTitle(dtoObj);
		}
		catch (InvalidMovieTitle e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}
	public void updateMovieReleaseDate(String movieTitle,String date) throws InvalidMovieTitle{
		dtoObj.setMovie_Title(movieTitle);
		dtoObj.setRelease_date(date);
		try {
		service.updateMovieReleaseDate(dtoObj);
		}
		catch (InvalidMovieTitle e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}
	public void updateDirectorDetails(String firstName,String LastName,String address,String contactNumber) throws InvalidDirectorName{
		dtoObj.setDirector_First_Name(firstName);
		dtoObj.setDirector_Last_Name(LastName);
		dtoObj.setDirector_Address(address);
		dtoObj.setDirector_Contact_Number(contactNumber);
		try {
		service.updateDirectorDetails(dtoObj);
		}
		catch (InvalidDirectorName e) {
			// TODO: handle exception
			System.err.println(e);
			
		}
	}
	public void removeMovie(String movie_title) throws InvalidMovieTitle{
		dtoObj.setMovie_Title(movie_title);
		try {
		service.removeMovie(dtoObj);
		}
		catch (InvalidMovieTitle e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}
	
}
