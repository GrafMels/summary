package Class;

/**
 * Command
 */
public class Command {
    private String name = "";

    public Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}