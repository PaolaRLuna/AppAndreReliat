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
import javax.swing.border.EmptyBorder;

import edu.java.dao.controleurs.controleurMonnaie.ControleurMonnaie;
import edu.java.dao.models.modelMonnaie.Monnaie;

public class TableAjouterMonnaie {

	private JPanel contentPane;
	private JTextField texte_Idclass;
	private JTextField text_Format;
	private JTextField text_Diametre;
	private JTextField text_Empereur;
	private JTextField text_Classement;
	private JTextField textRegne;
	private JTextField textLegende_avers;
	private JTextField textLegende_revers;
	private JTextField textAcquit;
	private JTextField textLieu_date;
	private JTextField textvalNumis;
	private JTextField textRef;
	private JTextField textEtat;
	private JTextField textMatiere;
	private JFrame frame;
	private ControleurMonnaie controleurMonnaie;

	/**
	 * Launch the application.
	 */
	public TableAjouterMonnaie(ControleurMonnaie controleurMonnaie) {
		this.controleurMonnaie = controleurMonnaie;
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
		frame.setBounds(100, 100, 1318, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(panel);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		panel.setLayout(null);

		panel.setPreferredSize(new Dimension(800, 800));

		JLabel lblIdclass = new JLabel("Idclass");
		lblIdclass.setBounds(156, 114, 68, 21);
		lblIdclass.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblIdclass);

		JButton btnVider = new JButton("Vider");
		btnVider.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnVider.setBounds(570, 501, 100, 28);
		btnVider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				texte_Idclass.setText("");
				text_Format.setText("");
				text_Diametre.setText("");
				text_Empereur.setText("");
				text_Classement.setText("");
				textRegne.setText("");
				textLegende_avers.setText("");
				textLegende_revers.setText("");
				textAcquit.setText("");
				textLieu_date.setText("");
				textvalNumis.setText("");
				textRef.setText("");
				textEtat.setText("");
				textMatiere.setText("");
			}
		});
		panel.add(btnVider);

		texte_Idclass = new JTextField();
		texte_Idclass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		texte_Idclass.setBounds(262, 110, 147, 28);
		panel.add(texte_Idclass);
		texte_Idclass.setColumns(10);

		JButton btnNewButton_Ajouter = new JButton("Ajouter");
		btnNewButton_Ajouter.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_Ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idClass = Integer.parseInt(texte_Idclass.getText());
				String format = text_Format.getText();
				int diametre = Integer.parseInt(text_Diametre.getText());
				String empereur = text_Empereur.getText();
				String classement = text_Classement.getText();
				String regne = textRegne.getText();
				String legende_avers = textLegende_avers.getText();
				String legende_revers = textLegende_revers.getText();
				String acquit = textAcquit.getText();
				String lieu_date = textLieu_date.getText();
				String valvumis = textvalNumis.getText();
				String ref = textRef.getText();
				String etat = textEtat.getText();
				String matiere = textMatiere.getText();
				Monnaie m = new Monnaie(idClass, format, diametre, empereur, classement,
						regne, legende_avers, legende_revers, ref, matiere, etat,
						acquit, lieu_date, valvumis);
				String reponse = controleurMonnaie.CtrM_Enregistrer(m);
				if (reponse != null) {
					JOptionPane.showMessageDialog(null, "Livre ajoutée");
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Livre existe dèjà");
					texte_Idclass.setText("");
					text_Format.setText("");
					text_Diametre.setText("");
					text_Empereur.setText("");
					text_Classement.setText("");
					textRegne.setText("");
					textLegende_avers.setText("");
					textLegende_revers.setText("");
					textAcquit.setText("");
					textLieu_date.setText("");
					textvalNumis.setText("");
					textRef.setText("");
					textEtat.setText("");
					textMatiere.setText("");
				}
			}
		});
		btnNewButton_Ajouter.setBounds(345, 501, 108, 28);
		panel.add(btnNewButton_Ajouter);

		text_Format = new JTextField();
		text_Format.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_Format.setBounds(570, 110, 196, 27);
		text_Format.setColumns(10);
		panel.add(text_Format);

		text_Diametre = new JTextField();
		text_Diametre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_Diametre.setBounds(892, 110, 223, 28);
		text_Diametre.setColumns(10);
		panel.add(text_Diametre);

		JLabel lblFormat = new JLabel("Format");
		lblFormat.setBounds(456, 114, 100, 21);
		lblFormat.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblFormat);

		JLabel lblDiametre = new JLabel("Diametre");
		lblDiametre.setBounds(794, 114, 100, 21);
		lblDiametre.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblDiametre);

		JLabel lbEmpereur = new JLabel("Empereur");
		lbEmpereur.setBounds(144, 189, 117, 21);
		lbEmpereur.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lbEmpereur);

		JLabel Classement = new JLabel("Classement");
		Classement.setBounds(444, 185, 126, 29);
		Classement.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(Classement);

		JLabel lblNewLabel_3 = new JLabel("Regne");
		lblNewLabel_3.setBounds(792, 189, 90, 21);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel_3);

		text_Empereur = new JTextField();
		text_Empereur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_Empereur.setBounds(262, 185, 147, 29);
		text_Empereur.setColumns(10);
		panel.add(text_Empereur);

		text_Classement = new JTextField();
		text_Classement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_Classement.setBounds(570, 185, 196, 27);
		text_Classement.setColumns(10);
		panel.add(text_Classement);

		textRegne = new JTextField();
		textRegne.setBounds(892, 189, 229, 28);
		textRegne.setColumns(10);
		panel.add(textRegne);

		JLabel lblLegende_avers = new JLabel("Legende_avers");
		lblLegende_avers.setBounds(119, 259, 151, 21);
		lblLegende_avers.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblLegende_avers);

		JLabel lblLegende_revers = new JLabel("Legende_revers");
		lblLegende_revers.setBounds(419, 259, 151, 21);
		lblLegende_revers.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblLegende_revers);

		JLabel lblAcquit = new JLabel("Acquit");
		lblAcquit.setBounds(794, 259, 75, 21);
		lblAcquit.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblAcquit);

		JLabel lblLieu_date = new JLabel("Lieu_date");
		lblLieu_date.setBounds(119, 338, 100, 21);
		lblLieu_date.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblLieu_date);

		JLabel lblvalNumis = new JLabel("valNumis");
		lblvalNumis.setBounds(419, 338, 93, 21);
		lblvalNumis.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblvalNumis);

		JLabel lblRef = new JLabel("Ref");
		lblRef.setBounds(794, 344, 58, 21);
		lblRef.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblRef);

		JLabel lblEtat = new JLabel("Etat");
		lblEtat.setBounds(144, 417, 58, 21);
		lblEtat.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblEtat);

		JLabel lblMatiere = new JLabel("Matiere");
		lblMatiere.setBounds(423, 417, 101, 21);
		lblMatiere.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblMatiere);

		textLegende_avers = new JTextField();
		textLegende_avers.setColumns(10);
		textLegende_avers.setBounds(262, 259, 151, 27);
		panel.add(textLegende_avers);

		textLegende_revers = new JTextField();
		textLegende_revers.setColumns(10);
		textLegende_revers.setBounds(570, 259, 196, 27);
		panel.add(textLegende_revers);

		textAcquit = new JTextField();
		textAcquit.setColumns(10);
		textAcquit.setBounds(892, 259, 229, 28);
		panel.add(textAcquit);

		textLieu_date = new JTextField();
		textLieu_date.setColumns(10);
		textLieu_date.setBounds(262, 339, 147, 26);
		panel.add(textLieu_date);

		JButton btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRetour.setBounds(768, 501, 100, 28);
		panel.add(btnRetour);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		textvalNumis = new JTextField();
		textvalNumis.setColumns(10);
		textvalNumis.setBounds(570, 338, 196, 28);
		panel.add(textvalNumis);

		textRef = new JTextField();
		textRef.setColumns(10);
		textRef.setBounds(892, 338, 229, 28);
		panel.add(textRef);

		textEtat = new JTextField();
		textEtat.setColumns(10);
		textEtat.setBounds(262, 417, 147, 28);
		panel.add(textEtat);

		textMatiere = new JTextField();
		textMatiere.setColumns(10);
		textMatiere.setBounds(570, 417, 196, 28);
		panel.add(textMatiere);

		JLabel lblNewLabel = new JLabel("Ajouter Monnaie ");
		lblNewLabel.setForeground(new Color(255, 204, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(477, 28, 289, 28);
		panel.add(lblNewLabel);

	}
}
