/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package om;
import hris.ConnectionManager;
import hris.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import om.*;

/**
 *
 * @author i5
 */
public class Callib1 extends javax.swing.JPanel {

    /**
     * Creates new form ProdRec
         */
    Connection con;
    Statement stmt;
    ResultSet rs;
    DefaultTableModel model;
    User user;
    public String attendanceScore = "";
    public Callib1() {
        initComponents();
        loadData();
        qa_date.setDate(new Date());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new jdev.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        callib_score = new javax.swing.JTextField();
        qa_id = new javax.swing.JTextField();
        qa_name = new javax.swing.JTextField();
        qa_date = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setText("CALLIBRATION SCORE CHECKER");

        jLabel2.setText("ID:");

        jLabel4.setText("Name:");

        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Date:");

        jLabel5.setText("Callibration Score");

        callib_score.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                callib_scoreActionPerformed(evt);
            }
        });

        qa_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qa_idKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qa_idKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addGap(1157, 1157, 1157))
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(891, 891, 891))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(qa_name, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(qa_date, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(qa_id, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(callib_score, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(qa_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(qa_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(qa_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(callib_score, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(364, Short.MAX_VALUE))
        );

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable10.setSelectionBackground(new java.awt.Color(204, 204, 255));
        jTable10.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(jTable10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 887, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2244, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           try {
        String fname = qa_name.getText();
        String ids = qa_id.getText();
        String qascore = callib_score.getText();

        // Check if the fields are not empty
        if (fname.isEmpty() || ids.isEmpty() || qascore.isEmpty()) {
            // Display an error message if any of the fields is empty
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Prepare the INSERT or UPDATE query
        Connection con = ConnectionManager.getConnection();
        String queryCheck = "SELECT * FROM performance WHERE EmployeeID = ?";
        PreparedStatement pstmtCheck = con.prepareStatement(queryCheck);
        pstmtCheck.setString(1, ids);
        ResultSet rsCheck = pstmtCheck.executeQuery();
        if (rsCheck.next()) {
            // If the ID already exists, perform an update operation
            String queryUpdate = "UPDATE performance SET callib = ?, date = ?, modified_by = ? WHERE EmployeeID = ?";
            PreparedStatement pstmtUpdate = con.prepareStatement(queryUpdate);
            String date = qa_date.getDate().toString();
            pstmtUpdate.setInt(1, Integer.parseInt(callib_score.getText()));
            pstmtUpdate.setString(2, date);
            pstmtUpdate.setString(3, User.getEmployeeName());
            pstmtUpdate.setInt(4, Integer.parseInt(qa_id.getText()));
            int rowsUpdated = pstmtUpdate.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Productivity data updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update productivity data", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // If the ID doesn't exist, perform an insert operation
            String queryInsert = "INSERT INTO performance (EmployeeID, name, date,callib, modified_by) VALUES (?, ?, ?, ?, ?)";
            
            String emp = user.getEmployeeName();
            PreparedStatement pstmtInsert = con.prepareStatement(queryInsert);
            String date = qa_date.getDate().toString();
            pstmtInsert.setInt(1, Integer.parseInt(qa_id.getText()));
            pstmtInsert.setString(2, fname);
            pstmtInsert.setString(3, date);
            pstmtInsert.setInt(4, Integer.parseInt(callib_score.getText()));
            pstmtInsert.setString(5, emp);
            int rowsInserted = pstmtInsert.executeUpdate();
            
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Productivity data inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to insert productivity data", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        loadData();
    } catch (Exception e) {
        // Handle any exceptions that occur during the operation
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void loadData() {
    try (Connection con = ConnectionManager.getConnection();
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM performance");
    ) {
        // Create a DefaultTableModel with column names
        String[] columnNames = {"ID", "Name", "Callibration Score"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Iterate over the ResultSet and add each row to the model
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("EmployeeID"),
                rs.getString("name"),
                rs.getInt("callib") + "%"
            });
        }

        // Set the model to the JTable
        jTable10.setModel(model);
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
 private int getEmployeeAbsences(int employeeId) {
            int absences = 0;

            try {
                con = ConnectionManager.getConnection();
                String query = "SELECT DATE(timestamp) as date, COUNT(CASE WHEN status = 'Day In' THEN 1 END) as day_in_count, "
                             + "COUNT(CASE WHEN status = 'Day Out' THEN 1 END) as day_out_count "
                             + "FROM dtr WHERE EmployeeID = ? "
                             + "GROUP BY DATE(timestamp)";

                PreparedStatement pst = con.prepareStatement(query);
                pst.setInt(1, employeeId);

                rs = pst.executeQuery();

                while (rs.next()) {
                    int dayInCount = rs.getInt("day_in_count");
                    int dayOutCount = rs.getInt("day_out_count");

                    // Consider it an absence if any day lacks either a "Day In" or "Day Out" entry
                    if (dayInCount == 0 || dayOutCount == 0) {
                        absences++;
                    }
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }  
            return absences;
        }
    
    private void qa_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qa_idKeyTyped
                                                      // TODO add your handling code here:
    }//GEN-LAST:event_qa_idKeyTyped

    private void qa_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qa_idKeyReleased
        // TODO add your handling code here
          String id = qa_id.getText().trim();
            // Call the method to retrieve employee information based on the ID
            if(id.isEmpty()){
                qa_name.setText("");
                callib_score.setText("");
            }

        handleIDKeyReleased(id);
            getEmployeeByID(id);        // TODO add your handling code here:   
    }//GEN-LAST:event_qa_idKeyReleased

    private void callib_scoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_callib_scoreActionPerformed
          
    }//GEN-LAST:event_callib_scoreActionPerformed
         private void handleIDKeyReleased(String id) {
    if (!id.isEmpty()) {
        try {
            int employeeID = Integer.parseInt(id); // Convert the ID to an integer

            int absences = getEmployeeAbsences(employeeID);
            
            if (absences >= 2) {
                attendanceScore = "20";
            } else if (absences == 1) {
                attendanceScore ="60";
            } else {
                attendanceScore = "100";
            }
            con.close();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid ID format.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving information: " + ex.getMessage());
        }
    }
}
    
     private void getEmployeeByID(String id){
    // Implement the logic to retrieve employee information based on the ID
    // You can perform database queries or other operations here
    // For example:
    try {
        con = ConnectionManager.getConnection();
            stmt = con.createStatement();

        // Execute a SELECT query to retrieve data from the "emp_info" table based on the employee ID
       String query = "SELECT * FROM emp_info WHERE EmployeeID = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, id);
        rs = pstmt.executeQuery();
        
        while(rs.next()){

                   qa_name.setText(rs.getString("emp_fname") + " " + rs.getString("emp_lname"));
        }
         
        
        // Process the ResultSet and display or handle the retrieved employee information
        // For example, you can display the information in JTextFields or other components

    } catch (SQLException ex) {
        ex.printStackTrace(); // Handle SQL exceptions
    }
     }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField callib_score;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable10;
    private com.toedter.calendar.JDateChooser qa_date;
    private javax.swing.JTextField qa_id;
    private javax.swing.JTextField qa_name;
    private jdev.swing.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}
