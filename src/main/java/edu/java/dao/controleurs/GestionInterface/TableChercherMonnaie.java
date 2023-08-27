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

import edu.java.dao.controleurs.controleurMonnaie.ControleurMonnaie;

public class TableChercherMonnaie {

	private JPanel contentPane;
	private JTextField text_idClass;
	private JFrame frame;
	private ControleurMonnaie controleurMonnaie;
	private JTextField text_matiere;
	private JTextField text_empereur;

	/**
	 * Launch the application.
	 */
	public TableChercherMonnaie(ControleurMonnaie controleurMonnaie) {
		this.controleurMonnaie = controleurMonnaie;
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

		JLabel idClass = new JLabel("idClass");
		idClass.setBounds(321, 282, 80, 21);
		idClass.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(idClass);

		text_idClass = new JTextField();
		text_idClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_idClass.setBounds(308, 313, 132, 38);
		panel.add(text_idClass);
		text_idClass.setColumns(10);

		JButton btnNewButton_Chercher = new JButton("Chercher");
		btnNewButton_Chercher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_Chercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idClass = Integer.parseInt(text_idClass.getText());
				String empereur = text_empereur.getText();
				String matiere = text_matiere.getText();
				controleurMonnaie.CtrM_GetMonnaieById(idClass);
				controleurMonnaie.CtrM_GetMonnaieByEmpereur(empereur);
				controleurMonnaie.CtrM_GetMonnaieByMatiere(matiere);
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
				text_idClass.setText("");
				text_empereur.setText("");
				text_matiere.setText("");
			}
		});
		panel.add(btnVider);

		JLabel matiere = new JLabel("matiere");
		matiere.setFont(new Font("Tahoma", Font.BOLD, 18));
		matiere.setBounds(496, 282, 85, 21);
		panel.add(matiere);

		text_matiere = new JTextField();
		text_matiere.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_matiere.setColumns(10);
		text_matiere.setBounds(488, 313, 132, 38);
		panel.add(text_matiere);

		JLabel empereur = new JLabel("empereur");
		empereur.setFont(new Font("Tahoma", Font.BOLD, 18));
		empereur.setBounds(684, 282, 100, 21);
		panel.add(empereur);

		text_empereur = new JTextField();
		text_empereur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_empereur.setColumns(10);
		text_empereur.setBounds(669, 313, 132, 38);
		panel.add(text_empereur);

		JLabel lblNewLabel = new JLabel("Chercher Monnaie ");
		lblNewLabel.setForeground(new Color(255, 204, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(415, 54, 271, 59);
		panel.add(lblNewLabel);

	}
}
