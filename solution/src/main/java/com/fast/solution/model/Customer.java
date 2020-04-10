package com.fast.solution.model;

import lombok.Data;

import javax.persistence.*;
//object instance of the DB instance
@Data    //set get toStr...
@Entity //related to BD
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
}
