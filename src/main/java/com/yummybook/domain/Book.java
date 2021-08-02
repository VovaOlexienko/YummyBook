package com.yummybook.domain;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(updatable = false)
    private byte[] content;

    @Lob
    @Column(updatable = false)
    private byte[] image;

    @ToString.Include
    @EqualsAndHashCode.Include
    @NotBlank
    private String name;

    @ToString.Include
    @EqualsAndHashCode.Include
    @NotBlank
    private String isbn;

    @Column(name = "page_count")
    private Integer numberOfPages;

    @Column(name = "publish_year")
    private Integer publishYear;

    private String descr;

    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn
    private Genre genre;

    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn
    private Author author;

    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn
    private Publisher publisher;

    @Column(name = "view_count")
    private long numberOfViews;

    Rating rating;

    public Book(Long id, String name, Integer numberOfPages, String isbn, Genre genre, Author author, Publisher publisher, Integer publishYear, byte[] image, String descr, long numberOfViews, long totalRating, long totalVoteCount, int avgRating) {
        this.id = id;
        this.name = name;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.image = image;
        this.descr = descr;
        this.numberOfViews = numberOfViews;
        this.rating = new Rating(totalRating, totalVoteCount, avgRating);
    }

    public Book(Long id, byte[] image) {
        this.id = id;
        this.image = image;
    }
}