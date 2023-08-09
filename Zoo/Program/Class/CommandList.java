package Class;

import java.util.LinkedList;

public class CommandList {
    private LinkedList<Command> commandList = new LinkedList<Command>();

    public void addCommand(Command newCommand) {
        commandList.add(newCommand);
    }

    public String printCommands() {
        String fullList = "";
        for (int i = 0; i < commandList.size(); i++) {
            fullList = fullList + (i + 1) + commandList.get(i).getName();
        }
        return fullList;
    }

    public Command getCommand(int index) {
        return commandList.get(index);
    }

    public LinkedList<Command> getList() {
        return commandList;
    }

    @Override
    public String toString() {
        String commandString = "";
        int i = 0;
        for (Command command : commandList) {
            i++;
            if (i == commandList.size()) {
                commandString = commandString + command;
            } else {
                commandString = commandString + command + ",";
            }
        }
        return commandString;
    }

    public String toPrint(CommandList fullCommand) {
        LinkedList<Command> fullCommandList = fullCommand.getList();
        String commandString = "";
        for (int i = 0; i < fullCommandList.size(); i++) {
            for (int j = 0; j < commandList.size(); j++) {
                if (fullCommandList.get(i) == commandList.get(j)) {
                    if (i == fullCommandList.size()) {
                        commandString = commandString + i;
                    } else {
                        commandString = commandString + i + ",";
                    }
                }
            }
        }

        return commandString;
    }

    public String toVertikalString(CommandList commandlist) {
        String[] commandString = commandlist.toString().split(",");
        String fullCommandString = "";
        for (int i = 0; i < commandString.length; i++) {
            if (i == commandString.length - 1) {
                int x = i + 1;
                int y = i + 2;
                fullCommandString = fullCommandString + x + "." + commandString[i] + "\n";
                fullCommandString = fullCommandString + y + ".Добавить свою команду";
            } else {
                int x = i + 1;
                fullCommandString = fullCommandString + x + "." + commandString[i] + "\n";
            }
        }
        return fullCommandString;
    }

}
