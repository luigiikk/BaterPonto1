package br.luigi.baterponto1.controller;

import br.luigi.baterponto1.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.EmployeeDAO;

public class LoginController {
    @FXML
    private TextField matriculaField;

    @FXML
    private PasswordField passwordField;

    @FXML
    protected void loginButtonClick(ActionEvent e) {
        try {
            int matricula = Integer.parseInt(matriculaField.getText());
            int senha = Integer.parseInt(passwordField.getText());

            System.out.println("Matricula: " + matricula);
            System.out.println("Senha: " + senha);

            EmployeeDAO employeeDAO = new EmployeeDAO();

            if (employeeDAO.isValidEmployee(matricula, senha)) {
                if (employeeDAO.isAdmin(matricula)) {
                    Main.changeScreen("adm");
                } else {
                    Main.changeScreen("employee");
                }
            } else {
                System.err.println("Funcionário inválido ou senha incorreta.");
            }
        } catch (NumberFormatException ex) {
            System.err.println("Erro ao converter matrícula ou senha: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Erro ao tentar fazer login: " + ex.getMessage());
        }
    }
}
