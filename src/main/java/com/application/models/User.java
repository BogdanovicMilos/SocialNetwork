package com.application.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by Milos on 2/5/2018.
 */
@Data
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    private String firstName;
    private String surname;
    private Long age;
    private String gender;
    public int[] friends;


    public User(){

    }

}
