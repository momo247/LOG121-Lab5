package Controller;

public class OperationManager {

	private static OperationManager instance = new OperationManager();

	private OperationManager() {}

	public static OperationManager getInstance() {
		return instance;
	}

	public void executeOperation(Operation operation) {
		operation.execute();
	}
	
}
