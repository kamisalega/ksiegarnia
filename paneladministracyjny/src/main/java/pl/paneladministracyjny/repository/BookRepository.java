package pl.paneladministracyjny.repository;

import org.springframework.data.repository.CrudRepository;
import pl.paneladministracyjny.domain.Book;

/**
 * Created by kamilsalega on 08.07.2017.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
