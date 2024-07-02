package me.dio.domain.model;

import jakarta.persistence.*;

@Entity(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String agency;

    private String number;

    private double balance;

    @Column(name = "additional_limit")
    private double limit;

}
