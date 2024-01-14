package PruebaMatricula;

import Matricula.MatriculaBean;
import Matricula.MatriculaBean.BDModificadaEvent;
import Matricula.MatriculaBean.BDModificadaListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccedeBD implements BDModificadaListener {

    MatriculaBean matriculas;

    AccedeBD() {
        matriculas = new MatriculaBean();
        matriculas.addBDModificadaListener(
                (BDModificadaListener) this);
    }

    public void listado() {
        System.out.println("\033[36m***** LISTADO GENERAL DE MATRÍCULAS *****");
        for (int i = 0; i < matriculas.getSize(); i++) {
            matriculas.seleccionarFila(i);
            System.out.println("Alumno con DNI:" + matriculas.getDNI()
                    + " matriculado en:");
            System.out.println("\tNombre Modulo: "
                    + matriculas.getNombreModulo());
            System.out.println("\tCurso: " + matriculas.getCurso());
            System.out.println("\tNota: " + matriculas.getNota());
        }
    }

    public void listadoDNI(String DNI) throws ClassNotFoundException {
        matriculas.recargarDNI(DNI);
        System.out.println(
                "\033[36m***** LISTADO DE MATRÍCULAS PARA EL DNI " + matriculas.getDNI() + " *****");
        for (int i = 0; i < matriculas.getSize(); i++) {
            matriculas.seleccionarFila(i);
            System.out.println("\tNombre Modulo: "
                    + matriculas.getNombreModulo());
            System.out.println("\tCurso: " + matriculas.getCurso());
            System.out.println("\tNota: " + matriculas.getNota());
        }
    }

    void anade() {
        matriculas.setDNI("98765432B");
        matriculas.setNombreModulo("Programación");
        matriculas.setCurso("21-22");
        matriculas.setNota(7.5);
        try {
            matriculas.addMatricula();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccedeBD.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    @Override
    public void capturarBDModificada(BDModificadaEvent ev) {
        if (ev.modoDni) {
            System.out.println("\033[33mSe ha pedido el listado con DNI a la base de datos");
        } else {
            System.out.println("\033[33mSe ha añadido una nueva matrícula a la base de datos");
        }
    }
}


