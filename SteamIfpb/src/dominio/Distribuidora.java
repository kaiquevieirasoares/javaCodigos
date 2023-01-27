package dominio;

public class Distribuidora {

    private String nome;
    private int codigo;
    private String site;

    public Distribuidora(String nome, int codigo, String site) {
        this.nome = nome;
        this.codigo = codigo;
        this.site = site;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nCódigo: " + codigo + "\nSite: " + site;
    }

}
