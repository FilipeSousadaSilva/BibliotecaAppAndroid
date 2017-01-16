package android.filipe.bibliotecaappandroid;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.filipe.bibliotecaappandroid.R;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by filipe on 16/06/2016.
 */
public class EmprestimoLivroActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emprestimo);
        final Modelo_Emprestimo emprestimo = new Modelo_Emprestimo();
        final DAOBanco banco = new DAOBanco(EmprestimoLivroActivity.this.getApplicationContext());

        final EditText codemprestimo = (EditText) findViewById(R.id.editText_codemprestimo);
        final EditText dataemprestimo = (EditText) findViewById(R.id.editText_dataemprestimo);
        final EditText valoremprestimo = (EditText) findViewById(R.id.editText_valoremprestimo);
        final EditText livroemprestimo = (EditText) findViewById(R.id.editText_codigolivremprestimo);
        final EditText clienteemprestimo = (EditText) findViewById(R.id.editText_codclientemprestimo);

        Button btemprestimo = (Button) findViewById(R.id.button_efempretismo);

        btemprestimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emprestimo.setCodigo_Emprestimo(Double.parseDouble(codemprestimo.getText().toString()));
                emprestimo.setData_Emprestimo(dataemprestimo.getText().toString());
                emprestimo.setValor_Emprestimo(Double.parseDouble(valoremprestimo.getText().toString()));
                emprestimo.setLivro_Emprestimo(Double.parseDouble(livroemprestimo.getText().toString()));
                emprestimo.setCliente_EMprestimo(Double.parseDouble(clienteemprestimo.getText().toString()));
                banco.adicionarEmprestimo(emprestimo);

                mostrarAddEmprestimo("Efetuar Emprestimo", "Emprestimo " + emprestimo.getCodigo_Emprestimo()+ " Efetuado!\n");

            }
       });
    }
    public void mostrarAddEmprestimo(String titulo, String mensagem) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(titulo);
        builder.setMessage(mensagem);
        builder.show();
    }
}
