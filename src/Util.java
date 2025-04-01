import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

public class Util {
    private Produto produto[] = new Produto[3];
    private Fornecedor provider[] = new Fornecedor[3];
    private int indexProduct = 0;
    private int indexProvider = 0;

    public void mainMenu() {
        String menu = "1- Cadastrar produto\n2- Pesquisar produto por nome\n3- Pesquisar fornecedor por CNPJ\n 4- Finalizar";
        int option;

        while (true) {
            option = parseInt(showInputDialog(menu));
            if (option == 4) {
                return;
            }

            switch (option) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    searchName();
                    break;
                case 3:
                    searchProvider();
                    break;
                default:
                    showMessageDialog(null, "Opção inválida!");
            }
        }
    }

    private void addProduct() {
        String nome;
        double value;
        int qtdEstoque;
        Fornecedor provider = searchProvider();

        if(provider == null) {
            provider = addProvider();
        }

        nome = showInputDialog("Nome do produto");
        value = parseDouble(showInputDialog("Valor unitário"));
        qtdEstoque = parseInt(showInputDialog("Quantidade em estoque"));
        produto[indexProduct] = new Produto(nome, value, qtdEstoque, provider);
    }

    private Fornecedor addProvider() {
        Fornecedor fornecedor;
        String nome = showInputDialog("Nome do fornecedor");
        int cnpj =  parseInt(showInputDialog("CNPJ"));
        fornecedor =  new Fornecedor(nome, cnpj);
        this.provider[indexProvider] = fornecedor;
        indexProvider++;

        return fornecedor;
    }

    private void searchName() {
    }

    private Fornecedor searchProvider() {
        int cnpj = parseInt(showInputDialog("CNPJ do fornecedor"));
        for (int i = 0; i< indexProvider; i++) {
            if(provider[i].getCnpj() == cnpj ) {
                return provider[i];
            }
        }
        showMessageDialog(null, +cnpj+" não encontrado");
        return null;
    }
}