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

import edu.java.dao.controleurs.controleurOutil.ControleurOutil;

public class TableChercherOutil {

	private JPanel contentPane;
	private JTextField text_idref;
	private JFrame frame;
	private ControleurOutil controleuroutil;
	private JTextField text_matiere;
	private JTextField text_zone;

	/**
	 * Launch the application.
	 */
	public TableChercherOutil(ControleurOutil controleuroutil) {
		this.controleuroutil = controleuroutil;
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

		JLabel idref = new JLabel("idref");
		idref.setBounds(343, 282, 58, 21);
		idref.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(idref);

		text_idref = new JTextField();
		text_idref.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_idref.setBounds(308, 313, 132, 38);
		panel.add(text_idref);
		text_idref.setColumns(10);

		JButton btnNewButton_Chercher = new JButton("Chercher");
		btnNewButton_Chercher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_Chercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idref = Integer.parseInt(text_idref.getText());
				String zone = text_zone.getText();
				String matiere = text_matiere.getText();
				controleuroutil.CtrO_GetOutilById(idref);
				controleuroutil.CtrO_GetOutilByZone(zone);
				controleuroutil.CtrO_GetOutilByTitre_ou_Matiere(matiere);
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
				text_idref.setText("");
				text_zone.setText("");
				text_matiere.setText("");
			}
		});
		panel.add(btnVider);

		JLabel matiere = new JLabel("matiere");
		matiere.setFont(new Font("Tahoma", Font.BOLD, 18));
		matiere.setBounds(496, 282, 73, 21);
		panel.add(matiere);

		text_matiere = new JTextField();
		text_matiere.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_matiere.setColumns(10);
		text_matiere.setBounds(488, 313, 132, 38);
		panel.add(text_matiere);

		JLabel zone = new JLabel("zone");
		zone.setFont(new Font("Tahoma", Font.BOLD, 18));
		zone.setBounds(704, 282, 80, 21);
		panel.add(zone);

		text_zone = new JTextField();
		text_zone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_zone.setColumns(10);
		text_zone.setBounds(669, 313, 132, 38);
		panel.add(text_zone);

		JLabel lblNewLabel = new JLabel("Chercher Outil");
		lblNewLabel.setForeground(new Color(255, 204, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(430, 60, 245, 63);
		panel.add(lblNewLabel);

	}
}
