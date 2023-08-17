/**package edu.java.dao;
public final class App {
    private App() {
    }

    public static void main(String[] args) {
        // Selon le choix de l'utilisateur faudra appeler la bonne méthode
        // du contrôleur.
        // CAS 1 : Enregistrer un film

        Outil outil = new Outil();
        outil.setAppellation("biface");
        
        //Singleton, d'une classe donné je vais creer un objet
        ControleurOutil CtrO = ControleurOutil.getControleurOutil(); // on appel le controleur (getcontro est methode statique) apres avoir importé les modeles
        String message = CtrO.CtrO_Enregistrer(outil);
        System.out.println(message);

        // SwingUtilities.invokeLater(() -> {
        //     try {
        //         new GestionCategories();
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //     }
        // });
    }
}
