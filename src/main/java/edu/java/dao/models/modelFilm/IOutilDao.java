package edu.java.dao.models.modelFilm;

import edu.java.dao.controleurs.controleurFilm.List;

public interface IOutilDao {
    // Pour le CRUD - Create Read Update Delete
    
    // Create
    public String MdlO_Enregistrer(Outil loutil);
    
    // Read
    public List<Outil> MdlO_GetAll();

    public Outil MdlO_GetById(double idref);

    public Outil MdlO_GetByNom_ou_Matiere(String nom_matiere);

    public Outil MdlO_GetByZone(String zone);
    
    // Update
    public int MdlO_Modifier(Outil loutil);

    // Delete
    public int MdlO_Supprimer(int idref);
}
