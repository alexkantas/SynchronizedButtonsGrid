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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Alexandros Kantas
 */
public class GridSizeFormFXMLController implements Initializable {

    @FXML
    private Button crtbtn, bckbtn;

    @FXML
    private TextField rowfield, colfield, namefield;

    @FXML
    private Label errorlabel;

    private int Rows, Columns;

    private String name;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        //Get the stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        //
        Parent root = FXMLLoader.load(getClass().getResource("LogInFormFXML.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("StyleSheet.css").toExternalForm());
        stage.setScene(scene);
    }

    @FXML
    private void loadGrid() {
        try {
            Rows = Integer.parseInt(rowfield.getText().trim());
            Columns = Integer.parseInt(colfield.getText().trim());
            if(namefield.getText().isEmpty()){
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            errorlabel.setText("Wrong input, your input in grid dimensions is not a validnumber");
            return;
        } catch (IllegalArgumentException e) {
            errorlabel.setText("Wrong name, the field is empty");
        } finally {
            name=namefield.getText();
        }
        
        new InteractiveGrid(Rows, Columns, name);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
