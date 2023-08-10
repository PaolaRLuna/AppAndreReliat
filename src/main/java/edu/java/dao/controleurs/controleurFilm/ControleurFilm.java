package edu.java.dao.controleurs.controleurFilm;
import edu.java.dao.models.modelFilm.Film;
import edu.java.dao.models.modelFilm.DaoFilm;
// import edu.java.dao.models.modelFilm.DaoFilm;

//implement IActionsFilm, il se communique avec model qui est aussi un singleton
public class ControleurFilm implements IActionsFilm {

    private static ControleurFilm CtrF_Instance = null;
    private static DaoFilm Dao_Instance = null; // model
    // Singleton du contrôleur
    // getControleurFilm() est devenu une zonne critique.
    // Pour ne pas avoir deux processus légers (threads) qui
    // appellent au même temps getConnexion
    
    private ControleurFilm(){} // on mets le constructeur a private pour pouvoir creer notre singleton

//threads: miniprocessus autonomme qui travaillent,, il met un verrou devant la zone critique pour ne pas avoir 2 au meme temps
//la metrhode on l'appele par la methode la classe, ca retourne un objet
    public static synchronized ControleurFilm getControleurFilm() {
        try {
            if (CtrF_Instance == null) { // il a aucun objet jusqu'a date et il va cree un nouvel objet
                CtrF_Instance = new ControleurFilm();
                Dao_Instance = DaoFilm.getFilmDao(); // retourne un objet de la classe DaoFilm, le model, pour pouvoir appeler les methodes du model
            } // si l'instance existe donc on va la retourner CTrF_instance, toujours le meme objet (singleton)
            return CtrF_Instance;//
        } catch (Exception e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public String CtrF_Enregistrer(Film film) {
        String message = null;
        message = Dao_Instance.MdlF_Enregistrer(film); // retourne un msg pour dire que le model a été bien enregistré
        return message;
    }
}
