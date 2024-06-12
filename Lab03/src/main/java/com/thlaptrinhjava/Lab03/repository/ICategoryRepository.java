package com.thlaptrinhjava.Lab03.repository;

import com.thlaptrinhjava.Lab03.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

}
