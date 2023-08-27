package edu.java.dao.models.modelLivre;

public class Livre {

    private int idl;
    private int num;
    private String titre;
    private String sousTitre;
    private String auteur;
    private String editeur;
    private String tome;
    private String annee;
    private String support;
    private String rangement;
    private String empereurs;
    private String collection;
    private String categorie;

    public Livre() {
        super();
    }

    public Livre(int idl, int num, String titre, String sousTitre, String auteur,
            String editeur, String tome, String annee, String support, String rangement, String empereurs,
            String collection, String categorie) {
        this.idl = idl;
        this.num = num;
        this.titre = titre;
        this.sousTitre = sousTitre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.tome = tome;
        this.annee = annee;
        this.support = support;
        this.rangement = rangement;
        this.empereurs = empereurs;
        this.collection = collection;
        this.categorie = categorie;
    }

    // getters and setters

    /**
     * @return int return the idl
     */
    public int getIdl() {
        return idl;
    }

    /**
     * @param idl the idl to set
     */
    public void setIdl(int idl) {
        this.idl = idl;
    }

    /**
     * @return int return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * @return String return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre the titre to set
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @return String return the soutTitre
     */
    public String getSousTitre() {
        return sousTitre;
    }

    /**
     * @param soutTitre the soutTitre to set
     */
    public void setSousTitre(String soutTitre) {
        this.sousTitre = soutTitre;
    }

    /**
     * @return String return the auteur
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * @param auteur the auteur to set
     */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    /**
     * @return String return the editeur
     */
    public String getEditeur() {
        return editeur;
    }

    /**
     * @param editeur the editeur to set
     */
    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    /**
     * @return String return the tome
     */
    public String getTome() {
        return tome;
    }

    /**
     * @param tome the tome to set
     */
    public void setTome(String tome) {
        this.tome = tome;
    }

    /**
     * @return String return the annee
     */
    public String getAnnee() {
        return annee;
    }

    /**
     * @param annee the annee to set
     */
    public void setAnnee(String annee) {
        this.annee = annee;
    }

    /**
     * @return String return the support
     */
    public String getSupport() {
        return support;
    }

    /**
     * @param support the support to set
     */
    public void setSupport(String support) {
        this.support = support;
    }

    /**
     * @return String return the rangement
     */
    public String getRangement() {
        return rangement;
    }

    /**
     * @param rangement the rangement to set
     */
    public void setRangement(String rangement) {
        this.rangement = rangement;
    }

    /**
     * @return String return the empereurs
     */
    public String getEmpereurs() {
        return empereurs;
    }

    /**
     * @param empereurs the empereurs to set
     */
    public void setEmpereurs(String empereurs) {
        this.empereurs = empereurs;
    }

    /**
     * @return String return the collection
     */
    public String getCollection() {
        return collection;
    }

    /**
     * @param collection the collection to set
     */
    public void setCollection(String collection) {
        this.collection = collection;
    }

    /**
     * @return String return the categorie
     */
    public String getCategorie() {
        return categorie;
    }

    /**
     * @param categorie the categorie to set
     */
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

}
