package com.thlaptrinhjava.Lab03.repository;

import com.thlaptrinhjava.Lab03.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {


}
