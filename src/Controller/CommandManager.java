package Controller;

public class CommandManager {

	private static CommandManager instance = new CommandManager();

	private CommandManager() {}

	public static CommandManager getInstance() {
		return instance;
	}

	public void executeCommand(Command operation) {
		operation.execute();
	}
	
}
