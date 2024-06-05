package com.example.practica;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Client {

    @FXML
    private TextField Lastname_car;

    @FXML
    private TextField Name_car;

    @FXML
    private VBox Vbox;

    @FXML
    private Button arenda_client;

    @FXML
    private Button drCar;

    @FXML
    private Button dshCar;

    @FXML
    private Button exit_client;

    @FXML
    private Button srCar;

    private ToggleGroup carGroup;
    private String selectedCarName;
    private String selectedSegment;

    @FXML
    public void initialize() {
        exit_client.setOnAction(event -> {
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

        dshCar.setOnAction(event -> {
            selectedSegment = "Дешевый сегмент";
            updateCarOptions(selectedSegment, new String[]{"Лада Гранта", "Шевроле Ланос", "Фольксваген Поло", "Рено Логан", "Хундай Солярис"});
        });

        srCar.setOnAction(event -> {
            selectedSegment = "Средний сегмент";
            updateCarOptions(selectedSegment, new String[]{"Кия Рио", "Шкода Октавия", "Мазда 6", "Тойота Камри", "Ауди А6"});
        });

        drCar.setOnAction(event -> {
            selectedSegment = "Дорогой сегмент";
            updateCarOptions(selectedSegment, new String[]{"Ауди Р8", "Ауди РС7", "Бмв М8", "Мерседес С63", "Мерседес ГТ63"});
        });

        DatabaseHandler dbHandler = new DatabaseHandler();
        arenda_client.setOnAction(event -> {
            String name = Name_car.getText();
            String lastname = Lastname_car.getText();
            String type = selectedSegment;

            String brand = "";
            String model = "";

            if (selectedCarName != null && selectedCarName.contains(" ")) {
                String[] parts = selectedCarName.split(" ", 2);
                brand = parts[0];
                model = parts[1];
            }

            if (name.isEmpty() || lastname.isEmpty() || type.isEmpty() || brand.isEmpty() || model.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Ошибка");
                alert.setContentText("Все поля должны быть заполнены!");
                alert.showAndWait();
            } else {
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setHeaderText("Заявка принята");
                successAlert.setContentText("Катайтесь с удовольстиев!");
                successAlert.showAndWait();

                ServicePerformed serviceperformed = new ServicePerformed(name, lastname, type, brand, model);
                dbHandler.signCar(serviceperformed);
                dbHandler.signArchive(serviceperformed);

            }
        });

    }

    private void updateCarOptions(String segment, String[] carNames) {
        Vbox.getChildren().clear();
        carGroup = new ToggleGroup();
        for (String carName : carNames) {
            RadioButton radioButton = new RadioButton(carName);
            radioButton.setId(carName);
            radioButton.setToggleGroup(carGroup);
            radioButton.setOnAction(event -> {
                selectedCarName = radioButton.getId();
            });
            Vbox.getChildren().add(radioButton);
        }
    }
}