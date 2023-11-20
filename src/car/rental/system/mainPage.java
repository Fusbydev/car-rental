/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package car.rental.system;
import java.awt.GridLayout;
import java.sql.*;
import javax.swing.JFileChooser;

/**
 *
 * @author kirkf
 */
public class mainPage extends javax.swing.JFrame {

    /**
     * Creates new form mainPage
     */
    
    carDescription CD;
    public mainPage() {
        initComponents();
        cars();
        setTitle("RENTACAR");
        availableCars.setLayout(new GridLayout(0, 3, 10, 10));
        setLocationRelativeTo(null);
        
    }

    String url = "jdbc:mysql://localhost:3306/example";
    String username = "root";
    String password = "password";
    
    public void cars() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String query = "SELECT * FROM cars";
            try (Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery()) {
            
            while(rs.next()) {
                int price = 0;
                int id;
                int availability;
                id = rs.getInt(1);
                String model = rs.getString(2);
                price = rs.getInt(3);
                String color = rs.getString(4);
                String plateNumber = rs.getString(5);
                availability = rs.getInt(6);
                Blob imageIcon = rs.getBlob(7);
                int capacity = rs.getInt(8);
                CD = new carDescription(price, id, availability, (com.mysql.cj.jdbc.Blob) imageIcon, model, capacity, color, plateNumber);
                CD.changeActive(availability);
                availableCars.add(CD);
            }
       }
            
        } catch (SQLException e) {
    e.printStackTrace();
} catch (Exception e) {
    e.printStackTrace();
}
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        availableCars = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        availableCars.setBackground(new java.awt.Color(204, 204, 255));
        availableCars.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout availableCarsLayout = new javax.swing.GroupLayout(availableCars);
        availableCars.setLayout(availableCarsLayout);
        availableCarsLayout.setHorizontalGroup(
            availableCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
        );
        availableCarsLayout.setVerticalGroup(
            availableCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(availableCars);

        jCheckBox1.setText("Show Avalable cars");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("add car");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(jCheckBox1)
                .addContainerGap(462, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jButton1)))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

        availableCars.removeAll();
        availableCars.revalidate();
        availableCars.repaint();

    // Fetch and display the cars based on the checkbox state
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String query;
            if (jCheckBox1.isSelected()) {
                query = "SELECT * FROM cars WHERE availability = 1";
            } else {
                query = "SELECT * FROM cars";
            }

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement st = con.prepareStatement(query);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                int price = 0;
                int id;
                int availability;
                id = rs.getInt(1);
                String model = rs.getString(2);
                price = rs.getInt(3);
                String color = rs.getString(4);
                String plateNumber = rs.getString(5);
                availability = rs.getInt(6);
                Blob imageIcon = rs.getBlob(7);
                int capacity = rs.getInt(8);
                //System.out.println(availability);
                CD = new carDescription(price, id, availability, (com.mysql.cj.jdbc.Blob) imageIcon, model, capacity, color, plateNumber);
                CD.changeActive(availability);
                availableCars.add(CD);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      new addCar().setVisible(true);
      dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel availableCars;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
