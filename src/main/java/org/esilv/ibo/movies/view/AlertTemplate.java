package org.esilv.ibo.movies.view;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * Created by Louis on 02/12/2015.
 */

/*
 *  Simple example of Alert.
 *  Use at your convenience.
 */
public class AlertTemplate extends Alert {

    private String[] strings;

    public AlertTemplate(String[] strings) {
        super(AlertType.CONFIRMATION);
        this.strings = strings;
    }

    public boolean showAlert() {

        setTitle("Title" + strings[0]);
        setContentText("Content" + strings[1]);
        Optional<ButtonType> result = showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.OK) {
                return true;
            }
        }
        return false;
    }
}
