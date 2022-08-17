package com.endava.tmd.bookclubproject.repository;

import com.endava.tmd.bookclubproject.entity.WaitingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface WaitingListRepository extends JpaRepository<WaitingList, Long> {
    @Modifying
    @Query("DELETE from WaitingList b where b.user.id=:idUser and b.book.title=:title")
    void deleteWaitingList(Long idUser,String title);
}
