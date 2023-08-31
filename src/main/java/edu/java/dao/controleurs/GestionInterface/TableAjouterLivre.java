package edu.java.dao.controleurs.GestionInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import edu.java.dao.controleurs.controleurLivre.ControleurLivre;
import edu.java.dao.models.modelLivre.Livre;

public class TableAjouterLivre {

	private JPanel contentPane;
	private JTextField text_tome;
	private JFrame frame;
	private ControleurLivre controleurLivre;
	private JTextField text_idl;
	private JTextField text_num;
	private JTextField text_titre;
	private JTextField text_sousTitre;
	private JTextField text_auteur;
	private JTextField text_editeur;
	private JTextField text_annee;
	private JTextField text_support;
	private JTextField text_rangement;
	private JTextField text_empereurs;
	private JTextField text_collection;
	private JTextField text_categorie;

	/**
	 * Launch the application.
	 */
	public TableAjouterLivre(ControleurLivre controleurLivre) {
		this.controleurLivre = controleurLivre;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialiser();
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
	public void initialiser() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 1317, 828);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel titre = new JPanel();
		JScrollPane scrollPane = new JScrollPane(titre);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		titre.setLayout(null);

		titre.setPreferredSize(new Dimension(800, 800));

		JLabel idl = new JLabel("idl");
		idl.setBounds(345, 198, 39, 21);
		idl.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(idl);

		JButton btnVider = new JButton("Vider");
		btnVider.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnVider.setBounds(744, 553, 100, 37);
		btnVider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_idl.setText("");
				text_num.setText("");
				text_titre.setText("");
				text_sousTitre.setText("");
				text_auteur.setText("");
				text_editeur.setText("");
				text_tome.setText("");
				text_annee.setText("");
				text_support.setText("");
				text_rangement.setText("");
				text_empereurs.setText("");
				text_collection.setText("");
				text_categorie.setText("");

			}
		});
		titre.add(btnVider);

		JButton btnNewButton_Ajouter = new JButton("Ajouter");
		btnNewButton_Ajouter.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_Ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idl = Integer.parseInt(text_idl.getText());
				int num = Integer.parseInt(text_num.getText());
				String titre = text_titre.getText();
				String sousTitre = text_sousTitre.getText();
				String auteur = text_auteur.getText();
				String editeur = text_editeur.getText();
				String tome = text_tome.getText();
				String annee = text_annee.getText();
				String support = text_support.getText();
				String rangement = text_rangement.getText();
				String empereurs = text_empereurs.getText();
				String collection = text_collection.getText();
				String categorie = text_categorie.getText();
				Livre l = new Livre(idl, num, titre, sousTitre, auteur, editeur,
						tome, annee, support, rangement, empereurs, collection, categorie);
				String reponse = controleurLivre.CtrL_Enregistrer(l);
				if (reponse != null) {
					JOptionPane.showMessageDialog(null, "Livre ajoutée");
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Livre existe dèjà");
					text_idl.setText("");
					text_num.setText("");
					text_titre.setText("");
					text_sousTitre.setText("");
					text_auteur.setText("");
					text_editeur.setText("");
					text_tome.setText("");
					text_annee.setText("");
					text_support.setText("");
					text_rangement.setText("");
					text_empereurs.setText("");
					text_collection.setText("");
					text_categorie.setText("");
				}
			}
		});
		btnNewButton_Ajouter.setBounds(545, 553, 105, 37);
		titre.add(btnNewButton_Ajouter);

		JLabel num = new JLabel("num");
		num.setBounds(640, 198, 58, 21);
		num.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(num);

		JLabel lbltitre = new JLabel("titre");
		lbltitre.setBounds(922, 198, 58, 21);
		lbltitre.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(lbltitre);

		JLabel sousTitre = new JLabel("sousTitre");
		sousTitre.setBounds(318, 261, 100, 21);
		sousTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(sousTitre);

		JLabel auteur = new JLabel("auteur");
		auteur.setBounds(628, 261, 76, 21);
		auteur.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(auteur);

		JLabel editeur = new JLabel("editeur");
		editeur.setBounds(922, 261, 100, 21);
		editeur.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(editeur);

		JLabel tome = new JLabel("tome");
		tome.setBounds(325, 317, 93, 36);
		tome.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(tome);

		JLabel annee = new JLabel("annee");
		annee.setBounds(628, 325, 100, 21);
		annee.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(annee);

		JLabel support = new JLabel("support");
		support.setBounds(922, 325, 95, 21);
		support.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(support);

		JLabel rangement = new JLabel("rangement");
		rangement.setBounds(311, 390, 107, 36);
		rangement.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(rangement);

		JLabel empereurs = new JLabel("empereurs");
		empereurs.setBounds(602, 398, 114, 21);
		empereurs.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(empereurs);

		JLabel collection = new JLabel("collection");
		collection.setBounds(920, 398, 102, 21);
		collection.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(collection);

		JLabel categorie = new JLabel("categorie");
		categorie.setBounds(569, 481, 120, 21);
		categorie.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(categorie);

		text_tome = new JTextField();
		text_tome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_tome.setColumns(10);
		text_tome.setBounds(416, 317, 174, 36);
		titre.add(text_tome);

		JButton btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRetour.setBounds(943, 553, 100, 36);
		titre.add(btnRetour);

		text_idl = new JTextField();
		text_idl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_idl.setColumns(10);
		text_idl.setBounds(416, 183, 174, 36);
		titre.add(text_idl);

		text_num = new JTextField();
		text_num.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_num.setColumns(10);
		text_num.setBounds(696, 183, 174, 36);
		titre.add(text_num);

		text_titre = new JTextField();
		text_titre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_titre.setColumns(10);
		text_titre.setBounds(1033, 183, 174, 36);
		titre.add(text_titre);

		text_sousTitre = new JTextField();
		text_sousTitre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_sousTitre.setColumns(10);
		text_sousTitre.setBounds(416, 246, 174, 36);
		titre.add(text_sousTitre);

		text_auteur = new JTextField();
		text_auteur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_auteur.setColumns(10);
		text_auteur.setBounds(696, 246, 174, 36);
		titre.add(text_auteur);

		text_editeur = new JTextField();
		text_editeur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_editeur.setColumns(10);
		text_editeur.setBounds(1032, 246, 174, 36);
		titre.add(text_editeur);

		text_annee = new JTextField();
		text_annee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_annee.setColumns(10);
		text_annee.setBounds(696, 317, 174, 36);
		titre.add(text_annee);

		text_support = new JTextField();
		text_support.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_support.setColumns(10);
		text_support.setBounds(1033, 317, 174, 36);
		titre.add(text_support);

		text_rangement = new JTextField();
		text_rangement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_rangement.setColumns(10);
		text_rangement.setBounds(416, 390, 174, 36);
		titre.add(text_rangement);

		text_empereurs = new JTextField();
		text_empereurs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_empereurs.setColumns(10);
		text_empereurs.setBounds(707, 390, 174, 36);
		titre.add(text_empereurs);

		text_collection = new JTextField();
		text_collection.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_collection.setColumns(10);
		text_collection.setBounds(1033, 390, 174, 36);
		titre.add(text_collection);

		text_categorie = new JTextField();
		text_categorie.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_categorie.setColumns(10);
		text_categorie.setBounds(707, 473, 174, 36);
		titre.add(text_categorie);

		JLabel lblNewLabel = new JLabel("Ajouter un Livre");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 204, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(602, 49, 257, 55);
		titre.add(lblNewLabel);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

	}
}
