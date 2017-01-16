package android.filipe.bibliotecaappandroid;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.filipe.bibliotecaappandroid.R;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class LoginActivity extends AppCompatActivity {
    private Login autorizar = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText field_login = (EditText) findViewById(R.id.field_login);
        final EditText field_senha = (EditText) findViewById(R.id.field_senha);
        Button entrar = (Button) findViewById(R.id.button_entrar);



        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String usuario = field_login.getText().toString();
                final String senha = field_senha.getText().toString();
                autorizar = new Login(usuario, senha);
                autorizar.execute();
            }
        });

    }

    public class Login extends AsyncTask<String, String, String>{
        private final String ULOGIN;
        private final String USENHA;

        Login(String usuario, String senhas) {
            ULOGIN = usuario;
            USENHA = senhas;
        }

        @Override
        protected String doInBackground(String... strings) {



            HttpURLConnection connection = null;
            BufferedReader reader = null;
            Log.d("login", ULOGIN);
            Log.d("senha", USENHA);


            try {

                URL url = new URL("http://192.16.43.41:8080/trabalho_biblioteca/validaLoginAndroid");
                String login = ULOGIN;
                String senha = USENHA;
                Log.d("LOGIN post APP: ",login);
                Log.d("SENHA post APP: ",senha);

                String data = URLEncoder.encode("LOGIN", "UTF-8")
                        + "=" +URLEncoder.encode(login, "UTF-8");
                data += "&" + URLEncoder.encode("SENHA", "UTF-8")
                        + "=" +URLEncoder.encode(senha,"UTF-8");

                Log.d("STRING DATA FORMADA ",data);

                connection = (HttpURLConnection) url.openConnection();

                connection.setDoOutput(true);

                OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());

                wr.write( data );
                wr.flush();

                String response = ""; // variavel que recebe JSON
                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();

                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");

                }

                response = buffer.toString();
                JSONObject json_object = null;

                json_object = new JSONObject(response); //converte variavel Json para objeto Json
                Log.d("JSON: ", response);
                //String test = (json_object.get("id"));
                Log.d("JSONID: ", String.valueOf(json_object.get("id")));
                Log.d("ADM JSON tipo: ", String.valueOf(json_object.get("tipo")));

                if ((json_object.get("tipo").equals("ADM"))) {
                    Intent it = new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(it);

                }
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            finally {
                //    connection.disconnect();
                try {

                    if(reader != null) {
                        reader.close();
                    }
                } catch(IOException e) {

                }

            }

            return null;
        }
    }
}
