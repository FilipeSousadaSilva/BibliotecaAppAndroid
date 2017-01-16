package android.filipe.bibliotecaappandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.filipe.bibliotecaappandroid.R;
import android.widget.Button;

/**
 * Created by filipe on 15/06/2016.
 */
public class MenuActivity extends AppCompatActivity{
    BancoSQLite mBanco;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mBanco = new BancoSQLite(this);
        Button addlivro = (Button) findViewById(R.id.button_addlivro);
        Button altlivro = (Button) findViewById(R.id.button_alterarlivro);
        Button exclivro = (Button) findViewById(R.id.button_excluirlivro);
        Button conlivro = (Button) findViewById(R.id.button_consultarlivro);
        Button emprlivro = (Button) findViewById(R.id.button_emprestimo);
        Button conemprlivro = (Button) findViewById(R.id.button_conemprestimo);

        addlivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calladd();
            }
        });

        altlivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callalt();
            }
        });

        exclivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calldel();
            }
        });

        conlivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callcons();
            }
        });

        emprlivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callempr();
            }
        });

        conemprlivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callconempre();
            }
        });

    }
    public void calladd() {
        Intent intent = new Intent(this, AddLivroActivity.class);
        MenuActivity.this.startActivity(intent);
    }
    public void callcons() {
        Intent intent = new Intent(this, ConsultaLivroActivity.class);
        MenuActivity.this.startActivity(intent);
    }
    public void calldel() {
        Intent intent = new Intent(this, DeletarLivroActivity.class);
        MenuActivity.this.startActivity(intent);
    }

    public void callalt(){
        Intent intent = new Intent(this, AlterarLivroActivity.class);
        MenuActivity.this.startActivity(intent);
    }

    public void callempr(){
        Intent intent = new Intent(this, EmprestimoLivroActivity.class);
        MenuActivity.this.startActivity(intent);
    }

    public void callconempre(){
        Intent intent = new Intent(this, ConEmprestimoLivroActivity.class);
        MenuActivity.this.startActivity(intent);
    }

}
