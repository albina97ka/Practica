package com.example.practica;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Admin {

    //1
    @FXML
    private TableView<users> TableUser;
    @FXML
    private TableColumn<users, Integer> IDuser;
    @FXML
    private TableColumn<users, String> UserName;
    @FXML
    private TableColumn<users, String> UserLastName;
    @FXML
    private TableColumn<users, String> Surname;
    @FXML
    private TableColumn<users, String> Passport;
    @FXML
    private TableColumn<users, String> Number;
    @FXML
    private TableColumn<users, String> Login;
    @FXML
    private TableColumn<users, String> Password;

    //2
    @FXML
    private TableView<Service> TableCar;
    @FXML
    private TableColumn<Service, Integer> IDcar;
    @FXML
    private TableColumn<Service, String> CarName;
    @FXML
    private TableColumn<Service, String> CarLastName;
    @FXML
    private TableColumn<Service, String> CarBrand;
    @FXML
    private TableColumn<Service, String> CarType;
    @FXML
    private TableColumn<Service, String> CarModel;

    //3
    @FXML
    private TableView<Service> TableArchive;
    @FXML
    private TableColumn<Service, Integer> IDarchive;
    @FXML
    private TableColumn<Service, String> Name_archive;
    @FXML
    private TableColumn<Service, String> lastname_archive;
    @FXML
    private TableColumn<Service, String> brand_archive;
    @FXML
    private TableColumn<Service, String> type_archive;
    @FXML
    private TableColumn<Service, String> Model_archive;

    // прочее
    @FXML
    private TextField Id_car;
    @FXML
    private Button delete_car;
    @FXML
    private Button obArchive;
    @FXML
    private Button exit_archive;
    @FXML
    private Button exit_car;
    @FXML
    private Tab Archive;
    @FXML
    private Button ob_archive;

    @FXML
    protected void User(MouseEvent event) {
        ClikUser();
    }

    @FXML
    protected void Car(MouseEvent event) {ClikCar();}

    @FXML
    protected void Archive(MouseEvent event) {
        ClikArchive();
    }


    private void ClikArchive() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        ObservableList<Service> list_Archive = dbHandler.Get_All_Archive();

        IDarchive.setCellValueFactory(new PropertyValueFactory<Service, Integer>("IDarchive"));
        Name_archive.setCellValueFactory(new PropertyValueFactory<Service, String>("Name_archive"));
        lastname_archive.setCellValueFactory(new PropertyValueFactory<Service, String>("lastname_archive"));
        brand_archive.setCellValueFactory(new PropertyValueFactory<Service, String>("brand_archive"));
        type_archive.setCellValueFactory(new PropertyValueFactory<Service, String>("type_archive"));
        Model_archive.setCellValueFactory(new PropertyValueFactory<Service, String>("Model_archive"));

        TableArchive.setItems(list_Archive);
    }

    private void ClikCar() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        ObservableList<Service> list_Service = dbHandler.Get_All_Car();

        IDcar.setCellValueFactory(new PropertyValueFactory<Service, Integer>("IDcar"));
        CarName.setCellValueFactory(new PropertyValueFactory<Service, String>("CarName"));
        CarLastName.setCellValueFactory(new PropertyValueFactory<Service, String>("CarLastName"));
        CarBrand.setCellValueFactory(new PropertyValueFactory<Service, String>("CarBrand"));
        CarType.setCellValueFactory(new PropertyValueFactory<Service, String>("CarType"));
        CarModel.setCellValueFactory(new PropertyValueFactory<Service, String>("CarModel"));

        TableCar.setItems(list_Service);
    }

    private void ClikUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        ObservableList<users> list_users = dbHandler.Get_All_Users();

        IDuser.setCellValueFactory(new PropertyValueFactory<users, Integer>("IDuser"));
        UserName.setCellValueFactory(new PropertyValueFactory<users, String>("UserName"));
        UserLastName.setCellValueFactory(new PropertyValueFactory<users, String>("UserLastName"));
        Surname.setCellValueFactory(new PropertyValueFactory<users, String>("Surname"));
        Passport.setCellValueFactory(new PropertyValueFactory<users, String>("Passport"));
        Number.setCellValueFactory(new PropertyValueFactory<users, String>("Number"));
        Login.setCellValueFactory(new PropertyValueFactory<users, String>("Login"));
        Password.setCellValueFactory(new PropertyValueFactory<users, String>("Password"));

        TableUser.setItems(list_users);
    }


    @FXML
    void initialize() {
        exit_car.setOnAction(event -> {
            exit_car.getScene().getWindow().hide();

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
        exit_archive.setOnAction(event -> {
            exit_archive.getScene().getWindow().hide();

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
        delete_car.setOnAction(event -> {
            try {
                deletingCar();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
    private void deletingCar() throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String name = " car ";
        String nameId = " id_car ";
        String ID = Id_car.getText();

        if (!Id_car.equals("")) {

            Deleting deleting = new Deleting(name, nameId, ID);
            dbHandler.deletingLine(deleting);


            delete_car.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Заявка удалена");
                    alert.showAndWait();
                }
            });
        } else {
            delete_car.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Проверьте коректность данных" +
                            "(Только поле с ID должно быть заполнено)");
                    alert.showAndWait();
                }
            });
        }
        ClikCar();
    }
}
