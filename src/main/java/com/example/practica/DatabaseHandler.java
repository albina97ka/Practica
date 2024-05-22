package com.example.practica;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseHandler extends Config {
    Connection dbConnection;

    public DatabaseHandler() {
    }

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?serverTimezone=Europe/Moscow";
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.dbConnection = DriverManager.getConnection(connectionString, this.dbUser, this.dbPass);
        return this.dbConnection;
    }

    public void signUser(User user) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_NAME + "," + Const.USER_LASTNAME + "," + Const.USER_SURNAME + "," + Const.USER_PASSPORT + "," +
                Const.USER_NUMBER + "," + Const.USER_LOGIN + "," + Const.USER_PASSWORD +
                ")" + "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = this.getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getName());
            prSt.setString(2, user.getLastName());
            prSt.setString(3, user.getSurname());
            prSt.setString(4, user.getPassport());
            prSt.setString(5, user.getNumber());
            prSt.setString(6, user.getLogin());
            prSt.setString(7, user.getPassword());
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet getUser(User user) {
        ResultSet reSet = null;
        String select = "SELECT * FROM " +  Const.USER_TABLE + " WHERE " + Const.USER_LOGIN + "=? AND " + Const.USER_PASSWORD + "=?";
        try {
            PreparedStatement prSt = this.getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());
            reSet = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return reSet;
    }
    public void signCar (ServicePerformed serviceperformed){
        String insert = "INSERT INTO " + Const.CAR_TABLE + "("+Const.CAR_NAME + "," +
                Const.CAR_LASTNAME + "," + Const.CAR_TYPE + "," +Const.CAR_BRAND +  "," +Const.CAR_MODEL + ")" + "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, serviceperformed.getName());
            prSt.setString(2, serviceperformed.getLastname());
            prSt.setString(3, serviceperformed.getType());
            prSt.setString(4, serviceperformed.getBrand());
            prSt.setString(5, serviceperformed.getModel());
            prSt.executeUpdate();
        }
        catch (SQLException e) {throw new RuntimeException(e);}
        catch (ClassNotFoundException e) {throw new RuntimeException(e);}

    }
    public void signArchive(ServicePerformed serviceperformed){
        String insert = "INSERT INTO " + Const.ARCHIVE_TABLE + "("+Const.ARCHIVE_NAME + "," +
                Const.ARCHIVE_LASTNAME + "," + Const.ARCHIVE_TYPE + "," + Const.ARCHIVE_BRAND + "," +Const.ARCHIVE_MODEL + ")" + "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, serviceperformed.getName());
            prSt.setString(2, serviceperformed.getLastname());
            prSt.setString(3, serviceperformed.getType());
            prSt.setString(4, serviceperformed.getBrand());
            prSt.setString(5, serviceperformed.getModel());
            prSt.executeUpdate();
        }
        catch (SQLException e) {throw new RuntimeException(e);}
        catch (ClassNotFoundException e) {throw new RuntimeException(e);}

    }
    public void deletingLine (Deleting deleting) throws SQLException, ClassNotFoundException {
        String insert = "DELETE FROM " + deleting.getName() + " WHERE "+ deleting.getNameId()+" = " + deleting.getID() +";";

        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.executeUpdate();
    }
    public ObservableList<users> Get_All_Users() {
        String select = "SELECT * FROM users";
        ObservableList<users> list_users = FXCollections.observableArrayList();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            ResultSet resultSet = prSt.executeQuery();

            while (resultSet.next()){
                list_users.add(new users(resultSet.getInt("id"), resultSet.getString("Name"),
                        resultSet.getString("Lastname"),resultSet.getString("Surname"), resultSet.getString("Passport_series_and_number"), resultSet.getString("Phone_number"),
                        resultSet.getString("Login"), resultSet.getString("Password")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list_users;
    }
    public ObservableList<Service> Get_All_Car() {
        String select = "SELECT * FROM car";
        ObservableList<Service> list_Service = FXCollections.observableArrayList();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            ResultSet resultSet = prSt.executeQuery();
            while (resultSet.next()){
                list_Service.add(new Service(resultSet.getInt("id_car"), resultSet.getString("Name_car"),
                        resultSet.getString("Lastname_car"),resultSet.getString("Type_of_car_car"),
                        resultSet.getString("Brand_car"), resultSet.getString("Car_model_car")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list_Service;
    }
    public ObservableList<Service> Get_All_Archive() {
        String select = "SELECT * FROM archive";
        ObservableList<Service> list_Archive = FXCollections.observableArrayList();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            ResultSet resultSet = prSt.executeQuery();

            while (resultSet.next()){
                list_Archive.add(new Service(resultSet.getInt("id_archive"), resultSet.getString("Name_archive"),
                        resultSet.getString("Lastname_archive"),resultSet.getString("Type_of_car_archive"), resultSet.getString("Brand_archive"),
                        resultSet.getString("Car_model_archive")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list_Archive;
    }
}

