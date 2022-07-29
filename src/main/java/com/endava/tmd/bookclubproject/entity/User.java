package com.endava.tmd.bookclubproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "accounts")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(unique = true)
    @NonNull
    private String username;

    @NonNull
    private String password;

    @Column(unique = true)
    private String email;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @ManyToMany(mappedBy = "waitingList")
    @JsonIgnore
    private List<Book> waitingForBooks;

    @OneToMany(mappedBy = "user_who_borrowed")
    @JsonIgnore
    List<Borrow> borrowList;

    @OneToMany(mappedBy = "borrowed_book")
    @JsonIgnore
    List<Borrow> booked_borrow_list;

}
