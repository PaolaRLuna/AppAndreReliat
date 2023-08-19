package edu.java.dao.models.modelOutil;

// on appel le model
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoOutil implements IOutilDao {
    private static Connection conn = null;
    private static DaoOutil instanceDao = null;

    // MySQL
    // private static final String PILOTE = "com.mysql.jdbc.Driver";
    private static final String URL_BD = "jdbc:mysql://localhost/mabdcollection";
    private static final String USAGER = "root";
    private static final String PASS = "";
    // on cree les requetes
    private static final String SUPPRIMER = "DELETE FROM outils WHERE idref=?";
    private static final String GET_ALL = "SELECT * FROM outils ORDER BY idref";
    private static final String GET_BY_ID = "SELECT * FROM outils WHERE idref=?";
    private static final String GET_BY_NOM_OU_MATIERE = "SELECT * FROM outils WHERE appellation=? OR matiere=?";
    private static final String GET_BY_ZONE = "SELECT * FROM outils WHERE zone_ramassage=?";
    private static final String ENREGISTRER = "INSERT INTO outils VALUES(0,?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String MODIFIER = "UPDATE outils SET appelation=?, qualification_forme=?, forme_typ=?, forme_atyp=?, obs_aspect=?, "
            + "etat_conservation=?, ro_naturel=?, ro_amenage=?, hauteur_reele_mm=?, hauteur_suppose_mm=?, largeur_mm=?, eppaisseur_mm = ?,"
            + "masse_gr=?, matiere=?, couleur_int=?, intensite_pat =?, ref_couleur_pat=?, couleur_patref = ?, ret_sigmoidales=?, ret_cotefine=?"
            + "date_decouverte=?, info_secondaire=?, zone_ramassage=?, remarquable = ?, num_reference=? WHERE idref=?";

    // Singleton de connexion à la BD
    // getConnexion() est devenu une zonne critique.
    // Pour ne pas avoir deux processus légers (threads) qui
    // appellent au même temps getConnexion

    private DaoOutil() {
    };

    public static synchronized DaoOutil getOutilDao() {
        try {
            // Class.forName(PILOTE);
            if (instanceDao == null) {
                instanceDao = new DaoOutil(); // quand je cree une instance la classe on cree une connexion
                conn = DriverManager.getConnection(URL_BD, USAGER, PASS); // cela fait pas partie du singleton
            }
            return instanceDao;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // Create
    public String MdlO_Enregistrer(Outil loutil) {
        PreparedStatement stmt = null;
        try { // requete est dans enregistrer, pour obtenir la clé qui a été generé on utilise
              // return_generated keys
            stmt = conn.prepareStatement(ENREGISTRER, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, loutil.getIdref());
            stmt.setString(2, loutil.getAppellation());
            stmt.setString(3, loutil.getQualification_forme());
            stmt.setString(4, loutil.getForme_typ());
            stmt.setString(5, loutil.getForme_atyp());
            stmt.setString(6, loutil.getObs_aspect());
            stmt.setString(7, loutil.getEtat_conserv());
            stmt.setString(8, loutil.getRo_naturel());
            stmt.setString(9, loutil.getRo_amenage());
            stmt.setString(10, loutil.getHauteur_reelemm());
            stmt.setString(11, loutil.getHauteur_supposemm());
            stmt.setString(12, loutil.getLargeur_mm());
            stmt.setString(13, loutil.getEpaisseur_mm());
            stmt.setString(14, loutil.getMasse_gr());
            stmt.setString(15, loutil.getMatiere());
            stmt.setString(16, loutil.getCouleur_int());
            stmt.setString(17, loutil.getIntensite_pat());
            stmt.setString(18, loutil.getRef_couleur_pat());
            stmt.setString(19, loutil.getCouleur_patref_ral());
            stmt.setString(20, loutil.getRetouche_sigmoidales());
            stmt.setString(21, loutil.getRetouches_cote_fine());
            stmt.setDate(22, loutil.getDate_decouverte());
            stmt.setString(23, loutil.getInfo_secondaire());
            stmt.setString(24, loutil.getZone_ramassage());
            stmt.setString(25, loutil.getRemarquable());
            stmt.setDouble(26, loutil.getNum_reference());

            stmt.executeUpdate(); // il execute la requete
            ResultSet rs = stmt.getGeneratedKeys(); //

            if (rs.next()) {
                loutil.setIdref(rs.getInt(1)); // int est dans la premier colonne qui contient la clé, on veut la
                                               // metre
                // dans la classe pour definir le num de Outil
            }
            return "Outil bien enregistré";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MdlO_Fermer(stmt);
            MdlO_Fermer(conn);
        }
    }

    // Read
    // retourne une liste de Outils
    public ArrayList<Outil> MdlO_GetAll() {
        PreparedStatement stmt = null;
        List<Outil> listeOutils = new ArrayList<Outil>();

        try {
            stmt = conn.prepareStatement(GET_ALL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) { // on obtient la liste de tous les Outils et on va ligne par ligne
                Outil outil = new Outil();
                outil.setIdref(rs.getInt("idref"));
                outil.setAppellation(rs.getString("appelation"));
                outil.setQualification_forme(rs.getString("qualification_forme"));
                outil.setForme_typ(rs.getString("forme_typ"));
                outil.setForme_atyp(rs.getString("forme_atyp"));
                outil.setObs_aspect(rs.getString("obs_aspect"));
                outil.setEtat_conserv(rs.getString("etat_conservation"));
                outil.setRo_naturel(rs.getString("ro_naturel"));
                outil.setRo_amenage(rs.getString("ro_amenage"));
                outil.setHauteur_reelemm(rs.getString("hauteur_reel_mm"));
                outil.setHauteur_supposemm(rs.getString("hauteur_suppose_mm"));
                outil.setLargeur_mm(rs.getString("largeur_mm"));
                outil.setEpaisseur_mm(rs.getString("epaisseur_mm"));
                outil.setMasse_gr(rs.getString("masse_gr"));
                outil.setMatiere(rs.getString("matiere"));
                outil.setCouleur_int(rs.getString("couleur_int"));
                outil.setIntensite_pat(rs.getString("intensite_pat"));
                outil.setRef_couleur_pat(rs.getString("ref_couleur_pat"));
                outil.setCouleur_patref_ral(rs.getString("couleur_patref"));
                outil.setRetouche_sigmoidales(rs.getString("ret_sigmoidales"));
                outil.setRetouches_cote_fine(rs.getString("ret_cotefine"));
                outil.setDate_decouverte(rs.getDate("date_decouv"));
                outil.setInfo_secondaire(rs.getString("info_secondaire"));
                outil.setZone_ramassage(rs.getString("zone_ramassage"));
                outil.setRemarquable(rs.getString("remarquable"));
                outil.setNum_reference(rs.getDouble("num_reference"));

                listeOutils.add(outil);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
            // throw new RuntimeException(e);
        } finally {
            MdlO_Fermer(stmt);
            MdlO_Fermer(conn);
        }

        return (ArrayList<Outil>) listeOutils;
    }

    public Outil MdlO_GetById(int idref) {
        PreparedStatement stmt = null;

        try {

            stmt = conn.prepareStatement(GET_BY_ID);
            stmt.setInt(1, idref);

            ResultSet rs = stmt.executeQuery();
            Outil outil = new Outil();
            if (rs.next()) {

                outil.setIdref(rs.getInt("idref"));
                outil.setAppellation(rs.getString("appelation"));
                outil.setQualification_forme(rs.getString("qualification_forme"));
                outil.setForme_typ(rs.getString("forme_typ"));
                outil.setForme_atyp(rs.getString("forme_atyp"));
                outil.setObs_aspect(rs.getString("obs_aspect"));
                outil.setEtat_conserv(rs.getString("etat_conservation"));
                outil.setRo_naturel(rs.getString("ro_naturel"));
                outil.setRo_amenage(rs.getString("ro_amenage"));
                outil.setHauteur_reelemm(rs.getString("hauteur_reel_mm"));
                outil.setHauteur_supposemm(rs.getString("hauteur_suppose_mm"));
                outil.setLargeur_mm(rs.getString("largeur_mm"));
                outil.setEpaisseur_mm(rs.getString("epaisseur_mm"));
                outil.setMasse_gr(rs.getString("masse_gr"));
                outil.setMatiere(rs.getString("matiere"));
                outil.setCouleur_int(rs.getString("couleur_int"));
                outil.setIntensite_pat(rs.getString("intensite_pat"));
                outil.setRef_couleur_pat(rs.getString("ref_couleur_pat"));
                outil.setCouleur_patref_ral(rs.getString("couleur_patref"));
                outil.setRetouche_sigmoidales(rs.getString("ret_sigmoidales"));
                outil.setRetouches_cote_fine(rs.getString("ret_cotefine"));
                outil.setDate_decouverte(rs.getDate("date_decouv"));
                outil.setInfo_secondaire(rs.getString("info_secondaire"));
                outil.setZone_ramassage(rs.getString("zone_ramassage"));
                outil.setRemarquable(rs.getString("remarquable"));
                outil.setNum_reference(rs.getDouble("num_reference"));

                return outil;
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
    public Outil MdlO_GetByNom_ou_Matiere(String nom_matiere) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(GET_BY_NOM_OU_MATIERE);
            stmt.setString(1, nom_matiere);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Outil outil = new Outil();
                outil.setIdref(rs.getInt("idref"));
                outil.setAppellation(rs.getString("appelation"));
                outil.setQualification_forme(rs.getString("qualification_forme"));
                outil.setForme_typ(rs.getString("forme_typ"));
                outil.setForme_atyp(rs.getString("forme_atyp"));
                outil.setObs_aspect(rs.getString("obs_aspect"));
                outil.setEtat_conserv(rs.getString("etat_conservation"));
                outil.setRo_naturel(rs.getString("ro_naturel"));
                outil.setRo_amenage(rs.getString("ro_amenage"));
                outil.setHauteur_reelemm(rs.getString("hauteur_reel_mm"));
                outil.setHauteur_supposemm(rs.getString("hauteur_suppose_mm"));
                outil.setLargeur_mm(rs.getString("largeur_mm"));
                outil.setEpaisseur_mm(rs.getString("epaisseur_mm"));
                outil.setMasse_gr(rs.getString("masse_gr"));
                outil.setMatiere(rs.getString("matiere"));
                outil.setCouleur_int(rs.getString("couleur_int"));
                outil.setIntensite_pat(rs.getString("intensite_pat"));
                outil.setRef_couleur_pat(rs.getString("ref_couleur_pat"));
                outil.setCouleur_patref_ral(rs.getString("couleur_patref"));
                outil.setRetouche_sigmoidales(rs.getString("ret_sigmoidales"));
                outil.setRetouches_cote_fine(rs.getString("ret_cotefine"));
                outil.setDate_decouverte(rs.getDate("date_decouv"));
                outil.setInfo_secondaire(rs.getString("info_secondaire"));
                outil.setZone_ramassage(rs.getString("zone_ramassage"));
                outil.setRemarquable(rs.getString("remarquable"));
                outil.setNum_reference(rs.getDouble("num_reference"));

                return outil;
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
    public Outil MdlO_GetByZone(String zone) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(GET_BY_ZONE);
            stmt.setString(1, zone);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Outil outil = new Outil();
                outil.setIdref(rs.getInt("idref"));
                outil.setAppellation(rs.getString("appelation"));
                outil.setQualification_forme(rs.getString("qualification_forme"));
                outil.setForme_typ(rs.getString("forme_typ"));
                outil.setForme_atyp(rs.getString("forme_atyp"));
                outil.setObs_aspect(rs.getString("obs_aspect"));
                outil.setEtat_conserv(rs.getString("etat_conservation"));
                outil.setRo_naturel(rs.getString("ro_naturel"));
                outil.setRo_amenage(rs.getString("ro_amenage"));
                outil.setHauteur_reelemm(rs.getString("hauteur_reel_mm"));
                outil.setHauteur_supposemm(rs.getString("hauteur_suppose_mm"));
                outil.setLargeur_mm(rs.getString("largeur_mm"));
                outil.setEpaisseur_mm(rs.getString("epaisseur_mm"));
                outil.setMasse_gr(rs.getString("masse_gr"));
                outil.setMatiere(rs.getString("matiere"));
                outil.setCouleur_int(rs.getString("couleur_int"));
                outil.setIntensite_pat(rs.getString("intensite_pat"));
                outil.setRef_couleur_pat(rs.getString("ref_couleur_pat"));
                outil.setCouleur_patref_ral(rs.getString("couleur_patref"));
                outil.setRetouche_sigmoidales(rs.getString("ret_sigmoidales"));
                outil.setRetouches_cote_fine(rs.getString("ret_cotefine"));
                outil.setDate_decouverte(rs.getDate("date_decouv"));
                outil.setInfo_secondaire(rs.getString("info_secondaire"));
                outil.setZone_ramassage(rs.getString("zone_ramassage"));
                outil.setRemarquable(rs.getString("remarquable"));
                outil.setNum_reference(rs.getDouble("num_reference"));

                return outil;
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
    // les données du Outil à modifier via une interface et après envoyer
    // ce Outil à MdlF_Modifier(Outil) pour faire la mise à jour.
    public int MdlO_Modifier(Outil loutil) {
        PreparedStatement stmt = null;
        int reponse = -1;
        try {
            stmt = conn.prepareStatement(MODIFIER); // on appele la requete modifier
            stmt.setString(1, loutil.getAppellation());
            stmt.setString(2, loutil.getQualification_forme());
            stmt.setString(3, loutil.getForme_typ());
            stmt.setString(4, loutil.getForme_atyp());
            stmt.setString(5, loutil.getObs_aspect());
            stmt.setString(6, loutil.getEtat_conserv());
            stmt.setString(7, loutil.getRo_naturel());
            stmt.setString(8, loutil.getRo_amenage());
            stmt.setString(9, loutil.getHauteur_reelemm());
            stmt.setString(10, loutil.getHauteur_supposemm());
            stmt.setString(11, loutil.getLargeur_mm());
            stmt.setString(12, loutil.getEpaisseur_mm());
            stmt.setString(13, loutil.getMasse_gr());
            stmt.setString(14, loutil.getMatiere());
            stmt.setString(15, loutil.getCouleur_int());
            stmt.setString(16, loutil.getIntensite_pat());
            stmt.setString(17, loutil.getRef_couleur_pat());
            stmt.setString(18, loutil.getCouleur_patref_ral());
            stmt.setString(19, loutil.getRetouche_sigmoidales());
            stmt.setString(20, loutil.getRetouches_cote_fine());
            stmt.setDate(21, loutil.getDate_decouverte());
            stmt.setString(22, loutil.getInfo_secondaire());
            stmt.setString(23, loutil.getZone_ramassage());
            stmt.setString(24, loutil.getRemarquable());
            stmt.setDouble(25, loutil.getNum_reference());

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

    // Delete
    public int MdlO_Supprimer(int idref) {
        PreparedStatement stmt = null;
        int reponse = -1;
        try {
            stmt = conn.prepareStatement(SUPPRIMER);
            stmt.setInt(1, idref);

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
