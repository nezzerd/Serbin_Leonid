package Zoo.Movement;

import Zoo.Animals.Animal;

public interface Swimming {
    default void swim() {
        System.out.println(((Animal) this).getName() + " is swimming.");
    }
}
