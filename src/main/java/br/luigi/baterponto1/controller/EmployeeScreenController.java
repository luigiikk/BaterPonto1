package br.luigi.baterponto1.controller;

import br.luigi.baterponto1.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.CalculoHoras;
import model.Employee;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeScreenController implements Initializable {

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
    private Label initialPoint;
    @FXML
    private Label finalPoint;
    @FXML
    private Label horasAPagar;
    @FXML
    private Label horasTotais;
    @FXML
    private Label horasExtra;
    @FXML
    private Label salarioTotal;

    private Date horaInicial;
    private Date horaFinal;
    private boolean isEntrada = true;
    private Employee currentEmployee;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Main.addOnChangeScreenListener((newScreen, userData) -> {
            if (userData instanceof Employee) {
                currentEmployee = (Employee) userData;
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
    }

    @FXML
    protected void checkVacation(ActionEvent e) {
        Main.changeScreen("vacation");
    }

    @FXML
    public void checkPoint(ActionEvent e) {
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        DateFormat formataData = DateFormat.getDateInstance();
        DateFormat hora = DateFormat.getTimeInstance();

        if (isEntrada) {
            initialPoint.setText(String.format("%s %s", hora.format(data), formataData.format(data)));
            horaInicial = data;
        } else {
            finalPoint.setText(String.format("%s %s", hora.format(data), formataData.format(data)));
            horaFinal = data;

            if (horaInicial != null && horaFinal != null) {
                long diferencaMillis = CalculoHoras.calcularDiferencaTempo(horaInicial.getTime(), horaFinal.getTime());
                String diferenca = CalculoHoras.calcularDiferencaTempoFormatada(horaInicial.getTime(), horaFinal.getTime());
                System.out.println("Diferença de tempo: " + diferenca);
                String horasAPagarStr = CalculoHoras.horasApagar(horaInicial.getTime(), horaFinal.getTime(), currentEmployee.getSaldoHoras());
                horasAPagar.setText(horasAPagarStr);
                horasTotais.setText(diferenca);

                String salarioStr = CalculoHoras.calcularSalario(diferencaMillis).replace(",", ".");
                salarioTotal.setText("R$ " + salarioStr);

                double salario = Double.parseDouble(salarioStr);
                String horasExtrasStr = CalculoHoras.calcularHorasExtra(diferencaMillis);
                horasExtra.setText(horasExtrasStr);

                salarioTotal.setText("R$ " + salario);

                currentEmployee.setHorasTotais(diferenca);
                currentEmployee.setHorasExtras(horasExtrasStr);
                currentEmployee.setHorasAPagar(horasAPagarStr);
                currentEmployee.setSalarioCalculado(salario);
            }
        }

        isEntrada = !isEntrada;
    }

    @FXML
    public void voltarButton() {
        Main.changeScreen("login");
    }
}
