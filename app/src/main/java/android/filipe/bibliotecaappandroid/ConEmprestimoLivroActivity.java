package android.filipe.bibliotecaappandroid;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.filipe.bibliotecaappandroid.R;
import android.widget.Button;
import android.widget.EditText;


public class ConEmprestimoLivroActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conemprestimo);

        final Modelo_Emprestimo emprest = new Modelo_Emprestimo();
        final DAOBanco banco = new DAOBanco(ConEmprestimoLivroActivity.this.getApplicationContext());

        final EditText consulta = (EditText) findViewById(R.id.et_conemprestismo);
        Button btconsulta = (Button) findViewById(R.id.bt_conemprestimo);

        btconsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Modelo_Emprestimo aux = new Modelo_Emprestimo();
                StringBuffer buffer = new StringBuffer();
                emprest.setCodigo_Emprestimo(Double.parseDouble(consulta.getText().toString()));
                aux = banco.buscarEmprestimoCodigo(emprest);

                buffer.append("Codigo: " + String.valueOf(aux.getCodigo_Emprestimo())+"\n");
                buffer.append("Data: " +String.valueOf(aux.getData_Emprestimo())+"\n");
                buffer.append("Valor: " +String.valueOf(aux.getValor_Emprestimo())+"\n");
                buffer.append("Livro: " +String.valueOf(aux.getLivro_Emprestimo())+"\n");
                buffer.append("Cliente: " +String.valueOf(aux.getCliente_EMprestimo())+"\n\n");
                mostrarConsulta("Consulta Emprestimo", buffer.toString());
            }
        });
    }
    public void mostrarConsulta (String titulo, String mensagem) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(titulo);
        builder.setMessage(mensagem);
        builder.show();
    }
}
