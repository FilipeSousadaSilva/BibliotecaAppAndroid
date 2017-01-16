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

/**
 * Created by Vitor on 16/06/2016.
 */
public class DeletarLivroActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        final Modelo_Livros livros = new Modelo_Livros();
        final DAOBanco banco = new DAOBanco(DeletarLivroActivity.this.getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletarlivro);

        final EditText codlivro = (EditText) findViewById(R.id.editText_cclivro);
        Button btlivro = (Button) findViewById(R.id.button_excl);

        btlivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                livros.setCodigo(Double.parseDouble(codlivro.getText().toString()));
                banco.deletarLivro(livros);
                mostrarDeletar("Deletar Livro", "Livro: " + livros.getNome() + " Deletado!");
            }
        });
    }
    public void mostrarDeletar (String titulo, String mensagem) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(titulo);
        builder.setMessage(mensagem);
        builder.show();
    }

}
