// BusManagementUI.java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class BusManagementUI extends JFrame {
    private BusDAO busDAO;

    public BusManagementUI(Connection connection) {
        this.busDAO = new BusDAO(connection);
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Bus Management System");

        JPanel panel = new JPanel();
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);
        JLabel capacityLabel = new JLabel("Capacity:");
        JTextField capacityField = new JTextField(5);
        JButton addButton = new JButton("Add");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int capacity = Integer.parseInt(capacityField.getText());
                try {
                    busDAO.addBus(name, capacity);
                    JOptionPane.showMessageDialog(BusManagementUI.this, "Bus added successfully!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(BusManagementUI.this, "Error adding bus: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(capacityLabel);
        panel.add(capacityField);
        panel.add(addButton);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Connection connection = DBConnection.getConnection();
                new BusManagementUI(connection).setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}