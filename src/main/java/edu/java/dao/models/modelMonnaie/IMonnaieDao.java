package edu.java.dao.models.modelMonnaie;

import java.util.List;

public interface IMonnaieDao {
    // Pour le CRUD - Create Read Update Delete
    
    // Create
    public String MdlO_Enregistrer(Monnaie lMonnaie);
    
    // Read
    public List<Monnaie> MdlO_GetAll();

    public Monnaie MdlO_GetById(int idref);

    public Monnaie MdlO_GetByNom_ou_Matiere(String nom_matiere);

    public Monnaie MdlO_GetByZone(String zone);
    
    // Update
    public int MdlO_Modifier(Monnaie lMonnaie);

    // Delete
    public int MdlO_Supprimer(int idref);
}
