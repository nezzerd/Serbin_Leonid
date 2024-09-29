package Zoo.Food;

public abstract class Food {
    private final FoodType foodType;

    public Food(FoodType foodType) {
        this.foodType = foodType;
    }

    public FoodType getFoodType() {
        return foodType;
    }
}
