package com.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movie.entity.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer>{

	@Query("select d from Director d where first_name=?1 and last_name=?2")
	public Director findMovieByDirector(String First_Name,String Last_Name);
	
	@Modifying
	@Query("update Director set Address=:Address,Contact_Number=:Contact_Number where First_Name=:First_Name and Last_Name=:Last_Name")
	public Integer updateDirectorDetails(String First_Name,String Last_Name,String Address,String Contact_Number);
	
	
}
