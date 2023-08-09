package Class;

import java.time.LocalDate;

public class Dog extends PetsAnimal {

    public Dog(String name, LocalDate birthDay, CommandList commandList, String animalsType, String animalSpecies) {
        super(name, birthDay, commandList, animalsType, animalSpecies);
    }
}