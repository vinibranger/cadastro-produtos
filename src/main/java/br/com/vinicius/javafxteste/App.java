package br.com.vinicius.javafxteste;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.stage.Modality;
import javafx.stage.Window;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"), 640, 480);
        stage.setScene(scene);
        stage.show();
        //stage.setResizable(false);// nao aumentar tela
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));//trocar de tela
    }

    static void showModal(String fxml) throws IOException {
        // Obtém a tela atual
        Window primaryStage = scene.getRoot().getScene().getWindow();

        // Carrega a nova tela
        scene = new Scene(loadFXML(fxml));

        // Abre o modal
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        dialog.setScene(scene);
        dialog.showAndWait();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
//        launch();
        try {
            Connection connection = conectarBanco.getConnection();

            Statement statement = connection.createStatement();

            ResultSet queryResult = statement.executeQuery("SELECT * FROM produto");

            queryResult.next();
            int codigo = queryResult.getInt(1);
            System.out.println(codigo);

            String nome = queryResult.getString(2);
            System.out.println(nome);

            queryResult.previous();
            nome = queryResult.getString(2);
            System.out.println(nome);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    static void closeCurrentWindow() { //fechar janela
        ((Stage) scene.getRoot().getScene().getWindow()).close();
    }

}
