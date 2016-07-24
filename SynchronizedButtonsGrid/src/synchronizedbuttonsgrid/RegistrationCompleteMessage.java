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

import javafx.beans.property.StringProperty;
import javafx.css.SimpleStyleableStringProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Creates a registration complete message message with the user's credentials
 *
 * @author Alexandros Kantas
 */
public class RegistrationCompleteMessage extends Stage {

    private VBox vbox = new VBox(8);
    private StringProperty message;
    private Label label;
    private Button okbtn = new Button("Ok");

    
    public   RegistrationCompleteMessage(String username) {
        message = new SimpleStyleableStringProperty(null, "Registration Complete for user : " + username + " !!!");
        label = new Label(message.getValue());
        label.textProperty().bind(message);

        okbtn.setOnAction(e -> {
            message.setValue("Hi!!!");
        });

        initModality(Modality.APPLICATION_MODAL);
        vbox.getChildren().addAll(label, okbtn);
        vbox.setAlignment(Pos.CENTER);
        VBox.setVgrow(vbox, Priority.ALWAYS);

        Scene scene = new Scene(vbox);
        scene.getStylesheets().add(getClass().getResource("StyleSheet.css").toExternalForm());
        setScene(scene);
        showAndWait();
    }

}
