
package edu.java.dao.controleurs.controleurFilm;
import edu.java.dao.models.modelFilm.Outil;
import edu.java.dao.models.modelFilm.DaoOutil;

public class ControleurOutil implements IActionsOutil{
    
    private static ControleurOutil CtrO_Instance = null;
    private static DaoOutil Dao_Instance = null;

    private ControleurOutil(){}

    public static synchronized ControleurFilm getControleurFilm() {
        try {
            if (CtrO_Instance == null) { // il a aucun objet jusqu'a date et il va cree un nouvel objet
                CtrO_Instance = new ControleurOutil();
                Dao_Instance = DaoOutil.getOutilDao(); // retourne un objet de la classe DaoFilm, le model, pour pouvoir appeler les methodes du model
            } // si l'instance existe donc on va la retourner CTrF_instance, toujours le meme objet (singleton)
            return CtrO_Instance;//
        } catch (Exception e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public String CtrF_Enregistrer(Outil outil) {
        String message = null;
        message = Dao_Instance.MdlF_Enregistrer(outil); // retourne un msg pour dire que le model a été bien enregistré
        return message;
    }

}
