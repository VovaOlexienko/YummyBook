package com.yummybook.dao;

import com.yummybook.domain.Book;
import com.yummybook.domain.User;
import com.yummybook.domain.Vote;

public interface VoteDao extends GeneralDAO<Vote>{
    Vote getVote(Book book, User user);
}
