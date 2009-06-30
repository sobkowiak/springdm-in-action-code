package com.manning.sdmia.dataaccess.service;

import java.util.List;

import com.manning.sdmia.dataaccess.model.Author;

public interface LibraryService {
	List<Author> getAuthors();
	void addAuthor(Author author);
	void updateAuthor(Author author);
	void deleteAuthor(Author author);
	Author loadAuthor(long id);
}
