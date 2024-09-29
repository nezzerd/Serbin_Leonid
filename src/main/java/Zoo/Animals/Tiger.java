package Zoo.Animals;

import Zoo.Food.*;
import Zoo.Exceptions.InvalidFoodException;
import Zoo.Nutrition.Carnivore;
import Zoo.Movement.Walking;

public class Tiger extends Animal implements Carnivore, Walking {
    public Tiger(String name) {
        super(name);
    }

    @Override
    public void eat(Food food) {
        try {
            Carnivore.super.eat(food, FoodType.BEEF);
        } catch (InvalidFoodException e) {
            System.err.println(e.getMessage());
        }
    }
}