/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package om;

import hris.ConnectionManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author i5
 */
public class empcred extends javax.swing.JPanel {

    /**
     * Creates new form empcred
     */
    Connection con;
    Statement stmt;
    ResultSet rs;
    DefaultTableModel model;
    
    public empcred() {
        initComponents();
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel29 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jPanel9.setBackground(java.awt.Color.white);
        jPanel9.setPreferredSize(new java.awt.Dimension(1098, 688));

        jLabel63.setText("Employee Number:");

        jLabel64.setText("First Name:");

        jLabel65.setText("Last Name:");

        jButton6.setText("SEARCH");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("CLEAR");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("UPDATE RECORD");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("REMOVE RECORD");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1001, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee Number", "First Name", "Last Name", "Company email", "LOB", "Operation Manager", "Position", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable2);

        jScrollPane15.setViewportView(jScrollPane4);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel64)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel63)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(59, 59, 59)
                        .addComponent(jLabel65)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel63)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton6)
                        .addComponent(jButton8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel64)
                        .addComponent(jLabel65)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7)
                        .addComponent(jButton9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1066, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 1066, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private String getStringValue(Object obj) {
    if (obj == null) {
        return ""; // Or whatever default value you want to return for null
    }
    return obj.toString();
}
    
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
   // TODO add your handling code here:
   //remove the selected row
   int selectedRow = jTable2.getSelectedRow();
    
    // Check if any row is selected
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row to remove", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // Retrieve the EmployeeID of the selected row
    int employeeID = (int) jTable2.getValueAt(selectedRow, 0);
    
    try {
        // Establish database connection
        Connection con = ConnectionManager.getConnection();
        
        // Prepare the SQL delete statement
        String deleteQuery = "DELETE FROM cred WHERE EmployeeID = ?";
        PreparedStatement pstmt = con.prepareStatement(deleteQuery);
        
        // Set the parameter for the EmployeeID
        pstmt.setInt(1, employeeID);
        
        // Execute the delete statement
        int rowsDeleted = pstmt.executeUpdate();
        
        // Close resources
        pstmt.close();
        con.close();
        
        // Check if any rows were deleted
        if (rowsDeleted > 0) {
            JOptionPane.showMessageDialog(this, "Row removed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            
            // Reload the data in jTable2
            loadData();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to remove row", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
     DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    int selectedRow = jTable2.getSelectedRow(); // Get the selected row index

    if (selectedRow == -1) {
        // No row is selected
        JOptionPane.showMessageDialog(this, "Please select a row to update", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        Connection con = ConnectionManager.getConnection();
        String query = "UPDATE cred SET Status = ?, emp_fname = ?, emp_lname = ?, cEmail = ?, LOB = ?, OM = ?, Position = ? WHERE EmployeeID = ?";
        PreparedStatement pstmt = con.prepareStatement(query);

        // Retrieve data from the selected row
        String empID = model.getValueAt(selectedRow, 0).toString(); // Assuming EmployeeID is in the first column
        String status = model.getValueAt(selectedRow, 7).toString(); // Assuming Status is in the eighth column
        String emp_fname = model.getValueAt(selectedRow, 1).toString(); // Assuming emp_fname is in the second column
        String emp_lname = model.getValueAt(selectedRow, 2).toString(); // Assuming emp_lname is in the third column
        String cEmail = model.getValueAt(selectedRow, 3).toString(); // Assuming cEmail is in the fourth column
        String LOB = model.getValueAt(selectedRow, 4).toString(); // Assuming LOB is in the fifth column
        String OM = model.getValueAt(selectedRow, 5).toString(); // Assuming OM is in the sixth column
        String Position = model.getValueAt(selectedRow, 6).toString(); // Assuming Position is in the seventh column

        // Set parameters for the prepared statement
        pstmt.setString(1, status);
        pstmt.setString(2, emp_fname);
        pstmt.setString(3, emp_lname);
        pstmt.setString(4, cEmail);
        pstmt.setString(5, LOB);
        pstmt.setString(6, OM);
        pstmt.setString(7, Position);
        pstmt.setString(8, empID);

        // Execute the update
        int rowsUpdated = pstmt.executeUpdate();
        System.out.println("Rows updated: " + rowsUpdated);
        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(this, "Employee updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadData(); // Assuming this method reloads the data in the JTable
        } else {
            JOptionPane.showMessageDialog(this, "No rows were updated", "Error", JOptionPane.ERROR_MESSAGE);
        }
        con.close(); // Close the connection
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error updating employee: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        searchData();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        clearFields(); 
    }//GEN-LAST:event_jButton7ActionPerformed
 
 


     // Method to clear text fields
    private void clearFields() {
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
    }
    
    // Method to update existing employee
    
      // Method to add mouse listener to jTable2
    private void addTableListener() {
        jTable2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = jTable2.getSelectedRow();
                if (selectedRow != -1) {
                    jTextField5.setText(jTable2.getValueAt(selectedRow, 0).toString());
                    jTextField6.setText(jTable2.getValueAt(selectedRow, 1).toString());
                    jTextField7.setText(jTable2.getValueAt(selectedRow, 2).toString());
                }
            }
        });
    }
  
    private void searchData() {
    String employeeID = jTextField5.getText().trim(); // Assuming jTextField5 is for Employee ID
    String firstName = jTextField6.getText().trim(); // Assuming jTextField6 is for First Name
    String lastName = jTextField7.getText().trim(); // Assuming jTextField7 is for Last Name

    try {
        con = ConnectionManager.getConnection();
        stmt = con.createStatement();

        // Construct the SQL query based on the search criteria
        String query = "SELECT * FROM cred WHERE 1=1"; // 1=1 is used as a placeholder for dynamic conditions

        if (!employeeID.isEmpty()) {
            query += " AND EmployeeID = '" + employeeID + "'";
        }
        if (!firstName.isEmpty()) {
            query += " AND emp_fname LIKE '%" + firstName + "%'";
        }
        if (!lastName.isEmpty()) {
            query += " AND emp_lname LIKE '%" + lastName + "%'";
        }

        rs = stmt.executeQuery(query);

        // Clear existing table data
        model.setRowCount(0);

        // Add search results to the table model
        while (rs.next()) {
        model.addRow(new Object[]{
            rs.getInt("EmployeeID"),
            rs.getString("emp_fname"),
            rs.getString("emp_lname"),
            rs.getString("cEmail"),
            rs.getString("LOB"),
            rs.getString("OM"),
            rs.getString("Position"), // corrected typo here
            rs.getString("Status")
        });
            }


        // If no agents were found, show a JOptionPane

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

    
    private void loadData() {
        try {
            con = ConnectionManager.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery("SELECT * from cred");

            // Create a DefaultTableModel with column names
            String[] columnNames = {"Employee Number", "First Name", "Last Name", "Company email", "LOB", "Operation Manager", "Position", "Status"};
            model = new DefaultTableModel(columnNames, 0);

            while (rs.next()) {
        model.addRow(new Object[]{
            rs.getInt("EmployeeID"),
            rs.getString("emp_fname"),
            rs.getString("emp_lname"),
            rs.getString("cEmail"),
            rs.getString("LOB"),
            rs.getString("OM"),
            rs.getString("Position"), // corrected typo here
            rs.getString("Status")
        });
            }

            // Once all data is loaded, set the model to your JTable
            jTable2.setModel(model);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables

}
