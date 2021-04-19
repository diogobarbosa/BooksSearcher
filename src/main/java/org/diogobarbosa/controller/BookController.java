package org.diogobarbosa.controller;

import java.util.UUID;

import org.diogobarbosa.entity.Book;
import org.diogobarbosa.exceptions.BookNotFoundException;
import org.diogobarbosa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	
	@GetMapping("/consultar_livro/{uuidBook}")
	public ResponseEntity<Book> consultarLivro(@PathVariable("uuidBook") String uuidBook){
		
		try {
			return ResponseEntity.ok(bookRepository.findById(UUID.fromString(uuidBook)).orElseThrow(BookNotFoundException::new));
		} catch (BookNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping("/cadastrar_livro")
	public ResponseEntity<Book> consultarLivro(@RequestBody Book book){
		
		bookRepository.save(book);
		return ResponseEntity.ok(book);
	}

}
