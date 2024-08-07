package me.dio.domain.model;

import jakarta.persistence.*;

@Entity(name = "tb_card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String number;
    @Column(name = "available_limit")
    private double limit;

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public double getLimit() {
        return limit;
    }
}
