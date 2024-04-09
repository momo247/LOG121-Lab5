package Controller;

import java.util.ArrayList;

import Model.Memento;
import Model.PerspectiveModel;

public class CommandManager {

	private static CommandManager instance;
	private ArrayList<Memento> history;
	private int index;
	private PerspectiveModel model;

	private CommandManager() {
		history = new ArrayList<>();
	}

	public static CommandManager getInstance() {
		if (instance == null) {
			instance = new CommandManager();
		}
		return instance;
	}

	public void executeCommand(Command command, PerspectiveModel model) {
		this.model = model;
		command.execute(model);
	}

	public void undo() {
		if(index < 0 || history.size() == 0) {
			return;
		}
		model.restoreFromMemento(history.get(index--));
	}

	public void redo() {
		if (index >= -1 && index < history.size() - 1) {
			model.restoreFromMemento(history.get(++index));
		}
	}

	public void addMemento(Memento memento) {
		history.add(memento);
		index = history.size() - 1;
	}

}
