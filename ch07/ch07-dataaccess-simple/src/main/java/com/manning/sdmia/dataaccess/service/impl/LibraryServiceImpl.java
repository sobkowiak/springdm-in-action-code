package com.manning.sdmia.dataaccess.service.impl;

import java.util.List;

import com.manning.sdmia.dataaccess.dao.AuthorsDao;
import com.manning.sdmia.dataaccess.model.Author;
import com.manning.sdmia.dataaccess.service.LibraryService;

public class LibraryServiceImpl implements LibraryService {
	private AuthorsDao authorsDao;

	public void addAuthor(Author author) {
		authorsDao.addAuthor(author);
	}

	public void deleteAuthor(Author author) {
		authorsDao.deleteAuthor(author);
	}

	public List<Author> getAuthors() {
		return authorsDao.getAuthors();
	}

	public Author loadAuthor(long id) {
		return authorsDao.loadAuthor(id);
	}

	public void updateAuthor(Author author) {
		authorsDao.updateAuthor(author);
	}

	public AuthorsDao getAuthorsDao() {
		return authorsDao;
	}

	public void setAuthorsDao(AuthorsDao authorsDao) {
		this.authorsDao = authorsDao;
	}

}
