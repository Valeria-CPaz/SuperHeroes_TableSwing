package com.val;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SuperHeroes extends JPanel {

    private static boolean DEBUG = true;

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();

            }
        });
    }

    public SuperHeroes() {
        super(new GridLayout(1, 0));

        String[] columnNames = {"Real Name", "Super Hero Name", "Speed", "Power", "Tier"};

        Object[][] data = {
                {"Bruce Wayne", "Batman", 20, 25, 1},
                {"Thor Odinson", "Thor", 100, 100, 6},
                {"Wanda Maximoff", "Scarlet Witch", 100, 100, 7},
                {"Tony Stark", "Iron Man", 40, 80, 4},
                {"Wade Wilson", "Deadpool", 50, 55, 3},
        };

        final JTable TABLE = new JTable(data, columnNames);
        TABLE.setPreferredScrollableViewportSize(new Dimension(500, 70));
        TABLE.setFillsViewportHeight(true);

        if (DEBUG) {
            TABLE.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    printDebugData(TABLE);
                }
            });
        }

        JScrollPane scrollPane = new JScrollPane(TABLE);
        add(scrollPane);

    }

    private static void createAndShowGUI() {
        if (DEBUG) {
            System.out.println("SuperHeroes new table");
        }

        JFrame frame = new JFrame("SuperHeroes Table for John, who loves SuperHeroes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SuperHeroes newContentPane = new SuperHeroes();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }

    private void printDebugData(JTable TABLE) {
        System.out.println("Mouse is clicked");

        int numRows = TABLE.getRowCount();
        int numColus = TABLE.getColumnCount();

        javax.swing.table.TableModel model = TABLE.getModel();

        System.out.println("value of data: ");

        for (int i = 0; i < numRows; i++) {
            System.out.println("   row" + i + ":");
            for (int j = 0; j < numColus; j++) {
                System.out.println("   " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }

}
