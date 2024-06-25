package com.example.practica;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    private static final Logger logger = Logger.getLogger(Client.class.getName());

    @FXML
    public void initialize() {
        logger.info("Инициализация клиентского контроллера");

        exit_client.setOnAction(event -> {
            logger.info("Нажата кнопка выхода, загрузка avtoris.fxml");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("avtoris.fxml"));
            try {
                loader.load();
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Не удалось загрузить avtoris.fxml", e);
                throw new RuntimeException(e);
            }
        });

        dshCar.setOnAction(event -> {
            selectedSegment = "Дешевый сегмент";
            updateCarOptions(selectedSegment, new String[]{"Лада Гранта", "Шевроле Ланос", "Фольксваген Поло", "Рено Логан", "Хундай Солярис"});
            logger.info("Выбран дешевый сегмент");
        });

        srCar.setOnAction(event -> {
            selectedSegment = "Средний сегмент";
            updateCarOptions(selectedSegment, new String[]{"Кия Рио", "Шкода Октавия", "Мазда 6", "Тойота Камри", "Ауди А6"});
            logger.info("Выбран средний сегмент");
        });

        drCar.setOnAction(event -> {
            selectedSegment = "Дорогой сегмент";
            updateCarOptions(selectedSegment, new String[]{"Ауди Р8", "Ауди РС7", "Бмв М8", "Мерседес С63", "Мерседес ГТ63"});
            logger.info("Выбран дорогой сегмент");
        });

        DatabaseHandler dbHandler = new DatabaseHandler();
        arenda_client.setOnAction(event -> {
            logger.info("Нажата кнопка аренды");
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
                logger.warning("Ошибка проверки формы: некоторые поля пусты");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Ошибка");
                alert.setContentText("Все поля должны быть заполнены!");
                alert.showAndWait();
            } else {
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setHeaderText("Заявка принята");
                successAlert.setContentText("Катайтесь с удовольствием!");
                successAlert.showAndWait();

                ServicePerformed serviceperformed = new ServicePerformed(name, lastname, type, brand, model);
                dbHandler.signCar(serviceperformed);
                dbHandler.signArchive(serviceperformed);

                logger.info("Зарегистрированная аренда: " + serviceperformed);
            }
        });
    }
    private void updateCarOptions(String segment, String[] carNames) {
        logger.info("Обновление опций автомобилей для данного сегмента: " + segment);
        Vbox.getChildren().clear();
        carGroup = new ToggleGroup();
        for (String carName : carNames) {
            RadioButton radioButton = new RadioButton(carName);
            radioButton.setId(carName);
            radioButton.setToggleGroup(carGroup);
            radioButton.setOnAction(event -> {
                selectedCarName = radioButton.getId();
                logger.info("Выбранный автомобиль : " + selectedCarName);
            });
            Vbox.getChildren().add(radioButton);
        }
    }
}