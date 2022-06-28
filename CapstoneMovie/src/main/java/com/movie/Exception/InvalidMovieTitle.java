package com.movie.Exception;
public class InvalidMovieTitle  extends Exception  
{  
    public InvalidMovieTitle (String str)  
    {  
        // calling the constructor of parent Exception  
        super(str);  
    }  
}  