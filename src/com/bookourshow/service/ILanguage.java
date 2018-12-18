package com.bookourshow.service;

import java.util.List;

import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Language;

public interface ILanguage {
	
	public String fetchLanguageName(int languageId);
	public List<Language> fetchLanguageByMovieAndCity(int movieId,int cityId) throws BookOurShowException;
}
