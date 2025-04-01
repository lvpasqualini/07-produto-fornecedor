public class Produto {
    private String nome;
    private double valor;
    private int qtdEstoque;
    private Fornecedor fornecedor;

    public Produto(String nome, double valor, int qtdEstoque, Fornecedor fornecedor) {
        this.nome = nome;
        this.valor = valor;
        this.qtdEstoque = qtdEstoque;
        this.fornecedor = fornecedor;
    }

    public String getProduto() {
        return nome;
    }

    public void setProduto(String produto) {
        this.nome = produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = this.qtdEstoque;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
