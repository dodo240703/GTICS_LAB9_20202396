package com.example.gticslab920202396.Repositories;

import com.example.gticslab920202396.Entities.Favoritecocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritecocktailRepository extends JpaRepository<Favoritecocktail, Integer> {

    // Método para verificar si un cóctel ya está en la lista de favoritos
    boolean existsByFavoriteCocktailsId(String cocktailId);
}
