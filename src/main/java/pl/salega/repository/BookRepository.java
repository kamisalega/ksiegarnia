package pl.salega.repository;


import org.springframework.data.repository.CrudRepository;
import pl.salega.domain.Book;

import java.util.List;

/**
 * Created by kamilsalega on 09.07.2017.
 */
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByCategory(String category);
    List<Book> findByTitleContaining(String title);


}
