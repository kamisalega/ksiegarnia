package pl.salega.repository;


import org.springframework.data.repository.CrudRepository;
import pl.salega.domain.Book;

/**
 * Created by kamilsalega on 09.07.2017.
 */
public interface BookRepository extends CrudRepository<Book, Long> {


}
