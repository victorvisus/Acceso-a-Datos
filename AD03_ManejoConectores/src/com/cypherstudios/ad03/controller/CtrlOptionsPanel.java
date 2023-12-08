package com.cypherstudios.ad03.controller;

import com.cypherstudios.ad03.dao.FlightDAO;
import com.cypherstudios.ad03.dao.PassengerDAO;
import com.cypherstudios.ad03.exceptions.Ad03Exception;
import com.cypherstudios.ad03.model.ExampleDataConstructor;
import com.cypherstudios.ad03.model.FlightModel;
import com.cypherstudios.ad03.utils.utils;
import com.cypherstudios.ad03.view.OptionsPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Controlador que gestiona la lógica de la interfaz gráfica de usuario (GUI)
 * representada por la clase OptionsPanel.
 *
 * @author Victor
 */
public class CtrlOptionsPanel implements ActionListener {

    private final OptionsPanel run;
    protected final PassengerDAO opPass = new PassengerDAO();
    protected final FlightDAO opFly = new FlightDAO();
    private FlightModel fly;

    /**
     * Constructor que recibe una instancia de OptionsPanel para gestionar sus
     * eventos.
     *
     * @param run La instancia de OptionsPanel asociada al controlador.
     */
    public CtrlOptionsPanel(OptionsPanel run) {
        // Inicializa la instancia de OptionsPanel //
        this.run = run;

        // Lógica para cargar datos y configurar la interfaz //
        try {
            //Completo ComboBox con la lista de vuelos, 1º comprueba que exista la tabla vuelos
            if (!opFly.checkTableVuelos()) {
                JOptionPane.showMessageDialog(null, "La tabla vuelos no existe.\nPrimero deberas Importar los datos de ejemplo,\nen este proceso se creará la tabla.", "Crear", JOptionPane.ERROR_MESSAGE);

                //Manejo de datos masivamente
                this.run.btnDeleteAllData.setEnabled(false);

                //Pasajeros
                this.run.btnShowPassengers.setEnabled(false);
                this.run.btnDisplayFlightPassengers.setEnabled(false);
                this.run.btnModifyPassengers.setEnabled(false);
                this.run.jtPassengersList.setEnabled(false);

                //vuelos
                this.run.btnDeleteFlight.setEnabled(false);
                this.run.btnSaveFlight.setEnabled(false);
            } else {
                opFly.listCodVueloFlight(run);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlOptionsPanel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cargar los datos"
                    + "\nMensaje SQLException: " + ex.getMessage()
                    + "\nCódgio de error: " + ex.getErrorCode());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al listar los vuelos en el ComboBox", JOptionPane.ERROR_MESSAGE);
        }

        // Configuración de eventos y botones //
        //
        //Botón Salir
        this.run.btnExit.addActionListener(this);

        //Manejo de datos masivamente
        this.run.btnDeleteAllData.addActionListener(this);
        this.run.btnInsertAllData.addActionListener(this);

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

    /**
     * Inicia la aplicación y muestra la interfaz gráfica.
     */
    public void launchApp() {
        // Configuración inicial de la interfaz //
        //
        // Muestra la interfaz gráfica
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
        run.setTitle("Panel de opciones - Tarea AD03");
        run.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Manejo de eventos de botones //

        if (e.getSource() == run.btnExit) {
            //Cierra la aplicación
            System.exit(0);
        }

        //Botones
        try {
            if (e.getSource() == run.btnInsertAllData) {
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
            System.err.println("Error al listar los pasajeros"
                    + "\nMensaje SQLException: " + ex.getMessage()
                    + "\nCódgio de error: " + ex.getErrorCode());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al listar los pasajeros", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Método para evaluar la opción seleccionada y realizar la acción
     * correspondiente.
     *
     * @param numOption El número de la opción seleccionada.
     * @throws Ad03Exception Si ocurre una excepción específica de Ad03.
     * @throws SQLException Si ocurre una excepción SQL.
     */
    private void evaluateOption(int numOption) throws SQLException, Ad03Exception {
        // Lógica para evaluar y realizar acciones según la opción seleccionada //
        switch (numOption) {
            case 1:
                //Importar datos de ejemplo - Ej. 1
                opFly.insertFlights(ExampleDataConstructor.constExampleDataFlights());
                opFly.listCodVueloFlight(run);
                opPass.insertPassengers(ExampleDataConstructor.constExampleDataPassengers());

                JOptionPane.showMessageDialog(null, "Datos de ejemplo insertados correctamente",
                        "AD03 - Tarea", JOptionPane.INFORMATION_MESSAGE);
                enableButtons();
                break;
            case 2:
                //ELiminar todos los datos de la bbd - Ej. 2
                opPass.deletePassengers("");
                JOptionPane.showMessageDialog(null, "Pasajeros eliminados",
                        "AD03 - Tarea", JOptionPane.INFORMATION_MESSAGE);

                opFly.deleteFlight("");
                JOptionPane.showMessageDialog(null, "Vuelos eliminados",
                        "AD03 - Tarea", JOptionPane.INFORMATION_MESSAGE);
                run.cbxListCodeFlight.removeAllItems();
                break;
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
                opPass.modifyPassengers(run);
                break;
            case 6:
                //Actualizar pasajero en la bbdd - Ej.7: ÇGuardar en la bbdd
                opPass.savePassengers(run);
                JOptionPane.showMessageDialog(null, "Pasajero actualizado", "Gestión de pasajeros", JOptionPane.INFORMATION_MESSAGE);
                utils.cleanInputs(run);
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
                if (utils.checkHour(run.hourDepartureIn.getText())) {
                    fly.setDepartureTime(run.dateDepartureIn.getDate(), run.hourDepartureIn.getText());
                }
                fly.setFlighDestination(run.txtFlighDestinationIn.getText());
                fly.setFlightOrigin(run.txtFlightOriginIn.getText());
                fly.setNumEconomySeats(Integer.parseInt(run.txtNumFirstClassSeatIn.getText()));
                fly.setNumFirstClassSeat(Integer.parseInt(run.txtNumFirstClassSeatIn.getText()));
                fly.setNumNonSmokingSeat(Integer.parseInt(run.txtNumNonSmokingSeatIn.getText()));
                fly.setNumSmokingSeat(Integer.parseInt(run.txtNumSmokingSeatIn.getText()));

                //Compruebo que no existe un vuelo con el mismo código, si existe lanza un error
                opFly.flightExist(fly.getCodVuelo());
                opFly.createNewFlight(fly);

                JOptionPane.showMessageDialog(null, "Vuelo " + fly.getCodVuelo() + " añadido correctamente.\n" + fly.toString(), "Gestión de vuelos", JOptionPane.INFORMATION_MESSAGE);

                //Limpia los campos del formulario
                utils.cleanInputs(run);
                //Actualiza la lista de buelos en el desplegable
                opFly.listCodVueloFlight(run);

                break;
            default:
                throw new Ad03Exception();
        }
    }

    /**
     * Método para habilitar botones en la interfaz gráfica.
     */
    private void enableButtons() {

        //Manejo de datos masivamente
        this.run.btnDeleteAllData.setEnabled(true);

        //Pasajeros
        this.run.btnShowPassengers.setEnabled(true);
        this.run.btnDisplayFlightPassengers.setEnabled(true);
        this.run.btnModifyPassengers.setEnabled(true);
        this.run.jtPassengersList.setEnabled(true);

        //vuelos
        this.run.btnDeleteFlight.setEnabled(true);
        this.run.btnSaveFlight.setEnabled(true);

    }

}
