package com.example.barter.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="interests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Interest {
    @Id
    private int id;
    private String interested_uid;
    private int pid;
    private String offering_pid;
}
