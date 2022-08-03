import com.kyem.curso.Aluno;

public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Hello, World!"); //Imprime na tela
        Aluno a1 = new Aluno();
        a1.matricular();
        
        /* Utilizar quando for nessario importar uma ou mais classes, com o mesmo nome em diretórios
        diferentes em vez de importar que não é possivel utilizar dessa forma */
        com.kyem.escola.Aluno a2 = new com.kyem.escola.Aluno(); 
        a2.matricular();
        
    }
}
