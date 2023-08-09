package Class;
import java.time.LocalDate;

import Exceptions.EmptyField;

public class Counter {
    private static int counter = 0;
    private static Animal erorAnimal = new Cat("", LocalDate.of(9999, 1, 1), new CommandList(), "Shroedinger`s cat",
            "");

    public static void add(Animal animal) throws EmptyField {
        if (erorAnimal.getType() == animal.getType()) {
            throw new EmptyField();
        } else {
            counter++;
        }
    }

    public static void print() {
        System.out.println(counter);
    }
}
