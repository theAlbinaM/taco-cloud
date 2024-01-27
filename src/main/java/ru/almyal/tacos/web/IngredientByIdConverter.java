package ru.almyal.tacos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.almyal.tacos.Ingredient;
import ru.almyal.tacos.data.IngredientRepository;

import java.util.HashMap;
import java.util.Map;


@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private RestTemplate rest;
    private IngredientRepository ingredientRepo;
    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientRepo.findById(id).orElse(null);
    }

//    public Ingredient getIngredientById(String ingredientId) {
//        Map<String, String> urlVariables = new HashMap<>(); urlVariables.put("id", ingredientId);
//        return rest.getForObject("http://localhost:8080/ingredients/{id}",
//                Ingredient.class, urlVariables);
//    }

    public Ingredient getIngredientById(String ingredientId) {
        return rest.getForObject("http://localhost:8080/ingredients/{id}",
    Ingredient.class, ingredientId);
        }
}
