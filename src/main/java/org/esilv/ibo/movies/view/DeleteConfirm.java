package org.esilv.ibo.movies.view;

import javafx.beans.NamedArg;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * Created by juhel on 24/11/2015.
 */
public class DeleteConfirm extends Alert{

    public DeleteConfirm() {
        super(AlertType.CONFIRMATION);
    }

    public boolean doDelete()
    {
        setTitle("Are you sure ?");
        setContentText("Delete this movie ?");
        Optional<ButtonType> result = showAndWait();
        if(result.isPresent()) {
            if (result.get() == ButtonType.OK) {
                return true;
            }
        }
        return false;
    }
}
