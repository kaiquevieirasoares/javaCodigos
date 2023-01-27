package dominio;

public class Game {
    private String nome;
    private double preco;
    private String genero;
    private int codigo;
    private int codigoDistribuidora;

    public Game(String nome, double preco, String genero, int codigo, int codigoDistribuidora) {
        this.nome = nome;
        this.preco = preco;
        this.genero = genero;
        this.codigo = codigo;
        this.codigoDistribuidora = codigoDistribuidora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoDistribuidora() {
        return codigoDistribuidora;
    }

    public void setCodigoDistribuidora(int codigoDistribuidora) {
        this.codigoDistribuidora = codigoDistribuidora;
    }

    @Override
    public String toString() {
            return "Nome: " + nome + "\nPreço: " + preco + "\nGênero: " + genero + "\nCódigo: " + codigo + "\nCódigo da Distribuidora: " + codigoDistribuidora;
    }
    
    
    
}
