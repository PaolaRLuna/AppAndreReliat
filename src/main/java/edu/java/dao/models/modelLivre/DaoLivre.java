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
    private static final String URL_BD = "jdbc:mysql://localhost/mabdcollection";
    private static final String USAGER = "root";
    private static final String PASS = "";
    // on cree les requetes
    private static final String SUPPRIMER = "DELETE FROM livres WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM livres ORDER BY id";
    private static final String GET_BY_NUM = "SELECT * FROM livres WHERE num=?";
    private static final String GET_BY_TITRE = "SELECT * FROM livres WHERE titre=?";
    private static final String GET_BY_AUTEUR = "SELECT * FROM livres WHERE auteur=?";
    private static final String ENREGISTRER = "INSERT INTO livres VALUES(0,?, ?, ?, ?,?,?,?,?,?,?,?,?)";
    private static final String MODIFIER = "UPDATE livres SET num=?, titre=?, sousTitre=?, auteur=?, editeur=?, "
            + "tome=?, annee=?, support=?, rangement=?, empereurs=?, collection=?, categorie = ? WHERE idl=?";

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
    public String MdlL_Enregistrer(Livre leLivre) {
        PreparedStatement stmt = null;
        try { // requete est dans enregistrer, pour obtenir la clé qui a été generé on utilise
              // return_generated keys
            stmt = conn.prepareStatement(ENREGISTRER, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, leLivre.getIdl());
            stmt.setInt(2, leLivre.getNum());
            stmt.setString(3, leLivre.getTitre());
            stmt.setString(4, leLivre.getSousTitre());
            stmt.setString(5, leLivre.getAuteur());
            stmt.setString(6, leLivre.getEditeur());
            stmt.setString(7, leLivre.getTome());
            stmt.setString(8, leLivre.getAnnee());
            stmt.setString(9, leLivre.getSupport());
            stmt.setString(10, leLivre.getRangement());
            stmt.setString(11, leLivre.getEmpereurs());
            stmt.setString(12, leLivre.getCollection());
            stmt.setString(13, leLivre.getCategorie());

            stmt.executeUpdate(); // il execute la requete
            ResultSet rs = stmt.getGeneratedKeys(); //

            if (rs.next()) {
                leLivre.setIdl(rs.getInt(1)); // int est dans la premier colonne qui contient la clé, on veut la
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
    public ArrayList<Livre> MdlL_GetAll() {
        PreparedStatement stmt = null;
        List<Livre> listeLivres = new ArrayList<Livre>();

        try {
            stmt = conn.prepareStatement(GET_ALL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) { // on obtient la liste de tous les Livres et on va ligne par ligne
                Livre livre = new Livre();
                livre.setIdl(rs.getInt("idl"));
                livre.setNum(rs.getInt("num"));
                livre.setTitre(rs.getString("titre"));
                livre.setSousTitre(rs.getString("sousTitre"));
                livre.setAuteur(rs.getString("auteur"));
                livre.setEditeur(rs.getString("editeur"));
                livre.setTome(rs.getString("tome"));
                livre.setAnnee(rs.getString("annee"));
                livre.setSupport(rs.getString("support"));
                livre.setRangement(rs.getString("rangement"));
                livre.setEmpereurs(rs.getString("empereurs"));
                livre.setCollection(rs.getString("collection"));
                livre.setCategorie(rs.getString("categorie"));

                listeLivres.add(livre);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
            // throw new RuntimeException(e);
        } finally {
            MdlO_Fermer(stmt);
            MdlO_Fermer(conn);
        }

        return (ArrayList<Livre>) listeLivres;
    }

    public Livre MdlL_GetByNum(int num) {
        PreparedStatement stmt = null;

        try {

            stmt = conn.prepareStatement(GET_BY_NUM);
            stmt.setInt(2, num);

            ResultSet rs = stmt.executeQuery();
            Livre livre = new Livre();
            if (rs.next()) {
                livre.setIdl(rs.getInt("idl"));
                livre.setNum(rs.getInt("num"));
                livre.setTitre(rs.getString("titre"));
                livre.setSousTitre(rs.getString("sousTitre"));
                livre.setAuteur(rs.getString("auteur"));
                livre.setEditeur(rs.getString("editeur"));
                livre.setTome(rs.getString("tome"));
                livre.setAnnee(rs.getString("annee"));
                livre.setSupport(rs.getString("support"));
                livre.setRangement(rs.getString("rangement"));
                livre.setEmpereurs(rs.getString("empereurs"));
                livre.setCollection(rs.getString("collection"));
                livre.setCategorie(rs.getString("categorie"));

                return livre;
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
    public Livre MdlL_GetByTitre(String titre) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(GET_BY_TITRE);
            stmt.setString(1, titre);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Livre livre = new Livre();
                livre.setIdl(rs.getInt("idl"));
                livre.setNum(rs.getInt("num"));
                livre.setTitre(rs.getString("titre"));
                livre.setSousTitre(rs.getString("sousTitre"));
                livre.setAuteur(rs.getString("auteur"));
                livre.setEditeur(rs.getString("editeur"));
                livre.setTome(rs.getString("tome"));
                livre.setAnnee(rs.getString("annee"));
                livre.setSupport(rs.getString("support"));
                livre.setRangement(rs.getString("rangement"));
                livre.setEmpereurs(rs.getString("empereurs"));
                livre.setCollection(rs.getString("collection"));
                livre.setCategorie(rs.getString("categorie"));

                return livre;
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
    public Livre MdlL_GetByAuteur(String auteur) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(GET_BY_AUTEUR);
            stmt.setString(1, auteur);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Livre livre = new Livre();
                livre.setIdl(rs.getInt("idl"));
                livre.setNum(rs.getInt("num"));
                livre.setTitre(rs.getString("titre"));
                livre.setSousTitre(rs.getString("sousTitre"));
                livre.setAuteur(rs.getString("auteur"));
                livre.setEditeur(rs.getString("editeur"));
                livre.setTome(rs.getString("tome"));
                livre.setAnnee(rs.getString("annee"));
                livre.setSupport(rs.getString("support"));
                livre.setRangement(rs.getString("rangement"));
                livre.setEmpereurs(rs.getString("empereurs"));
                livre.setCollection(rs.getString("collection"));
                livre.setCategorie(rs.getString("categorie"));

                return livre;
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
    public int MdlL_Modifier(Livre leLivre) {
        PreparedStatement stmt = null;
        int reponse = -1;
        try {
            stmt = conn.prepareStatement(MODIFIER); // on appele la requete modifier
            stmt.setInt(1, leLivre.getNum());
            stmt.setString(2, leLivre.getTitre());
            stmt.setString(3, leLivre.getSousTitre());
            stmt.setString(4, leLivre.getAuteur());
            stmt.setString(5, leLivre.getEditeur());
            stmt.setString(6, leLivre.getTome());
            stmt.setString(7, leLivre.getAnnee());
            stmt.setString(8, leLivre.getSupport());
            stmt.setString(9, leLivre.getRangement());
            stmt.setString(10, leLivre.getEmpereurs());
            stmt.setString(11, leLivre.getCollection());
            stmt.setString(12, leLivre.getCategorie());

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
    public int MdlL_Supprimer(int id) {
        PreparedStatement stmt = null;
        int reponse = -1;
        try {
            stmt = conn.prepareStatement(SUPPRIMER);
            stmt.setInt(1, id);

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
