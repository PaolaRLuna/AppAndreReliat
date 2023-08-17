package edu.java.dao.controleurs.controleurMonnaie;

import java.util.ArrayList;

import edu.java.dao.models.modelMonnaie.Monnaie;

public interface IActionsMonnaie {

    // Pour le CRUD - Create Read Update Delete
    // Create
    public String CtrM_Enregistrer(Monnaie piece);

    // // Read
    public ArrayList<Monnaie> CtrM_GetAllMonnaie();

    public Monnaie CtrM_GetMonnaieById(int idf);

    public Monnaie CtrM_GetMonnaieByMatiere(String matiere);

    public Monnaie CtrM_GetMonnaieByEmpereur(String empereur);
    // // Update
    public int CtrM_Modifier(Monnaie piece);

    // // Delete
    public int CtrM_Enlever(int idclass);
}
