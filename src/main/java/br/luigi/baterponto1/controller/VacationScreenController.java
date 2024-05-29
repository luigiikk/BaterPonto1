package br.luigi.baterponto1.controller;

import br.luigi.baterponto1.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;

import java.time.LocalDate;

public class VacationScreenController {
    @FXML
    private DatePicker dataInicio;
    @FXML
    private DatePicker dataTermino;

    @FXML
    private TextArea comentariosFerias;





    @FXML
    public void dataInicio(ActionEvent event) {
        System.out.println(dataInicio.getValue());
    }

    @FXML
    public void dataTermino(ActionEvent event) {
        System.out.println(dataTermino.getValue());
    }


    @FXML
    public void enviarButton(ActionEvent e) {
        String inicioD = dataInicio.getValue().toString();
        String finalD = dataTermino.getValue().toString();
        String comentarios = comentariosFerias.getText();

        Main.changeScreen("request", inicioD, finalD, comentarios);
    }
    @FXML
    public void voltarButton(){
        Main.changeScreen("employee");
    }
}

