package Zoo.Animals;

import Zoo.Food.Food;
import Zoo.Exceptions.InvalidFoodException;
import Zoo.Nutrition.Herbivore;
import Zoo.Movement.Walking;

public class Camel extends Animal implements Herbivore, Walking {
    public Camel(String name) {
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