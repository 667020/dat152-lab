/**
 * 
 */
package no.hvl.dat152.controller;


import no.hvl.dat152.model.Author;
import no.hvl.dat152.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 */
@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/addauthor")
    public String create(){
        return "addauthor";
    }
    @PostMapping
    public String create(@RequestParam String fname,
                         @RequestParam String lname){

        authorService.saveAuthor(new Author(fname, lname));
        return "redirect:/";

    }
}
