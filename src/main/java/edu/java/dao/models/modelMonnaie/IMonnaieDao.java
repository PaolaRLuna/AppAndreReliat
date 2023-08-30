package edu.java.dao.models.modelMonnaie;

import java.util.List;

public interface IMonnaieDao {
    // Pour le CRUD - Create Read Update Delete

    // Create
    public String MdlM_Enregistrer(Monnaie piece);

    // Read
    public List<Monnaie> MdlM_GetAll();

    public Monnaie MdlM_GetById(int idclass);

    public List<Monnaie> MdlM_GetByMatiere(String matiere);

    public List<Monnaie> MdlM_GetByEmpereur(String empereur);

    // Update
    public int MdlM_Modifier(Monnaie piece);

    // Delete
    public int MdlM_Supprimer(int idclass);
}
