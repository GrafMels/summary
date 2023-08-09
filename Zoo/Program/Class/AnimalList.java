package Class;

import java.util.LinkedList;

import Exceptions.EmptyField;

public class AnimalList {
    private LinkedList<Animal> animlList = new LinkedList<Animal>();

    public void addAnimal(Animal newAnimal) {
        try {
            Counter.add(newAnimal);
            animlList.add(newAnimal);
        } catch (EmptyField e) {
            System.out.println(e.getMessage());
        }
    }

    public Animal getAnimal(Integer index) {
        return animlList.get(index);
    }

    public int size() {
        return animlList.size();
    }

    @Override
    public String toString() {
        String fullList = "";
        for (int i = 0; i < animlList.size(); i++) {
            fullList = fullList + (i + 1) + " " + animlList.get(i) + "\n";
        }
        return fullList;
    }

    public String toPrint(CommandList commandlist) {
        String fullList = "";
        for (int i = 0; i < animlList.size(); i++) {
            fullList = fullList + animlList.get(i).toString(commandlist) + "\n";
        }
        return fullList;
    }
}
