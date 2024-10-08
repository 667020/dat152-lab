/**
 * 
 */
package no.hvl.dat152.rest.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.hvl.dat152.rest.ws.exceptions.BookNotFoundException;
import no.hvl.dat152.rest.ws.model.Book;
import no.hvl.dat152.rest.ws.repository.BookRepository;

/**
 * 
 */
@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	
	public Book saveBook(Book book) {
		
		return bookRepository.save(book);
		
	}
	
	public List<Book> findAll(){
		
		return (List<Book>) bookRepository.findAll();
		
	}
	
	public Book findByISBN(String isbn) throws BookNotFoundException {
		
		Book book = null;
		try {
			book = bookRepository.findBookByISBN(isbn);
		}catch(Exception e) {
			throw new BookNotFoundException("Book with isbn = "+isbn+" not found!");
		}
		
		return book;
	}

	public Book updateBook(Book book) throws BookNotFoundException {
		Book existingBook = findByISBN(book.getIsbn());

		if(existingBook != null){
			existingBook.setTitle(book.getTitle());
			existingBook.setAuthors(book.getAuthors());

			return saveBook(existingBook);
		}else{
			throw new BookNotFoundException("Book with ISBN= " + book.getIsbn() + "not found" );
		}

	}

	public void deleteBookByISBN(String isbn) throws BookNotFoundException {
		Book book = findByISBN(isbn);
		if(book != null){
			bookRepository.delete(book);
		}else{
			throw new BookNotFoundException("Book with ISBN= " + book.getIsbn() + "not found");
		}
	}

	


}
