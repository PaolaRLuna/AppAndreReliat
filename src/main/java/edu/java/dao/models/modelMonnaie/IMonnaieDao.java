package edu.java.dao.models.modelMonnaie;

import java.util.List;

public interface IMonnaieDao {
    // Pour le CRUD - Create Read Update Delete

    // Create
    public String MdlO_Enregistrer(Monnaie piece);

    // Read
    public List<Monnaie> MdlO_GetAll();

    public Monnaie MdlO_GetById(int idclass);

    public Monnaie MdlO_GetByMatiere(String matiere);

    public Monnaie MdlO_GetByEmpereur(String empereur);

    // Update
    public int MdlO_Modifier(Monnaie piece);

    // Delete
    public int MdlO_Supprimer(int idclass);
}
