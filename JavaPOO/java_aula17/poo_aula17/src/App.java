import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class App {

    public static void limparTela() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static void main(String[] args) throws Exception {
    //    HashSet<String> tags = new HashSet<>();
    //    tags.add("java");
    //    tags.add("Programação");
    //    tags.add("poo");
    //    tags.add("java");
    //    for (String tag: tags) {
    //     System.out.println(tag + " - " + tag.hashCode());
    //    }

    // HashMap<Integer, String> produtos = new HashMap<Integer, String>();
    // produtos.put(1, "Banana");
    // produtos.put(2, "Abacaxi");
    // produtos.put(3, "Melancia");
    // produtos.put(4, "Morango");
    // produtos.put(5, "Laranja");
    // produtos.put(1, "Manga");
    //     // for (String p : produtos.values()){
    //     //     System.out.println(p);
    //     // }

    //     for(Map.Entry<Integer, String> produto : produtos.entrySet()) {
    //         System.out.format("%d: %s%n", produto.getKey(), produto.getValue());
    //     }

     
    HashMap<Integer, String> nomes = new HashMap<Integer, String>();
    HashMap<Integer, Double> precos = new HashMap<Integer, Double>();
    Scanner scan = new Scanner(System.in);  
    int opcaoMenu = 0;
    do {
        limparTela();
        mostrarMenu();
        opcaoMenu = lerOpcaoMenu(scan);
        if (!processarOpcaoMenu(scan, opcaoMenu, nomes, precos)) {
            System.out.println("Opção inválida. Tente novamente...");
            Thread.sleep(2000);
        }    
    }  while (opcaoMenu != 5);
    scan.close();

    }

    private static boolean processarOpcaoMenu(Scanner scan, int opcaoMenu,
        HashMap<Integer, String> nomes, HashMap<Integer, Double> precos) throws IOException, InterruptedException {
        switch (opcaoMenu) {
            case 1:
                inserirProduto(scan, nomes, precos);
                return true;
            case 2:
                alterarProduto(scan, nomes, precos);
                return true;
            case 3:
                removerProduto(scan, nomes, precos);
                return true;
            case 4:
                listarProduto(scan, nomes, precos);
                return true;
            case 5:
                sairDoPrograma();
                return true;
            default:
                return false;
        }  
    }

    private static void listarProduto(Scanner scan, HashMap<Integer, String> nomes,
        HashMap<Integer, Double> precos) throws IOException, InterruptedException {
        limparTela();
        System.out.println("Produtos Cadastrados");
        System.out.println("----------------------------");
        System.out.format("%6s | %-10s | %6s%n", "Codigo", "Nome", "Preço");
        for (int chave : nomes.keySet()){
            System.out.format("%06d | %-10s | %6.2f%n", chave, nomes.get(chave), precos.get(chave));
        }
        System.out.println("----------------------------");
        System.out.println(">> Pressione ENTER para voltar ao menu...");
        System.in.read();

    }

    private static void removerProduto(Scanner scan, HashMap<Integer, String> nomes,
        HashMap<Integer, Double> precos) throws IOException, InterruptedException {
        limparTela();   
        System.out.println("REMOÇÃO DE PRODUTO");
        System.out.println("-----------------------");
        System.out.print(">> Código: ");
        int codigo = scan.nextInt();
        scan.nextLine();
        if (nomes.containsKey(codigo)) {
            System.out.format("Valores originais:%n%s, R$ %.2f%n",
                nomes.get(codigo), precos.get(codigo));
            System.out.print(" >> Confirma a exclusão (S/N)? ");
            String resposta = scan.nextLine().trim();
            if (resposta.toUpperCase().equals("S")){
                nomes.remove(codigo);
                precos.remove(codigo);
                System.out.println("-------------------------");
                System.out.println("Produto removido com sucesso!");
            } else {
                System.out.println("Remoção não confirmada.");
            }
        } else {
            System.out.println("Produto não encontrado!");
        }
        System.out.println(">> Pressione ENTER para voltar ao menu...");
        System.in.read();
    }

    private static void alterarProduto(Scanner scan, HashMap<Integer, String> nomes,
        HashMap<Integer, Double> precos) throws IOException, InterruptedException {
            limparTela();   
            System.out.println("ALTERAÇÃO DE PRODUTO");
            System.out.println("-----------------------");
            System.out.print(">> Código: ");
            int codigo = scan.nextInt();
            scan.nextLine();
            if (nomes.containsKey(codigo)) {
                System.out.format("Valores originais:%n%s, R$ %.2f%n",
                    nomes.get(codigo), precos.get(codigo));
                System.out.println("(Deixe em branco para manter o valor original)");
                System.out.print(">> Novo nome");
                String novoNome = scan.nextLine().trim();
                novoNome = novoNome.isEmpty() ? nomes.get(codigo) : novoNome;
                System.out.print(">> Novo preço: ");
                String novoPrecoStr = scan.nextLine().trim();
                Double novoPreco = novoPrecoStr.isEmpty() ? precos.get(codigo) : 
                    Double.parseDouble(novoPrecoStr.replace(',','.'));
                    nomes.put(codigo, novoNome);
                    precos.put(codigo, novoPreco);
                    System.out.println("-------------------------");
                    System.out.println("Produto alterado com sucesso!");
                } else {
                System.out.println("Produto não encontrado!");
            }
            System.out.println(">> Pressione ENTER para voltar ao menu...");
            System.in.read();
        }
    
    private static void inserirProduto(Scanner scan, HashMap<Integer, String> nomes,
        HashMap<Integer, Double> precos) throws IOException, InterruptedException {
        limparTela();
        System.out.println("INSERÇÃO DE PRODUTO");
        System.out.println("-------------------------");
        System.out.print(">> Nome: ");
        String nome = scan.nextLine();
        System.out.print(">> Preço: ");
        Double preco = scan.nextDouble();
        int proximaChave = obterProximaChave(nomes.keySet());
        nomes.put(proximaChave, nome);
        precos.put(proximaChave, preco);
        System.out.println("-------------------------");
        System.out.println("Produto inserirdo com sucesso!");
        System.out.println(">> Pressione Enter para voltar ao menu...");
        System.in.read();
    }

    private static int obterProximaChave(Set<Integer> keySet) {
        if (keySet.size() > 0) {
            return Collections.max(keySet) + 1;
        } else return 1;
    }

    private static void sairDoPrograma() throws InterruptedException, IOException {
        System.out.println("Saindo do programa...");
        Thread.sleep(1000);
        limparTela();
    }

    private static void mostrarMenu() {
        System.out.println("CADASTRO DE PRODUTOS");
        System.out.println("--------------------");
        System.out.println("1. Adicionar");
        System.out.println("2. Alterar");
        System.out.println("3. Remover");
        System.out.println("4. Listar");
        System.out.println("5. Sair");
        System.out.println("--------------------");
    }

    private static int lerOpcaoMenu(Scanner scan) {
        System.out.print(">> Opção desejada: ");
        int opcaoEscolhida = scan.nextInt();
        scan.nextLine();
        return opcaoEscolhida;
    }

    
}
