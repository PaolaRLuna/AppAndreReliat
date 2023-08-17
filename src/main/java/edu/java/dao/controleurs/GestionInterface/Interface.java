package edu.java.dao.controleurs.GestionInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import edu.java.dao.controleurs.controleurLivre.ControleurLivre;
import edu.java.dao.controleurs.controleurMonnaie.ControleurMonnaie;
import edu.java.dao.models.modelLivre.Livre;
import edu.java.dao.models.modelMonnaie.Monnaie;

public class Interface {

    // je mets un ecouteur pour chaque boutton add action listner et j'appel la
    // methose qui lui correspond

    // private static ControleurOutil controleurOutil = null;
    private static ControleurLivre controleurLivre = null;
    private static ControleurMonnaie controleurMonnaie = null;

    private JPanel contentPane;
    JFrame frame;

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
        // controleurOutil = ControleurOutil.getControleurOutil();
        controleurLivre = ControleurLivre.getControleurLivre();
        controleurMonnaie = ControleurMonnaie.getControleurMonnaie();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 694, 441);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        frame.setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.WEST);
        panel.setLayout(new GridLayout(10, 1));

        JButton listermonnaie = new JButton("Lister Monnaie");
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

        JButton btnNewButton_1 = new JButton("Modifier Monnaie");
        panel.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Supprimer Monnaie");
        panel.add(btnNewButton_2);

        JButton listerlivre = new JButton("Lister Livre");
        listerlivre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Livre> livres = controleurLivre.CtrO_GetAllLivres();
                String[][] tab = new String[livres.size()][];
                int index = 0;
                for (Livre l : livres) {
                    tab[index] = new String[] { l.getIdref() + "", l.getAppellation(),
                            l.getQualification_forme(),
                            l.getForme_typ(), l.getForme_atyp(), l.getObs_aspect(), l.getEtat_conserv(),
                            l.getRo_naturel(), l.getRo_amenage(), l.getHauteur_reelemm(),
                            l.getHauteur_supposemm(),
                            l.getLargeur_mm(), l.getEpaisseur_mm(), l.getMasse_gr(), l.getMatiere(),
                            l.getCouleur_int(),
                            l.getIntensite_pat(), l.getRef_couleur_pat(), l.getCouleur_patref_ral(),
                            l.getRetouche_sigmoidales(),
                            l.getRetouches_cote_fine(), l.getDate_decouverte() + "",
                            l.getInfo_secondaire(),
                            l.getZone_ramassage(),
                            l.getRemarquable(), l.getNum_reference() + "" };
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

                // Appel à la fonctionnalité de la classe IActionsOutil
                //// ArrayList<Outil> outils = controleurOutil.CtrO_GetAllOutils();
                // Faites quelque chose avec la liste d'outils (par exemple, les afficher)
            }
        });
        panel.add(listerlivre);

        JButton btnNewButton_4 = new JButton("Modifier Livre");
        panel.add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("Supprimer Livre");
        panel.add(btnNewButton_5);

        JButton btnNewButton_6 = new JButton("Lister Outil");
        panel.add(btnNewButton_6);

        JButton btnNewButton_7 = new JButton("Modifier Outil");
        panel.add(btnNewButton_7);

        JButton btnNewButton_8 = new JButton("Supprimer Outil");
        panel.add(btnNewButton_8);

        JButton button = new JButton("Quitter");
        panel.add(button);

        JLabel lblNewLabel = new JLabel("Collection d'objets prehistoriques");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel, BorderLayout.NORTH);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(
                "C:\\Users\\ahgue\\OneDrive\\Documents\\GitHub\\Projet_Appli_bureau\\src\\main\\java\\edu\\java\\dao\\controleurs\\GestionInterface\\pieceor.jpg"));
        contentPane.add(lblNewLabel_1, BorderLayout.CENTER);

        JLabel lblNewLabel_2 = new JLabel("Choisir Votre Choix");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel_2, BorderLayout.SOUTH);
    }

}

// faire appels a toutes les metodes deja mis em place
// consulter la base de donnee pour bien l'exploiter avec des boutons ajout ,
// modifier et supprimer en se basant sur id
// ajouter un champ pour rechercher dans celle d apres