/**
 * 
 */
package no.hvl.dat152.rest.ws.service;


import no.hvl.dat152.rest.ws.exceptions.AuthorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.hvl.dat152.rest.ws.model.Author;
import no.hvl.dat152.rest.ws.repository.AuthorRepository;

import java.util.List;

/**
 * 
 */
@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	public Author findById(long id) {
		
		return authorRepository.findById(id).get();
	}

	public List<Author> findAllAuthor(){
		return (List<Author>) authorRepository.findAll();
	}

	public Author getAuthorById(long authorId) throws AuthorNotFoundException {
		return authorRepository.findById(authorId)
				.orElseThrow(() -> new AuthorNotFoundException("Author with id = " + authorId + " not found!"));
	}




}











}
