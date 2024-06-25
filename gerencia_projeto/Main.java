import java.util.*;
public class Main {
    static Scanner teclado = new Scanner(System.in);
    static int processo, quantidade;
    static String nome, desc;
    static double valor;
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        System.out.println("GERENCIAMENTO DE ESTOQUE");

        while (true) {
            System.out.print("\n1 - Adicionar produto\n2 - Remover produto\n3 - Editar quantidade\n4 - Relatório dos produtos\n5 - Sair\nEscolha uma opção: ");
            processo = teclado.nextInt();
            teclado.nextLine(); // Consumir a nova linha

            if (processo == 1) {
                System.out.println("Cadastro de produto");

                System.out.print("Nome: ");
                 nome = teclado.nextLine();

                System.out.print("Descrição: ");
                 desc = teclado.nextLine();

                System.out.print("Quantidade: ");
                 quantidade = teclado.nextInt();

                System.out.print("Valor: ");
                 valor = teclado.nextDouble();
                teclado.nextLine(); // Consumir a nova linha

                Produto produto = new Produto(quantidade, nome, desc, valor);
                inventario.getListaProdutos().add(produto);

                System.out.println("PRODUTO CADASTRADO");
            } 
            else if (processo == 2) {
                System.out.print("digite o nome do produto: ");
                nome = teclado.nextLine();
                
                boolean removido = inventario.removerItem(nome);

                if (removido) {
                    System.out.println("PRODUTO REMOVIDO");
                } else {
                    System.out.println("PRODUTO NÃO ENCONTRADO");
                }

                System.out.println("Relatório dos produtos:"); 
                for (Produto produto : inventario.getListaProdutos()) {
                    System.out.println(produto);
                }
            }else if (processo == 3) {
                System.out.print("digite o nome do produto: ");
                nome = teclado.nextLine();

                boolean existeProduto = inventario.editaProduto(nome);

                if (existeProduto) {
                    System.out.print("digite a quantidade do produto: ");
                    quantidade = teclado.nextInt();

                    inventario.editaQuantidade(quantidade);
                }
                
            }else if (processo == 4) {
                    if (inventario.isEmpty()) {
                    System.out.println("Não há produtos cadastrados.");
                } else {
                    System.out.println("Relatório dos produtos:");
                    for (Produto produto : inventario.getListaProdutos()) {
                        System.out.println(produto);
                    }
                }
                
            } else{
                break;
            }
        }
    }
}