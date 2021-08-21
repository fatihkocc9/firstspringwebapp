package com.trendyolfatih.firstspringwebapp.bootstrap;

import com.trendyolfatih.firstspringwebapp.domain.Author;
import com.trendyolfatih.firstspringwebapp.domain.Book;
import com.trendyolfatih.firstspringwebapp.domain.Publisher;
import com.trendyolfatih.firstspringwebapp.repository.AuthorRepository;
import com.trendyolfatih.firstspringwebapp.repository.BookRepository;
import com.trendyolfatih.firstspringwebapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123" );
        Publisher abc = new Publisher("Sinav", "Kazanci Yokusu 43-8", "istanbul", "marmara", "34347")
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(abc);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Dev without EJB", "393953013123");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started bootstrap");
        System.out.println("Number of books: " + bookRepository.count());

    }
}
