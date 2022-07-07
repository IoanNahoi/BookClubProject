package com.endava.tmd.bookclubproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "booksowners")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Book book;

//    @ManyToMany
//    @JoinTable(
//            name = "booksowners",
//            joinColumns = @JoinColumn(name = "id_book"),
//            inverseJoinColumns = @JoinColumn(name = "id_owner"))
//    private List<User> userListOwners;

}
