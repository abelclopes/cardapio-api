package com.exemple.cardapio.Controller;

import com.exemple.cardapio.food.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private IFoodRepository _repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ResponseFoodDto> getAll(){
        List<ResponseFoodDto> foods = _repository.findAll().stream().map(ResponseFoodDto::new).toList();
        return foods;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody RequestFoodDto data){
        Food foodData = new Food(data);
        _repository.save(foodData);
        return;
    }
}
