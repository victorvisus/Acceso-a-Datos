package com.cypherstudios.ad03.app;

import com.cypherstudios.ad03.controller.CtrlOptionsPanel;
import com.cypherstudios.ad03.view.OptionsPanel;

/**
 *
 * @author Victor
 */
public class LaunchApp {

    /**
     * Lanza la aplicación
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OptionsPanel run = new OptionsPanel();

        CtrlOptionsPanel ctrl = new CtrlOptionsPanel(run);

        ctrl.launchApp();
        run.setVisible(true);
    }

}
