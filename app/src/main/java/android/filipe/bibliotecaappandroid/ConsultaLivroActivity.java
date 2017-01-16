package android.filipe.bibliotecaappandroid;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.filipe.bibliotecaappandroid.R;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class ConsultaLivroActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_consultarlivro);
        super.onCreate(savedInstanceState);
        final Modelo_Livros livros = new Modelo_Livros();
        final DAOBanco banco = new DAOBanco(ConsultaLivroActivity.this.getApplicationContext());

        final EditText con = (EditText) findViewById(R.id.editText_consultar);
        Button bt = (Button) findViewById(R.id.button_consultar);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<Modelo_Livros> consulta = new ArrayList<Modelo_Livros>();
                livros.setNome(con.getText().toString());
                Cursor res = banco.buscarLivroNome(livros);
                res.moveToFirst();

                StringBuffer buffer = new StringBuffer();

                 do {
                    buffer.append("Codigo: " +res.getDouble(0)+"\n");
                    buffer.append("Nome: " +res.getString(1)+"\n");
                    buffer.append("Valor: " +res.getDouble(2)+"\n");
                    buffer.append("Genero: " +res.getString(3)+"\n\n");
                }while (res.moveToNext());
                mostrarConsulta("Consultar Livro",buffer.toString());
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
