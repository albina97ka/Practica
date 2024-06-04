package com.example.practica;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.TextField;

public class Client {

    @FXML
    private Label LabelCar;

    @FXML
    private TextField Lastname_car;

    @FXML
    private TextField Name_car;

    @FXML
    private Button arenda_client;

    @FXML
    private Button buttonCar_calc;

    @FXML
    private Button drCar;

    @FXML
    private Button dshCar;

    @FXML
    private Button exit_client;

    @FXML
    private RadioButton radio_1day;

    @FXML
    private RadioButton radio_1hour;

    @FXML
    private RadioButton radio_5hour;

    @FXML
    private Button srCar;

    @FXML
    void initialize() {
        exit_client.setOnAction(event -> {
            exit_client.getScene().getWindow().hide();

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
        arenda_client.setOnAction(event ->{

            String name = Name_car.getText();
            String lastname = Lastname_car.getText();
            String type = "";
            if (dshCar.isPressed()){type="Дешевый сегмент";}
            else if (srCar.isPressed()) {type = "Средний сегмент";}
            else {type = "Дорогой сегмент";}
            String brand = "";
           // if (.isPressed()){brand="";}
            //else if (.isPressed()) {brand = "";}
            //else {brand = "";}
            String model = "";

            ServicePerformed serviceperformed = new ServicePerformed(name, lastname, type, brand, model);
            dbHandler.signCar(serviceperformed);
        });
    }
    private void calculateCost() {
        double baseCost = 0;

        if (radio_1hour.isSelected()) {
            baseCost *= 2;
        }
        if (radio_5hour.isSelected()) {
            baseCost *= 4;
        }
        if (radio_1day.isSelected()) {
            baseCost *= 7;
        }
        LabelCar.setText(baseCost + " руб");
    }
}
