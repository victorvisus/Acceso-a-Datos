package com.cypherstudios.ad03.app;

import com.cypherstudios.ad03.controller.CtrlOptionsPanel;
import com.cypherstudios.ad03.view.OptionsPanel;

/**
 *
 * @author Victor
 */
public class LaunchApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OptionsPanel form = new OptionsPanel();

        CtrlOptionsPanel ctrl = new CtrlOptionsPanel(form);

        ctrl.launchApp();
        form.setVisible(true);
    }

}
