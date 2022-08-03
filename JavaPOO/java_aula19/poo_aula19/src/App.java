import java.io.IOException;
import java.util.ArrayList;

public class App {

    public static void  limparTela() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }


    public static void main(String[] args) throws Exception {
        limparTela();
        // Pessoa p1 = new Pessoa();
        // p1.setNome("Fulano de tal ");
        // p1.setIdade(21);
        // //System.out.printf("%s tem %d anos de idade.\n", p1.nome, p1.idade);
        // p1.mostrarDados();

        // Pessoa p2 = new Pessoa();
        // p2.setNome("Beltrano de tal");
        // p2.setIdade(35);
        // //System.out.printf("%s tem %d anos de idade.\n", p2.nome, p2.idade);
        // p2.mostrarDados();

        // Pessoa p3 = new Pessoa();
        // p3.mostrarDados();

        // Pessoa p4 = new Pessoa("Cricrano de Tal", 42);
        // System.out.println(p4.getSalario());
        // p4.mostrarDados();

        // Pessoa p5 = new Pessoa("Ada Lovelace");
        // p5.setIdade(56);
        // p5.mostrarDados();

        // Aluno a1 = new Aluno("Aluno de programação", 19, "Abc123");
        // a1.mostrarDados();

        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(new Aluno("Aluno 1", 18, "abc12345"));
        pessoas.add(new Professor("Professor 1", 36, "Computação"));
        pessoas.add(new Aluno("Aluno 2", 25, "abc78441"));
        pessoas.add(new Aluno("Aluno 3", 21, "abc35445"));
        pessoas.add(new Professor("Professor 2", 44, "Matemática"));
        pessoas.add(new Aluno("Aluno 4", 17, "abc45874"));
        pessoas.add(new Aluno("Aluno 5", 19, "abc99451"));
        pessoas.add(new Professor("Professor 3", 36, "Física"));

        for (Pessoa pessoa : pessoas) {
            pessoa.mostrarDados();
        }
        

    }
}
