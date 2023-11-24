/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package car.rental.system;

import com.mysql.cj.jdbc.Blob;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import javax.swing.JFileChooser;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;




/**
 *
 * @author kirkf
 */
public class addCar extends javax.swing.JFrame {
    
    String url = "jdbc:mysql://localhost:3306/example";
    String username = "root";
    String password = "password";
    String path1 = null;
    ButtonGroup jgroup;
    /**
     * Creates new form addCar
     */
    public addCar() {
        initComponents();
        jgroup = new ButtonGroup();
        jgroup.add(carNameSearch);
        jgroup.add(carIDSearch);
        jgroup.add(plateNumberSearch);
        carNameSearch.setBackground(null);
        carIDSearch.setBackground(null);
        plateNumberSearch.setBackground(null);
        populateData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        carModel = new javax.swing.JTextField();
        carPrice = new javax.swing.JTextField();
        carCapacity = new javax.swing.JTextField();
        carColor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        carPlateNumber = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        imagePanel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        plateNumberSearch = new javax.swing.JRadioButton();
        carNameSearch = new javax.swing.JRadioButton();
        carIDSearch = new javax.swing.JRadioButton();
        search = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jLabel3.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 128));

        jButton2.setBackground(new java.awt.Color(0, 102, 51));
        jButton2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ADD CAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        carModel.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        carModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carModelActionPerformed(evt);
            }
        });

        carPrice.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        carPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carPriceActionPerformed(evt);
            }
        });

        carCapacity.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        carColor.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        carColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carColorActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Capacity:");

        carPlateNumber.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Car Model:");

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Car Price:");

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Car Color:");

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Car Plate Number:");

        jButton1.setBackground(new java.awt.Color(0, 102, 0));
        jButton1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("UPLOAD PHOTO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        imagePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/car/rental/system/metrowheelslogo.png"))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        editButton.setBackground(new java.awt.Color(51, 255, 255));
        editButton.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("UPDATE");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(255, 51, 51));
        deleteButton.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        plateNumberSearch.setText("PLATE NUMBER");
        plateNumberSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plateNumberSearchActionPerformed(evt);
            }
        });

        carNameSearch.setText("CAR NAME");
        carNameSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carNameSearchActionPerformed(evt);
            }
        });

        carIDSearch.setText("CAR ID");
        carIDSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carIDSearchActionPerformed(evt);
            }
        });

        jLabel7.setText("Car Search");

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(240, 240, 240)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carModel)
                            .addComponent(carPrice)
                            .addComponent(carColor)
                            .addComponent(carPlateNumber)
                            .addComponent(carCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(carIDSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(carNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(plateNumberSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(111, 111, 111))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(116, 116, 116)
                                        .addComponent(jButton1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(78, 78, 78)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(64, 64, 64)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(16, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButton3)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(carModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(carIDSearch)
                            .addComponent(carNameSearch)
                            .addComponent(plateNumberSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(carPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(carColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(carPlateNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(carCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(editButton)
                            .addComponent(deleteButton)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carModelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carModelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser JF = new JFileChooser();
        JF.showOpenDialog(null);
        
        File file = JF.getSelectedFile();
        String path = file.getAbsolutePath();
        try {
            BufferedImage BI = ImageIO.read(new File(path));
            
            Image img = BI.getScaledInstance(152, 114, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            imagePanel.setIcon(icon);
            path1 = path;
            
        } catch (IOException ex) {
            Logger.getLogger(addCar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       //add car
       String CM = carModel.getText();
       int CP = Integer.parseInt(carPrice.getText());
       String color = carColor.getText();
       String CPN = String.valueOf(carPlateNumber.getText());
       int availability = 1;
       int carCap = Integer.parseInt(carCapacity.getText());
       
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           String query = "INSERT INTO cars (name, price, color, plate_number, availability, car_photo, capacity)"
                   + "VALUES (?,?,?,?,?,?,?)";
           try(Connection con = DriverManager.getConnection(url, username, password)) {
                PreparedStatement st = con.prepareStatement(query);
                
                st.setString(1, CM);
                st.setInt(2, CP);
                st.setString(3, color);
                st.setString(4, CPN);
                st.setInt(5, availability);
                InputStream is = new FileInputStream(new File(path1));
                st.setBlob(6, is);
                st.setInt(7, carCap);
                
                int rowsAffected = st.executeUpdate();
                if (rowsAffected > 0 ) {
                    carModel.setText("");
                    carPrice.setText("");
                    carColor.setText("");
                    carPlateNumber.setText("");
                    imagePanel.setIcon(null);
                }
                
           }
          
           
       } catch(Exception e) {
           e.printStackTrace();
       }
       
       
        mainPage MP = new mainPage();
        MP.setVisible(true);
       populateData();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void carPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carPriceActionPerformed

    private void carColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carColorActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
                DefaultTableModel jtable1 = (DefaultTableModel) jTable1.getModel();

        int carId = Integer.parseInt(jtable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           try(Connection con = DriverManager.getConnection(url, username, password)) {
               String Query="UPDATE cars SET name=?,price=?,color=?,plate_number=?,car_photo=?,capacity=? WHERE car_id=?";
              PreparedStatement btn=con.prepareStatement(Query);
              btn.setString(1, carModel.getText());
              btn.setFloat(2, Float.parseFloat(carPrice.getText()));
              btn.setString(3, carColor.getText());
              btn.setString(4, carPlateNumber.getText());
             InputStream is = new FileInputStream(new File(path1));
              btn.setBlob(5, is);
              btn.setFloat(6, Float.parseFloat(carCapacity.getText()));
              btn.setInt(7, carId);
              btn.executeUpdate();
               
           }        catch (FileNotFoundException ex) {
                        Logger.getLogger(addCar.class.getName()).log(Level.SEVERE, null, ex);
                    }
          
       } catch(SQLException e) {
           e.printStackTrace();
       } catch (ClassNotFoundException ex) {
            Logger.getLogger(carHistory1.class.getName()).log(Level.SEVERE, null, ex);
        }
        populateData();
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
          DefaultTableModel jtable1 = (DefaultTableModel) jTable1.getModel();
        int carId = Integer.parseInt(jtable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
         try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           try(Connection con = DriverManager.getConnection(url, username, password)) {
               String Query="DELETE FROM cars WHERE car_id=?";
              PreparedStatement btn=con.prepareStatement(Query);
              
              btn.setInt(1, carId);
              btn.executeUpdate();
               
           }
          
       } catch(SQLException e) {
           e.printStackTrace();
       } catch (ClassNotFoundException ex) {
            Logger.getLogger(carHistory1.class.getName()).log(Level.SEVERE, null, ex);
        }
        populateData();
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void carIDSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carIDSearchActionPerformed
        populateData();
    }//GEN-LAST:event_carIDSearchActionPerformed

    private void carNameSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carNameSearchActionPerformed
        populateData();
    }//GEN-LAST:event_carNameSearchActionPerformed

    private void plateNumberSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plateNumberSearchActionPerformed
       populateData();
    }//GEN-LAST:event_plateNumberSearchActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel jtable1 = (DefaultTableModel) jTable1.getModel();
        
        String model = jtable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
        String price = jtable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
        String color = jtable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
        String plate = jtable1.getValueAt(jTable1.getSelectedRow(), 4).toString();
        String capacity = jtable1.getValueAt(jTable1.getSelectedRow(), 5).toString();


        
        carModel.setText(model);
        carPrice.setText(price);
        carColor.setText(color);
        carPlateNumber.setText(plate);
        carCapacity.setText(capacity);
        int carId = Integer.parseInt(jtable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
         displayCarPhoto(carId);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new mainPage().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
   private void displayCarPhoto(int carId) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT car_photo FROM cars WHERE car_id = ?";
            try (PreparedStatement st = con.prepareStatement(query)) {
                st.setInt(1, carId);
                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                    // Retrieve the photo as a Blob
                    Blob blob = (Blob) rs.getBlob("car_photo");
                    
                    // Convert Blob to byte array
                    byte[] bytes = blob.getBytes(1, (int) blob.length());

                    // Convert byte array to ImageIcon
                    ImageIcon icon = new ImageIcon(bytes);
                    Image img = icon.getImage().getScaledInstance(152, 114, Image.SCALE_SMOOTH);

                    // Set the ImageIcon to the image panel
                    imagePanel.setIcon(new ImageIcon(img));
                }
            }
        }
    } catch (SQLException | ClassNotFoundException  e) {
        e.printStackTrace();
    }
}
    
    public void populateData() {
        String query;
        PreparedStatement st;
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           try(Connection con = DriverManager.getConnection(url, username, password)) {
                       if(carNameSearch.isSelected()) {
                         query = "SELECT car_id, name,price, color, plate_number, capacity FROM cars where name = ?";
                         st = con.prepareStatement(query);
                         st.setString(1, search.getText());
                     } else if(carIDSearch.isSelected()) {
                         query = "SELECT car_id, name,price, color, plate_number, capacity FROM cars where car_id = ?";
                         st = con.prepareStatement(query);
                         st.setInt(1, Integer.valueOf(search.getText()));
                     } else if(plateNumberSearch.isSelected()) {
                         query = "SELECT car_id, name,price, color, plate_number, capacity FROM cars where plate_number = ?";
                         st = con.prepareStatement(query);
                         st.setString(1, search.getText());
                     } else {
                          query = "SELECT car_id, name,price, color, plate_number, capacity FROM cars";
                          st = con.prepareStatement(query);
                     }
                ResultSet rs = st.executeQuery();
                ResultSetMetaData rm = rs.getMetaData();
                
                int getColumnCount = rm.getColumnCount();
                
                DefaultTableModel model = new DefaultTableModel();
                    for(int i = 1 ; i <= getColumnCount; i++) {
                        model.addColumn(rm.getColumnLabel(i));
                    }
                    while(rs.next()) {
                        Object[] rowData = new Object[getColumnCount];
                        for(int i = 1 ; i <= getColumnCount; i++) {
                        rowData[i - 1] = rs.getObject(i);
                        }
                        model.addRow(rowData);
                    }
                    
                    jTable1.setModel(model);
           }
          
       } catch(SQLException e) {
           e.printStackTrace();
       } catch (ClassNotFoundException ex) {
            Logger.getLogger(carHistory1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField carCapacity;
    private javax.swing.JTextField carColor;
    private javax.swing.JRadioButton carIDSearch;
    private javax.swing.JTextField carModel;
    private javax.swing.JRadioButton carNameSearch;
    private javax.swing.JTextField carPlateNumber;
    private javax.swing.JTextField carPrice;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel imagePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton plateNumberSearch;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
