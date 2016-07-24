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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Alexandros Kantas
 */
public class SelectGridFormFXMLController implements Initializable {

    @FXML
    private VBox gridspane;
    @FXML
    private Button plusbtn;
    @FXML
    private Button logoutbtn;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        //Get the stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        //Change the scene in the stage by creating a new scene based in GridSizeForm.fxml
        Parent root = FXMLLoader.load(getClass().getResource("GridSizeFormFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        logoutbtn.setOnAction(event -> {
            GridButton gridbtn = new GridButton("Hi");
            gridspane.getChildren().add(gridbtn);

            //new ConfirmationMessage((Stage) ((Node) event.getSource()).getScene().getWindow());
        });

    }

    /**
     * Creates a button in a AnchorPane with appropriate color
     */
    public class GridButton extends AnchorPane implements EventHandler<ActionEvent> {

        /**
         *
         * @param gridname The name of grid and text in button
         */
        public GridButton(String gridname) {
            Button btn = new Button(gridname);
            btn.getStyleClass().add("gridbtn");
            btn.setOnAction(this);
            getChildren().add(btn);
            setLeftAnchor(btn, 20.0);
            setRightAnchor(btn, 20.0);
        }

        @Override
        public void handle(ActionEvent event) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
