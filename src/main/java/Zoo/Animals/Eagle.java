package Zoo.Animals;

import Zoo.Food.*;
import Zoo.Exceptions.InvalidFoodException;
import Zoo.Nutrition.Carnivore;
import Zoo.Movement.Flying;

public class Eagle extends Animal implements Carnivore, Flying {
    public Eagle(String name) {
        super(name);
    }

    @Override
    public void eat(Food food) {
        try {
            Carnivore.super.eat(food, FoodType.BEEF, FoodType.FISH);
        } catch (InvalidFoodException e) {
            System.err.println(e.getMessage());
        }
    }
}