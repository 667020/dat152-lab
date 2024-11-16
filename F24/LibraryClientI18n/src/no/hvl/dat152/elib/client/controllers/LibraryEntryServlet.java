package no.hvl.dat152.elib.client.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.jstl.core.Config;
import no.hvl.dat152.elib.model.Book;

/**
 * Servlet implementation class LibraryEntryServlet
 */
@WebServlet("/library")
public class LibraryEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibraryEntryServlet() {
        super();
       
    }

    private List<Book> prepareBooks() {
    	
    	List<Book> allBooks = new ArrayList<>();
    	Book book1 = new Book("978-0470887998","Cloud Computing: Principles and Paradigms","","cloud_computing.jpeg");
    	Book book2 = new Book("978-0262046305","Introduction to Algorithms","","algorithms.jpeg");
    	Book book3 = new Book("978-1449373320","Designing Data-Intensive Applications","","data_intensive.png");
    	
    	allBooks.add(book1);
    	allBooks.add(book2);
    	allBooks.add(book3);
    	
    	return allBooks;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("locale")) {
                    // Set locale from cookie
                    Config.set(request.getSession(), Config.FMT_LOCALE, cookie.getValue());
                }
            }
        } 
		request.setAttribute("books", prepareBooks());
		request.getRequestDispatcher("books.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
