package com.jussi.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jussi.bookstore.domain.Book;
import com.jussi.bookstore.domain.BookRepository;
import com.jussi.bookstore.domain.Category;
import com.jussi.bookstore.domain.CategoryRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save couple of books for testing");
			crepository.save(new Category("Suspense"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Biography"));
			
			repository.save(new Book("Firm", 
					"John Grisham", 
					"1997", "0-385-41634-2", 
					19,
					crepository.findByName("Suspense").get(0)));
			repository.save(new Book("Harry Potter and the Philosopher's Stone", 
					" J. K. Rowling", 
					"1997 ", 
					"0-7475-3269-9", 
					29,
					crepository.findByName("Fantasy").get(0)));
		
			log.info("fetch all books");
			for(Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
	
}
