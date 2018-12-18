package com.bookourshow.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Movie {
	private int  movieId;
	private String movieName;
	private String movieReleaseDate;
	public Movie() {
		super();
	}
	public Movie(int movieId, String movieName, String movieReleaseDate) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieReleaseDate = movieReleaseDate;
	}
	public int getMovieId() {
		return movieId;
	}
	@Autowired
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	@Autowired
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieReleaseDate() {
		return movieReleaseDate;
	}
	@Autowired
	public void setMovieReleaseDate(String movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieReleaseDate=" + movieReleaseDate
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + movieId;
		result = prime * result + ((movieName == null) ? 0 : movieName.hashCode());
		result = prime * result + ((movieReleaseDate == null) ? 0 : movieReleaseDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (movieId != other.movieId)
			return false;
		if (movieName == null) {
			if (other.movieName != null)
				return false;
		} else if (!movieName.equals(other.movieName))
			return false;
		if (movieReleaseDate == null) {
			if (other.movieReleaseDate != null)
				return false;
		} else if (!movieReleaseDate.equals(other.movieReleaseDate))
			return false;
		return true;
	}
	
	

}
