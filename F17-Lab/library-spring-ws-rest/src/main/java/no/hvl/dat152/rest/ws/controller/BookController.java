/**
 * 
 */
package no.hvl.dat152.rest.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import no.hvl.dat152.rest.ws.exceptions.BookNotFoundException;
import no.hvl.dat152.rest.ws.model.Book;
import no.hvl.dat152.rest.ws.service.BookService;

/**
 * 
 */
@RestController
@RequestMapping("/elibrary/api/v1")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<Object> getAllBooks(){
		
		List<Book> books = bookService.findAll();
		
		if(books.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(books, HttpStatus.OK);		
	}
	
	@GetMapping("/books/{isbn}")
	public ResponseEntity<Book> getBook(@PathVariable("isbn") String isbn) throws BookNotFoundException{
		
		Book book = bookService.findByISBN(isbn);
		
		if(book == null)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(book, HttpStatus.OK);		
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		
		Book nbook = bookService.saveBook(book);
		
		return new ResponseEntity<>(nbook, HttpStatus.CREATED);
	}


	@PutMapping("/books/{isbn}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("isbn") String isbn) throws BookNotFoundException {
		book.setIsbn(isbn);

			Book updateBook = bookService.updateBook(book);

			if(updateBook != null) {
				return ResponseEntity.ok(updateBook);
			}

			return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/books/{isbn}")
	public ResponseEntity<Void> deleteBook(@PathVariable("isbn") String isbn) throws BookNotFoundException {
		bookService.deleteBookByISBN(isbn);
		return ResponseEntity.noContent().build();




	}




}
