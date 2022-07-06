package com.endava.tmd.bookclubproject.repository;

import com.endava.tmd.bookclubproject.entity.Book;
import com.endava.tmd.bookclubproject.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {

//    @Query("INSERT into booksowners values(idUser,idBook)")
//    void postToDatabase(long idUser,long idBook)
}
