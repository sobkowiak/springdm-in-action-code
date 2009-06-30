package com.manning.sdmia.dataaccess.dao.eclipselink;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import com.manning.sdmia.dataaccess.dao.AuthorsDao;
import com.manning.sdmia.dataaccess.model.Author;

public class AuthorsDaoImpl extends JpaDaoSupport implements AuthorsDao {

	public List<Author> getAuthors() {
		return getJpaTemplate().find("from Author author");
		// left join fetch author.books");
	}

	public void addAuthor(Author author) {
		getJpaTemplate().persist(author);
	}

	public void deleteAuthor(Author author) {
		getJpaTemplate().remove(author);
	}

	public void updateAuthor(Author author) {
		getJpaTemplate().merge(author);
	}

	public Author loadAuthor(long id) {
		return getJpaTemplate().find(Author.class, id);
	}
}
