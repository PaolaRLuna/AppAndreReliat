
package edu.java.dao.controleurs.controleurOutil;
import java.util.ArrayList;

import edu.java.dao.models.modelOutil.DaoOutil;
import edu.java.dao.models.modelOutil.Outil;

public class ControleurOutil implements IActionsOutil{
    
    private static ControleurOutil CtrO_Instance = null;
    private static DaoOutil Dao_Instance = null;

    private ControleurOutil(){}

    public static synchronized ControleurOutil getControleurOutil() {
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
    public String CtrO_Enregistrer(Outil outil) {
        String message = null;
        message = Dao_Instance.MdlO_Enregistrer(outil); // retourne un msg pour dire que le model a été bien enregistré
        return message;
    }

    public ArrayList<Outil> CtrO_GetAllOutils() {
        try{
            return (ArrayList<Outil>) Dao_Instance.MdlO_GetAll();
        } catch (ClassCastException e){
            return null;
        }
       
    }
    
    public Outil CtrO_GetOutilById(int idref) {
        return Dao_Instance.MdlO_GetById(idref);
    };

    public Outil CtrO_GetOutilByTitre(String titre){
        return Dao_Instance.MdlO_GetByNom_ou_Matiere(titre);
    };

 
    public int CtrO_Modifier(Outil loutil){
        return Dao_Instance.MdlO_Modifier(loutil);
    };


    public int CtrO_Enlever(int idf){
        return Dao_Instance.MdlO_Supprimer(idf);
    };
    

}
