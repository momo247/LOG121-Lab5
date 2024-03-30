package View;

import Model.Observable;

public interface Observer {
	public void update(Observable observable);
}
