package com.example.gticslab920202396.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "favoritecocktails")
public class Favoritecocktail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "favoriteCocktailsId", nullable = false, length = 120)
    private String favoriteCocktailsId;

    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @Column(name = "thumbnail", nullable = false, length = 120)
    private String thumbnail;

    @Column(name = "enFavoritos", nullable = false)
    private boolean esFavorito;

}