package com.endava.tmd.bookclubproject.repository;

import com.endava.tmd.bookclubproject.entity.BookOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookOwnerRepository extends JpaRepository<BookOwner, Long> {
}
