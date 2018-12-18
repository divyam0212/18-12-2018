package com.bookourshow.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bookourshow.dao.LanguageDAO;
import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Language;

@Service
public class LanguageService implements ILanguage {
	

	@Override
	public String fetchLanguageName(int languageId) {
		LanguageDAO languageDAO=new LanguageDAO();
		return languageDAO.fetchLanguageName(languageId);
	}

	@Override
	public List<Language> fetchLanguageByMovieAndCity(int movieId, int cityId) throws BookOurShowException {
		List<Language> languageList=new ArrayList<>();
		LanguageDAO languageDAO=new LanguageDAO();
		languageList=languageDAO.fetchLanguageByMovieAndCity(movieId, cityId);
		return languageList;
	}

}
