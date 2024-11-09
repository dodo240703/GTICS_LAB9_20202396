package com.example.gticslab920202396.Daos;

import com.example.gticslab920202396.Dtos.CoctelResponse;
import com.example.gticslab920202396.Entities.Coctel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CoctelDao {

    RestTemplate restTemplate = new RestTemplate();

    public List<Coctel> listaCocteles() {
        String endPoint = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Cocktail";
        ResponseEntity<CoctelResponse> response = restTemplate.getForEntity(endPoint, CoctelResponse.class);
        return response.getBody().getDrinks().stream().limit(12).collect(Collectors.toList());
    }

    // Método para obtener los detalles de un coctel por ID
    public Coctel getCoctelDetail(String id) {
        String endPoint = "https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=";
        CoctelResponse response = restTemplate.getForObject(endPoint + id, CoctelResponse.class);
        return response != null && !response.getDrinks().isEmpty() ? response.getDrinks().get(0) : null;
    }



}
