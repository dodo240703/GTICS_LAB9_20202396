package com.example.gticslab920202396.Controllers;

import com.example.gticslab920202396.Daos.CoctelDao;
import com.example.gticslab920202396.Entities.Coctel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/coctel")
public class CoctelController {

    @Autowired
    private CoctelDao coctelDao;

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
        return "detailCoctel";
    }

}
