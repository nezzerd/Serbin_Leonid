package Zoo.Animals;

import Zoo.Food.Food;

public abstract class Animal {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract void eat(Food food);
}