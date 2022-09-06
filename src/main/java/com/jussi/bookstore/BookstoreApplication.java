package com.jussi.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jussi.bookstore.domain.Book;
import com.jussi.bookstore.domain.BookRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("save couple of books for testing");
			repository.save(new Book("Firm", "John Grisham", "1999", "345dfgh", 19));
			repository.save(new Book("Harry Potter and the Philosopher's Stone", " J. K. Rowling", "1997 ", "5678dfghjk", 29));
		
			log.info("fetch all books");
			for(Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
	
}
