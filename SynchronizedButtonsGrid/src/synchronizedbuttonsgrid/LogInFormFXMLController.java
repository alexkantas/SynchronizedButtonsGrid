/*
 * Copyright (C) 2016 Alexandros Kantas 
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package synchronizedbuttonsgrid;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Alexandros Kantas
 */
public class LogInFormFXMLController {

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        //Get the stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        //Change the scene in the stage by creating a new scene based in GridSizeForm.fxml
        Parent root = FXMLLoader.load(getClass().getResource("GridSizeFormFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

}
