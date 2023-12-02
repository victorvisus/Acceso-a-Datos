package com.cypherstudios.ad03.controller;

import com.cypherstudios.ad03.dao.FlightDAO;
import com.cypherstudios.ad03.dao.PassengerDAO;
import com.cypherstudios.ad03.exceptions.Ad03Exception;
import com.cypherstudios.ad03.model.FlightModel;
import com.cypherstudios.ad03.view.OptionsPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class CtrlOptionsPanel implements ActionListener {

    private OptionsPanel run;
    private PassengerDAO opPass = new PassengerDAO();
    protected final FlightDAO opFly = new FlightDAO();
    private FlightModel fly;

    public CtrlOptionsPanel(OptionsPanel run) {

        this.run = run;

        try {
            //Completo ComboBox con la lista de vuelos
            opFly.listCodVueloFlight(run);
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
        //Evento de ratón en la Tabla
        this.run.jtPassengersList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //Llamo al método que va a cargar los datos en los campos
                opPass.getSelectedPasseger(run, e);

                /*
                Me gustaria que se enviara a actionPerformed() (al igual que los
                botones) para que luego lo pase a evaluateOption() para que fuera
                ahi donde se llamara al metodo, al igual que el resto de listeners
                 */
            }
        }
        );

        //Vuelos
        this.run.btnDeleteFlight.addActionListener(this);
        this.run.btnSaveFlight.addActionListener(this);
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
        run.labelCodVuelo.setEnabled(false);

        run.txtNumPassenger.setEditable(false);
        run.txtNumPassenger.setEnabled(false);
        run.labelNumPassenger.setEnabled(false);

        run.cbxSeatTypePassenger.setEditable(false);
        run.cbxSeatTypePassenger.setEnabled(false);
        run.labelTipoPlazaPassenger.setEnabled(false);

        run.rbtnSmokingNo.setEnabled(false);
        run.rbtnSmokingYes.setEnabled(false);
        run.labelFumadorPassenger.setEnabled(false);

        run.btnSavePassenger.setEnabled(false);

        // Establezco el titulo y la posición en la pantalla
        run.setTitle("Panel de opciones");
        run.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        int numOption = 0;
        if (e.getSource() == run.btnExit) {
            //Cierra la aplicación
            System.exit(0);
        }

        //Botones
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
            } else if (e.getSource() == run.btnDeleteFlight) {
                evaluateOption(7);
            } else if (e.getSource() == run.btnSaveFlight) {
                evaluateOption(8);
            } else {
                evaluateOption(99);
            }
        } catch (Ad03Exception ex) {
            //Logger.getLogger(CtrlOptionsPanel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Gestión de vuelos", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            System.out.println("Error al listar los pasajeros"
                    + "\nMensaje SQLException: " + ex.getMessage()
                    + "\nCódgio de error: " + ex.getErrorCode());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al listar los pasajeros", JOptionPane.ERROR_MESSAGE);
        }

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
                //Importar datos de ejemplo - Ej. 1
                throw new Ad03Exception(1);
            //break;
            case 2:
                //ELiminar todos los datos de la bbd - Ej. 2
                throw new Ad03Exception(1);
            //break;
            case 3:
                //Listar todos los pasajeros - Ej. 3
                opPass.showPassengers(run);
                break;
            case 4:
                //Mostrar en la tabla los pasajeros del vuelo seleccionado - Ej. 4
                opPass.displayFlightPassengers(run);
                break;
            case 5:
                //Modificar Pasajeros - Ej.7: btn que activa los campos para modificar
                if (!run.txtCodVuelo.getText().equals("")) {
                    opPass.modifyPassengers(run);
                } else {
                    throw new Ad03Exception(5);
                }
                break;
            case 6:
                //Actualizar pasajero en la bbdd - Ej.7: ÇGuardar en la bbdd
                opPass.savePassengers(run);
                JOptionPane.showMessageDialog(null, "Pasajero actualizado", "Gestión de pasajeros", JOptionPane.INFORMATION_MESSAGE);
                cleanInputs();
                break;
            case 7:
                //Eliminar vuelo - Ej. 6
                String codVuelo = run.cbxListCodeFlight.getSelectedItem().toString();
                //Creo el objeto para poder usar sus métodos
                fly = new FlightModel(codVuelo);

                //Deberia lanzar un mensaje si el vuelo tiene pasajeros, para comunicarlo al usuario
                if (opPass.countPassengers(codVuelo) <= 0) {
                    opFly.deleteFlight(codVuelo);
                } else {
                    opPass.deletePassengers(codVuelo);
                    opFly.deleteFlight(codVuelo);
                }

                JOptionPane.showMessageDialog(null, "Vuelo " + codVuelo + " eliminado correctamente.", "Gestión de vuelos", JOptionPane.INFORMATION_MESSAGE);
                //Actualiza la lista de vuelos en el combobox
                opFly.listCodVueloFlight(run);
                break;
            case 8:
                //Guardar vuelo - Ej. 5
                fly = new FlightModel();

                fly.setCodVuelo(run.txtCodVueloIn.getText());
                fly.setDepartureTime((Date) run.dateDepartureIn.getValue());
                fly.setFlighDestination(run.txtFlighDestinationIn.getText());
                fly.setFlightOrigin(run.txtFlightOriginIn.getText());
                fly.setNumEconomySeats(run.txtNumFirstClassSeatIn.getText());
                fly.setNumFirstClassSeat(run.txtNumFirstClassSeatIn.getText());
                fly.setNumNonSmokingSeat(run.txtNumNonSmokingSeatIn.getText());
                fly.setNumSmokingSeat(run.txtNumSmokingSeatIn.getText());

                //Compruebo que no existe un vuelo con el mismo código, si existe lanza un error
                opFly.flightExist(fly.getCodVuelo());
                opFly.createNewFlight(fly);

                JOptionPane.showMessageDialog(null, "Vuelo " + fly.getCodVuelo() + " añadido correctamente.\n" + fly.toString(), "Gestión de vuelos", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Vuelo " + fly.getCodVuelo() + " añadido correctamente.", "Gestión de vuelos", JOptionPane.INFORMATION_MESSAGE);
                cleanInputs();
            //throw new Ad03Exception(1);
            //break;
            default:
                throw new Ad03Exception();
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

        run.txtCodVueloIn.setText(null);
        //run.dateDepartureIn.setValue(null); -- Quiero resetear este campo
        run.txtFlighDestinationIn.setText(null);
        run.txtFlightOriginIn.setText(null);
        run.txtNumFirstClassSeatIn.setText(null);
        run.txtNumFirstClassSeatIn.setText(null);
        run.txtNumNonSmokingSeatIn.setText(null);
        run.txtNumSmokingSeatIn.setText(null);
    }

}
