package br.luigi.baterponto1.controller;

import br.luigi.baterponto1.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.Employee;
import model.EmployeeDAO;

import java.net.URL;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class AdministratorScreenController implements Initializable {

    @FXML
    private Label employeeName;
    @FXML
    private Label date;
    @FXML
    private Label hours;
    @FXML
    private Label employeeEnrollment;
    @FXML
    private Label employeeFunction;

    private Employee currentEmployee;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                if (userData instanceof Employee) {
                    currentEmployee = (Employee) userData;
                    employeeName.setText(currentEmployee.getName());
                    employeeEnrollment.setText(String.valueOf(currentEmployee.getEnrollment()));
                    employeeFunction.setText(currentEmployee.getFunction());
                }
                System.out.println("nova tela: " + newScreen + ", " + userData);
            }
        });

        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        DateFormat formataData = DateFormat.getDateInstance();
        DateFormat hora = DateFormat.getTimeInstance();
        date.setText(formataData.format(data));
        hours.setText(hora.format(data));
    }

    @FXML
    protected void registerScreenChange(ActionEvent e) {
        Main.changeScreen("register");
    }

    @FXML
    protected void relatorioButton(ActionEvent e) {
        Main.changeScreen("relatorio", EmployeeDAO.getAllEmployees());
    }

    @FXML
    protected void solicitacaoButton(ActionEvent event) {
        Main.changeScreen("solicitacao");
    }

    @FXML
    public void voltarButton(){
        Main.changeScreen("login");
    }
}
