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

import edu.java.dao.controleurs.controleurLivre.ControleurLivre;

public class TableSupprimerLivre {

	private JPanel contentPane;
	private JTextField texte_idl;
	private JFrame frame;
	private ControleurLivre controleurLivre;

	/**
	 * Launch the application.
	 */
	public TableSupprimerLivre(ControleurLivre controleurLivre) {
		this.controleurLivre = controleurLivre;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					creerFenetre1();
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
	public void creerFenetre1() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 1200, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(panel);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		panel.setLayout(null);

		panel.setPreferredSize(new Dimension(800, 800));

		JLabel lblidl = new JLabel("idl");
		lblidl.setBounds(605, 261, 58, 21);
		lblidl.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblidl);

		texte_idl = new JTextField();
		texte_idl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		texte_idl.setBounds(566, 292, 132, 31);
		panel.add(texte_idl);
		texte_idl.setColumns(10);

		JButton btnNewButton_Supprimer = new JButton("Supprimer");
		btnNewButton_Supprimer.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_Supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idl = Integer.parseInt(texte_idl.getText());
				int reponse = controleurLivre.CtrL_Enlever(idl);
				System.out.println(reponse);
				if (reponse != -1) {
					JOptionPane.showMessageDialog(null, "Livre Supprimé");
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Livre pas retrouvé");
					texte_idl.setText("");
				}
			}
		});
		btnNewButton_Supprimer.setBounds(403, 387, 132, 31);
		panel.add(btnNewButton_Supprimer);

		JButton btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRetour.setBounds(741, 387, 113, 31);
		panel.add(btnRetour);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		JButton btnVider = new JButton("Vider");
		btnVider.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnVider.setBounds(581, 387, 113, 31);
		btnVider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				texte_idl.setText("");
			}
		});
		panel.add(btnVider);

		JLabel lblNewLabel = new JLabel("Supprimer Livre");
		lblNewLabel.setForeground(new Color(255, 204, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(512, 71, 266, 85);
		panel.add(lblNewLabel);

	}
}
