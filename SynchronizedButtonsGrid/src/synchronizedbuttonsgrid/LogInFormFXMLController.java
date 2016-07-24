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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Alexandros Kantas
 */
public class LogInFormFXMLController implements Initializable {

    @FXML
    private Label errorlabel;
    
    @FXML
    private Button regbtn;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        //Get the stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        //Change the scene in the stage by creating a new scene based in GridSizeForm.fxml
        Parent root = FXMLLoader.load(getClass().getResource("SelectGridFormFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    
    @FXML
    private void loadRegisterForm(ActionEvent event) throws IOException {
        //Get the stage
        Stage regStage = new Stage();
        
        

        //Change the scene in the stage by creating a new scene based in GridSizeForm.fxml
        Parent root = FXMLLoader.load(getClass().getResource("RegisterFormFXML.fxml"));
        regStage.initModality(Modality.APPLICATION_MODAL);
        regStage.setTitle("Register");
        Scene scene = new Scene(root);
        regStage.setScene(scene);
        regStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        regbtn.setOnAction(e->{
//            errorlabel.setText("Wrong username or/and password!" );
//        });
    }

}
