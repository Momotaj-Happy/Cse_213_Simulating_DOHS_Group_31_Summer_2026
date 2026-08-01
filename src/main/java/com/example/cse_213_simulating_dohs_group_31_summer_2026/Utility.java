package com.example.cse_213_simulating_dohs_group_31_summer_2026;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
            FXMLLoader fxmlLoader = new FXMLLoader(Utility.class.getResource(fxmlFile));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();


            Stage oldStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            oldStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





/*
    public static <T extends Serializable> void saveObject(String fileName, T object) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Append a single object to an existing file
    public static <T extends Serializable> void appendObject(String fileName, T object) {
        File file = new File(fileName);

        try (ObjectOutputStream out =
                     file.exists() && file.length() > 0
                             ? new AppendableObjectOutputStream(new FileOutputStream(file, true))
                             : new ObjectOutputStream(new FileOutputStream(file, true))) {

            out.writeObject(object);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read all objects stored one after another
    public static <T> ArrayList<T> readObjects(String fileName) {
        ArrayList<T> list = new ArrayList<>();

        File file = new File(fileName);

        if (!file.exists() || file.length() == 0)
            return list;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {

            while (true) {
                try {
                    @SuppressWarnings("unchecked")
                    T obj = (T) in.readObject();
                    list.add(obj);
                } catch (EOFException e) {
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Save an entire ArrayList
    public static <T extends Serializable> void saveList(String fileName, ArrayList<T> list) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read an entire ArrayList
    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> readList(String fileName) {

        File file = new File(fileName);

        if (!file.exists() || file.length() == 0)
            return new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<T>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    // Custom ObjectOutputStream to avoid writing header while appending
    private static class AppendableObjectOutputStream extends ObjectOutputStream {

        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            reset();
        }
    }
    */

    public static <T> void writeInto(String fileName, T data, boolean append) throws IOException {

        File file = new File(fileName);
        FileOutputStream fileOut;
        ObjectOutputStream objOut;

        if (file.exists()) {
            fileOut = new FileOutputStream(file, append);
            objOut = new AppendableObjectOutputStream(fileOut);

        }

        else {
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
                    throw new RuntimeException("Class mismatch during deserialization", e);
            }
        }


        //catch (ClassNotFoundException e) {
            //throw new RuntimeException(e);
        }
        finally {
            objIn.close();

        }


    }




}


