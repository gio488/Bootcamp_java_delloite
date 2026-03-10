public class Cliente {
     String nome;
     String cpf;


    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void consultar() {
        System.out.println("\n---DADOS DO CADASTRO ---");
        System.out.println("NOME: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("----------------------------");
    }

    public void atualizar(String novoNome, String novoCpf) {
        this.nome = novoNome;
        this.cpf = novoCpf;
        System.out.println("Dados atualizados com sucesso!");
    }

    public void prepararExclusao() {
        System.out.println("Limpando dados e removendo acesso de: " + this.nome);
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
}