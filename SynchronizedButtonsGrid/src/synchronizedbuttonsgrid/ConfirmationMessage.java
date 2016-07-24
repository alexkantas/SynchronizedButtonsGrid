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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Alexandros Kantas
 */
public class ConfirmationMessage extends Stage {

    public static final String LOGOUT = "LOGOUT";
    public static final String DELETE_NODE = "DELETE NODE";
    private Stage mainStage;
    private final VBox vbox = new VBox(8);
    private final HBox hbox = new HBox(2);
    private StringProperty message;
    private final Label label = new Label();
    private final Button yesbtn = new Button("Yes");
    private final Button nobtn = new Button("No");

    /**
     * Creates a "Are you sure?" window
     *
     * @param node The name of the node
     */
    public ConfirmationMessage(String node) {
        if (node.equals(LOGOUT)) {
            message = new SimpleStringProperty("Are you sure you want to log out ?");
            setTitle("Delete node ?");
        } else if (node.equals(DELETE_NODE)) {
            message = new SimpleStringProperty("Are you sure you want to delete the node ?");
            setTitle("Logging out ?");
        } else {
            message = new SimpleStringProperty("Are you sure ?");
        }
    }

    /**
     * Creates a "Are you sure?" window
     *
     * @param mainStage The stage the program returns after logout
     */
    public ConfirmationMessage(Stage mainStage) {
        this.mainStage = mainStage;
        message = new SimpleStringProperty("Are you sure you want to log out ?");
        setTitle("Logging out ?");

        yesbtn.setOnAction(e -> {
            logOutAction();
        });

        initialize();
    }

    private void logOutAction() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("LogInFormFXML.fxml"));
        } catch (IOException ex) {
            System.err.println("Problem loading login form");
            return;
        }
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("StyleSheet.css").toExternalForm());
        mainStage.setScene(scene);
        close();
    }

    private void deleteNodeAction() {

    }

    private void initialize() {
        label.textProperty().bind(message);

        nobtn.setOnAction(e -> {
            close();
        });

        initModality(Modality.APPLICATION_MODAL);
        hbox.getChildren().addAll(yesbtn, nobtn);
        hbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(label, hbox);
        vbox.setAlignment(Pos.CENTER);
        VBox.setVgrow(vbox, Priority.ALWAYS);

        Scene scene = new Scene(vbox);
        scene.getStylesheets().add(getClass().getResource("StyleSheet.css").toExternalForm());
        setScene(scene);
        showAndWait();
    }

}
