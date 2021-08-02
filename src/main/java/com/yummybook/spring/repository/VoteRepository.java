package com.yummybook.spring.repository;

import com.yummybook.domain.Book;
import com.yummybook.domain.User;
import com.yummybook.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Vote findByBookAndUser(Book book, User user);
}
