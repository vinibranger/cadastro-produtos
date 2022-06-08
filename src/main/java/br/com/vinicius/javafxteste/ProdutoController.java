package br.com.vinicius.javafxteste;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProdutoController implements Initializable {

    @FXML
    private TableColumn<Produto, Integer> codProdutoTable;

    @FXML
    private TableColumn<Produto, String> nomeProdutoTable;

    @FXML
    private TableColumn<Produto, Double> precoProduto;
    @FXML
    private TableView<Produto> produtotable;

    ObservableList<Produto> produtos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.codProdutoTable.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        this.nomeProdutoTable.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.precoProduto.setCellValueFactory(new PropertyValueFactory<>("preco"));

        this.produtos = this.produtotable.getItems();

        Produto maca = new Produto(1, "Maçã", 2.99);
        Produto banana = new Produto(2, "Banana", 2.99);
        Produto pcGamer = new Produto(3, "PC Gamer", 14999.99);
        Produto teclado = new Produto(4, "Teclado Gamer Super Top", 149.99);

        produtos.add(maca);
        produtos.add(banana);
        produtos.add(pcGamer);
        produtos.add(teclado);

    }

    @FXML
    void editar() throws IOException {
        // obtem o produto da linha selecionada na lista
        Produto produtoSelecionado = this.produtotable.getSelectionModel().getSelectedItem();
        if (produtoSelecionado != null) {

            AddProdutosController.setProduto(produtoSelecionado);

            App.showModal("AddProdutos");

            Produto produtoAlterado = AddProdutosController.getProduto();//busca produto variavel global

            produtoSelecionado.setCodigo(produtoAlterado.getCodigo());
            produtoSelecionado.setNome(produtoAlterado.getNome());
            produtoSelecionado.setPreco(produtoAlterado.getPreco());

            this.produtotable.refresh();

        }

    }

    @FXML
    void novo() throws IOException {
        AddProdutosController.setProduto(null);
        App.showModal("AddProdutos");
        Produto produtoNovo = AddProdutosController.getProduto();
        if (produtoNovo != null) {
            this.produtos.add(produtoNovo);
        }
    }

    @FXML
    void remover() throws IOException {
       Produto produtoSelecionado = this.produtotable.getSelectionModel().getSelectedItem();
        
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Remover");
        alert.setHeaderText(produtoSelecionado.getCodigo()+ " " + produtoSelecionado.getNome());
        alert.setContentText("Deseja Remover o Registro ? ");
        

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
                 
            //Remove prduto
            this.produtos.remove(produtoSelecionado);
        
        } 
        
    }

    @FXML
    void switchToAddProdutos() throws IOException {
        App.setRoot("addprodutos");
    }

}
