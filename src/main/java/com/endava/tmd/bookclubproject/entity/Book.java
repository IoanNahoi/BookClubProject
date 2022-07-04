package com.endava.tmd.bookclubproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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
            name = "booksowners",
            joinColumns = @JoinColumn(name = "id_book"),
            inverseJoinColumns = @JoinColumn(name = "id_owner"))
    private List<User> userList;

//    @ManyToMany
//    @JoinTable(
//            name = "waitinglist",
//            joinColumns = @JoinColumn(name = "id_book"),
//            inverseJoinColumns = @JoinColumn(name = "id_user")
//    )
//    private List<User> waitingList;
}
