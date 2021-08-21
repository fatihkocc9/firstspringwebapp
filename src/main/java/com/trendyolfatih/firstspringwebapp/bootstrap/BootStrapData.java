package com.trendyolfatih.firstspringwebapp.bootstrap;

import com.trendyolfatih.firstspringwebapp.domain.Author;
import com.trendyolfatih.firstspringwebapp.domain.Book;
import com.trendyolfatih.firstspringwebapp.repository.AuthorRepository;
import com.trendyolfatih.firstspringwebapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123" );
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Dev without EJB", "393953013123");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        System.out.println("Started bootstrap");
        System.out.println("Number of books: " + bookRepository.count());

    }
}
