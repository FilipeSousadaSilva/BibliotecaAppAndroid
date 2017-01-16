package android.filipe.bibliotecaappandroid;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.filipe.bibliotecaappandroid.R;
import android.widget.Button;
import android.widget.EditText;


public class AlterarLivroFormActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Modelo_Livros aux = new Modelo_Livros();
        final DAOBanco banco = new DAOBanco(AlterarLivroFormActivity.this.getApplicationContext());
        Modelo_Livros livros = new Modelo_Livros();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterarform);

        Bundle bundle = getIntent().getExtras();
        double cod_livro = bundle.getDouble("CODIGO");
        Log.d("BUNDLE CD", String.valueOf(cod_livro));


        livros.setCodigo(cod_livro);
        livros = banco.buscarLivroCodigo(livros);

        EditText nome = (EditText) findViewById(R.id.editText_nn);
        EditText cod = (EditText) findViewById(R.id.editText_cd);
        EditText valor = (EditText) findViewById(R.id.editText_vvalor);
        EditText gen = (EditText) findViewById(R.id.editText_gen);
        Button btalt = (Button) findViewById(R.id.btn_alterarxzy);

        cod.setText(String.valueOf(livros.getCodigo()));
        nome.setText(livros.getNome());
        valor.setText(String.valueOf(livros.getValor()));
        gen.setText(livros.getGenero());


        btalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nome = (EditText) findViewById(R.id.editText_nn);
                EditText cod = (EditText) findViewById(R.id.editText_cd);
                EditText valor = (EditText) findViewById(R.id.editText_vvalor);
                EditText gen = (EditText) findViewById(R.id.editText_gen);

                aux.setCodigo(Double.parseDouble(cod.getText().toString()));
                aux.setNome(nome.getText().toString());
                aux.setValor(Double.parseDouble(valor.getText().toString()));
                aux.setGenero(gen.getText().toString());

                banco.atualizarLivro(aux);

                mostrarAltera("Alterar Produto", "Produto: " + aux.getNome() + " Alterado!\n\n");

            }
        });

    }
    public void mostrarAltera (String titulo, String mensagem) {
        AlertDialog.Builder builder = new AlertDialog.Builder(AlterarLivroFormActivity.this);
        builder.setCancelable(true);
        builder.setTitle(titulo);
        builder.setMessage(mensagem);
        builder.show();
    }
}
