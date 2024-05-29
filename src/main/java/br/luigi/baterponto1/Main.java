package br.luigi.baterponto1;

import br.luigi.baterponto1.controller.RequestScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    private static Stage stage;

    private static Scene employeeScene;
    private static Scene admnistratorScene;
    private static Scene loginScene;
    private static Scene registerScene;
    private static Scene vacationScene;
    private static Scene requestScene;
    private static Scene relatorioScene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        loginScene = new Scene(fxmlLogin, 800, 530);

        Parent fxmlRelatorio = FXMLLoader.load(getClass().getResource("analysis-view.fxml"));
        relatorioScene = new Scene(fxmlRelatorio, 800, 530);

        Parent fxmlRegister = FXMLLoader.load(getClass().getResource("register-view.fxml"));
        registerScene = new Scene(fxmlRegister, 800, 530);

        Parent fxmlEmployee = FXMLLoader.load(getClass().getResource("employee-view.fxml"));
        employeeScene = new Scene(fxmlEmployee, 800, 530);

        Parent fxmlAdmnistrator = FXMLLoader.load(getClass().getResource("admnistrator-view.fxml"));
        admnistratorScene = new Scene(fxmlAdmnistrator, 800, 530);

        Parent fxmlVacation = FXMLLoader.load(getClass().getResource("vacation-view.fxml"));
        vacationScene = new Scene(fxmlVacation, 800, 530);

        Parent fxmlRequest = FXMLLoader.load(getClass().getResource("request-view.fxml"));
        requestScene = new Scene(fxmlRequest, 800, 530);

        stage.setScene(loginScene);
        stage.show();
    }

    public static void changeScreen(String scr, Object... userData){
        switch (scr){
            case "adm":
                stage.setScene(admnistratorScene);
                notifyAllListeners("adm", userData.length > 0 ? userData[0] : null);
                break;
            case "login":
                stage.setScene(loginScene);
                break;
            case "employee":
                stage.setScene(employeeScene);
                notifyAllListeners("employee", userData.length > 0 ? userData[0] : null);
                break;
            case "register":
                stage.setScene(registerScene);
                notifyAllListeners("register", userData.length > 0 ? userData[0] : null);
                break;
            case "vacation":
                stage.setScene(vacationScene);
                notifyAllListeners("vacation", userData.length > 0 ? userData[0] : null);
                break;
            case "relatorio":
                stage.setScene(relatorioScene);
                notifyAllListeners("relatorio", userData.length > 0 ? userData[0] : null);
                break;
            case "request":
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("request-view.fxml"));
                Parent root;
                try {
                    root = loader.load();
                    RequestScreenController controller = loader.getController();

                    if (userData.length >= 3) {
                        String inicioD = (String) userData[0];
                        String finalD = (String) userData[1];
                        String comentarios = (String) userData[2];

                        controller.receberDados(comentarios, inicioD, finalD);
                    }

                    stage.setScene(new Scene(root, 800, 530));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public static void changeScreen(String scr){
        changeScreen(scr, (Object) null);
    }

    public static void main(String[] args) {
        launch();
    }

    private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();

    public interface OnChangeScreen{
        void onScreenChanged(String newScreen, Object userData);
    }

    public static void addOnChangeScreenListener(OnChangeScreen newListener){
        listeners.add(newListener);
    }

    private static void notifyAllListeners(String newScreen, Object userData){
        for(OnChangeScreen l : listeners) {
            l.onScreenChanged(newScreen, userData);
        }
    }
}
