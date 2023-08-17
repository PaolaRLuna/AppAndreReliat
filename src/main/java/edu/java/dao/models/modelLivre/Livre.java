package edu.java.dao.models.modelOutil;

import java.sql.Date;

public class Livre {

    private double idref;
    private String appellation;
    private String qualification_forme;
    private String forme_typ;
    private String forme_atyp;
    private String obs_aspect;
    private String etat_conserv;
    private String ro_naturel;
    private String ro_amenage;
    private String hauteur_reelemm;
    private String hauteur_supposemm;
    private String largeur_mm;
    private String epaisseur_mm;
    private String masse_gr;
    private String matiere;
    private String couleur_int;
    private String intensite_pat;
    private String ref_couleur_pat;
    private String couleur_patref_ral; // gerer couleur
    private String retouche_sigmoidales;
    private String retouches_cote_fine;
    private Date date_decouverte;  // gerer date // add Date class
    private String info_secondaire;
    private String zone_ramassage;
    private String remarquable;
    private double num_reference;

    // getters and setters
    public double getIdref() {
        return idref;
    }

    public void setIdref(double idref) {
        this.idref = idref;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public String getQualification_forme() {
        return qualification_forme;
    }

    public void setQualification_forme(String qualification_forme) {
        this.qualification_forme = qualification_forme;
    }

    public String getForme_typ() {
        return forme_typ;
    }

    public void setForme_typ(String forme_typ) {
        this.forme_typ = forme_typ;
    }

    public String getForme_atyp() {
        return forme_atyp;
    }

    public void setForme_atyp(String forme_atyp) {
        this.forme_atyp = forme_atyp;
    }

    public String getObs_aspect() {
        return obs_aspect;
    }

    public void setObs_aspect(String obs_aspect) {
        this.obs_aspect = obs_aspect;
    }

    public String getEtat_conserv() {
        return etat_conserv;
    }

    public void setEtat_conserv(String etat_conserv) {
        this.etat_conserv = etat_conserv;
    }

    public String getRo_naturel() {
        return ro_naturel;
    }

    public void setRo_naturel(String ro_naturel) {
        this.ro_naturel = ro_naturel;
    }

    public String getRo_amenage() {
        return ro_amenage;
    }

    public void setRo_amenage(String ro_amenage) {
        this.ro_amenage = ro_amenage;
    }

    public String getHauteur_reelemm() {
        return hauteur_reelemm;
    }

    public void setHauteur_reelemm(String hauteur_reelemm) {
        this.hauteur_reelemm = hauteur_reelemm;
    }

    public String getHauteur_supposemm() {
        return hauteur_supposemm;
    }

    public void setHauteur_supposemm(String hauteur_supposemm) {
        this.hauteur_supposemm = hauteur_supposemm;
    }

    public String getLargeur_mm() {
        return largeur_mm;
    }

    public void setLargeur_mm(String largeur_mm) {
        this.largeur_mm = largeur_mm;
    }

    public String getEpaisseur_mm() {
        return epaisseur_mm;
    }

    public void setEpaisseur_mm(String epaisseur_mm) {
        this.epaisseur_mm = epaisseur_mm;
    }

    public String getMasse_gr() {
        return masse_gr;
    }

    public void setMasse_gr(String masse_gr) {
        this.masse_gr = masse_gr;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getCouleur_int() {
        return couleur_int;
    }

    public void setCouleur_int(String couleur_int) {
        this.couleur_int = couleur_int;
    }

    public String getIntensite_pat() {
        return intensite_pat;
    }

    public void setIntensite_pat(String intensite_pat) {
        this.intensite_pat = intensite_pat;
    }

    public String getRef_couleur_pat() {
        return ref_couleur_pat;
    }

    public void setRef_couleur_pat(String ref_couleur_pat) {
        this.ref_couleur_pat = ref_couleur_pat;
    }

    public String getCouleur_patref_ral() {
        return couleur_patref_ral;
    }

    public void setCouleur_patref_ral(String couleur_patref_ral) {
        this.couleur_patref_ral = couleur_patref_ral;
    }

    public String getRetouche_sigmoidales() {
        return retouche_sigmoidales;
    }

    public void setRetouche_sigmoidales(String retouche_sigmoidales) {
        this.retouche_sigmoidales = retouche_sigmoidales;
    }

    public String getRetouches_cote_fine() {
        return retouches_cote_fine;
    }

    public void setRetouches_cote_fine(String retouches_cote_fine) {
        this.retouches_cote_fine = retouches_cote_fine;
    }

    public Date getDate_decouverte() {
        return date_decouverte;
    }

    public void setDate_decouverte(Date date_decouverte) {
        this.date_decouverte = date_decouverte;
    }

    public String getInfo_secondaire() {
        return info_secondaire;
    }

    public void setInfo_secondaire(String info_secondaire) {
        this.info_secondaire = info_secondaire;
    }

    public String getZone_ramassage() {
        return zone_ramassage;
    }

    public void setZone_ramassage(String zone_ramassage) {
        this.zone_ramassage = zone_ramassage;
    }

    public String getRemarquable() {
        return remarquable;
    }

    public void setRemarquable(String remarquable) {
        this.remarquable = remarquable;
    }

    public double getNum_reference() {
        return num_reference;
    }

    public void setNum_reference(double num_reference) {
        this.num_reference = num_reference;
    }

}
