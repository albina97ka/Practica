package com.example.practica;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class Avtoris {
    @FXML
    private TextField UserLogin;
    @FXML
    private PasswordField UserPass;
    @FXML
    private Button adminButton;
    @FXML
    private Button applicationButton;
    @FXML
    void initialize() {
        this.applicationButton.setOnAction((event) -> {
            this.applicationButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("regist.fxml"));

            try {
                loader.load();
            } catch (IOException var5) {
                throw new RuntimeException(var5);
            }

            Parent root = (Parent)loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        this.adminButton.setOnAction((event) -> {
            String loginText = this.UserLogin.getText().trim();
            String loginPass = this.UserPass.getText().trim();
            if (!loginText.equals("") && !loginPass.equals("")) {
                try {
                    this.loginUser(loginText, loginPass);
                } catch (IOException | SQLException var5) {
                    throw new RuntimeException(var5);
                }
            } else {
                this.adminButton.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent actionEvent) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("Проверьте коректность данных.");
                        alert.showAndWait();
                    }
                });
            }

        });
    }
    private void loginUser(String loginText, String loginPass) throws IOException, SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setLogin(loginText);
        user.setPassword(loginPass);
        ResultSet result = dbHandler.getUser(user);

        FXMLLoader loader;
        Parent root;
        Stage stage;
        if (loginText.equals("admin") && loginPass.equals("12345")) {
            this.adminButton.getScene().getWindow().hide();
            loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("admin.fxml"));
            loader.load();
            root = (Parent)loader.getRoot();
            stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        }
        else if (result.next()) {
            this.adminButton.getScene().getWindow().hide();
            loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("client.fxml"));
            loader.load();
            root = (Parent)loader.getRoot();
            stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        }
        else {
            Shake userLoginAnim = new Shake(this.UserLogin);
            Shake userPassAnim = new Shake(this.UserPass);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();
        }
    }
}
