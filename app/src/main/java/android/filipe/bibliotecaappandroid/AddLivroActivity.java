package android.filipe.bibliotecaappandroid;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.filipe.bibliotecaappandroid.R;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by filipe on 15/06/2016.
 */
public class AddLivroActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addlivro);
        final Modelo_Livros livros = new Modelo_Livros();
        final DAOBanco banco = new DAOBanco(AddLivroActivity.this.getApplicationContext());

        final EditText codigolivro = (EditText) findViewById(R.id.editText_codigo);
        final EditText nomelivro = (EditText) findViewById(R.id.editText_nome);
        final EditText valorlivro = (EditText) findViewById(R.id.editText_valor);
        final EditText generolivro = (EditText) findViewById(R.id.editText_genero);

        Button button_ad = (Button) findViewById(R.id.button_livro);
        button_ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                livros.setCodigo(Double.parseDouble(codigolivro.getText().toString()));
                livros.setNome(nomelivro.getText().toString());
                livros.setValor(Double.parseDouble(valorlivro.getText().toString()));
                livros.setGenero(generolivro.getText().toString());

                banco.adicionarLivro(livros);
                mostrarAdicionar("Adicionar Livro", "Livro " + livros.getNome() + " Adicionado!");
            }
        });}

    public void mostrarAdicionar(String titulo, String mensagem) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(titulo);
        builder.setMessage(mensagem);
        builder.show();
    }
}