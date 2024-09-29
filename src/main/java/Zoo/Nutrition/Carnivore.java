package Zoo.Nutrition;

import Zoo.Animals.Animal;
import Zoo.Exceptions.InvalidFoodException;
import Zoo.Food.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public interface Carnivore {
    default void eat(Food food, FoodType... allowedFoods) throws InvalidFoodException {
        if (food == null || !Arrays.asList(allowedFoods).contains(food.getFoodType())) {
            String allowedFoodsStr = Arrays.stream(allowedFoods)
                    .map(FoodType::toString)
                    .map(String::toLowerCase)
                    .collect(Collectors.joining(" and "));
            throw new InvalidFoodException(((Animal) this).getName() + " can't eat " +
                    (food != null ? food.getFoodType().toString().toLowerCase() : "null") +
                    ". It only eats " + allowedFoodsStr + ".");
        }

        System.out.println(((Animal) this).getName() + " is eating " + food.getFoodType().toString().toLowerCase() + ".");
    }

}