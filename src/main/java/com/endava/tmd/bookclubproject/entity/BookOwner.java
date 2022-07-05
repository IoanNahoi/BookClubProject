package com.endava.tmd.bookclubproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "booksowners")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookOwner {
    @Id
    private long id;

    @ManyToMany
    @JoinTable(
            name = "booksowners",
            joinColumns = @JoinColumn(name = "id_book"),
            inverseJoinColumns = @JoinColumn(name = "id_owner"))
    private List<User> userList;

}