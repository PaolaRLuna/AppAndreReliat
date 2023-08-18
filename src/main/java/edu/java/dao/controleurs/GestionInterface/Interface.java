package edu.java.dao.controleurs.GestionInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import edu.java.dao.controleurs.controleurLivre.ControleurLivre;
import edu.java.dao.controleurs.controleurMonnaie.ControleurMonnaie;
import edu.java.dao.controleurs.controleurOutil.ControleurOutil;
import edu.java.dao.models.modelLivre.Livre;
import edu.java.dao.models.modelMonnaie.Monnaie;
import edu.java.dao.models.modelOutil.Outil;

public class Interface {

    // je mets un ecouteur pour chaque boutton add action listner et j'appel la
    // methose qui lui correspond

    private static ControleurOutil controleurOutil = null;
    private static ControleurLivre controleurLivre = null;
    private static ControleurMonnaie controleurMonnaie = null;

    private JFrame frame;

    public Interface() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    initialise();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void initialise() {
        frame = new JFrame();
        controleurOutil = ControleurOutil.getControleurOutil();
        controleurLivre = ControleurLivre.getControleurLivre();
        controleurMonnaie = ControleurMonnaie.getControleurMonnaie();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 694, 441);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); //

        frame.setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.WEST);
        panel.setLayout(new GridLayout(10, 1));

        JButton listermonnaie = new JButton("Lister Monnaie");// ***********//
        listermonnaie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Monnaie> monnaies = controleurMonnaie.CtrM_GetAllMonnaie();
                String[][] tab = new String[monnaies.size()][];
                int index = 0;
                for (Monnaie m : monnaies) {
                    tab[index] = new String[] { m.getIdclass() + "", m.getFormat(),
                            m.getDiametre() + "",
                            m.getEmpereur(), m.getClassement(), m.getRegne(), m.getLegende_avers(),
                            m.getLegende_revers(), m.getAcquit(), m.getLieu_date(), m.getvalNumis(),
                            m.getRef() + "",
                            m.getEtat(), m.getMatiere() };
                    index++;
                }
                String[] enTete = { "Idclass", "Format", "Diametre", "Empereur",
                        "Classement",
                        "Regne", "Legende_avers", "Legende_revers", "Acquit", "Lieu_date",
                        "valNumis", "Ref", "Etat",
                        "Matiere" };
                TableLister.afficher("Collection de Monnaies", tab, enTete);

                // Appel à la fonctionnalité de la classe IActionsOutil
                //// ArrayList<Outil> outils = controleurOutil.CtrO_GetAllOutils();
                // Faites quelque chose avec la liste d'outils (par exemple, les afficher)
            }
        });
        panel.add(listermonnaie);

        JButton ajoutermonnaie = new JButton("Ajouter Monnaie");
        ajoutermonnaie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Monnaie> monnaies = controleurMonnaie.CtrM_Enregistrer(ajoutermonnaie);
                String[][] tab = new String[monnaies.size()][];
                int index = 0;
                for (Monnaie m : monnaies) {
                    tab[index] = new String[] { m.getIdclass() + "", m.getFormat(),
                            m.getDiametre() + "",
                            m.getEmpereur(), m.getClassement(), m.getRegne(), m.getLegende_avers(),
                            m.getLegende_revers(), m.getAcquit(), m.getLieu_date(), m.getvalNumis(),
                            m.getRef() + "",
                            m.getEtat(), m.getMatiere() };
                    index++;
                }
                String[] enTete = { "Idclass", "Format", "Diametre", "Empereur",
                        "Classement",
                        "Regne", "Legende_avers", "Legende_revers", "Acquit", "Lieu_date",
                        "valNumis", "Ref", "Etat",
                        "Matiere" };
                TableAjouter.afficher("Collection de Monnaies", enTete);

                // Appel à la fonctionnalité de la classe IActionsOutil
                //// ArrayList<Outil> outils = controleurOutil.CtrO_GetAllOutils();
                // Faites quelque chose avec la liste d'outils (par exemple, les afficher)
            }
        });
        panel.add(ajoutermonnaie);

        JButton btnNewButton_2 = new JButton("Supprimer Monnaie");
        panel.add(btnNewButton_2);

        JButton listerlivre = new JButton("Lister Livre");
        listerlivre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Livre> livres = controleurLivre.CtrL_GetAllLivres();
                String[][] tab = new String[livres.size()][];
                int index = 0;
                for (Livre l : livres) {
                    tab[index] = new String[] { l.getIdl() + "", l.getNum() + "",
                            l.getTitre(),
                            l.getSousTitre(), l.getAuteur(), l.getEditeur(), l.getTome(),
                            l.getAnnee(), l.getSupport(), l.getRangement(), l.getEmpereurs(),
                            l.getCollection(), l.getCategorie() };
                    index++;
                }
                String[] enTete = { "idl", "num", "titre", "sousTitre",
                        "auteur", "editeur", "tome", "annee", "support",
                        "rangement", "empereurs", "collection", "categorie" };
                TableLister.afficher("Collection de Livres", tab, enTete);

                // Appel à la fonctionnalité de la classe IActionsOutil
                //// ArrayList<Outil> outils = controleurOutil.CtrO_GetAllOutils();
                // Faites quelque chose avec la liste d'outils (par exemple, les afficher)
            }
        });
        panel.add(listerlivre);

        JButton modifierlivre = new JButton("Ajouter Livre");
        panel.add(modifierlivre);

        JButton btnNewButton_5 = new JButton("Supprimer Livre");
        panel.add(btnNewButton_5);

        JButton listeroutil = new JButton("Lister Outil");
        listeroutil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Outil> outils = controleurOutil.CtrO_GetAllOutils();
                String[][] tab = new String[outils.size()][];
                int index = 0;
                for (Outil o : outils) {
                    tab[index] = new String[] { o.getIdref() + "", o.getAppellation(),
                            o.getQualification_forme(), o.getForme_typ(), o.getForme_atyp(), o.getObs_aspect(),
                            o.getEtat_conserv(), o.getRo_naturel(), o.getRo_amenage(), o.getHauteur_reelemm(),
                            o.getHauteur_supposemm(), o.getLargeur_mm(), o.getEpaisseur_mm(), o.getMasse_gr(),
                            o.getMatiere(),
                            o.getCouleur_int(), o.getIntensite_pat(), o.getRef_couleur_pat(), o.getCouleur_patref_ral(),
                            o.getRetouche_sigmoidales(), o.getRetouches_cote_fine(), o.getDate_decouverte() + "",
                            o.getInfo_secondaire(), o.getZone_ramassage(), o.getRemarquable(),
                            o.getNum_reference() + "" };
                    index++;
                }
                String[] enTete = { "idref", "appellation", "qualification_forme",
                        "forme_typ", "forme_atyp",
                        "obs_aspect", "etat_conserv", "ro_naturel", "ro_amenage", "hauteur_reelemm",
                        "hauteur_supposemm",
                        "largeur_mm", "epaisseur_mm", "masse_gr", "matiere", "couleur_int",
                        "intensite_pat",
                        "ref_couleur_pat",
                        "couleur_patref_ral", "retouche_sigmoidales", "retouches_cote_fine",
                        "date_decouverte",
                        "info_secondaire", "zone_ramassage", "remarquable", "num_reference" };
                TableLister.afficher("Collection de Livres", tab, enTete);
            }
        });
        panel.add(listeroutil);

        JButton btnNewButton_7 = new JButton("Ajouter Outil");
        panel.add(btnNewButton_7);

        JButton btnNewButton_8 = new JButton("Supprimer Outil");
        panel.add(btnNewButton_8);

        JButton button = new JButton("Quitter");
        panel.add(button);

        JLabel lblNewLabel = new JLabel("Collection d'objets prehistoriques");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel, BorderLayout.NORTH);

        JLabel image = new JLabel("");
        image.setIcon(new ImageIcon(
                "C:\\Users\\ahgue\\OneDrive\\Documents\\GitHub\\Projet_Appli_bureau\\src\\main\\java\\edu\\java\\dao\\controleurs\\GestionInterface\\pieceor.jpg"));
        contentPane.add(image, BorderLayout.CENTER);

        JLabel lblNewLabel_2 = new JLabel("Choisir Votre Choix");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel_2, BorderLayout.SOUTH);
    }

    private void setDefaultCloseOperation(int exitOnClose) {
    }

}

// faire appels a toutes les metodes deja mis em place
// consulter la base de donnee pour bien l'exploiter avec des boutons ajout ,
// modifier et supprimer en se basant sur id
// ajouter un champ pour rechercher dans celle d apres