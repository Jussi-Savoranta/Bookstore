package com.jussi.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jussi.bookstore.domain.Book;
import com.jussi.bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@GetMapping(value = "/books")
	public String getBooks(Model model) {
		model.addAttribute("bookList", repository.findAll());
		return "books";
	}

	@GetMapping(value = "/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@PostMapping(value = "/save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:books";
	}
	
	@RequestMapping(value = "/delete/{bookId}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("bookId") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../books";
	}
	
	@RequestMapping(value = "/edit/{bookId}")
	public String editBook(@PathVariable("bookId") Long bookId, Model model) {
		model.addAttribute("editoitavaKirja", repository.findById(bookId));
//		System.out.println(repository.findById(bookId).toString());
		return "edit";
	}
}
