
package edu.java.dao.controleurs.controleurMonnaie;
import java.util.ArrayList;

import edu.java.dao.models.modelMonnaie.DaoMonnaie;
import edu.java.dao.models.modelMonnaie.Monnaie;

public class ControleurMonnaie implements IActionsMonnaie{
    
    private static ControleurMonnaie CtrO_Instance = null;
    private static DaoMonnaie Dao_Instance = null;

    private ControleurMonnaie(){}

    public static synchronized ControleurMonnaie getControleurMonnaie() {
        try {
            if (CtrO_Instance == null) { // il a aucun objet jusqu'a date et il va cree un nouvel objet
                CtrO_Instance = new ControleurMonnaie();
                Dao_Instance = DaoMonnaie.getMonnaieDao(); // retourne un objet de la classe DaoFilm, le model, pour pouvoir appeler les methodes du model
            } // si l'instance existe donc on va la retourner CTrF_instance, toujours le meme objet (singleton)
            return CtrO_Instance;//
        } catch (Exception e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public String CtrM_Enregistrer(Monnaie piece) {
        String message = null;
        message = Dao_Instance.MdlO_Enregistrer(piece); // retourne un msg pour dire que le model a été bien enregistré
        return message;
    }

    public ArrayList<Monnaie> CtrO_GetAllMonnaies() {
        try{
            return (ArrayList<Monnaie>) Dao_Instance.MdlO_GetAll();
        } catch (ClassCastException e){
            return null;
        }
       
    }
    
    public Monnaie CtrO_GetMonnaieById(int idref) {
        return Dao_Instance.MdlO_GetById(idref);
    };

    public Monnaie CtrO_GetMonnaieByMatiere(String matiere){
        return Dao_Instance.MdlM_GetByMatiere(matiere);
    };

 
    public int CtrO_Modifier(Monnaie lMonnaie){
        return Dao_Instance.MdlO_Modifier(lMonnaie);
    };


    public int CtrO_Enlever(int idf){
        return Dao_Instance.MdlO_Supprimer(idf);
    };
    

}
