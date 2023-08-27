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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import edu.java.dao.controleurs.controleurLivre.ControleurLivre;

public class TableChercherLivre {

	private JPanel contentPane;
	private JTextField text_idl;
	private JFrame frame;
	private ControleurLivre controleurLivre;
	private JTextField text_titre;
	private JTextField text_auteur;

	/**
	 * Launch the application.
	 */
	public TableChercherLivre(ControleurLivre controleurLivre) {
		this.controleurLivre = controleurLivre;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					creerFenetre();
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
	public void creerFenetre() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 1152, 801);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(panel);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		panel.setLayout(null);

		panel.setPreferredSize(new Dimension(800, 800));

		JLabel idl = new JLabel("idl");
		idl.setBounds(343, 282, 58, 21);
		idl.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(idl);

		text_idl = new JTextField();
		text_idl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_idl.setBounds(308, 313, 132, 38);
		panel.add(text_idl);
		text_idl.setColumns(10);

		JButton btnNewButton_Chercher = new JButton("Chercher");
		btnNewButton_Chercher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_Chercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idClass = Integer.parseInt(text_idl.getText());
				String auteur = text_auteur.getText();
				String titre = text_titre.getText();
				controleurLivre.CtrL_GetLivreById(idClass);
				controleurLivre.CtrL_GetLivreByAuteur(auteur);
				controleurLivre.CtrL_GetLivreByTitre(titre);
			}
		});
		btnNewButton_Chercher.setBounds(496, 385, 124, 38);
		panel.add(btnNewButton_Chercher);

		JButton btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRetour.setBounds(673, 503, 100, 38);
		panel.add(btnRetour);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		JButton btnVider = new JButton("Vider");
		btnVider.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVider.setBounds(361, 503, 100, 38);
		btnVider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_idl.setText("");
				text_auteur.setText("");
				text_titre.setText("");
			}
		});
		panel.add(btnVider);

		JLabel titre = new JLabel("titre");
		titre.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.setBounds(523, 282, 58, 21);
		panel.add(titre);

		text_titre = new JTextField();
		text_titre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_titre.setColumns(10);
		text_titre.setBounds(488, 313, 132, 38);
		panel.add(text_titre);

		JLabel auteur = new JLabel("auteur");
		auteur.setFont(new Font("Tahoma", Font.BOLD, 18));
		auteur.setBounds(704, 282, 80, 21);
		panel.add(auteur);

		text_auteur = new JTextField();
		text_auteur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_auteur.setColumns(10);
		text_auteur.setBounds(669, 313, 132, 38);
		panel.add(text_auteur);

		JLabel lblNewLabel = new JLabel("Chercher Livre");
		lblNewLabel.setForeground(new Color(255, 204, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(457, 128, 238, 21);
		panel.add(lblNewLabel);

	}
}
