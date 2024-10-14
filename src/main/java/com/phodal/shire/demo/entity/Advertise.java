package com.phodal.shire.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entity class representing an Advertise object.
 * An Advertise has an id, title, content, and an author.
 *
 * @author Your Name
 * @version 1.0
 * @since 1.0
 */
@Entity

public class Advertise {
    /**
     * Unique identifier for the Advertise object.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The title of the advertise.
     */
    private String title;

    /**
     * The content of the advertise.
     */
    private String content;

    /**
     * The author of the advertise.
     */
    private String author;

    /**
     * Constructor to create a new Advertise object with specified title, content, and author.
     *
     * @param title   The title of the advertise.
     * @param content The content of the advertise.
     * @param author  The author of the advertise.
     */
    public Advertise(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    /**
     * Default no-argument constructor.
     */
    public Advertise() {

    }
}

