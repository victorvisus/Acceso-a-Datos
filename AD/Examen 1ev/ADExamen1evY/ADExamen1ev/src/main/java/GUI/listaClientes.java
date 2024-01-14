/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class listaClientes extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    PreparedStatement pesta;
    ResultSet resulset;
 
    
    
    
    public listaClientes() throws SQLException {
            initComponents();
            setLocationRelativeTo(null);
            inicTabla();
            mostrarClientes();
            
    }
    
    public void inicTabla(){
        
        modelo.setColumnIdentifiers(new String [] {"DNI","Nombre","Apellidos","Dirección","C.P.","Población","E-mail"});
        jTable1.setModel(modelo);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
    }
    
        private void clearTable(){
        for (int i = 0; i < modelo.getRowCount(); i++) {
        modelo.removeRow(i);
        i-=1;
        }
    }
    
    public DefaultTableModel mostrarClientes() throws SQLException{
            
        String [] registros = new String[7];
        
        String sql= "SELECT dni, nombre, apellidos, direccion, cp, poblacion, email FROM cliente";
        pesta = null;
        resulset = null;
        
        try{
        Connection conex = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "pch1ld77AAA");    
        pesta=conex.prepareStatement(sql);
        resulset=pesta.executeQuery();
        while(resulset.next()){
            registros[0] = resulset.getString(String.valueOf("DNI"));
            registros[1] = resulset.getString(String.valueOf("NOMBRE"));
            registros[2] = resulset.getString(String.valueOf("APELLIDOS"));
            registros[3] = resulset.getString(String.valueOf("DIRECCION"));
            registros[4] = (String)resulset.getString(String.valueOf("CP"));
            registros[5] = resulset.getString(String.valueOf("POBLACION"));
            registros[6] = resulset.getString(String.valueOf("EMAIL"));
            modelo.addRow(registros);

        }
        }catch(Exception ex){
            System.err.println("Fucked up");
        }
        return modelo;
       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Listado de clientes:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel8)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar cliente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            this.setVisible(false);
            ventanaPpal venpal = new ventanaPpal();
            venpal.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(listaClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(listaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            int columna = 0;
            int row = jTable1.getSelectedRow();
            String dato = jTable1.getModel().getValueAt(row, columna).toString();
            
            String sql= "DELETE FROM cliente WHERE dni = '"+dato+"'";
            String sql2= "DELETE FROM compra WHERE dni_a = '"+dato+"'";
            
            pesta = null;
            resulset = null;
            
            Connection conex = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "pch1ld77AAA");
            pesta=conex.prepareStatement(sql);
            resulset=pesta.executeQuery();
            
            JOptionPane.showMessageDialog(null,"Todos los datos del cliente y sus ventas han sido eliminados.");
            
            clearTable();
            mostrarClientes();
        } catch (SQLException ex) {
            Logger.getLogger(listaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
