package com.trendyolfatih.firstspringwebapp.repository;

import com.trendyolfatih.firstspringwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
