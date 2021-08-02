package com.yummybook.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Vote {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ToString.Include
    private int value;

    @ToString.Include
    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn
    private Book book;

    @ToString.Include
    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn
    private User user;
}