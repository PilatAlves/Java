import java.io.IOException;

public class App {

    public static void limparTela() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
    public static void main(String[] args) throws Exception {
        limparTela();
        Aluno p1 = new Aluno();
        p1.nome = "Fulano de tal";
        p1.idade = 25;
        p1.matricula = "Abc123";
        p1.mostrarDados();

        Professor p2 = new Professor();
        p2.nome = "Professor Pardal";
        p2.idade = 36;
        p2.formacao = "Computação";
        p2.mostrarDados();
    }
}
