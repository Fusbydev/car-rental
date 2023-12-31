/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package car.rental.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kirkf
 */
public class carHistory1 extends javax.swing.JFrame {

    String url = "jdbc:mysql://localhost:3306/example";
    String username = "root";
    String password = "password";
    
    String plateNumber;
    public carHistory1(String plateNumber) throws ClassNotFoundException {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.plateNumber = plateNumber;
        initComponents();
        fetchFromDatabase(plateNumber);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(164, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void fetchFromDatabase(String plate) {
    
    try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           String query = "SELECT * FROM rentalrecords where plate_number = ?";
           try(Connection con = DriverManager.getConnection(url, username, password)) {
                PreparedStatement st = con.prepareStatement(query);
                st.setString(1, plate);
                
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
