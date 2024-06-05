package com.example.practica;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class Regict {

    @FXML
    private Button CarButton;

    @FXML
    private TextField CarLastname;

    @FXML
    private TextField CarLogin;

    @FXML
    private TextField CarName;

    @FXML
    private TextField CarNumber;

    @FXML
    private TextField CarPassport;

    @FXML
    private TextField CarPassword;

    @FXML
    private TextField CarSurname;

    @FXML
    private Button exit_regist;

    @FXML
    void initialize() {
        exit_regist.setOnAction(event -> {
            exit_regist.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("avtoris.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        DatabaseHandler dbHandler = new DatabaseHandler();
        CarButton.setOnAction(event ->{

            String name = CarName.getText();
            String lastname = CarLastname.getText();
            String surname = CarSurname.getText();
            String passport = CarPassport.getText();
            String number = CarNumber.getText();
            String login= CarLogin.getText();
            String password = CarPassword.getText();

            if (name.isEmpty() || lastname.isEmpty() || surname.isEmpty() || passport.isEmpty() || number.isEmpty() || login.isEmpty() || password.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Ошибка");
                alert.setContentText("Все поля должны быть заполнены!");
                alert.showAndWait();
            } else {
                User user = new User(name, lastname, surname, passport, number, login, password);
                dbHandler.signUser(user);

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setHeaderText("Успешная регистрация");
                successAlert.setContentText("Пользователь зарегистрирован!");
                successAlert.showAndWait();
            }
        });
    }
}
