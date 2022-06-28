package com.movie;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Scanner;
import java.util.TreeSet;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.movie.MovieAndDirectorDTO.MovieAndDirectorDTO;
import com.movie.UI.UserInterface;
import com.movie.entity.Director;
import com.movie.entity.Movie;
import com.movie.service.MovieService;

@SpringBootApplication
public class CapstoneMovieApplication {


	public static void main(String[] args) throws Exception {
		ApplicationContext context = (ApplicationContext)SpringApplication.run(CapstoneMovieApplication.class, args);
		UserInterface uiObj = context.getBean(UserInterface.class);
		uiObj.userConsole();
	}

}
