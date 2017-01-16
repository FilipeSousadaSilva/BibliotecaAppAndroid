package android.filipe.bibliotecaappandroid;

/**
 * Created by filipe on 15/06/2016.
 */
public class Modelo_Livros {
    private double codigo;
    private String nome;
    private double valor;
    private String genero;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getCodigo() {
        return codigo;
    }

    public void setCodigo(double codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
