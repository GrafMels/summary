package Class;

import java.time.LocalDate;

abstract class PackAnimal extends Animal {
    public PackAnimal(String name, LocalDate birthDay, CommandList commandList, String animalsType,
            String animalSpecies) {
        super(name, birthDay, commandList, animalsType, animalSpecies);
    }

    protected PackAnimal() {

    }
}