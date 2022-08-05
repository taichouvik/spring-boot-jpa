package com.example.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book>{
    
    @Query("SELECT b from Book b join fetch b.author where b.author.id = :authorId")
    public List<Book> findByAuthorId(int authorId);
}
