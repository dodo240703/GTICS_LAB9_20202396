package com.example.gticslab920202396.Controllers;

import com.example.gticslab920202396.Daos.CoctelDao;
import com.example.gticslab920202396.Entities.Coctel;
import com.example.gticslab920202396.Entities.Favoritecocktail;
import com.example.gticslab920202396.Repositories.FavoritecocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/coctel")
public class CoctelController {

    @Autowired
    private CoctelDao coctelDao;
    @Autowired
    private FavoritecocktailRepository favoritecocktailRepository;

    // Listar cocteles
    @GetMapping("/lista")
    public String getCocktailList(Model model) {
        model.addAttribute("cocteles", coctelDao.listaCocteles());
        return "listaCocteles";
    }

    @GetMapping("/detail/{id}")
    public String getCocktailDetail(@PathVariable String id, Model model) {
        Coctel coctel = coctelDao.getCoctelDetail(id);
        model.addAttribute("coctel", coctel);
        boolean isFavorite = favoritecocktailRepository.existsByFavoriteCocktailsId(id);
        model.addAttribute("isFavorite", isFavorite);
        return "detailCoctel";
    }

    @PostMapping("/addFavorite")
    public String addToFavorites(@RequestParam("cocktailId") String cocktailId,
                                 @RequestParam("name") String name,
                                 @RequestParam("thumbnail") String thumbnail,
                                 RedirectAttributes redirectAttributes) {

        if (!favoritecocktailRepository.existsByFavoriteCocktailsId(cocktailId)) {
            Favoritecocktail favorite = new Favoritecocktail();
            favorite.setFavoriteCocktailsId(cocktailId);
            favorite.setName(name);
            favorite.setThumbnail(thumbnail);
            favoritecocktailRepository.save(favorite);
            redirectAttributes.addFlashAttribute("messageExito", "Favorite saved successfully!");
        } else {
            redirectAttributes.addFlashAttribute("messageFracaso", "This drink is already in your favorites.");
        }

        return "redirect:/coctel/detail/" + cocktailId;
    }

    @GetMapping("/listarFavoritos")
    public String getCocktailFavoriteList(Model model) {
        model.addAttribute("cocteles", favoritecocktailRepository.findAll());
        return "listaCoctelesFavoritos";
    }
}
