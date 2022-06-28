package com.movie.UI;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movie.Exception.InvalidMovieTitle;

@Component
public class UserInterface {

	@Autowired
	MovieDirectorUIMethods movieObj;
	public void userConsole() throws Exception {
		while(true) {
		System.out.println("choose options below");
		System.out.println("1.Insert a movie");
		System.out.println("2.search movie using title");
		System.out.println("3.search movie using director name");
		System.out.println("4.search director using movie title");
		System.out.println("5.update release date");
		System.out.println("6.update director details");
		System.out.println("7.remove movie");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		switch (n) {
		case 1:
			movieObj.movieAndDirectorDetailsInsertion();
			break;
		case 2:
			System.out.println("enter title");
			String title = sc.nextLine();
			movieObj.searchMovieusingTitle(title);
			break;
		case 3:
			System.out.println("enter firstname");
			String firstname = sc.nextLine();
			System.out.println("enter lastname");
			String lastname = sc.nextLine();
			movieObj.searchMovieUsingDirector(firstname, lastname);
			break;
		case 4:
			System.out.println("enter movie name");
			String movie = sc.nextLine();
			movieObj.searchMovieusingTitle(movie);
			break;
		case 5:
			System.out.println("enter movie name");
			movie = sc.nextLine();
			System.out.println("enter new date YYYY-MM-DD");
			String date = sc.nextLine();
			movieObj.updateMovieReleaseDate(movie, date);
			break;
		case 6:
			System.out.println("enter firstname");
			firstname = sc.nextLine();
			System.out.println("enter last name");
			lastname = sc.nextLine();
			System.out.println("enter address");
			String address = sc.nextLine();
			System.out.println("enter contact number");
			String contact = sc.nextLine();
			movieObj.updateDirectorDetails(firstname, lastname, address, contact);
			break;
		case 7:
			System.out.println("enter title");
			title = sc.nextLine();
			movieObj.removeMovie(title);
			break;
		
		}
		}
	}
}
