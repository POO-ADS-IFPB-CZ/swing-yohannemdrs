package view;

import model.Produto;
import dao.ProdutoDao;
import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ProdutoDao produtoDao = new ProdutoDao();
        int idProduto;
        String descricaoProduto;
        float precoProduto;
        LocalDate validadeProduto;

        int opcaoEscolhida;

        do {
            // Exibe o menu de opções para o usuário
            String menu = "Escolha uma opção:\n" +
                    "1 - Cadastrar produto\n" +
                    "2 - Exibir produtos\n" +
                    "3 - Modificar produto\n" +
                    "4 - Deletar produto\n" +
                    "5 - Sair";
            JOptionPane.showMessageDialog(null, menu);

            opcaoEscolhida = Integer.parseInt(JOptionPane.showInputDialog("Digite sua opção:", "1"));

            switch (opcaoEscolhida) {
                case 1:
                    // Cadastro de novo produto
                    idProduto = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do produto:"));
                    descricaoProduto = JOptionPane.showInputDialog("Informe a descrição do produto:");
                    precoProduto = Float.parseFloat(JOptionPane.showInputDialog("Informe o preço do produto:"));
                    validadeProduto = LocalDate.parse(JOptionPane.showInputDialog("Informe a validade do produto (YYYY-MM-DD):"));

                    produtoDao.adicionarProduto(new Produto(idProduto, descricaoProduto, precoProduto, validadeProduto));
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                    break;

                case 2:
                    // Exibe os produtos cadastrados
                    String produtosListados = produtoDao.getProdutos().toString();
                    JOptionPane.showMessageDialog(null, "Lista de Produtos:\n" + produtosListados);
                    break;

                case 3:
                    // Atualiza informações de um produto
                    idProduto = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do produto que deseja atualizar:"));
                    descricaoProduto = JOptionPane.showInputDialog("Informe a nova descrição do produto:");
                    precoProduto = Float.parseFloat(JOptionPane.showInputDialog("Informe o novo preço do produto:"));
                    validadeProduto = LocalDate.parse(JOptionPane.showInputDialog("Informe a nova validade do produto (YYYY-MM-DD):"));

                    produtoDao.atualizar(new Produto(idProduto, descricaoProduto, precoProduto, validadeProduto));
                    JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
                    break;

                case 4:
                    // Exclui um produto
                    idProduto = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do produto a ser excluído:"));
                    produtoDao.removerProduto(new Produto(idProduto, null, 0, null));
                    JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Programa encerrado.");
                    break;

                default:
                    // Opção inválida
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (opcaoEscolhida != 5);
    }
}
