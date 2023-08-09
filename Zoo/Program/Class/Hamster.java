package Class;

import java.time.LocalDate;

public class Hamster extends PetsAnimal {

    public Hamster(String name, LocalDate birthDay, CommandList commandList, String animalsType, String animalSpecies) {
        super(name, birthDay, commandList, animalsType, animalSpecies);
    }
}
