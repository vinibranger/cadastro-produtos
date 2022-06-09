package br.com.vinicius.javafxteste;

public class Produto {

    int codigo;
    String nome;
    double preco;

    //Construtor
    public Produto(int codigo, String nome, double preco) {//alt+Insert
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
