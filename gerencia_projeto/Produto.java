public class Produto {
    @SuppressWarnings("unused")
    private int id, quantidade;
    private static int contador = 0;
    private String nome, descricao;
    private double valor;

    public Produto(int qtd, String nome, String desc, double valor){
        this.id = ++contador; // Incrementa o contador e atribui ao id
        this.quantidade = qtd;
        this.nome = nome;
        this.descricao = desc;
        this.valor = valor;
    }

    // Métodos get para os atributos da classe
    public int getId() {return id;}
    public String getNome() {return nome;}
    public String getDescricao() {return descricao;}
    public double getValor() {return valor;}
    // possibilita a mudança no valor da quantidade
    public void setQuantidade(int qtd) {
        this.quantidade = qtd;
    }

    public String toString(){
        return "\nID:" + id +
               "\nNome: " + nome +
               "\nDescrição: " + descricao +
               "\nQuantidade: " + quantidade +
               "\nValor: R$" + valor; 
    }

    
}
