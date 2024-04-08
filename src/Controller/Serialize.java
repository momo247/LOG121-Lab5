package Controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import Model.ModelWrapper;

public class Serialize {
	
	public static void serializeModels(ModelWrapper wrapper, String fileName) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(wrapper);
			System.out.println("Models have been saved!");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ModelWrapper deserializeModels(String fileName) {
		ModelWrapper wrapper = null;

		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			wrapper = (ModelWrapper) in.readObject();
			System.out.println("Models have been read!");
			in.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return wrapper;
	}
}
