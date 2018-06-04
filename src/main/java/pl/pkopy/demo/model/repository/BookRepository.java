package pl.pkopy.demo.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pkopy.demo.model.BookEntity;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {
    boolean existsByTitle(String title);
    boolean existsById(int id);
}
