package br.luigi.baterponto1.controller;

import br.luigi.baterponto1.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Employee;
import model.EmployeeDAO;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class AnalysisScreenController implements Initializable {
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
    @FXML
    private TableView<Employee> empregados;
    @FXML
    private TableColumn<Employee, String> Funcao;
    @FXML
    private TableColumn<Employee, Integer> Matricula;
    @FXML
    private TableColumn<Employee, Double> salario;
    @FXML
    private TableColumn<Employee, String> horasTotais;
    @FXML
    private TableColumn<Employee, String> horasExtras;
    @FXML
    private TableColumn<Employee, String> horasAPagar;
    @FXML
    private TableColumn<Employee, Double> salarioCalculado;

    private ObservableList<Employee> list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Main.addOnChangeScreenListener((newScreen, userData) -> {
            if (userData instanceof Employee) {
                Employee currentEmployee = (Employee) userData;
                employeeName.setText(currentEmployee.getName());
                employeeEnrollment.setText(String.valueOf(currentEmployee.getEnrollment()));
                employeeFunction.setText(currentEmployee.getFunction());
            }
            System.out.println("nova tela: " + newScreen + ", " + userData);
        });

        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        DateFormat formataData = DateFormat.getDateInstance();
        DateFormat hora = DateFormat.getTimeInstance();
        date.setText(formataData.format(data));
        hours.setText(hora.format(data));

        list = FXCollections.observableArrayList(EmployeeDAO.getAllEmployees());

        Funcao.setCellValueFactory(new PropertyValueFactory<>("function"));
        Matricula.setCellValueFactory(new PropertyValueFactory<>("enrollment"));
        salario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        horasTotais.setCellValueFactory(new PropertyValueFactory<>("horasTotais"));
        horasExtras.setCellValueFactory(new PropertyValueFactory<>("horasExtras"));
        horasAPagar.setCellValueFactory(new PropertyValueFactory<>("horasAPagar"));
        salarioCalculado.setCellValueFactory(new PropertyValueFactory<>("salarioCalculado"));

        empregados.setItems(list);
    }

    public void gerarCSV(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Salvar Arquivo CSV");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Arquivos CSV (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);
        Stage stage = (Stage) empregados.getScene().getWindow();
        File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.append("Função,Matrícula,Salário,Horas Totais,Horas Extras,Horas a Pagar,Salário Calculado\n");
                for (Employee emp : list) {
                    writer.append(emp.getFunction()).append(",");
                    writer.append(String.valueOf(emp.getEnrollment())).append(",");
                    writer.append(String.valueOf(emp.getSalario())).append(",");
                    writer.append(emp.getHorasTotais()).append(",");
                    writer.append(emp.getHorasExtras()).append(",");
                    writer.append(emp.getHorasAPagar()).append(",");
                    writer.append(String.valueOf(emp.getSalarioCalculado())).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void voltarButton() {
        Main.changeScreen("adm");
    }
}
