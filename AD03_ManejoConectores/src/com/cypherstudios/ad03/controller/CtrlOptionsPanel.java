package com.cypherstudios.ad03.controller;

import com.cypherstudios.ad03.dao.FlightDAO;
import com.cypherstudios.ad03.dao.PassengerDAO;
import com.cypherstudios.ad03.exceptions.Ad03Exception;
import com.cypherstudios.ad03.view.OptionsPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class CtrlOptionsPanel implements ActionListener {
    
    private OptionsPanel run;
    private PassengerDAO pass = new PassengerDAO();
    
    public CtrlOptionsPanel(OptionsPanel run) {
        
        this.run = run;
        
        try {
            //Completo ComboBox con la lista de vuelos
            FlightDAO.listCodVueloFlight(run);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlOptionsPanel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cargar los datos"
                    + "\nMensaje SQLException: " + ex.getMessage()
                    + "\nCódgio de error: " + ex.getErrorCode());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al listar los pasajeros", JOptionPane.ERROR_MESSAGE);
        }

        //Botón Salir
        this.run.btnExit.addActionListener(this);

        //Manejo de datos masivamente
        this.run.btnDeleteAllData.addActionListener(this);
        this.run.btnEnterAllData.addActionListener(this);

        //Pasajeros
        this.run.btnShowPassengers.addActionListener(this);
        this.run.btnDisplayFlightPassengers.addActionListener(this);
        this.run.btnModifyPassengers.addActionListener(this);
        this.run.btnSavePassenger.addActionListener(this);

        //Vuelos
    }
    
    public void launchApp() {
        run.setVisible(true);

        //Oculto los campos y las etiquetas Destino y procedencia hasta que implemente el cód.
        run.txtFlightDestination.setEditable(false);
        run.txtFlightDestination.setVisible(false);
        run.labelFlightDestination.setVisible(false);

        run.txtFlightOrigin.setEditable(false);
        run.txtFlightOrigin.setVisible(false);
        run.labelFlightOrigin.setVisible(false);

        run.labelListCodeFlight.setVisible(false);

        //Arranco el formulario con los campos de edición de pasajeros desactivados
        run.txtCodVuelo.setEditable(false);
        run.txtCodVuelo.setEnabled(false);
        run.txtNumPassenger.setEditable(false);
        run.txtNumPassenger.setEnabled(false);
        run.cbxSeatTypePassenger.setEditable(false);
        run.cbxSeatTypePassenger.setEnabled(false);
        run.rbtnSmokingNo.setEnabled(false);
        run.rbtnSmokingYes.setEnabled(false);

        // Establezco el titulo y la posición en la pantalla
        run.setTitle("Panel de opciones");
        run.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        int numOption = 0;
        
        if (e.getSource() == run.btnExit) {
            //Cierra la aplicación
            System.exit(0);
        }
        
        try {
            if (e.getSource() == run.btnEnterAllData) {
                evaluateOption(1);
            } else if (e.getSource() == run.btnDeleteAllData) {
                evaluateOption(2);
            } else if (e.getSource() == run.btnShowPassengers) {
                evaluateOption(3);
            } else if (e.getSource() == run.btnDisplayFlightPassengers) {
                evaluateOption(4);
            } else if (e.getSource() == run.btnModifyPassengers) {
                evaluateOption(5);
            } else if (e.getSource() == run.btnSavePassenger) {
                evaluateOption(6);
            } else {
                evaluateOption(99);
            }
        } catch (Ad03Exception ex) {
            Logger.getLogger(CtrlOptionsPanel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Gestión de vuelos", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            System.out.println("Error al listar los pasajeros"
                    + "\nMensaje SQLException: " + ex.getMessage()
                    + "\nCódgio de error: " + ex.getErrorCode());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al listar los pasajeros", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    /**
     * Limpiar el formulario
     */
    private void cleanInputs() {
        run.txtCodVuelo.setText(null);
        run.txtCodVuelo.setEnabled(false);
        run.txtNumPassenger.setText(null);
        run.txtNumPassenger.setEnabled(false);
        run.cbxSeatTypePassenger.setSelectedIndex(0);
        run.cbxSeatTypePassenger.setEnabled(false);
        run.rbtnSmokingNo.setSelected(false);
        run.rbtnSmokingNo.setEnabled(false);
        run.rbtnSmokingYes.setSelected(false);
        run.rbtnSmokingYes.setEnabled(false);
    }

    /**
     * Evaluado el int recibido y llama al método correspondiente
     *
     * @param numOption
     * @throws Ad03Exception
     */
    private void evaluateOption(int numOption) throws SQLException, Ad03Exception {
        switch (numOption) {
            case 1:
                throw new Ad03Exception(1);
            //break;
            case 2:
                throw new Ad03Exception(1);
            //break;
            case 3:
                pass.showPassengers(run);
                break;
            case 4:
                pass.displayFlightPassengers(run);
                //throw new Ad03Exception(1);
                break;
            case 5:
                throw new Ad03Exception(1);
            //break;
            case 6:
                throw new Ad03Exception(1);
            //break;
            default:
                throw new Ad03Exception();
        }
    }
    
}
