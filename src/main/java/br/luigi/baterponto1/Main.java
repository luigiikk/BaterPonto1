package br.luigi.baterponto1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage stage;

    private static Scene employeeScene;
    private static Scene admnistratorScene;
    private static Scene loginScene;
    private static Scene registerScene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        loginScene = new Scene(fxmlLogin, 1000, 800);

        Parent fxmlRegister = FXMLLoader.load(getClass().getResource("register-view.fxml"));
        registerScene = new Scene(fxmlRegister, 1000, 800);


        Parent fxmlEmployee = FXMLLoader.load(getClass().getResource("employee-view.fxml"));
        employeeScene = new Scene(fxmlEmployee, 1000, 800);

        Parent fxmlAdmnistrator = FXMLLoader.load(getClass().getResource("admnistrator-view.fxml"));
        admnistratorScene = new Scene(fxmlAdmnistrator, 1000, 800);



        stage.setScene(loginScene);
        stage.show();
    }

    public static void changeScreen(String scr){
        switch (scr){
            case "adm":
                stage.setScene(admnistratorScene);
                break;
            case "employee":
                stage.setScene(employeeScene);
                break;
            case "register":
                stage.setScene(registerScene);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}