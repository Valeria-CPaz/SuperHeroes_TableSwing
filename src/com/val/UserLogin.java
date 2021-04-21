package com.val;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UserLogin extends JFrame {

    private JPanel contentPane;
    private JButton btnNewButton;
    private JTextField textField;
    private JPasswordField passwordField;

    final String DB_URL = "jdbc:mysql://localhost:3306/titanicmanifest";
    final String DB_USER = "ValeriaPaz";
    final String DB_PASSWORD = "280585";

    public static void main(String[] args) {

        System.out.println("this is user login ");

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserLogin frame = new UserLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public UserLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Login Label
        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(423, 13, 273, 93);
        contentPane.add(lblNewLabel);

        // Username Label
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblPassword.setBounds(250, 166, 193, 52);
        contentPane.add(lblPassword);

        // password Label
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblUsername.setBounds(250, 286, 193, 52);
        contentPane.add(lblUsername);

        // text field
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        textField.setBounds(481, 170, 281, 68);
        textField.setColumns(1);
        contentPane.add(textField);

        // password field
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 31));
        passwordField.setBounds(481, 286, 281, 68);
        passwordField.setColumns(1);
        contentPane.add(passwordField);

        // button login
        btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(545, 392, 162, 72);

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String userName = textField.getText();
                String password = passwordField.getText();
                System.out.println("Button is pressed" + userName + ": " + password);



                try  {
                    Class.forName("com.mysql.jdbc.Driver");

                    Connection con = DriverManager.getConnection(
                            DB_URL, DB_USER, DB_PASSWORD);

                    PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement("select name, password from student where name = ? and password = ?");
                    preparedStatement.setString(1, userName);
                    preparedStatement.setString(2, password);

                    ResultSet rs = preparedStatement.executeQuery();

                    ResultSetMetaData metaData = rs.getMetaData();
                    if (rs.next()) {
                        System.out.println("Logging IN");
                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in" );
                    } else {
                        System.out.println("Not allowed to login");
                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password" );



                    }

                } catch (SQLException e) {
                    System.out.println(e.toString());

                } catch(Exception e) {

                } finally{
                    // System.out.println("finally");
                }


            }

        });

        contentPane.add(btnNewButton);

    }
}
