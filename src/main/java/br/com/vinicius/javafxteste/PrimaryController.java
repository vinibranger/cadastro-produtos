package br.com.vinicius.javafxteste;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {

    @FXML
    private Button produtos;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    void switchToProdutos() throws IOException {
        App.setRoot("produto");
    }

}
