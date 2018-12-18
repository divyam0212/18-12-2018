package com.bookourshow.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class MovieCategory {
	private int movieCategoryId;
	private Movie movie;
	private List<Category> category;
	private List<Language> language;
	private String movieCategoryStr;
	public MovieCategory() {
		// TODO Auto-generated constructor stub
	}
	public MovieCategory(String movieCategoryStr, Movie movie, List<Category> category, List<Language> language) {
		super();
		this.movieCategoryStr = movieCategoryStr;
		this.movie = movie;
		this.category = category;
		this.language = language;
	}
	public String getMovieCategoryStr() {
		return movieCategoryStr;
	}
	public void setMovieCategoryStr(String movieCategoryStr) {
		this.movieCategoryStr = movieCategoryStr;
	}
	public int getMovieCategoryId() {
		return movieCategoryId;
	}
	public void setMovieCategoryId(int movieCategoryId) {
		this.movieCategoryId = movieCategoryId;
	}
	public Movie getMovie() {
		return movie;
	}
	@Autowired
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public List<Category> getCategory() {
		return category;
	}
	public void setCategory(List<Category> category) {
		this.category = category;
	}
	public List<Language> getLanguage() {
		return language;
	}
	public void setLanguage(List<Language> language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "MovieCategory [movieCategoryId=" + movieCategoryId + ", movie=" + movie + ", category=" + category
				+ ", language=" + language + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + movieCategoryId;
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
		MovieCategory other = (MovieCategory) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (movieCategoryId != other.movieCategoryId)
			return false;
		return true;
	}
	

}
