package MVC;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

import Class.Animal;
import Class.AnimalList;
import Class.Camel;
import Class.Cat;
import Class.Command;
import Class.CommandList;
import Class.Dog;
import Class.Donkey;
import Class.Hamster;
import Class.Horse;
import Exceptions.EmptyField;
import Exceptions.invalidInput;
import Exceptions.NoRightInputElement;

public class View {
    static private Scanner sc = new Scanner(System.in, "Cp866");

    public static Integer startMenu() {
        System.out.println(
                "1: Показать список животных\n2: Показать список команд которым можно обучить животных\n3: Добавить новое животное\n\n0:Выход");
        System.out.print("Выберите пункт и введите нужную цифру: ");
        int answer = sc.nextInt();
        return answer;
    }

    public static String loadingFromFile(String fileName) {
        String allFile = "";
        try (FileReader fr = new FileReader(new File(fileName))) {
            Scanner sca = new Scanner(fr);
            while (sca.hasNextLine()) {
                allFile = allFile + sca.nextLine() + ":";
            }
            sca.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("XXX");
        }

        return allFile;
    }

    public static void saveFiles(CommandList commandlist, AnimalList animallist) {
        File file = new File("AnimalList.txt");
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(animallist.toPrint(commandlist));
        } catch (Exception e) {

        }

        String[] commandString = commandlist.toString().split(",");
        String fullCommandString = "";
        for (int i = 0; i < commandString.length; i++) {
            if (i == commandString.length) {
                fullCommandString = fullCommandString + commandString[i];
            } else {
                fullCommandString = fullCommandString + commandString[i] + "\n";
            }
        }
        file = new File("CommandList.txt");
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(fullCommandString);
        } catch (Exception e) {

        }
    }

    /**
     * @param fullCommandlist
     * @return
     * @throws EmptyField
     * @throws NoRightInputElement
     * @throws invalidInput
     */
    public static Animal newAnimal(CommandList fullCommandlist) throws EmptyField, NoRightInputElement, invalidInput {
        sc.nextLine();

        System.out.println("Введите имя животного: ");
        String name = sc.nextLine();
        if (name.equals("")) {
            return new Cat("", LocalDate.of(9999, 1, 1), new CommandList(), "Shroedinger`s cat", "");
        }

        System.out.println("Введите дату рождения животного(в формате \"dd-mm-yyyy\"): ");
        String dateString = sc.nextLine();
        String[] date = "12-12-12".split("-");
        LocalDate birthDay;
        if (dateString.equals("")) {
            return new Cat("", LocalDate.of(9999, 1, 1), new CommandList(), "Shroedinger`s cat", "");
        }
        try {
            date = dateString.split("-");
            birthDay = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]),
                    Integer.parseInt(date[0]));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoRightInputElement(2);
        }

        String[] commandString = fullCommandlist.toString().split(",");
        String fullCommandString = "";
        int i = 0;
        for (String string : commandString) {
            i++;
            fullCommandString = fullCommandString + i + "." + string + "\n";
        }
        fullCommandString = fullCommandString + "0.Выход" + "\n";
        int condition = 0;
        LinkedList<Integer> commands = new LinkedList<Integer>();
        i = 0;
        String conditionString = "";
        do {
            System.out.printf("Введите номера команд которые животное знает: \n%s : ", fullCommandString);
            conditionString = sc.nextLine();
            if (!conditionString.equals("")) {
                try {
                    condition = Integer.parseInt(conditionString);
                    if (condition != 0) {
                        commands.add(condition);
                    }
                    i++;
                } catch (Exception e) {
                    throw new NoRightInputElement(3);
                }
            }
        } while (condition != 0 || conditionString.equals(""));
        CommandList commandlist = new CommandList();
        for (Integer command : commands) {
            Command newCommand = fullCommandlist.getCommand(command);
            commandlist.addCommand(newCommand);
        }

        System.out.print("Введите вид животного(Цифрой): \n1.Cat\n2.Dog\n3.Hamster\n4.Donkey\n5.Horse\n6.Camel\n : ");
        int animalSpecies = 0;
        String animalSpeciesString = sc.nextLine();
        if (animalSpeciesString.equals("")) {
            return new Cat("", LocalDate.of(9999, 1, 1), new CommandList(), "Shroedinger`s cat", "");
        }
        try {
            animalSpecies = Integer.parseInt(animalSpeciesString);
        } catch (Exception e) {
            throw new NoRightInputElement(4);
        }

        Animal newAnimal = new Camel();
        if (animalSpecies == 1) {
            newAnimal = new Cat(name, birthDay, commandlist, "petsAnimals", "Cat");
        } else if (animalSpecies == 2) {
            newAnimal = new Dog(name, birthDay, commandlist, "petsAnimals", "Dog");
        } else if (animalSpecies == 3) {
            newAnimal = new Hamster(name, birthDay, commandlist, "petsAnimals", "Hamster");
        } else if (animalSpecies == 4) {
            newAnimal = new Donkey(name, birthDay, commandlist, "packAnimals", "Donkey");
        } else if (animalSpecies == 5) {
            newAnimal = new Horse(name, birthDay, commandlist, "packAnimals", "Horse");
        } else if (animalSpecies == 6) {
            newAnimal = new Camel(name, birthDay, commandlist, "packAnimals", "Camel");
        } else {
            throw new invalidInput();
        }
        return newAnimal;
    }

    public static int choiceAnimal() {
        System.out.print("Выберите животное и введите нужную цифру: ");
        int answer = sc.nextInt();
        return answer;
    }

    public static int choiceWhatDoAnimal(Animal animal) {
        System.out.println(
                "1: Показать список команд\n2: Показать всю информацию о животном\n3: Добавить новую команду\n0:Выход");
        System.out.print("Выберите пункт и введите нужную цифру: ");
        int answer = sc.nextInt();
        return answer;
    }

    public static int choiceComand(CommandList commandlist) {
        System.out.println(commandlist.toVertikalString(commandlist));
        System.out.println("Выберите пункт и введите нужную цифру: ");
        int answer = sc.nextInt();
        return answer - 1;
    }

    public static String newCommand() {
        sc.nextLine();
        System.out.println("Придумайте новую команду: ");
        String answer = sc.nextLine();
        return answer;
    }
}