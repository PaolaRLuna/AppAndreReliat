package edu.java.dao.models.modelMonnaie;
// on appel le model
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoMonnaie implements IMonnaieDao {
    private static Connection conn = null;
    private static DaoMonnaie instanceDao = null;

    // MySQL
    // private static final String PILOTE = "com.mysql.jdbc.Driver";
    private static final String URL_BD = "jdbc:mysql://localhost/mabdMonnaies";
    private static final String USAGER = "root";
    private static final String PASS = "";
    // on cree les requetes
    private static final String SUPPRIMER = "DELETE FROM Monnaies WHERE idref=?";
    private static final String GET_ALL = "SELECT * FROM Monnaies ORDER BY idref";
    private static final String GET_BY_ID = "SELECT * FROM Monnaies WHERE idref=?";
    private static final String GET_BY_NOM_OU_MATIERE = "SELECT * FROM Monnaies WHERE appellation=? OR matiere=?";
    private static final String GET_BY_ZONE = "SELECT * FROM Monnaies WHERE zone_ramassage=?";
    private static final String ENREGISTRER = "INSERT INTO Monnaies VALUES(0,?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String MODIFIER = "UPDATE Monnaies SET appelation=?, qualification_forme=?, forme_typ=?, forme_atyp=?, obs_aspect=?, "
            + "etat_conservation=?, ro_naturel=?, ro_amenage=?, hauteur_reele_mm=?, hauteur_suppose_mm=?, largeur_mm=?, eppaisseur_mm = ?,"
            + "masse_gr=?, matiere=?, couleur_int=?, intensite_pat =?, ref_couleur_pat=?, couleur_patref = ?, ret_sigmoidales=?, ret_cotefine=?"
            + "date_decouverte=?, info_secondaire=?, zone_ramassage=?, remarquable = ?, num_reference=? WHERE idref=?";

    // Singleton de connexion à la BD
    // getConnexion() est devenu une zonne critique.
    // Pour ne pas avoir deux processus légers (threads) qui
    // appellent au même temps getConnexion

    private DaoMonnaie() {
    };

    public static synchronized DaoMonnaie getMonnaieDao() {
        try {
            // Class.forName(PILOTE);
            if (instanceDao == null) {
                instanceDao = new DaoMonnaie(); // quand je cree une instance la classe on cree une connexion
                conn = DriverManager.getConnection(URL_BD, USAGER, PASS); // cela fait pas partie du singleton
            }
            return instanceDao;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // Create
    public String MdlO_Enregistrer(Monnaie lMonnaie) {
        PreparedStatement stmt = null;
        try { // requete est dans enregistrer, pour obtenir la clé qui a été generé on utilise
              // return_generated keys
            stmt = conn.prepareStatement(ENREGISTRER, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, lMonnaie.getAppellation());
            stmt.setString(2, lMonnaie.getQualification_forme());
            stmt.setString(3, lMonnaie.getForme_typ());
            stmt.setString(4, lMonnaie.getForme_atyp());
            stmt.setString(5, lMonnaie.getObs_aspect());
            stmt.setString(6, lMonnaie.getEtat_conserv());
            stmt.setString(7, lMonnaie.getRo_naturel());
            stmt.setString(8, lMonnaie.getRo_amenage());
            stmt.setString(9, lMonnaie.getHauteur_reelemm());
            stmt.setString(10, lMonnaie.getHauteur_supposemm());
            stmt.setString(11, lMonnaie.getLargeur_mm());
            stmt.setString(12, lMonnaie.getEpaisseur_mm());
            stmt.setString(13, lMonnaie.getMasse_gr());
            stmt.setString(14, lMonnaie.getMatiere());
            stmt.setString(15, lMonnaie.getCouleur_int());
            stmt.setString(16, lMonnaie.getIntensite_pat());
            stmt.setString(17, lMonnaie.getRef_couleur_pat());
            stmt.setString(18, lMonnaie.getCouleur_patref_ral());
            stmt.setString(19, lMonnaie.getRetouche_sigmoidales());
            stmt.setString(20, lMonnaie.getRetouches_cote_fine());
            stmt.setDate(21, lMonnaie.getDate_decouverte());
            stmt.setString(22, lMonnaie.getInfo_secondaire());
            stmt.setString(23, lMonnaie.getZone_ramassage());
            stmt.setString(24, lMonnaie.getRemarquable());
            stmt.setDouble(25, lMonnaie.getNum_reference());

            stmt.executeUpdate(); // il execute la requete
            ResultSet rs = stmt.getGeneratedKeys(); //

            if (rs.next()) {
                lMonnaie.setIdref(rs.getDouble(1)); // int est dans la premier colonne qui contient la clé, on veut la
                                                  // metre
                // dans la classe pour definir le num de Monnaie
            }
            return "Monnaie bien enregistré";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MdlO_Fermer(stmt);
            MdlO_Fermer(conn);
        }
    }

    // Read
    // retourne une liste de Monnaies
    public ArrayList<Monnaie> MdlO_GetAll() {
        PreparedStatement stmt = null;
        List<Monnaie> listeMonnaies = new ArrayList<Monnaie>();

        try {
            stmt = conn.prepareStatement(GET_ALL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) { // on obtient la liste de tous les Monnaies et on va ligne par ligne
                Monnaie Monnaie = new Monnaie();
                Monnaie.setIdref(rs.getDouble("idref"));
                Monnaie.setAppellation(rs.getString("appelation"));
                Monnaie.setQualification_forme(rs.getString("qualification_forme"));
                Monnaie.setForme_typ(rs.getString("forme_typ"));
                Monnaie.setForme_atyp(rs.getString("forme_atyp"));
                Monnaie.setObs_aspect(rs.getString("obs_aspect"));
                Monnaie.setEtat_conserv(rs.getString("etat_conservation"));
                Monnaie.setRo_naturel(rs.getString("ro_naturel"));
                Monnaie.setRo_amenage(rs.getString("ro_amenage"));
                Monnaie.setHauteur_reelemm(rs.getString("hauteur_reele_mm"));
                Monnaie.setHauteur_supposemm(rs.getString("hauteur_suppose_mm"));
                Monnaie.setLargeur_mm(rs.getString("largeur_mm"));
                Monnaie.setEpaisseur_mm(rs.getString("eppaisseur_mm"));
                Monnaie.setMasse_gr(rs.getString("masse_gr"));
                Monnaie.setMatiere(rs.getString("matiere"));
                Monnaie.setCouleur_int(rs.getString("couleur_int"));
                Monnaie.setIntensite_pat(rs.getString("intensite_pat"));
                Monnaie.setRef_couleur_pat(rs.getString("ref_couleur_pat"));
                Monnaie.setCouleur_patref_ral(rs.getString("couleur_patref"));
                Monnaie.setRetouche_sigmoidales(rs.getString("ret_sigmoidales"));
                Monnaie.setRetouches_cote_fine(rs.getString("ret_cotefine"));
                Monnaie.setDate_decouverte(rs.getDate("date_decouverte"));
                Monnaie.setInfo_secondaire(rs.getString("info_secondaire"));
                Monnaie.setZone_ramassage(rs.getString("zone_rammassage"));
                Monnaie.setRemarquable(rs.getString("remarquable"));
                Monnaie.setNum_reference(rs.getDouble("num_reference"));

                listeMonnaies.add(Monnaie);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);
        } finally {
            MdlO_Fermer(stmt);
            MdlO_Fermer(conn);
        }

        return (ArrayList<Monnaie>) listeMonnaies;
    }

    public Monnaie MdlO_GetById(int idref) {
        PreparedStatement stmt = null;

        try {

            stmt = conn.prepareStatement(GET_BY_ID);
            stmt.setDouble(1, idref);

            ResultSet rs = stmt.executeQuery();
            Monnaie Monnaie = new Monnaie();
            if (rs.next()) {

                Monnaie.setIdref(rs.getDouble("idref"));
                Monnaie.setAppellation(rs.getString("appelation"));
                Monnaie.setQualification_forme(rs.getString("qualification_forme"));
                Monnaie.setForme_typ(rs.getString("forme_typ"));
                Monnaie.setForme_atyp(rs.getString("forme_atyp"));
                Monnaie.setObs_aspect(rs.getString("obs_aspect"));
                Monnaie.setEtat_conserv(rs.getString("etat_conservation"));
                Monnaie.setRo_naturel(rs.getString("ro_naturel"));
                Monnaie.setRo_amenage(rs.getString("ro_amenage"));
                Monnaie.setHauteur_reelemm(rs.getString("hauteur_reele_mm"));
                Monnaie.setHauteur_supposemm(rs.getString("hauteur_suppose_mm"));
                Monnaie.setLargeur_mm(rs.getString("largeur_mm"));
                Monnaie.setEpaisseur_mm(rs.getString("eppaisseur_mm"));
                Monnaie.setMasse_gr(rs.getString("masse_gr"));
                Monnaie.setMatiere(rs.getString("matiere"));
                Monnaie.setCouleur_int(rs.getString("couleur_int"));
                Monnaie.setIntensite_pat(rs.getString("intensite_pat"));
                Monnaie.setRef_couleur_pat(rs.getString("ref_couleur_pat"));
                Monnaie.setCouleur_patref_ral(rs.getString("couleur_patref"));
                Monnaie.setRetouche_sigmoidales(rs.getString("ret_sigmoidales"));
                Monnaie.setRetouches_cote_fine(rs.getString("ret_cotefine"));
                Monnaie.setDate_decouverte(rs.getDate("date_decouverte"));
                Monnaie.setInfo_secondaire(rs.getString("info_secondaire"));
                Monnaie.setZone_ramassage(rs.getString("zone_rammassage"));
                Monnaie.setRemarquable(rs.getString("remarquable"));
                Monnaie.setNum_reference(rs.getDouble("num_reference"));

                return Monnaie;
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
    public Monnaie MdlO_GetByNom_ou_Matiere(String nom_matiere) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(GET_BY_NOM_OU_MATIERE);
            stmt.setString(1, nom_matiere);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Monnaie Monnaie = new Monnaie();
                Monnaie.setIdref(rs.getDouble("idref"));
                Monnaie.setAppellation(rs.getString("appelation"));
                Monnaie.setQualification_forme(rs.getString("qualification_forme"));
                Monnaie.setForme_typ(rs.getString("forme_typ"));
                Monnaie.setForme_atyp(rs.getString("forme_atyp"));
                Monnaie.setObs_aspect(rs.getString("obs_aspect"));
                Monnaie.setEtat_conserv(rs.getString("etat_conservation"));
                Monnaie.setRo_naturel(rs.getString("ro_naturel"));
                Monnaie.setRo_amenage(rs.getString("ro_amenage"));
                Monnaie.setHauteur_reelemm(rs.getString("hauteur_reele_mm"));
                Monnaie.setHauteur_supposemm(rs.getString("hauteur_suppose_mm"));
                Monnaie.setLargeur_mm(rs.getString("largeur_mm"));
                Monnaie.setEpaisseur_mm(rs.getString("eppaisseur_mm"));
                Monnaie.setMasse_gr(rs.getString("masse_gr"));
                Monnaie.setMatiere(rs.getString("matiere"));
                Monnaie.setCouleur_int(rs.getString("couleur_int"));
                Monnaie.setIntensite_pat(rs.getString("intensite_pat"));
                Monnaie.setRef_couleur_pat(rs.getString("ref_couleur_pat"));
                Monnaie.setCouleur_patref_ral(rs.getString("couleur_patref"));
                Monnaie.setRetouche_sigmoidales(rs.getString("ret_sigmoidales"));
                Monnaie.setRetouches_cote_fine(rs.getString("ret_cotefine"));
                Monnaie.setDate_decouverte(rs.getDate("date_decouverte"));
                Monnaie.setInfo_secondaire(rs.getString("info_secondaire"));
                Monnaie.setZone_ramassage(rs.getString("zone_rammassage"));
                Monnaie.setRemarquable(rs.getString("remarquable"));
                Monnaie.setNum_reference(rs.getDouble("num_reference"));

                return Monnaie;
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
    public Monnaie MdlO_GetByZone(String zone) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(GET_BY_ZONE);
            stmt.setString(1, zone);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Monnaie Monnaie = new Monnaie();
                Monnaie.setIdref(rs.getDouble("idref"));
                Monnaie.setAppellation(rs.getString("appelation"));
                Monnaie.setQualification_forme(rs.getString("qualification_forme"));
                Monnaie.setForme_typ(rs.getString("forme_typ"));
                Monnaie.setForme_atyp(rs.getString("forme_atyp"));
                Monnaie.setObs_aspect(rs.getString("obs_aspect"));
                Monnaie.setEtat_conserv(rs.getString("etat_conservation"));
                Monnaie.setRo_naturel(rs.getString("ro_naturel"));
                Monnaie.setRo_amenage(rs.getString("ro_amenage"));
                Monnaie.setHauteur_reelemm(rs.getString("hauteur_reele_mm"));
                Monnaie.setHauteur_supposemm(rs.getString("hauteur_suppose_mm"));
                Monnaie.setLargeur_mm(rs.getString("largeur_mm"));
                Monnaie.setEpaisseur_mm(rs.getString("eppaisseur_mm"));
                Monnaie.setMasse_gr(rs.getString("masse_gr"));
                Monnaie.setMatiere(rs.getString("matiere"));
                Monnaie.setCouleur_int(rs.getString("couleur_int"));
                Monnaie.setIntensite_pat(rs.getString("intensite_pat"));
                Monnaie.setRef_couleur_pat(rs.getString("ref_couleur_pat"));
                Monnaie.setCouleur_patref_ral(rs.getString("couleur_patref"));
                Monnaie.setRetouche_sigmoidales(rs.getString("ret_sigmoidales"));
                Monnaie.setRetouches_cote_fine(rs.getString("ret_cotefine"));
                Monnaie.setDate_decouverte(rs.getDate("date_decouverte"));
                Monnaie.setInfo_secondaire(rs.getString("info_secondaire"));
                Monnaie.setZone_ramassage(rs.getString("zone_rammassage"));
                Monnaie.setRemarquable(rs.getString("remarquable"));
                Monnaie.setNum_reference(rs.getDouble("num_reference"));

                return Monnaie;
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
    // les données du Monnaie à modifier via une interface et après envoyer
    // ce Monnaie à MdlF_Modifier(Monnaie) pour faire la mise à jour.
    public int MdlO_Modifier(Monnaie lMonnaie) {
        PreparedStatement stmt = null;
        int reponse = -1;
        try {
            stmt = conn.prepareStatement(MODIFIER); // on appele la requete modifier
            stmt.setString(1, lMonnaie.getAppellation());
            stmt.setString(2, lMonnaie.getQualification_forme());
            stmt.setString(3, lMonnaie.getForme_typ());
            stmt.setString(4, lMonnaie.getForme_atyp());
            stmt.setString(5, lMonnaie.getObs_aspect());
            stmt.setString(6, lMonnaie.getEtat_conserv());
            stmt.setString(7, lMonnaie.getRo_naturel());
            stmt.setString(8, lMonnaie.getRo_amenage());
            stmt.setString(9, lMonnaie.getHauteur_reelemm());
            stmt.setString(10, lMonnaie.getHauteur_supposemm());
            stmt.setString(11, lMonnaie.getLargeur_mm());
            stmt.setString(12, lMonnaie.getEpaisseur_mm());
            stmt.setString(13, lMonnaie.getMasse_gr());
            stmt.setString(14, lMonnaie.getMatiere());
            stmt.setString(15, lMonnaie.getCouleur_int());
            stmt.setString(16, lMonnaie.getIntensite_pat());
            stmt.setString(17, lMonnaie.getRef_couleur_pat());
            stmt.setString(18, lMonnaie.getCouleur_patref_ral());
            stmt.setString(19, lMonnaie.getRetouche_sigmoidales());
            stmt.setString(20, lMonnaie.getRetouches_cote_fine());
            stmt.setDate(21, lMonnaie.getDate_decouverte());
            stmt.setString(22, lMonnaie.getInfo_secondaire());
            stmt.setString(23, lMonnaie.getZone_ramassage());
            stmt.setString(24, lMonnaie.getRemarquable());
            stmt.setDouble(25, lMonnaie.getNum_reference());

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
