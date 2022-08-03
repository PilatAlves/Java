public class Aluno extends Pessoa implements AlunoInterface {
    public String matricula;
    public void mostrarDados(){
        System.out.printf("Nome: %s\nIdade: %d\nMatricula: %s\n", this.nome,
        this.idade, this.matricula);
    }
 

    public void fazerProva() {
        System.out.println("Fzendo prova...");
        
    }


    public void mostrarIdade() {
        System.out.printf("Idade: %d\n", this.idade);
        
    }
    
}
