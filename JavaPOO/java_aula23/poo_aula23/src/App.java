import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void limparTela(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) throws Exception {
       limparTela();
       lerDeArquivo("arquivo.txt");
       
    }

    public static void criarArquivo(String caminho) {
        File arquivo = new File(caminho);
        try {
            if (arquivo.createNewFile()){
                System.out.println("Arquivo criado com sucesso.");
            } else {
                System.out.println("Arquivo já existe.");
            }
        }
        catch (IOException e){
            System.out.println("\nErro ao criar arquivo: ");
            e.printStackTrace();
        }
    } 

    public static String traduzir(boolean valor){
        if (valor)
            return "sim";
        else
            return "não";
    }

    public static void mostrarInfoArquivo(String caminho) {
        File arquivo = new File(caminho);
        System.out.printf("Pode ser lido: %s\n",traduzir(arquivo.canRead()));
        System.out.printf("Pode ser escrito: %s\n",traduzir(arquivo.canWrite()));
        System.out.printf("Pode ser executado: %s\n",traduzir(arquivo.canExecute()));
        System.out.printf("É um arquivo: %s\n",traduzir(arquivo.isFile()));
        System.out.printf("é um diretório: %s\n",traduzir(arquivo.isDirectory()));
        System.out.printf("Criado com caminho absoluto: %s\n",traduzir(arquivo.isAbsolute()));
        System.out.printf("é oculto: %s\n",traduzir(arquivo.isHidden()));
        System.out.printf("Existe: %s\n",traduzir(arquivo.exists()));
        System.out.printf("Nome: %s\n",arquivo.getName());
        System.out.printf("Caminho absoluto: %s\n",arquivo.getAbsolutePath());
        System.out.printf("Diretório pai: %s\n",arquivo.getParent());

        if (arquivo.exists()) {
            if (arquivo.isFile())
                System.out.printf("Tamanho em bytes: %d\n", arquivo.length());
        } else if (arquivo.isDirectory()) {
            System.out.println("Conteúdo do diretório: ");
            String[] arquivos = arquivo.list();
            for (String arqFilho : arquivos) {
                System.out.println(arqFilho); 
            }
        }
    }

    public static void escreverEmArquivo(String caminho) {
        try {
            FileWriter escritor = new FileWriter(caminho);
            escritor.write("Linha 01\n");
            escritor.write("Linha 02\n");
            escritor.write("Linha 04\n");
            escritor.write("Linha 05\n");
            escritor.close();
            System.out.println("Dados escritos com suscesso.");
        } catch (IOException e) {
            System.out.println();
        }
    }

    public static void lerDeArquivo(String caminho) {
        try {
            File arquivo = new File(caminho);
            Scanner leitor = new Scanner(arquivo);
            while (leitor.hasNextLine()){
                String linha = leitor.nextLine();
                System.out.println(linha);
            }
            leitor.close();
            System.out.println("Dados lidos com sucesso");
        } catch (FileNotFoundException e) {
            System.out.println("\nErro ao ler de arquivo:");
            e.printStackTrace();
        }
    }
}
