package edu.java.dao.models.modelLivre;

import java.util.List;

public interface ILivreDao {
    // Pour le CRUD - Create Read Update Delete

    // Create
    public String MdlL_Enregistrer(Livre leLivre);

    // Read
    public List<Livre> MdlL_GetAll();

    public Livre MdlL_GetByNum(int num);

    public List<Livre> MdlL_GetByTitre(String titre);

    public Livre MdlL_GetByAuteur(String auteur);

    // Update
    public int MdlL_Modifier(Livre leLivre);

    // Delete
    public int MdlL_Supprimer(int id);
}
