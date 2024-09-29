package Zoo.Movement;

import Zoo.Animals.Animal;

public interface Flying {
    default void fly() {
        System.out.println(((Animal) this).getName() + " is flying.");
    }
}
