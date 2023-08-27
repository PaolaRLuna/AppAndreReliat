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

public class TableSupprimerOutil {

	private JPanel contentPane;
	private JTextField texte_idf;
	private JFrame frame;
	private ControleurOutil controleurOutil;

	/**
	 * Launch the application.
	 */
	public TableSupprimerOutil(ControleurOutil controleurOutil) {
		this.controleurOutil = controleurOutil;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					creerFenetre2();
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
	public void creerFenetre2() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 1196, 786);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(panel);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		panel.setLayout(null);

		panel.setPreferredSize(new Dimension(800, 800));

		JLabel lblidf = new JLabel("idf");
		lblidf.setBounds(592, 284, 58, 21);
		lblidf.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblidf);

		texte_idf = new JTextField();
		texte_idf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		texte_idf.setBounds(540, 324, 132, 34);
		panel.add(texte_idf);
		texte_idf.setColumns(10);

		JButton btnNewButton_Supprimer = new JButton("Supprimer");
		btnNewButton_Supprimer.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_Supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idf = Integer.parseInt(texte_idf.getText());
				controleurOutil.CtrO_Enlever(idf);
			}
		});
		btnNewButton_Supprimer.setBounds(381, 446, 132, 34);
		panel.add(btnNewButton_Supprimer);

		JButton btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRetour.setBounds(736, 446, 113, 34);
		panel.add(btnRetour);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		JButton btnVider = new JButton("Vider");
		btnVider.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnVider.setBounds(559, 446, 113, 34);
		btnVider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				texte_idf.setText("");
			}
		});
		panel.add(btnVider);

		JLabel lblNewLabel = new JLabel("Supprimer Outil");
		lblNewLabel.setForeground(new Color(255, 204, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(477, 97, 236, 48);
		panel.add(lblNewLabel);

	}
}
