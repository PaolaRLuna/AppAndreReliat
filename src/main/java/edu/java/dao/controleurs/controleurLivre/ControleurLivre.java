
package edu.java.dao.controleurs.controleurLivre;
import java.util.ArrayList;

import edu.java.dao.models.modelLivre.DaoLivre;
import edu.java.dao.models.modelLivre.Livre;

public class ControleurLivre implements IActionsLivre{
    
    private static ControleurLivre CtrO_Instance = null;
    private static DaoLivre Dao_Instance = null;

    private ControleurLivre(){}

    public static synchronized ControleurLivre getControleurLivre() {
        try {
            if (CtrO_Instance == null) { // il a aucun objet jusqu'a date et il va cree un nouvel objet
                CtrO_Instance = new ControleurLivre();
                Dao_Instance = DaoLivre.getLivreDao(); // retourne un objet de la classe DaoFilm, le model, pour pouvoir appeler les methodes du model
            } // si l'instance existe donc on va la retourner CTrF_instance, toujours le meme objet (singleton)
            return CtrO_Instance;//
        } catch (Exception e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public String CtrO_Enregistrer(Livre Livre) {
        String message = null;
        message = Dao_Instance.MdlO_Enregistrer(Livre); // retourne un msg pour dire que le model a été bien enregistré
        return message;
    }

    public ArrayList<Livre> CtrO_GetAllLivres() {
        try{
            return (ArrayList<Livre>) Dao_Instance.MdlO_GetAll();
        } catch (ClassCastException e){
            return null;
        }
       
    }
    
    public Livre CtrO_GetLivreById(int idref) {
        return Dao_Instance.MdlO_GetById(idref);
    };

    public Livre CtrO_GetLivreByTitre(String titre){
        return Dao_Instance.MdlO_GetByNom_ou_Matiere(titre);
    };

 
    public int CtrO_Modifier(Livre lLivre){
        return Dao_Instance.MdlO_Modifier(lLivre);
    };


    public int CtrO_Enlever(int idf){
        return Dao_Instance.MdlO_Supprimer(idf);
    };
    

}
