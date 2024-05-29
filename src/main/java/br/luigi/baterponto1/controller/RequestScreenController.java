package br.luigi.baterponto1.controller;

import br.luigi.baterponto1.Main;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RequestScreenController {
    @FXML
    private TextArea inicioD;
    @FXML
    private TextArea finalD;
    @FXML
    private TextArea comentarios;

    public void receberDados(String comentarios, String inicioD, String finalD) {
        this.comentarios.setText(comentarios);
        this.inicioD.setText(inicioD);
        this.finalD.setText(finalD);
    }
    @FXML
    public void voltarButton(){
        Main.changeScreen("employee");
    }
}
