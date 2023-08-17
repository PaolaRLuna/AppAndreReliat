
package edu.java.dao.controleurs.controleurLivre;

import java.util.ArrayList;

import edu.java.dao.models.modelLivre.DaoLivre;
import edu.java.dao.models.modelLivre.Livre;

public class ControleurLivre implements IActionsLivre {

    private static ControleurLivre CtrO_Instance = null;
    private static DaoLivre Dao_Instance = null;

    private ControleurLivre() {
    }

    public static synchronized ControleurLivre getControleurLivre() {
        try {
            if (CtrO_Instance == null) { // il a aucun objet jusqu'a date et il va cree un nouvel objet
                CtrO_Instance = new ControleurLivre();
                Dao_Instance = DaoLivre.getLivreDao(); // retourne un objet de la classe DaoFilm, le model, pour pouvoir
                                                       // appeler les methodes du model
            } // si l'instance existe donc on va la retourner CTrF_instance, toujours le meme
              // objet (singleton)
            return CtrO_Instance;//
        } catch (Exception e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public String CtrL_Enregistrer(Livre livre) {
        String message = null;
        message = Dao_Instance.MdlL_Enregistrer(livre); // retourne un msg pour dire que le model a été bien enregistré
        return message;
    }

    public ArrayList<Livre> CtrL_GetAllLivres() {
        try {
            return (ArrayList<Livre>) Dao_Instance.MdlL_GetAll();
        } catch (ClassCastException e) {
            return null;
        }

    }

    public Livre CtrL_GetLivreById(int idl) {
        return Dao_Instance.MdlL_GetByNum(idl);
    };

    public Livre CtrL_GetLivreByTitre(String titre) {
        return Dao_Instance.MdlL_GetByTitre(titre);
    };

    public Livre CtrL_GetLivreByAuteur(String auteur) {
        return Dao_Instance.MdlL_GetByAuteur(auteur);
    };

    public int CtrL_Modifier(Livre livre) {
        return Dao_Instance.MdlL_Modifier(livre);
    };

    public int CtrL_Enlever(int idl) {
        return Dao_Instance.MdlL_Supprimer(idl);
    };

}
