package Zoo.Animals;

import Zoo.Food.*;
import Zoo.Exceptions.InvalidFoodException;
import Zoo.Nutrition.Carnivore;
import Zoo.Movement.Swimming;

public class Dolphin extends Animal implements Carnivore, Swimming {
    public Dolphin(String name) {
        super(name);
    }

    @Override
    public void eat(Food food) {
        try {
            Carnivore.super.eat(food, FoodType.FISH);
        } catch (InvalidFoodException e) {
            System.err.println(e.getMessage());
        }
    }
}