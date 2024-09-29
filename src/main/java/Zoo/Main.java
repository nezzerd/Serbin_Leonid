package Zoo;

import Zoo.Animals.*;
import Zoo.Food.*;

public class Main {
    public static void main(String[] args) {
        Horse horse1 = new Horse("horse1");
        Dolphin dolphin1 = new Dolphin("dolphin1");
        Tiger tiger1 = new Tiger("tiger1");
        Eagle eagle1 = new Eagle("eagle1");
        Camel camel1 = new Camel("camel1");

        horse1.walk();
        dolphin1.swim();
        tiger1.walk();
        eagle1.fly();
        camel1.walk();

        horse1.eat(new Grass());
        horse1.eat(new Meat(FoodType.FISH));

        dolphin1.eat(new Grass());
        dolphin1.eat(new Meat(FoodType.FISH));

        camel1.eat(new Grass());
        camel1.eat(new Meat(FoodType.FISH));

        eagle1.eat(new Grass());
        eagle1.eat(new Meat(FoodType.BEEF));

        tiger1.eat(new Grass());
        tiger1.eat(new Meat(FoodType.BEEF));

    }
}
