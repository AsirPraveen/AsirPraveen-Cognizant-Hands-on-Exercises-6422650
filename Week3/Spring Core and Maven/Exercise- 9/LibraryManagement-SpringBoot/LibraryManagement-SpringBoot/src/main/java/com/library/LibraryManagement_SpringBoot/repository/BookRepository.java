package com.library.LibraryManagement_SpringBoot.repository;

import com.library.LibraryManagement_SpringBoot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
