package MVC;

import Class.Animal;
import Class.AnimalList;
import Class.CommandList;
import Exceptions.EmptyField;
import Exceptions.invalidInput;
import Exceptions.NoRightInputElement;

public class Controller {
    private static CommandList commandlist;
    private static AnimalList animallist;

    public static void start() {
        commandlist = Model.loadingFromCommandList();
        animallist = Model.loadingFromAnimalList(commandlist);
        int condition = 0;

        do {
            System.out.println("\n");/// Убрать
            condition = View.startMenu();
            if (condition != 0) {
                mainDivarication(condition);
            }
            View.saveFiles(commandlist, animallist);

        } while (condition != 0);
    }

    private static void mainDivarication(int condition) {
        if (condition == 1) {
            System.out.println(animallist);
            int animalAnswer = View.choiceAnimal();

            if (animalAnswer <= animallist.size() && animalAnswer > 0) {
                animalDivarication(View.choiceWhatDoAnimal(animallist.getAnimal(animalAnswer - 1)),
                        animallist.getAnimal(animalAnswer - 1));
            } else {
                try {
                    throw new invalidInput();
                } catch (invalidInput e) {
                    System.out.println(e.getMessage());
                }
            }

        } else if (condition == 2) {
            String[] command = commandlist.toString().split(",");
            for (int i = 0; i < command.length; i++) {
                System.out.println(command[i]);
            }

        } else if (condition == 3) {
            try {
                animallist.addAnimal(View.newAnimal(commandlist));
            } catch (invalidInput | EmptyField | NoRightInputElement e) {
                System.out.println(e.getMessage());
            }
        } else if (condition == 0) {

        } else {
            try {
                throw new invalidInput();
            } catch (invalidInput e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void animalDivarication(int condition, Animal animal) {
        if (condition == 1) {
            System.out.println();
            System.out.println(animal.getCommand());

        } else if (condition == 2) {
            System.out.println();
            System.out.println(animal);

        } else if (condition == 3) {
            animal.setCommand(Model.newCommand(commandlist, animal.getCommand()));

        } else if (condition == 0) {

        } else {
            try {
                throw new invalidInput();
            } catch (invalidInput e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
