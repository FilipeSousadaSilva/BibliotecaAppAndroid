package android.filipe.bibliotecaappandroid;

/**
 * Created by filipe on 16/06/2016.
 */
public class Modelo_Emprestimo {
    private double Codigo_Emprestimo;
    private String Data_Emprestimo;
    private double Valor_Emprestimo;
    private  double Livro_Emprestimo;
    private  double Cliente_EMprestimo;

    public double getCliente_EMprestimo() {
        return Cliente_EMprestimo;
    }

    public void setCliente_EMprestimo(double cliente_EMprestimo) {
        Cliente_EMprestimo = cliente_EMprestimo;
    }

    public double getLivro_Emprestimo() {
        return Livro_Emprestimo;
    }

    public void setLivro_Emprestimo(double livro_Emprestimo) {
        Livro_Emprestimo = livro_Emprestimo;
    }

    public String getData_Emprestimo() {
        return Data_Emprestimo;
    }

    public void setData_Emprestimo(String data_Emprestimo) {
        Data_Emprestimo = data_Emprestimo;
    }

    public double getCodigo_Emprestimo() {
        return Codigo_Emprestimo;
    }

    public void setCodigo_Emprestimo(double codigo_Emprestimo) {
        Codigo_Emprestimo = codigo_Emprestimo;
    }

    public double getValor_Emprestimo() {
        return Valor_Emprestimo;
    }

    public void setValor_Emprestimo(double valor_Emprestimo) {
        Valor_Emprestimo = valor_Emprestimo;
    }
}
