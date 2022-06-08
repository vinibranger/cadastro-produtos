package br.com.vinicius.javafxteste;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class AddProdutosController implements Initializable {

    static Produto produto; //declarar produto 

    @FXML
    private TextField textFieldCodigoProduto;

    @FXML
    private TextField textFieldNomeProduto;

    @FXML
    private TextField textFieldPrecoProduto;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (produto != null) {
            //inteiro para String
            textFieldCodigoProduto.setText(Integer.toString(produto.getCodigo()));
            textFieldNomeProduto.setText(produto.getNome());
            textFieldPrecoProduto.setText(Double.toString(produto.getPreco()));

        }

    }

    static void setProduto(Produto produto) {
        //nome da minha clase
        AddProdutosController.produto = produto;

    }

    static Produto getProduto() {
        return AddProdutosController.produto;
        // ou return produto;
    }

    @FXML
    void salvar() {
        if (!this.textFieldCodigoProduto.getText().isEmpty()//
                && !this.textFieldNomeProduto.getText().isEmpty()//
                && !this.textFieldPrecoProduto.getText().isEmpty());{
            

            produto = new Produto( //
                    Integer.parseInt(this.textFieldCodigoProduto.getText()), //
                    this.textFieldNomeProduto.getText(),
                    Double.parseDouble(this.textFieldPrecoProduto.getText()) //
            );
        }
        App.closeCurrentWindow();

    }

}
