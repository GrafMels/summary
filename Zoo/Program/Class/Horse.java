package Class;

import java.time.LocalDate;

public class Horse extends PackAnimal {

    public Horse(String name, LocalDate birthDay, CommandList commandList, String animalsType,
            String animalSpecies) {
        super(name, birthDay, commandList, animalsType, animalSpecies);
    }
}
