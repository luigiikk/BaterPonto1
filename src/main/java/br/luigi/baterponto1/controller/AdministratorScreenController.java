package br.luigi.baterponto1.controller;

import br.luigi.baterponto1.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class AdministratorScreenController {

    @FXML
    protected void registerScreenChange(ActionEvent e) {
        Main.changeScreen("register");
    }
}
