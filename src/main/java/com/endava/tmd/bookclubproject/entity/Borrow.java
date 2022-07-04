package com.endava.tmd.bookclubproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "borrow")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Borrow {
    @Id
    private int id;
    @Builder.Default()
    private Date date_when_borrowed;
    private Date date_when_return;

    @ManyToOne()
    @JoinColumn(name = "id_book")
    private User user_who_borrowed;
}
