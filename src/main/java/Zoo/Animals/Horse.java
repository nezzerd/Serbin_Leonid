package Zoo.Animals;

import Zoo.Exceptions.InvalidFoodException;
import Zoo.Food.*;
import Zoo.Nutrition.Herbivore;
import Zoo.Movement.Walking;

public class Horse extends Animal implements Herbivore, Walking {
    public Horse(String name) {
        super(name);
    }

    @Override
    public void eat(Food food) {
        try {
            Herbivore.super.eat(food);
        } catch (InvalidFoodException e) {
            System.err.println(e.getMessage());
        }
    }
}