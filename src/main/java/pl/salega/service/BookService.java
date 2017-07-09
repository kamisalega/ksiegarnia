package pl.salega.service;


import pl.salega.domain.Book;

import java.util.List;

/**
 * Created by kamilsalega on 09.07.2017.
 */
public interface BookService {
    List<Book> findAll();

    Book findOne(Long id);
}
