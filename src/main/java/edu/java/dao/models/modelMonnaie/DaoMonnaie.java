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
    private static final String URL_BD = "jdbc:mysql://localhost/mabdcollection";
    private static final String USAGER = "root";
    private static final String PASS = "";
    // on cree les requetes
    private static final String SUPPRIMER = "DELETE FROM monnaie WHERE id_class=?";
    private static final String GET_ALL = "SELECT * FROM monnaie ORDER BY id_class";
    private static final String GET_BY_ID = "SELECT * FROM monnaie WHERE id_class=?";
    private static final String GET_BY_MATIERE = "SELECT * FROM monnaie WHERE matiere=?";
    private static final String GET_BY_EMPEREUR = "SELECT * FROM monnaie WHERE empereur=?";
    private static final String ENREGISTRER = "INSERT INTO monnaie VALUES(?,?, ?, ?, ?,?,?,?,?,?,?,?,?)";
    private static final String MODIFIER = "UPDATE monnaie SET id_class=?, format=?, diametre=?, empereur=?, classement=?, "
            + "regne=?, leg_avers=?, leg_revers=?, ref=?, matiere=?,  etat=?, acquit=?, lieu_date=?, valnumis=? WHERE id_class=?";

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
    public String MdlM_Enregistrer(Monnaie piece) {
        PreparedStatement stmt = null;
        try { // requete est dans enregistrer, pour obtenir la clé qui a été generé on utilise
              // return_generated keys
            stmt = conn.prepareStatement(ENREGISTRER, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, piece.getIdclass());
            stmt.setString(2, piece.getFormat());
            stmt.setInt(3, piece.getDiametre());
            stmt.setString(4, piece.getEmpereur());
            stmt.setString(5, piece.getClassement());
            stmt.setString(6, piece.getRegne());
            stmt.setString(7, piece.getLegende_avers());
            stmt.setString(8, piece.getLegende_revers());
            stmt.setInt(9, piece.getRef());
            stmt.setString(9, piece.getMatiere());
            stmt.setString(10, piece.getEtat());
            stmt.setString(11, piece.getAcquit());
            stmt.setString(12, piece.getLieu_date());
            stmt.setString(13, piece.getvalNumis());

            stmt.executeUpdate(); // il execute la requete
            ResultSet rs = stmt.getGeneratedKeys(); //

            if (rs.next()) {
                piece.setIdclass(rs.getInt(1)); // int est dans la premier colonne qui contient la clé, on veut la
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
    public ArrayList<Monnaie> MdlM_GetAll() {
        PreparedStatement stmt = null;
        List<Monnaie> listeMonnaies = new ArrayList<Monnaie>();

        try {
            stmt = conn.prepareStatement(GET_ALL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) { // on obtient la liste de tous les Monnaies et on va ligne par ligne
                Monnaie piece = new Monnaie();
                piece.setIdclass(rs.getInt("idclass"));
                piece.setFormat(rs.getString("format"));
                piece.setDiametre(rs.getInt("diametre"));
                piece.setEmpereur(rs.getString("empereur"));
                piece.setClassement(rs.getString("classement"));
                piece.setRegne(rs.getString("regne"));
                piece.setLegende_avers(rs.getString("leg_averse"));
                piece.setLegende_revers(rs.getString("leg_revers"));
                piece.setRef(rs.getInt("ref"));
                piece.setMatiere(rs.getString("matiere"));
                piece.setEtat(rs.getString("etat"));
                piece.setAcquit(rs.getString("acquit"));
                piece.setLieu_date(rs.getString("lieu_date"));
                piece.setvalNumis(rs.getString("valnumis"));

                listeMonnaies.add(piece);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
            // throw new RuntimeException(e);
        } finally {
            MdlO_Fermer(stmt);
            MdlO_Fermer(conn);
        }

        return (ArrayList<Monnaie>) listeMonnaies;
    }

    public Monnaie MdlM_GetById(int idref) {
        PreparedStatement stmt = null;

        try {

            stmt = conn.prepareStatement(GET_BY_ID);
            stmt.setInt(1, idref);

            ResultSet rs = stmt.executeQuery();
            Monnaie piece = new Monnaie();
            if (rs.next()) {

                piece.setIdclass(rs.getInt("idclass"));
                piece.setFormat(rs.getString("format"));
                piece.setDiametre(rs.getInt("diametre"));
                piece.setEmpereur(rs.getString("empereur"));
                piece.setClassement(rs.getString("classement"));
                piece.setRegne(rs.getString("regne"));
                piece.setLegende_avers(rs.getString("leg_averse"));
                piece.setLegende_revers(rs.getString("leg_revers"));
                piece.setRef(rs.getInt("ref"));
                piece.setMatiere(rs.getString("matiere"));
                piece.setEtat(rs.getString("etat"));
                piece.setAcquit(rs.getString("acquit"));
                piece.setLieu_date(rs.getString("lieu_date"));
                piece.setvalNumis(rs.getString("valnumis"));

                return piece;
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
    public Monnaie MdlM_GetByMatiere(String nom_matiere) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(GET_BY_MATIERE);
            stmt.setString(1, nom_matiere);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Monnaie piece = new Monnaie();
                piece.setIdclass(rs.getInt("idclass"));
                piece.setFormat(rs.getString("format"));
                piece.setDiametre(rs.getInt("diametre"));
                piece.setEmpereur(rs.getString("empereur"));
                piece.setClassement(rs.getString("classement"));
                piece.setRegne(rs.getString("regne"));
                piece.setLegende_avers(rs.getString("leg_averse"));
                piece.setLegende_revers(rs.getString("leg_revers"));
                piece.setRef(rs.getInt("ref"));
                piece.setMatiere(rs.getString("matiere"));
                piece.setEtat(rs.getString("etat"));
                piece.setAcquit(rs.getString("acquit"));
                piece.setLieu_date(rs.getString("lieu_date"));
                piece.setvalNumis(rs.getString("valnumis"));

                return piece;
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
    public Monnaie MdlM_GetByEmpereur(String zone) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(GET_BY_EMPEREUR);
            stmt.setString(1, zone);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Monnaie piece = new Monnaie();
                piece.setIdclass(rs.getInt("idclass"));
                piece.setFormat(rs.getString("format"));
                piece.setDiametre(rs.getInt("diametre"));
                piece.setEmpereur(rs.getString("empereur"));
                piece.setClassement(rs.getString("classement"));
                piece.setRegne(rs.getString("regne"));
                piece.setLegende_avers(rs.getString("leg_averse"));
                piece.setLegende_revers(rs.getString("leg_revers"));
                piece.setRef(rs.getInt("ref"));
                piece.setMatiere(rs.getString("matiere"));
                piece.setEtat(rs.getString("etat"));
                piece.setAcquit(rs.getString("acquit"));
                piece.setLieu_date(rs.getString("lieu_date"));
                piece.setvalNumis(rs.getString("valnumis"));

                return piece;
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
    public int MdlM_Modifier(Monnaie piece) {
        PreparedStatement stmt = null;
        int reponse = -1;
        try {
            stmt = conn.prepareStatement(MODIFIER); // on appele la requete modifier
            stmt.setInt(1, piece.getIdclass());
            stmt.setString(2, piece.getFormat());
            stmt.setInt(3, piece.getDiametre());
            stmt.setString(4, piece.getEmpereur());
            stmt.setString(5, piece.getClassement());
            stmt.setString(6, piece.getRegne());
            stmt.setString(7, piece.getLegende_avers());
            stmt.setString(8, piece.getLegende_revers());
            stmt.setInt(9, piece.getRef());
            stmt.setString(10, piece.getMatiere());
            stmt.setString(11, piece.getEtat());
            stmt.setString(12, piece.getAcquit());
            stmt.setString(13, piece.getLieu_date());
            stmt.setString(14, piece.getvalNumis());

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
    public int MdlM_Supprimer(int idref) {
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
