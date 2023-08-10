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

public class DaoOutil {
    private static Connection conn = null;
    private static DaoOutil instanceDao = null;

    // MySQL
    //private static final String PILOTE = "com.mysql.jdbc.Driver";
    private static final String URL_BD = "jdbc:mysql://localhost/mabdoutils";
    private static final String USAGER = "root";
    private static final String PASS = "";
    // on cree les requetes
    private static final String SUPPRIMER = "DELETE FROM Outils WHERE idref=?";
    private static final String GET_ALL = "SELECT * FROM Outils ORDER BY idref";
    private static final String GET_BY_ID = "SELECT * FROM Outils WHERE idref=?";
    private static final String GET_BY_TITRE = "SELECT * FROM Outils WHERE appellation=?";
    private static final String ENREGISTRER = "INSERT INTO Outils VALUES(0,?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String MODIFIER = "UPDATE Outils SET appelation=?, qualification_forme=?, forme_typ=?, forme_atyp=?, obs_aspect=?, "
    + "etat_conserv=?, ro_naturel=?, ro_amenage=?, hauteur_reele_mm=?, hauteur_suppose_mm=?, largeur_mm=?, eppaisseur_mm = ?," 
    + "masse_gr=?, matiere=?, couleur_int=?, intensite_pat =?, WHERE idf=?";

    // Singleton de connexion à la BD
    // getConnexion() est devenu une zonne critique. 
    // Pour ne pas avoir deux processus légers (threads) qui
    // appellent au même temps getConnexion

    private DaoOutil(){};
    
    public static synchronized DaoOutil getOutilDao () {
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
    public String MdlF_Enregistrer(Outil Outil) {
        PreparedStatement stmt = null;
        try { // requete est dans enregistrer, pour obtenir la clé qui a été generé  on utilise return_generated keys
            stmt = conn.prepareStatement(ENREGISTRER, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, Outil.getTitre());
            stmt.setInt(2, Outil.getDuree());
            stmt.setString(3, Outil.getRes());
            stmt.setString(4, Outil.getPochette());
           
            stmt.executeUpdate(); // il execute la requete
            ResultSet rs = stmt.getGeneratedKeys(); // 

            if (rs.next()) {
                Outil.setIdf(rs.getInt(1)); // int est dans la premier colonne qui contient la clé, on veut la metre dans la classe pour definir le num de Outil
            }
            return "Outil bien enregistré";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MdlF_Fermer(stmt);
            MdlF_Fermer(conn);
        }
    }

    // Read
    // retourne une liste de Outils
    public List<Outil> MdlF_GetAll() {
        PreparedStatement stmt = null;
        List<Outil> listeOutils = new ArrayList<Outil>();

        try {
            stmt = conn.prepareStatement(GET_ALL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) { // on obtient la liste de tous les Outils et on va ligne par ligne
                Outil Outil = new Outil();
                Outil.setIdf(rs.getInt("idf"));
                Outil.setTitre(rs.getString("titre"));
                Outil.setDuree(rs.getInt("duree"));
                Outil.setRes(rs.getString("res"));
                Outil.setPochette(rs.getString("pochette"));

                listeOutils.add(Outil);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            MdlF_Fermer(stmt);
            MdlF_Fermer(conn);
        }

        return listeOutils;
    }

    public Outil MdlF_GetById(int idf) {
        PreparedStatement stmt = null;

        try {

            stmt = conn.prepareStatement(GET_BY_ID);
            stmt.setInt(1, idf);

            ResultSet rs = stmt.executeQuery();
            Outil Outil = new Outil();
            if (rs.next()) {
                
                Outil.setIdf(rs.getInt("idf"));
                Outil.setTitre(rs.getString("titre"));
                Outil.setDuree(rs.getInt("duree"));
                Outil.setRes(rs.getString("res"));
                Outil.setPochette(rs.getString("pochette"));

                return Outil;
            } else {
                return null;
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            MdlF_Fermer(stmt);
            MdlF_Fermer(conn);
        }
    }

    public Outil MdlF_GetByTitre(String titre) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(GET_BY_TITRE);
            stmt.setString(1, titre);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Outil Outil = new Outil();
                Outil.setIdf(rs.getInt("idf"));
                Outil.setTitre(rs.getString("titre"));
                Outil.setDuree(rs.getInt("duree"));
                Outil.setRes(rs.getString("res"));
                Outil.setPochette(rs.getString("pochette"));

                return Outil;
            } else {
                return null;
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            MdlF_Fermer(stmt);
            MdlF_Fermer(conn);
        }
    }

    // Update, faudrat avant appeler MdlF_GetById(idf) pour obtenir
    // les données du Outil à modifier via une interface et après envoyer 
    // ce Outil à MdlF_Modifier(Outil) pour faire la mise à  jour.
    public int MdlF_Modifier(Outil Outil) {
        PreparedStatement stmt = null;
       ;
        try {
            stmt = conn.prepareStatement(MODIFIER); // on appele la requete modifier
            stmt.setString(1, Outil.getTitre());
            stmt.setInt(2, Outil.getDuree());
            stmt.setString(3, Outil.getRes());
            stmt.setString(4, Outil.getPochette());

            return stmt.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            MdlF_Fermer(stmt);
            MdlF_Fermer(conn);
        }
    }

    // Delete
    public int MdlF_Supprimer(int idf) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(SUPPRIMER);
            stmt.setInt(1, idf);

            return stmt.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            MdlF_Fermer(stmt);
            MdlF_Fermer(conn);
        }
    }
   
    private static void MdlF_Fermer(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    private static void MdlF_Fermer(Statement stmt) {
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
