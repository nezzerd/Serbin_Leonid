package Zoo.Nutrition;

import Zoo.Animals.Animal;
import Zoo.Exceptions.InvalidFoodException;
import Zoo.Food.*;

public interface Herbivore {
    default void eat(Food food) throws InvalidFoodException {
        if (food == null || food.getFoodType() != FoodType.GRASS) {
            throw new InvalidFoodException(((Animal) this).getName() + " can't eat "
                    + (food != null ? food.getFoodType().toString().toLowerCase() : "null") + ". It only eats grass.");
        }
        System.out.println(((Animal) this).getName() + " is eating grass.");
    }
}