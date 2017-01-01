package com.santy.model.mydata;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "mydata")
public class MyData {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;

}