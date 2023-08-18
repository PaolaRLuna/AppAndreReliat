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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class TableChercher {
    public static void afficher(String titre, String[][] data, String[] enTete) {
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 800, 600); // Adjust the size to your needs
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 128, 64));
        frame.getContentPane().add(panel, BorderLayout.NORTH);

        JLabel lblTitre = new JLabel(titre);
        lblTitre.setFont(new Font("Serif", Font.BOLD, 25));
        panel.add(lblTitre);

        DefaultTableModel tableModel = new DefaultTableModel(data, enTete);
        JTable table = new JTable(tableModel);
        table.setRowHeight(25);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Dialog", Font.BOLD, 18));

        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(rowSorter);

        JScrollPane scroll = new JScrollPane(table);

        JPanel sud = new JPanel();
        sud.setLayout(new GridLayout(2, 1));

        JPanel panelBtn = new JPanel();
        panelBtn.setBackground(new Color(255, 128, 64));
        sud.setBackground(Color.ORANGE);

        JTextField searchField = new JTextField();
        JButton chercher = new JButton("Chercher");

        panelBtn.add(searchField);
        panelBtn.add(chercher);
        sud.add(panelBtn);
        chercher.setFont(new Font("Serif", Font.BOLD, 20));

        chercher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String query = searchField.getText();
                if (query.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    try {
                        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));
                    } catch (java.util.regex.PatternSyntaxException ex) {
                        JOptionPane.showMessageDialog(
                                frame,
                                "Erreur dans la recherche : " + ex.getMessage(),
                                "Erreur de recherche",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        frame.add(scroll);
        frame.getContentPane().add(sud, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}
