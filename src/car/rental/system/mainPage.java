/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package car.rental.system;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
        carPanel.setLayout(new GridLayout(0, 3, 10, 10));
        setLocationRelativeTo(null);
        
    }

    String url = "jdbc:mysql://localhost:3306/example";
    String username = "root";
    String password = "password";
    
    public void cars() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String query;

        if (jCheckBox1.isSelected()) {
            query = "SELECT * FROM cars WHERE availability = 1";
        } else {
            query = "SELECT * FROM cars WHERE 1 = 1"; // Base query when no specific filter is selected
        }

        if (seater4.isSelected()) {
            query += " AND capacity = 4";
        }

        if (seater59.isSelected()) {
            query += " AND capacity BETWEEN 5 AND 1000";
        }

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement st = con.prepareStatement(query);
             ResultSet rs = st.executeQuery()) {

                carPanel = new JPanel(); // Create a new panel for cars
                carPanel.setLayout(new GridLayout(0, 3, 10, 10)); // Set layout for car panel with 3 columns

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
                    // System.out.println(availability);
                    CD = new carDescription(price, id, availability, (com.mysql.cj.jdbc.Blob) imageIcon, model, capacity, color, plateNumber);
                    CD.changeActive(availability);
                    carPanel.add(CD); // Add each car component to the car panel
                }

                // Add the car panel to the scroll pane with vertical scrolling
                JScrollPane scrollPane = new JScrollPane(carPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                scrollPane.setPreferredSize(new Dimension(500, 400));
                jScrollPane1.setViewportView(scrollPane);

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

        seater59 = new javax.swing.JCheckBox();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        carPanel = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        seater4 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        seater59.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        seater59.setText("5 to 9 Seaters");
        seater59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seater59ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 0, 128));
        jButton5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Filter");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        carPanel.setBackground(new java.awt.Color(255, 255, 255));
        carPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        carPanel.setPreferredSize(new java.awt.Dimension(500, 400));

        javax.swing.GroupLayout carPanelLayout = new javax.swing.GroupLayout(carPanel);
        carPanel.setLayout(carPanelLayout);
        carPanelLayout.setHorizontalGroup(
            carPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
        );
        carPanelLayout.setVerticalGroup(
            carPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(carPanel);

        jCheckBox1.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jCheckBox1.setText("Show Avalable Cars");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/car/rental/system/logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jButton3.setBackground(new java.awt.Color(0, 0, 128));
        jButton3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Manage Transactions");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton2.setBackground(new java.awt.Color(0, 0, 128));
        jButton2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Income Tracker");

        jButton1.setBackground(new java.awt.Color(0, 0, 128));
        jButton1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Manage Cars");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 128));
        jButton4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("History");

        seater4.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        seater4.setText("4 Seaters");
        seater4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seater4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addGap(67, 67, 67)
                        .addComponent(seater4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(seater59, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox1)
                            .addComponent(seater4)
                            .addComponent(seater59)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new addCar().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void seater4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seater4ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_seater4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        cars();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void seater59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seater59ActionPerformed

    }//GEN-LAST:event_seater59ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel carPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox seater4;
    private javax.swing.JCheckBox seater59;
    // End of variables declaration//GEN-END:variables
}
