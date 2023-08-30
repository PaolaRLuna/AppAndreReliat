package edu.java.dao.controleurs.GestionInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import edu.java.dao.controleurs.controleurOutil.ControleurOutil;
import edu.java.dao.models.modelOutil.Outil;

public class TableAjouterOutil {

	private JPanel contentPane;
	private JTextField text_appellation;
	private JTextField text_qualification_forme;
	private JTextField text_forme_typ;
	private JTextField text_obs_aspect;
	private JTextField text_etat_conserv;
	private JTextField text_ro_naturel;
	private JTextField text_hauteur_supposemm;
	private JTextField text_largeur_mm;
	private JTextField text_epaisseur_mm;
	private JTextField text_matiere;
	private JTextField text_couleur_int;
	private JTextField text_intensite_pat;
	private JTextField text_retouche_sigmoidales;
	private JFrame frame;
	private ControleurOutil controleurOutil;
	private JTextField text_idref;
	private JTextField text_forme_atyp;
	private JTextField text_ro_amenage;
	private JTextField text_hauteur_reelemm;
	private JTextField text_masse_gr;
	private JTextField text_couleur_patref_ral;
	private JTextField text_ref_couleur_pat;
	private JTextField text_date_decouverte;
	private JTextField text_retouches_cote_fine;
	private JTextField text_info_secondaire;
	private JTextField text_zone_ramassage;
	private JTextField text_remarquable;
	private JTextField text_num_reference;

