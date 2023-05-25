package com.example.onesteptimejava.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Inheritance
@Transactional(readOnly = false)
@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ISBN {
    @Id
    @JsonProperty("isbn")
    public String isbn;

    @Column(unique = true)
    @JsonProperty("title")
    public String title;

    @Column(unique = true)
    @JsonProperty("title_long")
    public String title_long;

    @Column(unique = true)
    @JsonProperty("isbn13")
    public String isbn13;
    @JsonProperty("dewey_decimal")
    public String dewey_decimal;
    @JsonProperty("binding")
    public String binding;
    @JsonProperty("publisher")
    public String publisher;
    @JsonProperty("language")
    public String language;
    @JsonProperty("date_published")
    public String date_published;
    @JsonProperty("edition")
    public String edition;
    @JsonProperty("pages")
    public Integer pages;
    @JsonProperty("dimensions")
    public String dimensions;
    @JsonProperty("overview")
    public String overview;
    @JsonProperty("image")
    public String image;
    @JsonProperty("msrp")
    public Double msrp;
    @JsonProperty("excerpt")
    public String excerpt;
    @JsonProperty("synopsys")
    public String synopsys;
    @JsonProperty("authors")
    public String[] authors;
    @JsonProperty("subjects")
    @Column(length = 1000)
    public String[] subjects;
    @JsonProperty("reviews")
    public String[] reviews;

    public ISBN() {
    }

    public ISBN(
            String isbn,
            String title,
            String title_long,
            String isbn13,
            String dewey_decimal,
            String binding,
            String publisher,
            String language,
            String date_published,
            String edition,
            Integer pages,
            String dimensions,
            String overview,
            String image,
            Double msrp,
            String excerpt,
            String synopsys,
            String[] authors,
            String[] subjects,
            String[] reviews) {
        this.isbn = isbn;
        this.title = title;
        this.title_long = title_long;
        this.isbn13 = isbn13;
        this.dewey_decimal = dewey_decimal;
        this.binding = binding;
        this.publisher = publisher;
        this.language = language;
        this.date_published = date_published;
        this.edition = edition;
        this.pages = pages;
        this.dimensions = dimensions;
        this.overview = overview;
        this.image = image;
        this.msrp = msrp;
        this.excerpt = excerpt;
        this.synopsys = synopsys;
        this.authors = authors;
        this.subjects = subjects;
        this.reviews = reviews;
    }
}
