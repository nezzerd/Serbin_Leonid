package Zoo.Movement;

import Zoo.Animals.Animal;

public interface Walking {
    default void walk() {
        System.out.println(((Animal) this).getName() + " is walking.");
    }
}
