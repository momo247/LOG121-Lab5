package Controleur;

public class GestionnaireCommande {
	private static GestionnaireCommande instance = new GestionnaireCommande();

	public static GestionnaireCommande getInstance() {
		return instance;
	}
}
