public final class Professor extends Pessoa {
    
    private String formacao;
    public String getFormcao(){
        return this.formacao;
    }

    public void setFormacao(String formacao) throws Exception{
        if (formacao.length() > 2) {
            this.formacao = formacao;
        } else {
            throw new Exception(" O nome da formação deve ter pelo menos dois caracteres");
        }
    }

    public void mostrarDados() {
        System.out.printf("%s tem %d anos de idade e sua formação é %s\n",
            this.getNome(), this.getIdade(), this.getFormcao());
    }

    public Professor(String nome, int idade, String formacao) throws Exception {
        super(nome, idade);
        this.setFormacao(formacao);
    }


}
