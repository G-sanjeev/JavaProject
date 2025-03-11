package com.learn.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.demo.entity.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Long> {

}
