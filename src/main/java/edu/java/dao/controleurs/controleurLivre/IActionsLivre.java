package edu.java.dao.controleurs.controleurLivre;
import java.util.ArrayList;

import edu.java.dao.models.modelLivre.Livre;

public interface IActionsLivre {
    
    // Pour le CRUD - Create Read Update Delete
    // Create
    public String CtrO_Enregistrer(Livre Livre);

    // // Read
    public ArrayList<Livre> CtrO_GetAllLivres();

    public Livre CtrO_GetLivreById(int idf);

    public Livre CtrO_GetLivreByTitre(String titre);

    // // Update
    public int CtrO_Modifier(Livre Livre);

    // // Delete
    public int CtrO_Enlever(int idf);
}
