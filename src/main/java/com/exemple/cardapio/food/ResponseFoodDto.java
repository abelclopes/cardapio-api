package com.exemple.cardapio.food;

public record ResponseFoodDto(long id, String title, String image, String price) {
    public ResponseFoodDto(Food food) {
        this(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
    }

}
