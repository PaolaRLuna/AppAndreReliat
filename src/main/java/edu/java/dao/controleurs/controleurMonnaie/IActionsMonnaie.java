package edu.java.dao.controleurs.controleurMonnaie;
import java.util.ArrayList;

import edu.java.dao.models.modelMonnaie.Monnaie;

public interface IActionsMonnaie {
    
    // Pour le CRUD - Create Read Update Delete
    // Create
    public String CtrO_Enregistrer(Monnaie Monnaie);

    // // Read
    public ArrayList<Monnaie> CtrO_GetAllMonnaies();

    public Monnaie CtrO_GetMonnaieById(int idf);

    public Monnaie CtrO_GetMonnaieByTitre(String titre);

    // // Update
    public int CtrO_Modifier(Monnaie Monnaie);

    // // Delete
    public int CtrO_Enlever(int idf);
}
