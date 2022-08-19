package com.endava.tmd.bookclubproject.repository;

import com.endava.tmd.bookclubproject.entity.Book;
import com.endava.tmd.bookclubproject.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WishListRepository extends JpaRepository<WishList, Long> {
    @Query("DELETE from WishList b where b.user.id=:idUser and b.book.title=:title")
    void deleteWishList(Long idUser, String title);

    @Query("SELECT b.book FROM WishList b where b.user.id=:idUser ")
    List<Book> getWishListByUserID(Long idUser);

    @Query("SELECT b from WishList b where b.user.id=:idUser and b.book.title=:title")
    WishList getWishListByUserAndBook(Long idUser, String title);
}