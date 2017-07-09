package pl.salega.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.salega.domain.Book;
import pl.salega.repository.BookRepository;
import pl.salega.service.BookService;


import java.util.List;

/**
 * Created by kamilsalega on 09.07.2017.
 */
@Service
public class BookServiceImplementation implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book findOne(Long id) {
        return bookRepository.findOne(id);
    }
}
