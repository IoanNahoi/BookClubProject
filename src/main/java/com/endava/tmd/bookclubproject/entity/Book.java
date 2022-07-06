package com.endava.tmd.bookclubproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(unique = true)
    private String title;

    private String author;

    private String description;


    @ManyToMany
    @JoinTable(
            name = "waitinglist",
            joinColumns = @JoinColumn(name = "id_book"),
            inverseJoinColumns = @JoinColumn(name = "id_user")
    )
    private Set<User> waitingList;

//    @ManyToMany
//    @JoinTable(
//            name = "booksowners",
//            joinColumns = @JoinColumn(name = "id_book",table = "book",referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "id_owner",table = "accounts",referencedColumnName = "id"))
//    private Set<User> userList;
}


