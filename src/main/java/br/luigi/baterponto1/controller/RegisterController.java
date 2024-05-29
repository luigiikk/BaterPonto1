package br.luigi.baterponto1.controller;

import br.luigi.baterponto1.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.EmployeeDAO;

public class RegisterController {

    @FXML
    private TextField matriculaField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField functionField;

    @FXML
    private CheckBox isAdminCheckBox;

    private EmployeeDAO employeeDAO;

    public RegisterController() {
        this.employeeDAO = new EmployeeDAO();
    }

    @FXML
    protected void registerButtonClick(ActionEvent e) {
        try {
            int matricula = Integer.parseInt(matriculaField.getText());
            int senha = Integer.parseInt(passwordField.getText());
            String name = nameField.getText();
            String function = functionField.getText();
            boolean isAdmin = isAdminCheckBox.isSelected();
            int saldoHoras = 20;
            double salario = 12000;

            System.out.println("Matricula: " + matricula);
            System.out.println("Senha: " + senha);
            System.out.println("Nome: " + name);
            System.out.println("Função: " + function);
            System.out.println("É Admin: " + isAdmin);

            employeeDAO.addEmployee(name, matricula, senha, function, isAdmin, saldoHoras, salario);

            System.out.println("Funcionario adicionado: " + employeeDAO.getEmployee(matricula));
        } catch (NumberFormatException ex) {
            System.err.println("Erro ao converter valores de matrícula ou senha: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Erro ao adicionar funcionário: " + ex.getMessage());
        }
    }
    @FXML
    public void voltarButton(){
        Main.changeScreen("adm");
    }
}
