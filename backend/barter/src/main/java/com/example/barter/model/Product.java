package com.example.barter.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @Id
    private int id;
    private String name;
    private int uid;
    private String description;
    private String age;
    private String brand;
    private String color;
}