	/**
	 * Launch the application.
	 */
	public TableAjouterOutil(ControleurOutil controleurOutil) {
		this.controleurOutil = controleurOutil;
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
		frame.setBounds(100, 100, 1341, 828);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel titre = new JPanel();
		JScrollPane scrollPane = new JScrollPane(titre);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		titre.setLayout(null);

		titre.setPreferredSize(new Dimension(800, 800));

		JLabel appellation = new JLabel("appellation");
		appellation.setVerticalAlignment(SwingConstants.BOTTOM);
		appellation.setBounds(345, 78, 118, 21);
		appellation.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(appellation);

		JButton btnVider = new JButton("Vider");
		btnVider.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnVider.setBounds(533, 627, 110, 21);
		btnVider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_idref.setText("");
				text_appellation.setText("");
				text_qualification_forme.setText("");
				text_forme_typ.setText("");
				text_forme_atyp.setText("");
				text_obs_aspect.setText("");
				text_etat_conserv.setText("");
				text_ro_naturel.setText("");
				text_ro_amenage.setText("");
				text_hauteur_reelemm.setText("");
				text_hauteur_supposemm.setText("");
				text_largeur_mm.setText("");
				text_epaisseur_mm.setText("");
				text_masse_gr.setText("");
				text_matiere.setText("");
				text_couleur_int.setText("");
				text_intensite_pat.setText("");
				text_ref_couleur_pat.setText("");
				text_couleur_patref_ral.setText("");
				text_retouche_sigmoidales.setText("");
				text_retouches_cote_fine.setText("");
				text_date_decouverte.setText("");
				text_info_secondaire.setText("");
				text_zone_ramassage.setText("");
				text_remarquable.setText("");
				text_num_reference.setText("");
			}
		});
		titre.add(btnVider);

		text_appellation = new JTextField();
		text_appellation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_appellation.setBounds(345, 106, 206, 28);
		titre.add(text_appellation);
		text_appellation.setColumns(10);

		JButton btnNewButton_Ajouter = new JButton("Ajouter");
		btnNewButton_Ajouter.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_Ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idref = Integer.parseInt(text_idref.getText());
				String appellation = text_appellation.getText();
				String qualification_forme = text_qualification_forme.getText();
				String forme_typ = text_qualification_forme.getText();
				String forme_atyp = text_qualification_forme.getText();
				String obs_aspect = text_qualification_forme.getText();
				String etat_conserv = text_qualification_forme.getText();
				String ro_naturel = text_qualification_forme.getText();
				String ro_amenage = text_qualification_forme.getText();
				String hauteur_reelemm = text_hauteur_reelemm.getText();
				String hauteur_supposemm = text_qualification_forme.getText();
				String largeur_mm = text_qualification_forme.getText();
				String epaisseur_mm = text_qualification_forme.getText();
				String masse_gr = text_qualification_forme.getText();
				String matiere = text_qualification_forme.getText();
				String couleur_int = text_qualification_forme.getText();
				String intensite_pat = text_qualification_forme.getText();
				String ref_couleur_pat = text_qualification_forme.getText();
				String couleur_patref_ral = text_qualification_forme.getText(); // gerer couleur
				String retouche_sigmoidales = text_qualification_forme.getText();
				String retouches_cote_fine = text_qualification_forme.getText();
				LocalDate date_decouverte = LocalDate.parse(text_date_decouverte.getText());
				String info_secondaire = text_qualification_forme.getText();
				String zone_ramassage = text_qualification_forme.getText();
				String remarquable = text_qualification_forme.getText();
				double num_reference = Integer.parseInt(text_num_reference.getText());

				Outil o = new Outil(idref, appellation, qualification_forme, forme_typ, forme_atyp, obs_aspect,
						etat_conserv, ro_naturel, ro_amenage, hauteur_reelemm, hauteur_supposemm,
						largeur_mm, epaisseur_mm, masse_gr, matiere, couleur_int, intensite_pat,
						ref_couleur_pat, couleur_patref_ral, retouche_sigmoidales, retouches_cote_fine,
						date_decouverte, info_secondaire, zone_ramassage, remarquable, num_reference);
				controleurOutil.CtrO_Enregistrer(o);
				JOptionPane.showMessageDialog(null, "Outil Ajouté");
				frame.dispose();
			}
		});
		btnNewButton_Ajouter.setBounds(323, 627, 103, 21);
		titre.add(btnNewButton_Ajouter);

		text_qualification_forme = new JTextField();
		text_qualification_forme.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_qualification_forme.setBounds(601, 110, 225, 27);
		text_qualification_forme.setColumns(10);
		titre.add(text_qualification_forme);

		text_forme_typ = new JTextField();
		text_forme_typ.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_forme_typ.setBounds(884, 110, 212, 28);
		text_forme_typ.setColumns(10);
		titre.add(text_forme_typ);

		JLabel qualification_forme = new JLabel("qualification_forme");
		qualification_forme.setBounds(591, 78, 183, 21);
		qualification_forme.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(qualification_forme);

		JLabel forme_typ = new JLabel("forme_typ");
		forme_typ.setBounds(884, 78, 124, 21);
		forme_typ.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(forme_typ);

		JLabel obs_aspect = new JLabel("obs_aspect");
		obs_aspect.setBounds(345, 147, 118, 21);
		obs_aspect.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(obs_aspect);

		JLabel etat_conserv = new JLabel("etat_conserv");
		etat_conserv.setBounds(601, 147, 173, 21);
		etat_conserv.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(etat_conserv);

		JLabel ro_naturel = new JLabel("ro_naturel");
		ro_naturel.setBounds(884, 148, 102, 21);
		ro_naturel.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(ro_naturel);

		text_obs_aspect = new JTextField();
		text_obs_aspect.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_obs_aspect.setBounds(345, 178, 206, 27);
		text_obs_aspect.setColumns(10);
		titre.add(text_obs_aspect);

		text_etat_conserv = new JTextField();
		text_etat_conserv.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_etat_conserv.setBounds(606, 178, 220, 27);
		text_etat_conserv.setColumns(10);
		titre.add(text_etat_conserv);

		text_ro_naturel = new JTextField();
		text_ro_naturel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_ro_naturel.setBounds(884, 178, 212, 28);
		text_ro_naturel.setColumns(10);
		titre.add(text_ro_naturel);

		JLabel hauteur_supposemm = new JLabel("hauteur_supposemm");
		hauteur_supposemm.setBounds(601, 213, 211, 21);
		hauteur_supposemm.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(hauteur_supposemm);

		JLabel largeur_mm = new JLabel("largeur_mm");
		largeur_mm.setBounds(884, 213, 118, 21);
		largeur_mm.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(largeur_mm);

		JLabel epaisseur_mm = new JLabel("epaisseur_mm");
		epaisseur_mm.setBounds(121, 285, 152, 21);
		epaisseur_mm.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(epaisseur_mm);

		JLabel matiere = new JLabel("matiere");
		matiere.setBounds(601, 285, 118, 21);
		matiere.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(matiere);

		JLabel couleur_int = new JLabel("couleur_int");
		couleur_int.setBounds(884, 285, 127, 21);
		couleur_int.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(couleur_int);

		JLabel intensite_pat = new JLabel("intensite_pat");
		intensite_pat.setBounds(121, 352, 133, 21);
		intensite_pat.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(intensite_pat);

		JLabel retouche_sigmoidales = new JLabel("retouche_sigmoidales");
		retouche_sigmoidales.setBounds(879, 352, 217, 21);
		retouche_sigmoidales.setFont(new Font("Tahoma", Font.BOLD, 18));
		titre.add(retouche_sigmoidales);

		text_hauteur_supposemm = new JTextField();
		text_hauteur_supposemm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_hauteur_supposemm.setColumns(10);
		text_hauteur_supposemm.setBounds(601, 244, 225, 31);
		titre.add(text_hauteur_supposemm);

		text_largeur_mm = new JTextField();
		text_largeur_mm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_largeur_mm.setColumns(10);
		text_largeur_mm.setBounds(884, 250, 212, 28);
		titre.add(text_largeur_mm);

		text_epaisseur_mm = new JTextField();
		text_epaisseur_mm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_epaisseur_mm.setColumns(10);
		text_epaisseur_mm.setBounds(121, 316, 182, 26);
		titre.add(text_epaisseur_mm);

		text_matiere = new JTextField();
		text_matiere.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_matiere.setColumns(10);
		text_matiere.setBounds(601, 312, 225, 34);
		titre.add(text_matiere);

		JButton btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRetour.setBounds(785, 627, 100, 21);
		titre.add(btnRetour);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		text_couleur_int = new JTextField();
		text_couleur_int.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_couleur_int.setColumns(10);
		text_couleur_int.setBounds(882, 316, 214, 34);
		titre.add(text_couleur_int);

		text_intensite_pat = new JTextField();
		text_intensite_pat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_intensite_pat.setColumns(10);
		text_intensite_pat.setBounds(121, 383, 183, 25);
		titre.add(text_intensite_pat);

		text_retouche_sigmoidales = new JTextField();
		text_retouche_sigmoidales.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_retouche_sigmoidales.setColumns(10);
		text_retouche_sigmoidales.setBounds(879, 386, 217, 28);
		titre.add(text_retouche_sigmoidales);

		JLabel idref = new JLabel("idref");
		idref.setVerticalAlignment(SwingConstants.BOTTOM);
		idref.setFont(new Font("Tahoma", Font.BOLD, 18));
		idref.setBounds(121, 71, 58, 21);
		titre.add(idref);

		text_idref = new JTextField();
		text_idref.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_idref.setColumns(10);
		text_idref.setBounds(121, 102, 182, 31);
		titre.add(text_idref);

		JLabel forme_atyp = new JLabel("forme_atyp");
		forme_atyp.setVerticalAlignment(SwingConstants.BOTTOM);
		forme_atyp.setFont(new Font("Tahoma", Font.BOLD, 18));
		forme_atyp.setBounds(121, 147, 140, 21);
		titre.add(forme_atyp);

		text_forme_atyp = new JTextField();
		text_forme_atyp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_forme_atyp.setColumns(10);
		text_forme_atyp.setBounds(121, 176, 182, 29);
		titre.add(text_forme_atyp);

		JLabel ro_amenage = new JLabel("ro_amenage");
		ro_amenage.setVerticalAlignment(SwingConstants.BOTTOM);
		ro_amenage.setFont(new Font("Tahoma", Font.BOLD, 18));
		ro_amenage.setBounds(121, 215, 133, 21);
		titre.add(ro_amenage);

		text_ro_amenage = new JTextField();
		text_ro_amenage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_ro_amenage.setColumns(10);
		text_ro_amenage.setBounds(121, 250, 183, 25);
		titre.add(text_ro_amenage);

		JLabel masse_gr = new JLabel("masse_gr");
		masse_gr.setVerticalAlignment(SwingConstants.BOTTOM);
		masse_gr.setFont(new Font("Tahoma", Font.BOLD, 18));
		masse_gr.setBounds(345, 285, 126, 21);
		titre.add(masse_gr);

		text_masse_gr = new JTextField();
		text_masse_gr.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_masse_gr.setColumns(10);
		text_masse_gr.setBounds(349, 319, 202, 28);
		titre.add(text_masse_gr);

		JLabel couleur_patref_ral = new JLabel("couleur_patref_ral");
		couleur_patref_ral.setVerticalAlignment(SwingConstants.BOTTOM);
		couleur_patref_ral.setFont(new Font("Tahoma", Font.BOLD, 18));
		couleur_patref_ral.setBounds(604, 352, 183, 21);
		titre.add(couleur_patref_ral);

		text_couleur_patref_ral = new JTextField();
		text_couleur_patref_ral.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_couleur_patref_ral.setColumns(10);
		text_couleur_patref_ral.setBounds(601, 380, 225, 31);
		titre.add(text_couleur_patref_ral);

		JLabel ref_couleur_pat = new JLabel("ref_couleur_pat");
		ref_couleur_pat.setVerticalAlignment(SwingConstants.BOTTOM);
		ref_couleur_pat.setFont(new Font("Tahoma", Font.BOLD, 18));
		ref_couleur_pat.setBounds(323, 352, 173, 21);
		titre.add(ref_couleur_pat);

		text_ref_couleur_pat = new JTextField();
		text_ref_couleur_pat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_ref_couleur_pat.setColumns(10);
		text_ref_couleur_pat.setBounds(349, 379, 206, 28);
		titre.add(text_ref_couleur_pat);

		JLabel date_decouverte = new JLabel("date_decouverte");
		date_decouverte.setVerticalAlignment(SwingConstants.BOTTOM);
		date_decouverte.setFont(new Font("Tahoma", Font.BOLD, 18));
		date_decouverte.setBounds(334, 430, 162, 21);
		titre.add(date_decouverte);

		text_date_decouverte = new JTextField();
		text_date_decouverte.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_date_decouverte.setColumns(10);
		text_date_decouverte.setBounds(345, 461, 206, 28);
		titre.add(text_date_decouverte);

		JLabel retouches_cote_fine = new JLabel("retouches_cote_fine");
		retouches_cote_fine.setVerticalAlignment(SwingConstants.BOTTOM);
		retouches_cote_fine.setFont(new Font("Tahoma", Font.BOLD, 18));
		retouches_cote_fine.setBounds(97, 430, 206, 21);
		titre.add(retouches_cote_fine);

		text_retouches_cote_fine = new JTextField();
		text_retouches_cote_fine.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_retouches_cote_fine.setColumns(10);
		text_retouches_cote_fine.setBounds(121, 462, 182, 26);
		titre.add(text_retouches_cote_fine);

		JLabel info_secondaire = new JLabel("info_secondaire");
		info_secondaire.setVerticalAlignment(SwingConstants.BOTTOM);
		info_secondaire.setFont(new Font("Tahoma", Font.BOLD, 18));
		info_secondaire.setBounds(601, 430, 162, 21);
		titre.add(info_secondaire);

		text_info_secondaire = new JTextField();
		text_info_secondaire.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_info_secondaire.setColumns(10);
		text_info_secondaire.setBounds(601, 461, 225, 28);
		titre.add(text_info_secondaire);

		JLabel zone_ramassage = new JLabel("zone_ramassage");
		zone_ramassage.setVerticalAlignment(SwingConstants.BOTTOM);
		zone_ramassage.setFont(new Font("Tahoma", Font.BOLD, 18));
		zone_ramassage.setBounds(879, 430, 173, 21);
		titre.add(zone_ramassage);

		text_zone_ramassage = new JTextField();
		text_zone_ramassage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_zone_ramassage.setColumns(10);
		text_zone_ramassage.setBounds(884, 465, 212, 28);
		titre.add(text_zone_ramassage);

		JLabel remarquable = new JLabel("remarquable");
		remarquable.setVerticalAlignment(SwingConstants.BOTTOM);
		remarquable.setFont(new Font("Tahoma", Font.BOLD, 18));
		remarquable.setBounds(362, 512, 143, 21);
		titre.add(remarquable);

		text_remarquable = new JTextField();
		text_remarquable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_remarquable.setColumns(10);
		text_remarquable.setBounds(345, 543, 206, 28);
		titre.add(text_remarquable);

		JLabel num_reference = new JLabel("num_reference");
		num_reference.setVerticalAlignment(SwingConstants.BOTTOM);
		num_reference.setFont(new Font("Tahoma", Font.BOLD, 18));
		num_reference.setBounds(601, 512, 143, 21);
		titre.add(num_reference);

		text_num_reference = new JTextField();
		text_num_reference.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_num_reference.setColumns(10);
		text_num_reference.setBounds(601, 547, 225, 24);
		titre.add(text_num_reference);

		text_hauteur_reelemm = new JTextField();
		text_hauteur_reelemm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_hauteur_reelemm.setColumns(10);
		text_hauteur_reelemm.setBounds(345, 250, 206, 28);
		titre.add(text_hauteur_reelemm);

		JLabel hauteur_reelemm = new JLabel("hauteur_reelemm");
		hauteur_reelemm.setVerticalAlignment(SwingConstants.BOTTOM);
		hauteur_reelemm.setFont(new Font("Tahoma", Font.BOLD, 18));
		hauteur_reelemm.setBounds(344, 219, 183, 21);
		titre.add(hauteur_reelemm);

		JLabel lblNewLabel = new JLabel("Ajouter Outil");
		lblNewLabel.setForeground(new Color(255, 204, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(490, 10, 322, 34);
		titre.add(lblNewLabel);

	}
}
