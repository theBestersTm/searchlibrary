package com.softexpansion.searchlibrary.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="myuser")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userid;
    @Column
    private String name;
    @Column
    private String libarianpass;
    @Column
    private Boolean librarian;


}
