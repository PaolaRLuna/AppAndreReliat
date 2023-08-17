package edu.java.dao.controleurs.GestionInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import edu.java.dao.controleurs.controleurOutil.ControleurOutil;
import edu.java.dao.models.modelMonnaie.Monnaie;

public class Interface extends JFrame {

    // je mets un ecouteur pour chaque boutton add action listner et j'appel la
    // methose qui lui correspond

    private static ControleurOutil controleurOutil = null;
    private static ControleurLivre controleurLivre = null;
    private static ControleurMonnaie controleurMonnaie = null;

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        controleurOutil = ControleurOutil.getControleurOutil();
        controleurLivre = ControleurLivre.getControleurLivre();
        controleurMonnaie = ControleurMonnaie.getControleurMonnaie();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Interface frame = new Interface();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Interface() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 694, 441);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.WEST);
        panel.setLayout(new GridLayout(10, 1));

        JButton btnNewButton = new JButton("Lister Monnaie");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Monnaie> monnaies = controleurMonnaie.CtrM_GetAllMonnaie();
                String[][] tab = new String[monnaies.size()][];
                int index = 0;
                for (Monnaie m : monnaies) {
                    tab[index] = new String[] { m.getIdclass() + "", m.getFormat(), m.getDiametre() + "",
                            m.getEmpereur(), m.getClassement(), m.getRegne(), m.getLegende_avers(),
                            m.getLegende_revers(), m.getAcquit(), m.getLieu_date(), m.getvalNumis(), m.getRef() + "",
                            m.getEtat(), m.getMatiere() };
                    index++;
                }
                String[] enTete = { "Idclass", "Format", "Diametre", "Empereur", "Classement",
                        "Regne", "Legende_avers", "Legende_revers", "Acquit", "Lieu_date", "valNumis", "Ref", "Etat",
                        "Matiere" };
                TableLister.afficher("Collection de Monnaies", tab, enTete);

                // Appel à la fonctionnalité de la classe IActionsOutil
                //// ArrayList<Outil> outils = controleurOutil.CtrO_GetAllOutils();
                // Faites quelque chose avec la liste d'outils (par exemple, les afficher)
            }
        });

        JButton btnNewButton_1 = new JButton("New button");
        panel.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("New button");
        panel.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("New button");
        panel.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("New button");
        panel.add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("New button");
        panel.add(btnNewButton_5);

        JButton btnNewButton_6 = new JButton("New button");
        panel.add(btnNewButton_6);

        JButton btnNewButton_7 = new JButton("New button");
        panel.add(btnNewButton_7);

        JButton btnNewButton_8 = new JButton("New button");
        panel.add(btnNewButton_8);

        JButton button = new JButton("New button");
        panel.add(button);

        JLabel lblNewLabel = new JLabel("Titre Principal");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel, BorderLayout.NORTH);

        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ahgue\\OneDrive\\Bureau\\pieceor.jpg"));
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