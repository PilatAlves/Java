public class Professor extends Pessoa implements ProfessorInterface {
    public String formacao;
    public void mostrarDados(){
        System.out.printf("Nome: %s\nIdade: %d\nFormação: %s\n", this.nome,
        this.idade, this.formacao);
    }
    
    public void corrigirProva() {
        System.out.println("Corrigindo prova");
        
    }

    public void mostrarIdade() {
        System.out.printf("Idade: %d\n", this.idade);
        
    }
}
