
package Matricula;

import java.beans.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EventListener;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class MatriculaBean implements Serializable {

    static final String url = "jdbc:mysql://localhost:3306/alumnos";
    static final String user = "root";
    static final String pass = "pch1ld77";

    protected String DNI;

    public String getDNI() {

        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    protected String NombreModulo;

    public String getNombreModulo() {
        return NombreModulo;
    }

    public void setNombreModulo(String NombreModulo) {
        this.NombreModulo = NombreModulo;
    }

    protected String Curso;

    public String getCurso() {

        return Curso;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;
    }

    protected double Nota;

    public double getNota() {
        return Nota;
    }

    public void setNota(double Nota) {
        this.Nota = Nota;
    }

    private PropertyChangeSupport propertySupport;

    public MatriculaBean() {
        propertySupport = new PropertyChangeSupport(this);
        try {
            recFilas();
        } catch (ClassNotFoundException ex) {
            this.DNI = "";
            this.NombreModulo = "";
            this.Curso = "";
            this.Nota = 0.0;
            Logger.getLogger(MatriculaBean.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    protected int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    boolean modoDni;

    private class Matricula {

        String DNI;
        String NombreModulo;
        String Curso;
        double Nota;

        public Matricula() {
        }

        public Matricula(String DNI, String NombreModulo, String Curso, double Nota) {
            this.DNI = DNI;
            this.NombreModulo = NombreModulo;
            this.Curso = Curso;
            this.Nota = Nota;
        }

    }

    private Vector Matriculas = new Vector();

    public void recFilas() throws ClassNotFoundException {

        if (!Matriculas.isEmpty()) {
            Matriculas.removeAllElements();
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con
                    = DriverManager.getConnection(url, user, pass);
            java.sql.Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from matriculas");
            while (rs.next()) {
                Matricula a = new Matricula(rs.getString("DNI"),
                        rs.getString("NombreModulo"),
                        rs.getString("Curso"),
                        rs.getDouble("Nota"));
                Matriculas.add(a);
            }
            Matricula matric = new Matricula();
            matric = (Matricula) Matriculas.elementAt(1);
            this.DNI = matric.DNI;
            this.NombreModulo = matric.NombreModulo;
            this.Curso = matric.Curso;
            this.Nota = matric.Nota;

            size = Matriculas.size();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            this.DNI = "";
            this.NombreModulo = "";
            this.Curso = "";
            this.Nota = 0;
            Logger.getLogger(MatriculaBean.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public void seleccionarFila(int i) {
        if (i < Matriculas.size()) {
            Matricula matric = new Matricula();
            matric = (Matricula) Matriculas.elementAt(i);
            this.DNI = matric.DNI;
            this.NombreModulo = matric.NombreModulo;
            this.Curso = matric.Curso;
            this.Nota = matric.Nota;
        } else {
            this.DNI = "";
            this.NombreModulo = "";
            this.Curso = "";
            this.Nota = 0.0;
        }
    }

    public void cargarDNI(String DNI) throws ClassNotFoundException {

        if (!Matriculas.isEmpty()) {
            Matriculas.removeAllElements();
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con
                    = DriverManager.getConnection(url, user, pass);
            PreparedStatement s = con.prepareStatement(
                    "select * from matriculas where DNI = ?");
            s.setString(1, DNI);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                Matricula m = new Matricula(rs.getString("DNI"),
                        rs.getString("NombreModulo"), rs.getString("Curso"),
                        rs.getDouble("Nota"));
                Matriculas.add(m);
            }
            Matricula matric = new Matricula();
            matric = (Matricula) Matriculas.elementAt(1);
            this.DNI = matric.DNI;
            this.NombreModulo = matric.NombreModulo;
            this.Curso = matric.Curso;
            this.Nota = matric.Nota;

            modoDni = true;
            receptor.capturarBDModificada(
                    new BDModificadaEvent(this, modoDni));
            size = Matriculas.size();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            this.DNI = "";
            this.NombreModulo = "";
            this.Curso = "";
            this.Nota = 0;
            Logger.getLogger(MatriculaBean.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    private BDModificadaListener receptor;

    public class BDModificadaEvent extends java.util.EventObject {

        public boolean modoDni;

        public BDModificadaEvent(Object source, boolean modoDNI) {
            super(source);
            modoDni = modoDNI;
        }
    }

    public interface BDModificadaListener extends EventListener {

        public void capturarBDModificada(BDModificadaEvent ev);
    }

    public void addBDModificadaListener(BDModificadaListener receptor) {
        this.receptor = receptor;
    }

    public void removeBDModificadaListener(BDModificadaListener receptor) {
        this.receptor = null;
    }

    public void addMatricula() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con
                    = DriverManager.getConnection(url, user, pass);
            PreparedStatement s = con.prepareStatement(
                    "insert into matriculas values (?,?,?,?)");
            s.setString(1, DNI);
            s.setString(2, NombreModulo);
            s.setString(3, Curso);
            s.setDouble(4, Nota);
            s.executeUpdate();
            recFilas();

            modoDni = false;
            receptor.capturarBDModificada(
                    new BDModificadaEvent(this, modoDni));
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaBean.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public void addPropertyChangeListener(
            PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(
            PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
}

