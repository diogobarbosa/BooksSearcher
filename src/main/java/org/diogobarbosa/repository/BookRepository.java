package org.diogobarbosa.repository;

import java.util.UUID;

import org.diogobarbosa.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, UUID>{

}
