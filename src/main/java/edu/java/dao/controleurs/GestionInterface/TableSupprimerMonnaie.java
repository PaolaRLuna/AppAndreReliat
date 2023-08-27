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

public class TableSupprimerMonnaie {

	private JPanel contentPane;
	private JTextField texte_Idclass;
	private JFrame frame;
	private ControleurMonnaie controleurMonnaie;

	/**
	 * Launch the application.
	 */
	public TableSupprimerMonnaie(ControleurMonnaie controleurMonnaie) {
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
		frame.setBounds(100, 100, 1181, 784);
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
		lblIdclass.setBounds(612, 297, 90, 21);
		lblIdclass.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblIdclass);

		texte_Idclass = new JTextField();
		texte_Idclass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		texte_Idclass.setBounds(592, 347, 132, 27);
		panel.add(texte_Idclass);
		texte_Idclass.setColumns(10);

		JButton btnNewButton_Supprimer = new JButton("Supprimer");
		btnNewButton_Supprimer.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_Supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idClass = Integer.parseInt(texte_Idclass.getText());
				controleurMonnaie.CtrM_Enlever(idClass);
			}
		});
		btnNewButton_Supprimer.setBounds(412, 434, 139, 31);
		panel.add(btnNewButton_Supprimer);

		JButton btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRetour.setBounds(789, 434, 112, 31);
		panel.add(btnRetour);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		JButton btnVider = new JButton("Vider");
		btnVider.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnVider.setBounds(612, 434, 112, 31);
		btnVider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				texte_Idclass.setText("");
			}
		});
		panel.add(btnVider);

		JLabel lblNewLabel = new JLabel("Supprimer Monnaie");
		lblNewLabel.setForeground(new Color(255, 204, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(550, 133, 290, 48);
		panel.add(lblNewLabel);

	}
}
