package pl.paneladministracyjny.service;

import pl.paneladministracyjny.domain.Book;

import java.util.List;

/**
 * Created by kamilsalega on 08.07.2017.
 */
public interface BookService {

    Book save(Book book);

    List<Book> findAll();
}
