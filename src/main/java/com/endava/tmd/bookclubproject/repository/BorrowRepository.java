package com.endava.tmd.bookclubproject.repository;

import com.endava.tmd.bookclubproject.entity.Book;
import com.endava.tmd.bookclubproject.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {

    //    @Query("INSERT into booksowners values(idUser,idBook)")
//    void postToDatabase(long idUser,long idBook)
//@Query("SELECT b from Borrow b join booksowners b2 on b.borrowed_book = b2.book_id and b2.user_id =:idOwner")
//    @Query("SELECT b FROM BookOwner b join b.user.id where b.user.id=:idOwner")
    @Query("SELECT b from Borrow b where b.id_owner_book=:idOwner")
    List<Borrow> getBorrowDetails(Long idOwner);

    @Query("SELECT b from BookOwner b where b.book.id=:idBook")
    Long idUserByBookId(Long idBook);

    @Query("select b from Borrow b where b.user_who_borrowed.id=:idUser AND b.borrowed_book.id=:bookID")
    Borrow getBorrowByIdUserAndBookName(Long idUser, Long bookID);
}
