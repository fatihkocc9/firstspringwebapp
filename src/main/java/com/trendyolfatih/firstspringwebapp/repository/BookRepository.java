package com.trendyolfatih.firstspringwebapp.repository;

import com.trendyolfatih.firstspringwebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
