package com.phodal.shire.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Advertise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String content;

    private String author;

    public Advertise(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Advertise() {

    }
}
