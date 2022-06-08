package br.com.vinicius.javafxteste;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {

    @FXML
    TextField usuarioTextField; //metodo

    @FXML
    PasswordField senhaPasswordField; //metodo
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    void login() throws IOException {
        if (usuarioTextField.getText().equals("Vini")
                && 
                senhaPasswordField.getText().equals("123")) {
            App.setRoot("primary");
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Errorr");
            alert.setHeaderText(null);
            alert.setContentText("Falha na Autenticação");
            alert.showAndWait();

        }

    }

    @FXML
    void digitarUser() {

    }

}
