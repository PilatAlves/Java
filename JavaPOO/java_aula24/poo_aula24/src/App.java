import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class App {

    public static void limparTela(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start()
            .waitFor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        limparTela();
        // criarArquivoBinarioSerializado();
        // lerArquivoBinarioSerializado();
        ArrayList<Pessoa> pessoas = criarListaDePessoasEmMemoria();
        persistirListaDePessoasEmArquivoBinario(pessoas);
        ArrayList<Pessoa> pessoasLidas = lerListaDePessoasDeArquivoBinario();
        mostrarListaPessoas(pessoasLidas);
       
    }

    private static void criarArquivoBinarioSerializado() {
        Pessoa p1 = new Pessoa(1, "Fulano de Tal", 2000, "123456");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("arquivo.bin");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(p1);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo.");
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e){
                    System.out.println("Erro ao fechar o arquivo.");
                }
            }
        }
    }

    private static void lerArquivoBinarioSerializado() {
        Pessoa p1 = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("arquivo.bin");
            ois = new ObjectInputStream(fis);
            p1 = (Pessoa)ois.readObject();
            System.out.printf("Id: %2d\nNome: %s\nSalário: %.2f\nSenha: %s\n",
            p1.getId(), p1.getNome(), p1.getSalario(), p1.getSenha());
        } catch (ClassNotFoundException e) {
            System.out.println("Classe não encontrado.");
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo.");
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e){
                    System.out.println("Erro ao fechar o arquivo.");
                }
            }
        }
    }

    private static ArrayList<Pessoa> criarListaDePessoasEmMemoria() {
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(new Pessoa(1, "Charles Babbage", 1000, "123456"));
        pessoas.add(new Pessoa(2, "John Backus", 4000, "123456"));
        pessoas.add(new Pessoa(3, "Tim Berners-Lee", 2000, "123456"));
        pessoas.add(new Pessoa(4, "Edsger Dijkstra", 2000, "123456"));
        pessoas.add(new Pessoa(5, "Anders Hejlsberg", 3000, "123456"));
        return pessoas;
    }

    private static void persistirListaDePessoasEmArquivoBinario(ArrayList<Pessoa> pessoas) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("pessoas.dat");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(pessoas);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo.");
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e){
                    System.out.println("Erro ao fechar o arquivo.");
                }
            }
        }
    }

    private static ArrayList<Pessoa> lerListaDePessoasDeArquivoBinario() {
        ArrayList<Pessoa> pessoas = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("pessoas.dat");
            ois = new ObjectInputStream(fis);
            pessoas = (ArrayList<Pessoa>)ois.readObject();
            return pessoas;
        } catch (ClassNotFoundException e) {
            System.out.println("Classe não encontrado.");
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo.");
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e){
                    System.out.println("Erro ao fechar o arquivo.");
                }
            }
        }
        return null;
    }

    // Formatador
    private static void mostrarListaPessoas(ArrayList<Pessoa> pessoas){
        System.out.printf("%-8s%-20s%10s %-8s\n",
            "Código", "Nome", "Salário", "Senha");
        System.out.println("--------------------------------------------\n");
        for (Pessoa pessoa : pessoas) {
            System.out.printf("%06d %-20s%10.2f %-8s\n",
                pessoa.getId(), pessoa.getNome(), pessoa.getSalario(), pessoa.getSenha());
        }
    }
}
