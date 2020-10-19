package com.softexpansion.searchlibrary.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="book")
@Data
@Builder
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookid;
    @Column
    private String name;
    @Column
    private String author;
    @Column
    private String description;
    @ManyToOne
    private Category category;


}
