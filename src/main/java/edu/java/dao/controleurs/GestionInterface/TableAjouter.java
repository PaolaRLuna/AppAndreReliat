package edu.java.dao.controleurs.GestionInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class TableAjouter {
    public static void afficher(String titre, String[] enTete) {
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 800, 600); // Adjust the size to your needs
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 128, 64));
        frame.getContentPane().add(panel, BorderLayout.NORTH);

        JLabel lblTitre = new JLabel(titre);
        lblTitre.setFont(new Font("Serif", Font.BOLD, 25));
        panel.add(lblTitre);

        DefaultTableModel tableModel = new DefaultTableModel(enTete, 0);
        JTable table = new JTable(tableModel);
        table.setRowHeight(25);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Dialog", Font.BOLD, 18));

        JScrollPane scroll = new JScrollPane(table);

        JPanel sud = new JPanel();
        sud.setLayout(new GridLayout(2, 1));

        JPanel panelBtn = new JPanel();
        panelBtn.setBackground(new Color(255, 128, 64));
        sud.setBackground(Color.ORANGE);

        JButton ajouter = new JButton("Ajouter");
        panelBtn.add(ajouter);
        sud.add(panelBtn);
        ajouter.setFont(new Font("Serif", Font.BOLD, 20));

        JTextField[] inputFields = new JTextField[enTete.length];
        JPanel panelInput = new JPanel(new GridLayout(1, enTete.length));

        for (int i = 0; i < enTete.length; i++) {
            inputFields[i] = new JTextField();
            panelInput.add(inputFields[i]);
        }

        sud.add(panelInput);

        ajouter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] rowData = new String[enTete.length];
                for (int i = 0; i < enTete.length; i++) {
                    rowData[i] = inputFields[i].getText();
                }
                tableModel.addRow(rowData);
                for (int i = 0; i < enTete.length; i++) {
                    inputFields[i].setText("");
                }
            }
        });

        frame.add(scroll);
        frame.getContentPane().add(sud, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}
