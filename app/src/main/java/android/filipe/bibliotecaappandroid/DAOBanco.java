package android.filipe.bibliotecaappandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Display;

import java.util.ArrayList;
import java.util.List;


public class DAOBanco {
    private SQLiteDatabase bdados;

    public DAOBanco(Context context) {
        BancoSQLite auxBd = new BancoSQLite(context);
        bdados = auxBd.getWritableDatabase();
    }

    public void adicionarLivro(Modelo_Livros livros) {
        ContentValues valor = new ContentValues();

        valor.put("Codigo_Livro", livros.getCodigo());
        valor.put("Nome_Livro", livros.getNome());
        valor.put("Valor_Livro", livros.getValor());
        valor.put("Genero_Livro", livros.getGenero());
        bdados.insert("TB_LIVROS", null, valor);
    }

    public void deletarLivro(Modelo_Livros livros) {
        bdados.delete("TB_LIVROS", "Codigo_Livro = " + livros.getCodigo(), null);
    }

    public void atualizarLivro(Modelo_Livros livros) {
        ContentValues valor = new ContentValues();
        valor.put("Codigo_Livro", livros.getCodigo());
        valor.put("Nome_Livro", livros.getNome());
        valor.put("Valor_Livro", livros.getValor());
        valor.put("Genero_Livro", livros.getGenero());
        bdados.update("TB_LIVROS", valor, "Codigo_Livro = ?", new String[]{String.valueOf(livros.getCodigo())});
    }

    public Cursor buscarLivroNome(Modelo_Livros livros) {
        Modelo_Livros aux = new Modelo_Livros();
        List<Modelo_Livros> m_livros = new ArrayList<Modelo_Livros>();
        Cursor cursor;

        if(livros.getNome().equals("null")) {
            cursor = bdados.rawQuery("select * from TB_LIVROS", null);
        }
        else{
            cursor = bdados.rawQuery("select * from TB_LIVROS where Nome_Livro like '%"+livros.getNome()+"%'", null);
        }

        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {

                livros.setCodigo(cursor.getDouble(0));
                livros.setNome(cursor.getString(1));
                livros.setValor(cursor.getDouble(2));
                livros.setGenero(cursor.getString(3));

            } while (cursor.moveToNext());
        }
        return cursor;
    }

    public Modelo_Livros buscarLivroCodigo(Modelo_Livros livros) {
        Modelo_Livros u = new Modelo_Livros();
        Cursor cursor;
            cursor = bdados.rawQuery("select * from TB_LIVROS where Codigo_Livro = "+livros.getCodigo()+"", null);

        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {

                u.setCodigo(cursor.getDouble(0));
                u.setNome(cursor.getString(1));
                u.setValor(cursor.getDouble(2));
                u.setGenero(cursor.getString(3));

            } while (cursor.moveToNext());
        }
        return u;
    }

    public void adicionarEmprestimo(Modelo_Emprestimo empre) {
        ContentValues valor = new ContentValues();

        valor.put("Codigo_Emprestimo", empre.getCodigo_Emprestimo());
        valor.put("Data_Emprestimo", empre.getData_Emprestimo());
        valor.put("Valor_Emprestimo", empre.getValor_Emprestimo());
        valor.put("Livro_Emprestimo ", empre.getLivro_Emprestimo());
        valor.put("Cliente_EMprestimo ", empre.getCliente_EMprestimo());

        bdados.insert("TB_EMPRESTIMO", null, valor);
    }

    public Modelo_Emprestimo buscarEmprestimoCodigo(Modelo_Emprestimo empre) {
        Modelo_Emprestimo u = new Modelo_Emprestimo();
        Cursor cursor;
        cursor = bdados.rawQuery("select * from TB_EMPRESTIMO where Codigo_Emprestimo = "+empre.getCodigo_Emprestimo()+"", null);

        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {

                u.setCodigo_Emprestimo(cursor.getDouble(0));
                u.setData_Emprestimo(cursor.getString(1));
                u.setValor_Emprestimo(cursor.getDouble(2));
                u.setLivro_Emprestimo(cursor.getDouble(3));
                u.setCliente_EMprestimo(cursor.getDouble(4));

            } while (cursor.moveToNext());
        }
        return u;
    }



}

