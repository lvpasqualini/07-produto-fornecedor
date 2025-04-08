import java.text.DecimalFormat;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

public class Util {
    private Produto produto[] = new Produto[3];
    private Fornecedor fornecedor[] = new Fornecedor[3];
    private int indexProduto = 0;
    private int indexFornecedor = 0;

    public void menuPrincipal() {
        String menu = "1- Cadastrar produto\n2- Pesquisar produto por nome\n3- Pesquisar fornecedor por CNPJ\n 4- Finalizar";
        int option;

        while (true) {
            option = parseInt(showInputDialog(menu));
            if (option == 4) {
                return;
            }
            switch (option) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    procurarProduto();
                    break;
                case 3:
                    pesquisar();
                    break;
                default:
                    showMessageDialog(null, "Opção inválida!");
            }
        }
    }

    private void pesquisar() {
        Fornecedor fornecedor = procurarFornecedor();
        if(fornecedor != null) {
            String aux = "";
            aux+= "Fornecedor: " + fornecedor.getNome() + "\n";
            aux+= "CNPJ: " + fornecedor.getCnpj() + "\n";
            showMessageDialog(null, aux);
        }
    }

    private void adicionarProduto() {
        String nome;
        double valor;
        int qtdEstoque;
        Fornecedor fornecedor = procurarFornecedor();

        if(fornecedor == null) {
            fornecedor = adicionarFornecedor();
        }

        nome = showInputDialog("Nome do produto: ");
        valor = parseDouble(showInputDialog("Valor unitário: "));
        qtdEstoque = parseInt(showInputDialog("Quantidade em estoque: "));
        produto[indexProduto] = new Produto(nome, valor, qtdEstoque, fornecedor);
        indexProduto++;
    }

    private Fornecedor adicionarFornecedor() {
        Fornecedor fornecedor;
        String nome = showInputDialog("Nome do fornecedor");
        int cnpj =  parseInt(showInputDialog("CNPJ"));
        fornecedor =  new Fornecedor(nome, cnpj);
        this.fornecedor[indexFornecedor] = fornecedor;
        indexFornecedor++;

        return fornecedor;
    }

    private void procurarProduto() {
        DecimalFormat df = new DecimalFormat("R$0,00");
        String nome = showInputDialog("Nome do produto: ");
        String aux = "Produto não encontrado!";
        for(int i = 0; i< indexProduto; i++) {
            if(produto[i].getProduto().equalsIgnoreCase(nome)){
                aux = "";
                aux += "Nome do produto: "+nome+"\n";
                aux += "Valor unitário: " + df.format(produto[i].getValor()) + "\n";
                aux +="Nome do fornecedor: " + produto[i].getFornecedor().getNome() + "\n";
            }
        }
        showMessageDialog(null, aux);
    }

    private Fornecedor procurarFornecedor() {
        int cnpj = parseInt(showInputDialog("CNPJ do fornecedor"));
        for (int i = 0; i< indexFornecedor; i++) {
            if(fornecedor[i].getCnpj() == cnpj ) {
                return fornecedor[i];
            }
        }
        showMessageDialog(null, +cnpj+" não encontrado!");
        return null;
    }
}