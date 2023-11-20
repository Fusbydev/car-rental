/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package car.rental.system;
import com.mysql.cj.jdbc.Blob;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.ImageIcon;

/**
 *
 * @author kirkf
 */
public class carDescription extends javax.swing.JPanel {
    private int carID = 0;
    private int availability  = 0;
    private String model;
    private int capacity;
    private String color;
    private String plateNumber;
    addCar AC = new addCar();
    
    
    /** Creates new form carDescription
     * @param price
     * @param idcar 
     * @param availability*/
    
    
    public carDescription(float price, int idcar, int availability, Blob blob, String model, int capacity, String color, String plateNumber) 
            throws SQLException, FileNotFoundException, IOException {
        initComponents();
        
        this.carID = idcar;
        this.availability = availability;
        this.color = color;
        this.model = model;
        this.capacity = capacity;
        this.plateNumber = plateNumber;
        setMaximumSize(new Dimension(127, 165));
        setVisible(true);
        
        jLabel2.setText("PHP: " + price + " / Day");
        carMod.setText("Model: " + model);
        carPlate.setText("Plate Number: " + plateNumber);
        carColor.setText("Color: " + color);
        carCap.setText("Capacity: " + capacity);
        
         try {
            byte[] imageBytes = blob.getBytes(1, (int) blob.length());
            ImageIcon originalIcon = new ImageIcon(imageBytes);
            Image originalImage = originalIcon.getImage();
            
            // Resize the image to fit inside imagePanel1
            int panelWidth = 167;
            int panelHeight = 71;
            Image resizedImage = originalImage.getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH);
            // Set the resized image to imagePanel
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            imagePanel.setIcon(resizedIcon);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int getCarID() {
        return carID;
    }
    
    public void changeActive(int avi) {
        if (avi == 1 ) {
          activeStats.setBackground(new Color(102, 255, 51));
          rent.setEnabled(true);
        } else if (avi == 0) {
          activeStats.setBackground(Color.GRAY);
          rent.setEnabled(false);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rent = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        activeStats = new javax.swing.JPanel();
        imagePanel = new javax.swing.JLabel();
        carMod = new javax.swing.JLabel();
        carPlate = new javax.swing.JLabel();
        carColor = new javax.swing.JLabel();
        carCap = new javax.swing.JLabel();

        jLabel4.setText("Price");

        setBackground(new java.awt.Color(153, 153, 255));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));

        jLabel2.setText("Price");

        rent.setText("Rent");
        rent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentActionPerformed(evt);
            }
        });

        jButton2.setText("history");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        activeStats.setBackground(new java.awt.Color(102, 255, 51));

        javax.swing.GroupLayout activeStatsLayout = new javax.swing.GroupLayout(activeStats);
        activeStats.setLayout(activeStatsLayout);
        activeStatsLayout.setHorizontalGroup(
            activeStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        activeStatsLayout.setVerticalGroup(
            activeStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        imagePanel.setBackground(new java.awt.Color(204, 255, 255));

        carMod.setText("Model");

        carPlate.setText("Plate Number");

        carColor.setText("Color");

        carCap.setText("Capacity");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(activeStats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rent, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2))
                            .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carMod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(carPlate, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(carColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(carCap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carMod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carPlate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carColor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(carCap)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rent)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(activeStats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentActionPerformed
        rentalInterface RI = new rentalInterface(getCarID());
        RI.setVisible(true);
        
        javax.swing.JFrame mainPageFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        mainPageFrame.dispose();
    }//GEN-LAST:event_rentActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel activeStats;
    public javax.swing.JLabel carCap;
    public javax.swing.JLabel carColor;
    public javax.swing.JLabel carMod;
    public javax.swing.JLabel carPlate;
    private javax.swing.JLabel imagePanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JButton rent;
    // End of variables declaration//GEN-END:variables

}
