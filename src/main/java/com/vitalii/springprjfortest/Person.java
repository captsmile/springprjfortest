package com.vitalii.springprjfortest;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Data
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    int id;

    @Column
    String name;

    public Person(String name) {
        this.name = name;
    }
}
