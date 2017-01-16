package android.filipe.bibliotecaappandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BancoSQLite extends SQLiteOpenHelper{
    private static final String NOME_BD = "Biblioteca.db"; //
    private static final int VERSAO = 1;
    private static final String TABELA1 = "TB_LIVROS";
    private static final String TABELA2 = "TB_EMPRESTIMO";

    public BancoSQLite(Context context) {
        super(context, NOME_BD, null, VERSAO);
        SQLiteDatabase db = this.getWritableDatabase();
   }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE TB_LIVROS (" +
                "  Codigo_Livro DOUBLE  NOT NULL," +
                "  Nome_Livro VARCHAR(20)," +
                "  Valor_Livro DOUBLE," +
                "  Genero_Livro VARCHAR(20)," +
                "PRIMARY KEY(Codigo_Livro));");

        sqLiteDatabase.execSQL("CREATE TABLE TB_EMPRESTIMO (" +
                "  Codigo_Emprestimo DOUBLE  NOT NULL," +
                "  Data_Emprestimo VARCHAR(20)," +
                "  Valor_Emprestimo DOUBLE," +
                "  Livro_Emprestimo DOUBLE," +
                "  Cliente_EMprestimo DOUBLE," +
                "PRIMARY KEY(Codigo_Emprestimo));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table TB_LIVROS");
        sqLiteDatabase.execSQL("drop table TB_EMPRESTIMO");
        onCreate(sqLiteDatabase);
    }
}
