module br.com.vinicius.javafxteste {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens br.com.vinicius.javafxteste to javafx.fxml;
    exports br.com.vinicius.javafxteste;
}
