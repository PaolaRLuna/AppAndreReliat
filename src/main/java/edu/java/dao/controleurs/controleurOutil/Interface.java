package edu.java.dao.controleurs.controleurOutil;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Interface extends JFrame {

    //// private ControleurOutil controleurOutil;

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
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
        setBounds(100, 100, 695, 500);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnOptions = new JMenu("Options");
        menuBar.add(mnOptions);

        JMenuItem mntmExit = new JMenuItem("Exit");
        mnOptions.add(mntmExit);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        //// controleurOutil = ControleurOutil.getControleurOutil(); // Initialisez le
        //// contrôleur

        JButton btnNewButton = new JButton("Outil");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(23, 243, 131, 21);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("monnais ");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Appel à la fonctionnalité de la classe IActionsOutil
                //// ArrayList<Outil> outils = controleurOutil.CtrO_GetAllOutils();
                // Faites quelque chose avec la liste d'outils (par exemple, les afficher)
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_1.setBounds(522, 225, 131, 21);
        contentPane.add(btnNewButton_1);

        JButton btnChercher = new JButton("Bibliothèque");
        btnChercher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Appel à la fonctionnalité de la classe IActionsOutil
                //// Outil outil = controleurOutil.CtrO_GetOutilByTitre("Titre de l'outil");
                // Faites quelque chose avec l'outil (par exemple, l'afficher)
            }
        });
        btnChercher.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnChercher.setBounds(262, 382, 145, 21);
        contentPane.add(btnChercher);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(
                "C:\\Users\\ahgue\\OneDrive\\Documents\\GitHub\\Projet_Appli_bureau\\src\\main\\java\\edu\\java\\dao\\controleurs\\controleurOutil\\pieceor.jpg"));
        lblNewLabel_1.setBounds(-22, 0, 693, 441);
        contentPane.add(lblNewLabel_1);

    }
}

// faire appels a toutes les metodes deja mis em place
// consulter la base de donnee pour bien l'exploiter avec des boutons ajout ,
// modifier et supprimer en se basant sur id
// ajouter un champ pour rechercher dans celle d apres