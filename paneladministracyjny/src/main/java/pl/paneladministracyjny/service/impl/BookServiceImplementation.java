package pl.paneladministracyjny.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.paneladministracyjny.domain.Book;
import pl.paneladministracyjny.repository.BookRepository;
import pl.paneladministracyjny.service.BookService;

import java.util.List;

/**
 * Created by kamilsalega on 08.07.2017.
 */
@Service
public class BookServiceImplementation implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book findOne(Long id) {
        return bookRepository.findOne(id);
    }


}
