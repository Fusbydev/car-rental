/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package car.rental.system;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author kirkf
 */
public class rentalInterface extends javax.swing.JFrame {

    private int carID;
    String url = "jdbc:mysql://localhost:3306/example";
    String username = "root";
    String password = "password";
    int price;
    String color;
    String cname = null;
    String plateNumber1 = null;
    int cap;
    public rentalInterface(int carID) {
        initComponents();
        this.carID = carID;
        showRent(carID);
        setLocationRelativeTo(null);
    }
public void showRent(int id) {
   
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String query = "SELECT * FROM cars WHERE car_id = ?";
        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement st = con.prepareStatement(query)) {

            st.setInt(1, id);

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    price = rs.getInt("price");
                    color = rs.getString("color");
                    cname = rs.getString("name");
                    plateNumber1 = rs.getString("plate_number");
                    cap = rs.getInt("capacity");
                   
                    carPrice.setText(String.valueOf(price));
                    carColor.setText(color);
                    vehicleType.setText(String.valueOf(cname));
                    Cap.setText(String.valueOf(cap));
                    plateNumber.setText(plateNumber1);
                    
                   
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void updateCars(int updateID) {
    System.out.println(updateID);
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String updateQuery = "UPDATE cars SET availability = ? WHERE car_id = ?";    
        
        try(Connection con = DriverManager.getConnection(url, username, password)) {
            PreparedStatement st = con.prepareStatement(updateQuery);
            st.setInt(1, 0);
            st.setInt(2, updateID);
            
           st.executeUpdate();
        } catch(SQLException e) {
        e.printStackTrace();
    }
        
    }  catch (Exception e) {
        e.printStackTrace();
    }
    
}


public void rentConfirm(int id) {
    String Cname = name.getText();
    int daysOfRent = Integer.parseInt(daysofRent.getText());
    int cAge = Integer.parseInt(age.getText());
    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String query = "INSERT INTO RentalRecords (name, age, days_of_rent"
                + ", car_name, plate_number, car_color, total_price, date_rented) VALUES (?,?,?,?,?,?,?,CURRENT_DATE())";
        int totalPrice = price * daysOfRent;
        try(Connection con = DriverManager.getConnection(url, username, password)) {
            PreparedStatement st = con.prepareStatement(query);
            
            st.setString(1, Cname);
            st.setInt(2, cAge);
            st.setInt(3, daysOfRent);
            st.setString(4, cname);
            st.setString(5, plateNumber1);
            st.setString(6, color);
            st.setInt(7, totalPrice);
            
            int rowsAffected = st.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("update success");
                updateCars(id);
            }
            
            
        } catch(SQLException e) {
        e.printStackTrace();
    }
        
    }  catch (Exception e) {
        e.printStackTrace();
    }
    
    
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        daysofRent = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        carPrice = new javax.swing.JLabel();
        carColor = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        vehicleType = new javax.swing.JLabel();
        Cap = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        plateNumber = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 128));

        name.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Full name:");

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Age:");

        age.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Day/s of rent:");

        daysofRent.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 14)); // NOI18N
        jLabel6.setText("COLOR : ");

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 14)); // NOI18N
        jLabel5.setText("PRICE : ");

        carPrice.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        carPrice.setText("...");

        carColor.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        carColor.setText("...");

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 14)); // NOI18N
        jLabel7.setText("MODEL:");

        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 14)); // NOI18N
        jLabel8.setText("CAPACITY:");

        jButton1.setBackground(new java.awt.Color(0, 0, 128));
        jButton1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 10)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CONFIRM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        vehicleType.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        vehicleType.setText("...");

        Cap.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        Cap.setText("...");

        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 14)); // NOI18N
        jLabel9.setText("PLATE NUMBER:");

        plateNumber.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        plateNumber.setText("...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(carPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(carColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(vehicleType, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cap, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(plateNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carPrice))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carColor)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(vehicleType, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cap, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plateNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/car/rental/system/CustomerTicket.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jLabel4)
                .addContainerGap(152, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(daysofRent, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 21, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(daysofRent, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed

    }//GEN-LAST:event_nameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       //confirm rental 
       
    int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to confirm the rental?", "Confirmation", JOptionPane.YES_NO_OPTION);
    if (result == JOptionPane.YES_OPTION) {
        // User clicked "Yes"
        rentConfirm(carID);
        mainPage MP = new mainPage();
        MP.setVisible(true);
    } else {
      
    }
       
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cap;
    private javax.swing.JTextField age;
    private javax.swing.JLabel carColor;
    private javax.swing.JLabel carPrice;
    private javax.swing.JTextField daysofRent;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField name;
    private javax.swing.JLabel plateNumber;
    private javax.swing.JLabel vehicleType;
    // End of variables declaration//GEN-END:variables
}
