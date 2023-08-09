package Class;

import java.time.LocalDate;

public class PetsAnimal extends Animal {

    public PetsAnimal(String name, LocalDate birthDay, CommandList commandList, String animalsType,
            String animalSpecies) {
        super(name, birthDay, commandList, animalsType, animalSpecies);
    }

    protected PetsAnimal() {

    }

}
