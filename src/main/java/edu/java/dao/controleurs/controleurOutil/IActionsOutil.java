package edu.java.dao.controleurs.controleurOutil;
import java.util.ArrayList;

import edu.java.dao.models.modelOutil.Outil;

public interface IActionsOutil {
    
    // Pour le CRUD - Create Read Update Delete
    // Create
    public String CtrO_Enregistrer(Outil outil);

    // // Read
    public ArrayList<Outil> CtrO_GetAllOutils();

    public Outil CtrO_GetOutilById(int idref);

    public List<Outil> CtrO_GetOutilByTitre_ou_Matiere(String titre_ou_matiere);

    public List<Outil> CtrO_GetOutilByZone(String zone);

    // // Update
    public int CtrO_Modifier(Outil outil);

    // // Delete
    public int CtrO_Enlever(int idf);
}
