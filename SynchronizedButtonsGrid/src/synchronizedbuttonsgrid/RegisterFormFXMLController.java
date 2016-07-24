package synchronizedbuttonsgrid;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

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
/**
 *
 * @author Alexandros Kantas
 */
public class RegisterFormFXMLController implements Initializable {

    @FXML
    private Label errorlabel;
    @FXML
    private Label usernamelabel;
    @FXML
    private Label qnlbl;
    @FXML
    private Button cnlbtn;
    @FXML
    private Button regbtn;
    @FXML
    private TextField qntxt;
    @FXML
    private TextField usernamefield;
    @FXML
    private PasswordField passwordfield;
    @FXML
    private VBox root;

    private int numa, numb, result, userresult;//Number will use to create a question ex. 1+2=? , result is the actual result and userresult the user's input
    private static final char[] operators = {'+', '-', '*'}; //list of operators ex 1+2=? , 1*2=?
    private char operator;// The opperation of question

    @FXML
    private void RegAction(ActionEvent event) {

        //With the folllowing try-catch if qntxt field is emptry or not valid number the method terminates
        try {
            userresult = Integer.parseInt(qntxt.getText().trim());
        } catch (NumberFormatException e) {
            userresult = -100;
            errorlabel.setText("Wrong input, your input is not a validnumber");
            return;
        }
        if (result == userresult) {
            errorlabel.setText("loading...");
            errorlabel.setTextFill(Color.GREEN);
            new RegistrationCompleteMessage(usernamefield.getText().trim());
            errorlabel.setText("");
        } else {
            errorlabel.setText("Wrong input idiot!!! " + numa + " " + operator + " " + numb + " = " + userresult + "??? Are u serious ???");
            genarateQuestion();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genarateQuestion();
    }

    private void genarateQuestion() {
        //Give Random numbers between 1 and 10 in numa-numb
        numa = ThreadLocalRandom.current().nextInt(1, 9);
        numb = ThreadLocalRandom.current().nextInt(1, 9);
        operator = operators[ThreadLocalRandom.current().nextInt(operators.length)];

        switch (operator) {
            case '+':
                result = numa + numb;
                break;
            case '-':
                result = numa - numb;
                break;
            case '*':
                result = numa * numb;
                break;
        }

        qnlbl.setText(" " + numa + " " + operator + " " + numb + " = ?");
        System.out.println("" + result);
    }

}
