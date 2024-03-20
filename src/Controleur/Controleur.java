package Controleur;

public class Controleur {
    

    public void recevoirAction(String event) {
        if(event.equals("Ouvrir")) {
            ouvrir();
        } else if(event.equals("Sauvegarder")) {
            sauvegarder();
        }
    }

    public void ouvrir() {
        System.out.println("Ouvrir fichier");
    }

    public void sauvegarder() {
        System.out.println("Sauvegarder fichier");
    }
}
