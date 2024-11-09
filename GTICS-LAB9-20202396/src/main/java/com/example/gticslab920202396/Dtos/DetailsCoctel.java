package com.example.gticslab920202396.Dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DetailsCoctel {
    private String strDrink;
    private String strThumb;
    private String strCateogry;
    private String strAlcoholic;
    private String strGlass;
    private String strInstructions;
    private List<String> strIngedients;
    private List<String> strMeasures;
}
