package com.movie.repository;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movie.entity.Director;
import com.movie.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{
	
	@Query("select c from Movie c where movie_title=?1 and release_date=?2 and movie_running_time=?3")
	public Movie findMovie(String Movie_Title,LocalDate release_date,Time Movie_Running_Time);
	
	@Query("select c from Movie c where movie_title=?1")
	public List<Movie> findByMovieTitle(String Movie_Title);

	@Modifying
	@Query("update Movie set release_date=:release where Movie_Title=:movieTitle")
	public Integer updateMovieReleaseDate(LocalDate release,String movieTitle);
	
	@Modifying
	@Query("delete from Movie where Movie_Title=?1")
	public Integer removeMovie(String Movie_Title);
}

