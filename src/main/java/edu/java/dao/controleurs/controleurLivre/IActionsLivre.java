package edu.java.dao.controleurs.controleurLivre;

import java.util.ArrayList;
import java.util.List;

import edu.java.dao.models.modelLivre.Livre;

public interface IActionsLivre {

    // Pour le CRUD - Create Read Update Delete
    // Create
    public String CtrL_Enregistrer(Livre livre);

    // // Read
    public ArrayList<Livre> CtrL_GetAllLivres();

    public Livre CtrL_GetLivreById(int idl);

    public List<Livre> CtrL_GetLivreByTitre(String titre);

    public List<Livre> CtrL_GetLivreByAuteur(String auteur);

    // // Update
    public int CtrL_Modifier(Livre livre);

    // // Delete
    public int CtrL_Enlever(int idl);
}
