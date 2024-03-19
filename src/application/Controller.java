package application;

import java.util.Iterator;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Button;

public class Controller {
	
	@FXML
	MenuBar barDeMenu;
	@FXML
	Button bouton;
	

	public void initialize() {
		
	}
	
	public void setUpBarDeMenu() {
		ObservableList<Menu> menus = this.barDeMenu.getMenus();
		Iterator<Menu> iter = menus.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next().getText());
		}
	}
	
	public void bouton(ActionEvent e) {
		setUpBarDeMenu();
	}
}
