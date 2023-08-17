package edu.java.dao.models.modelLivre;

import java.util.List;

public interface ILivreDao {
    // Pour le CRUD - Create Read Update Delete
    
    // Create
    public String MdlO_Enregistrer(Livre lLivre);
    
    // Read
    public List<Livre> MdlO_GetAll();

    public Livre MdlO_GetById(int idref);

    public Livre MdlO_GetByNom_ou_Matiere(String nom_matiere);

    public Livre MdlO_GetByZone(String zone);
    
    // Update
    public int MdlO_Modifier(Livre lLivre);

    // Delete
    public int MdlO_Supprimer(int idref);
}
