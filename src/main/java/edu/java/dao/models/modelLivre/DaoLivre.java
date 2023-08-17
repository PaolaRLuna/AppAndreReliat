package edu.java.dao.models.modelLivre;
// on appel le model
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoLivre implements ILivreDao {
    private static Connection conn = null;
    private static DaoLivre instanceDao = null;

    // MySQL
    // private static final String PILOTE = "com.mysql.jdbc.Driver";
    private static final String URL_BD = "jdbc:mysql://localhost/mabdLivres";
    private static final String USAGER = "root";
    private static final String PASS = "";
    // on cree les requetes
    private static final String SUPPRIMER = "DELETE FROM Livres WHERE idref=?";
    private static final String GET_ALL = "SELECT * FROM Livres ORDER BY idref";
    private static final String GET_BY_ID = "SELECT * FROM Livres WHERE idref=?";
    private static final String GET_BY_NOM_OU_MATIERE = "SELECT * FROM Livres WHERE appellation=? OR matiere=?";
    private static final String GET_BY_ZONE = "SELECT * FROM Livres WHERE zone_ramassage=?";
    private static final String ENREGISTRER = "INSERT INTO Livres VALUES(0,?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String MODIFIER = "UPDATE Livres SET appelation=?, qualification_forme=?, forme_typ=?, forme_atyp=?, obs_aspect=?, "
            + "etat_conservation=?, ro_naturel=?, ro_amenage=?, hauteur_reele_mm=?, hauteur_suppose_mm=?, largeur_mm=?, eppaisseur_mm = ?,"
            + "masse_gr=?, matiere=?, couleur_int=?, intensite_pat =?, ref_couleur_pat=?, couleur_patref = ?, ret_sigmoidales=?, ret_cotefine=?"
            + "date_decouverte=?, info_secondaire=?, zone_ramassage=?, remarquable = ?, num_reference=? WHERE idref=?";

    // Singleton de connexion à la BD
    // getConnexion() est devenu une zonne critique.
    // Pour ne pas avoir deux processus légers (threads) qui
    // appellent au même temps getConnexion

    private DaoLivre() {
    };

    public static synchronized DaoLivre getLivreDao() {
        try {
            // Class.forName(PILOTE);
            if (instanceDao == null) {
                instanceDao = new DaoLivre(); // quand je cree une instance la classe on cree une connexion
                conn = DriverManager.getConnection(URL_BD, USAGER, PASS); // cela fait pas partie du singleton
            }
            return instanceDao;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // Create
    public String MdlO_Enregistrer(Livre lLivre) {
        PreparedStatement stmt = null;
        try { // requete est dans enregistrer, pour obtenir la clé qui a été generé on utilise
              // return_generated keys
            stmt = conn.prepareStatement(ENREGISTRER, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, lLivre.getAppellation());
            stmt.setString(2, lLivre.getQualification_forme());
            stmt.setString(3, lLivre.getForme_typ());
            stmt.setString(4, lLivre.getForme_atyp());
            stmt.setString(5, lLivre.getObs_aspect());
            stmt.setString(6, lLivre.getEtat_conserv());
            stmt.setString(7, lLivre.getRo_naturel());
            stmt.setString(8, lLivre.getRo_amenage());
            stmt.setString(9, lLivre.getHauteur_reelemm());
            stmt.setString(10, lLivre.getHauteur_supposemm());
            stmt.setString(11, lLivre.getLargeur_mm());
            stmt.setString(12, lLivre.getEpaisseur_mm());
            stmt.setString(13, lLivre.getMasse_gr());
            stmt.setString(14, lLivre.getMatiere());
            stmt.setString(15, lLivre.getCouleur_int());
            stmt.setString(16, lLivre.getIntensite_pat());
            stmt.setString(17, lLivre.getRef_couleur_pat());
            stmt.setString(18, lLivre.getCouleur_patref_ral());
            stmt.setString(19, lLivre.getRetouche_sigmoidales());
            stmt.setString(20, lLivre.getRetouches_cote_fine());
            stmt.setDate(21, lLivre.getDate_decouverte());
            stmt.setString(22, lLivre.getInfo_secondaire());
            stmt.setString(23, lLivre.getZone_ramassage());
            stmt.setString(24, lLivre.getRemarquable());
            stmt.setDouble(25, lLivre.getNum_reference());

            stmt.executeUpdate(); // il execute la requete
            ResultSet rs = stmt.getGeneratedKeys(); //

            if (rs.next()) {
                lLivre.setIdref(rs.getDouble(1)); // int est dans la premier colonne qui contient la clé, on veut la
                                                  // metre
                // dans la classe pour definir le num de Livre
            }
            return "Livre bien enregistré";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MdlO_Fermer(stmt);
            MdlO_Fermer(conn);
        }
    }

    // Read
    // retourne une liste de Livres
    public ArrayList<Livre> MdlO_GetAll() {
        PreparedStatement stmt = null;
        List<Livre> listeLivres = new ArrayList<Livre>();

        try {
            stmt = conn.prepareStatement(GET_ALL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) { // on obtient la liste de tous les Livres et on va ligne par ligne
                Livre Livre = new Livre();
                Livre.setIdref(rs.getDouble("idref"));
                Livre.setAppellation(rs.getString("appelation"));
                Livre.setQualification_forme(rs.getString("qualification_forme"));
                Livre.setForme_typ(rs.getString("forme_typ"));
                Livre.setForme_atyp(rs.getString("forme_atyp"));
                Livre.setObs_aspect(rs.getString("obs_aspect"));
                Livre.setEtat_conserv(rs.getString("etat_conservation"));
                Livre.setRo_naturel(rs.getString("ro_naturel"));
                Livre.setRo_amenage(rs.getString("ro_amenage"));
                Livre.setHauteur_reelemm(rs.getString("hauteur_reele_mm"));
                Livre.setHauteur_supposemm(rs.getString("hauteur_suppose_mm"));
                Livre.setLargeur_mm(rs.getString("largeur_mm"));
                Livre.setEpaisseur_mm(rs.getString("eppaisseur_mm"));
                Livre.setMasse_gr(rs.getString("masse_gr"));
                Livre.setMatiere(rs.getString("matiere"));
                Livre.setCouleur_int(rs.getString("couleur_int"));
                Livre.setIntensite_pat(rs.getString("intensite_pat"));
                Livre.setRef_couleur_pat(rs.getString("ref_couleur_pat"));
                Livre.setCouleur_patref_ral(rs.getString("couleur_patref"));
                Livre.setRetouche_sigmoidales(rs.getString("ret_sigmoidales"));
                Livre.setRetouches_cote_fine(rs.getString("ret_cotefine"));
                Livre.setDate_decouverte(rs.getDate("date_decouverte"));
                Livre.setInfo_secondaire(rs.getString("info_secondaire"));
                Livre.setZone_ramassage(rs.getString("zone_rammassage"));
                Livre.setRemarquable(rs.getString("remarquable"));
                Livre.setNum_reference(rs.getDouble("num_reference"));

                listeLivres.add(Livre);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);
        } finally {
            MdlO_Fermer(stmt);
            MdlO_Fermer(conn);
        }

        return (ArrayList<Livre>) listeLivres;
    }

    public Livre MdlO_GetById(int idref) {
        PreparedStatement stmt = null;

        try {

            stmt = conn.prepareStatement(GET_BY_ID);
            stmt.setDouble(1, idref);

            ResultSet rs = stmt.executeQuery();
            Livre Livre = new Livre();
            if (rs.next()) {

                Livre.setIdref(rs.getDouble("idref"));
                Livre.setAppellation(rs.getString("appelation"));
                Livre.setQualification_forme(rs.getString("qualification_forme"));
                Livre.setForme_typ(rs.getString("forme_typ"));
                Livre.setForme_atyp(rs.getString("forme_atyp"));
                Livre.setObs_aspect(rs.getString("obs_aspect"));
                Livre.setEtat_conserv(rs.getString("etat_conservation"));
                Livre.setRo_naturel(rs.getString("ro_naturel"));
                Livre.setRo_amenage(rs.getString("ro_amenage"));
                Livre.setHauteur_reelemm(rs.getString("hauteur_reele_mm"));
                Livre.setHauteur_supposemm(rs.getString("hauteur_suppose_mm"));
                Livre.setLargeur_mm(rs.getString("largeur_mm"));
                Livre.setEpaisseur_mm(rs.getString("eppaisseur_mm"));
                Livre.setMasse_gr(rs.getString("masse_gr"));
                Livre.setMatiere(rs.getString("matiere"));
                Livre.setCouleur_int(rs.getString("couleur_int"));
                Livre.setIntensite_pat(rs.getString("intensite_pat"));
                Livre.setRef_couleur_pat(rs.getString("ref_couleur_pat"));
                Livre.setCouleur_patref_ral(rs.getString("couleur_patref"));
                Livre.setRetouche_sigmoidales(rs.getString("ret_sigmoidales"));
                Livre.setRetouches_cote_fine(rs.getString("ret_cotefine"));
                Livre.setDate_decouverte(rs.getDate("date_decouverte"));
                Livre.setInfo_secondaire(rs.getString("info_secondaire"));
                Livre.setZone_ramassage(rs.getString("zone_rammassage"));
                Livre.setRemarquable(rs.getString("remarquable"));
                Livre.setNum_reference(rs.getDouble("num_reference"));

                return Livre;
            } else {
                return null;
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            MdlO_Fermer(stmt);
            MdlO_Fermer(conn);
        }
    }

    // GET BY APPELLATION OU MATIERE
    public Livre MdlO_GetByNom_ou_Matiere(String nom_matiere) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(GET_BY_NOM_OU_MATIERE);
            stmt.setString(1, nom_matiere);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Livre Livre = new Livre();
                Livre.setIdref(rs.getDouble("idref"));
                Livre.setAppellation(rs.getString("appelation"));
                Livre.setQualification_forme(rs.getString("qualification_forme"));
                Livre.setForme_typ(rs.getString("forme_typ"));
                Livre.setForme_atyp(rs.getString("forme_atyp"));
                Livre.setObs_aspect(rs.getString("obs_aspect"));
                Livre.setEtat_conserv(rs.getString("etat_conservation"));
                Livre.setRo_naturel(rs.getString("ro_naturel"));
                Livre.setRo_amenage(rs.getString("ro_amenage"));
                Livre.setHauteur_reelemm(rs.getString("hauteur_reele_mm"));
                Livre.setHauteur_supposemm(rs.getString("hauteur_suppose_mm"));
                Livre.setLargeur_mm(rs.getString("largeur_mm"));
                Livre.setEpaisseur_mm(rs.getString("eppaisseur_mm"));
                Livre.setMasse_gr(rs.getString("masse_gr"));
                Livre.setMatiere(rs.getString("matiere"));
                Livre.setCouleur_int(rs.getString("couleur_int"));
                Livre.setIntensite_pat(rs.getString("intensite_pat"));
                Livre.setRef_couleur_pat(rs.getString("ref_couleur_pat"));
                Livre.setCouleur_patref_ral(rs.getString("couleur_patref"));
                Livre.setRetouche_sigmoidales(rs.getString("ret_sigmoidales"));
                Livre.setRetouches_cote_fine(rs.getString("ret_cotefine"));
                Livre.setDate_decouverte(rs.getDate("date_decouverte"));
                Livre.setInfo_secondaire(rs.getString("info_secondaire"));
                Livre.setZone_ramassage(rs.getString("zone_rammassage"));
                Livre.setRemarquable(rs.getString("remarquable"));
                Livre.setNum_reference(rs.getDouble("num_reference"));

                return Livre;
            } else {
                return null;
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            MdlO_Fermer(stmt);
            MdlO_Fermer(conn);
        }
    }

    // GET BY APPELLATION OU MATIERE
    public Livre MdlO_GetByZone(String zone) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(GET_BY_ZONE);
            stmt.setString(1, zone);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Livre Livre = new Livre();
                Livre.setIdref(rs.getDouble("idref"));
                Livre.setAppellation(rs.getString("appelation"));
                Livre.setQualification_forme(rs.getString("qualification_forme"));
                Livre.setForme_typ(rs.getString("forme_typ"));
                Livre.setForme_atyp(rs.getString("forme_atyp"));
                Livre.setObs_aspect(rs.getString("obs_aspect"));
                Livre.setEtat_conserv(rs.getString("etat_conservation"));
                Livre.setRo_naturel(rs.getString("ro_naturel"));
                Livre.setRo_amenage(rs.getString("ro_amenage"));
                Livre.setHauteur_reelemm(rs.getString("hauteur_reele_mm"));
                Livre.setHauteur_supposemm(rs.getString("hauteur_suppose_mm"));
                Livre.setLargeur_mm(rs.getString("largeur_mm"));
                Livre.setEpaisseur_mm(rs.getString("eppaisseur_mm"));
                Livre.setMasse_gr(rs.getString("masse_gr"));
                Livre.setMatiere(rs.getString("matiere"));
                Livre.setCouleur_int(rs.getString("couleur_int"));
                Livre.setIntensite_pat(rs.getString("intensite_pat"));
                Livre.setRef_couleur_pat(rs.getString("ref_couleur_pat"));
                Livre.setCouleur_patref_ral(rs.getString("couleur_patref"));
                Livre.setRetouche_sigmoidales(rs.getString("ret_sigmoidales"));
                Livre.setRetouches_cote_fine(rs.getString("ret_cotefine"));
                Livre.setDate_decouverte(rs.getDate("date_decouverte"));
                Livre.setInfo_secondaire(rs.getString("info_secondaire"));
                Livre.setZone_ramassage(rs.getString("zone_rammassage"));
                Livre.setRemarquable(rs.getString("remarquable"));
                Livre.setNum_reference(rs.getDouble("num_reference"));

                return Livre;
            } else {
                return null;
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            MdlO_Fermer(stmt);
            MdlO_Fermer(conn);
        }
    }

    // Update, faudrat avant appeler MdlF_GetById(idf) pour obtenir
    // les données du Livre à modifier via une interface et après envoyer
    // ce Livre à MdlF_Modifier(Livre) pour faire la mise à jour.
    public int MdlO_Modifier(Livre lLivre) {
        PreparedStatement stmt = null;
        int reponse = -1;
        try {
            stmt = conn.prepareStatement(MODIFIER); // on appele la requete modifier
            stmt.setString(1, lLivre.getAppellation());
            stmt.setString(2, lLivre.getQualification_forme());
            stmt.setString(3, lLivre.getForme_typ());
            stmt.setString(4, lLivre.getForme_atyp());
            stmt.setString(5, lLivre.getObs_aspect());
            stmt.setString(6, lLivre.getEtat_conserv());
            stmt.setString(7, lLivre.getRo_naturel());
            stmt.setString(8, lLivre.getRo_amenage());
            stmt.setString(9, lLivre.getHauteur_reelemm());
            stmt.setString(10, lLivre.getHauteur_supposemm());
            stmt.setString(11, lLivre.getLargeur_mm());
            stmt.setString(12, lLivre.getEpaisseur_mm());
            stmt.setString(13, lLivre.getMasse_gr());
            stmt.setString(14, lLivre.getMatiere());
            stmt.setString(15, lLivre.getCouleur_int());
            stmt.setString(16, lLivre.getIntensite_pat());
            stmt.setString(17, lLivre.getRef_couleur_pat());
            stmt.setString(18, lLivre.getCouleur_patref_ral());
            stmt.setString(19, lLivre.getRetouche_sigmoidales());
            stmt.setString(20, lLivre.getRetouches_cote_fine());
            stmt.setDate(21, lLivre.getDate_decouverte());
            stmt.setString(22, lLivre.getInfo_secondaire());
            stmt.setString(23, lLivre.getZone_ramassage());
            stmt.setString(24, lLivre.getRemarquable());
            stmt.setDouble(25, lLivre.getNum_reference());

            reponse = stmt.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
            //throw new RuntimeException(e);
           
        } finally {
            MdlO_Fermer(stmt);
            MdlO_Fermer(conn);
        }
        return reponse;
    }

    // Delete
    public int MdlO_Supprimer(int idref) {
        PreparedStatement stmt = null;
        int reponse = -1;
        try {
            stmt = conn.prepareStatement(SUPPRIMER);
            stmt.setDouble(1, idref);

            reponse = stmt.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
           // throw new RuntimeException(e);
        } finally {
            MdlO_Fermer(stmt);
            MdlO_Fermer(conn);
        }
        return reponse;
    }

    private static void MdlO_Fermer(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    private static void MdlO_Fermer(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                // e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
