package code;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class databaseConnection extends JFrame {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Korng";
    private static final String USER = "root";
    private static final String PASS = "";
    public databaseConnection() {
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        String[] colNames = {"ID", "Last Name", "First Name", "Phone Number"};
        DefaultTableModel model = new DefaultTableModel(colNames, 0);
        JTable table = new JTable(model);
        JScrollPane sPane = new JScrollPane(table);
        add(sPane, BorderLayout.CENTER);
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM person")) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String lastname = rs.getString("lastname");
                String firstname = rs.getString("firstname");
                String phonenumber = rs.getString("phonenumber");
                model.addRow(new Object[]{id, lastname, firstname, phonenumber});
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {

            new databaseConnection().setVisible(true);

    }}
