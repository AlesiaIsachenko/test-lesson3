package ru.st.selenium.applogic;

import java.util.List;

import ru.st.selenium.model.Film;

public interface FilmHelper {

	void create(Film film);
	void delete(Film film);
	int countfilm();
	boolean isElementPresent();
	List<Film> search(String title);

}
