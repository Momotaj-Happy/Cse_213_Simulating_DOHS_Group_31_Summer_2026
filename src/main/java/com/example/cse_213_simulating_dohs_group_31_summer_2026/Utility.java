package com.example.cse_213_simulating_dohs_group_31_summer_2026;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


import java.io.*;
import java.util.ArrayList;


public class Utility {
    public static void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void openFxml(ActionEvent event, String title, String fxmlFile) {

        try {
            FXMLLoader loader = new FXMLLoader(Utility.class.getResource(fxmlFile));
            Parent root = loader.load();

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource())
                    .getScene()
                    .getWindow();

            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> void writeInto(String fileName, T data, boolean append) throws IOException {

        File file = new File(fileName);
        FileOutputStream fileOut;
        ObjectOutputStream objOut;

        if (file.exists()) {
            fileOut = new FileOutputStream(file, append);
            objOut = new AppendableObjectOutputStream(fileOut);

        } else {
            fileOut = new FileOutputStream(file);
            objOut = new ObjectOutputStream(fileOut);

        }

        objOut.writeObject(data);
        objOut.close();


    }


    public static <T> void loadFrom(String fileName, ArrayList<T> list) throws IOException {
        File file = new File(fileName);

        if (!file.exists()) {
            showAlert("Error", "File missing.");
            return;

        }

        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream objIn = new ObjectInputStream(fileIn);

        try {
            while (true) {
                //T obj = (T) objIn.readObject();
                //list.add(obj);
                try {
                    T obj = (T) objIn.readObject();
                    list.add(obj);
                } catch (EOFException e) {

                    break;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException("Class not found", e);
                }
                catch (Exception e){
                    showAlert("Error", "Something went wrong" +e);
                    break;
                }
            }


            //catch (ClassNotFoundException e) {
            //throw new RuntimeException(e);
        } finally {
            objIn.close();

        }


    }

}


