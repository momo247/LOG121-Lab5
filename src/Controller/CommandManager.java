package Controller;

import java.util.ArrayList;

public class CommandManager {

	private static CommandManager instance = new CommandManager();
	private ArrayList<Command> history = new ArrayList<>();
	private int index;

	private CommandManager() {}

	public static CommandManager getInstance() {
		return instance;
	}

	public void executeCommand(Command command) {
		command.execute();
	}

	public void undo() {
		if(index < 0 || history.size() == 0) {
			return;
		}
		Command command = history.get(index--);
		command.undo();
	}

	public void redo() {
		if (index < history.size() - 1) {
			index++;
			Command command = history.get(index);
			command.execute();
		}
	}

	public void addCommand(Command command) {
		history.add(command);
		index = history.size() - 1;
	}

}
