package francisco.com.projeto;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import francisco.com.projeto.Calendario.CalendarioActivity;
import francisco.com.projeto.Calendario.IrCalendarioActivity;
import francisco.com.projeto.Global.Utils;
import francisco.com.projeto.Registo.RegistoActivity;
import francisco.com.projeto.Registo.UsuariaRegisto;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edEmail, edPaswword;  //private
    Button btnLogin, btnRegistar;    //private
    private SharedPreferences prefs;
    UsuariaRegisto usr;

    private ListView lvUtilizadores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Login");

        Utils u = Utils.getInstance();
        u.setIp("192.168.0.103");


        edEmail = (EditText) findViewById(R.id.email);
        edPaswword = (EditText) findViewById(R.id.password);
        btnRegistar = (Button) findViewById(R.id.btnregistar);
        btnLogin = (Button) findViewById(R.id.btnlogin);
        lvUtilizadores = (ListView) findViewById(R.id.lvUtilizador);

        btnLogin.setOnClickListener(this);
        btnRegistar.setOnClickListener(this);

        prefs = getSharedPreferences("MY_DATA", MODE_PRIVATE);
        String emailShared = prefs.getString("EMAIL", "");
        String passwordShared = prefs.getString("PASSWORD", "");


        if (android.os.Build.VERSION.SDK_INT > 9) {  //se a versao do SDK for > 9 ele deixa rodar
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

    }


    public static String POST(String url, UsuariaRegisto usr) {
        InputStream inputStream = null;
        String result = "";

        try {

            HttpClient httpclient = new DefaultHttpClient();

            HttpPost httpPost = new HttpPost(url);

            String json = "";

            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();

            jsonObject.accumulate("email", usr.getEmail());
            jsonObject.accumulate("password", usr.getPassword());
            Log.d("JSON", jsonObject + "");

            // 4. convert JSONObject to JSON to String
            json = jsonObject.toString();

            // 5. set json to StringEntity
            StringEntity se = new StringEntity(json);

            // 6. set httpPost Entity
            httpPost.setEntity(se);

            // 7. Set some headers to inform server about the type of the content 
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            // 8. Execute POST request to the given URL
            HttpResponse httpResponse = httpclient.execute(httpPost);

            // 9. receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // 10. convert inputstream to string
            if (inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Não funciona!";

        } catch (Exception e) {
            //Log.d("InputStream", e.getLocalizedMessage());
        }

        // 11. return result
        return result;
    }


    public void onClick(View view) {
        Utils u = Utils.getInstance();

        switch (view.getId()) {
            case R.id.btnlogin:

                if (!validate()) {
                    Toast.makeText(getBaseContext(), "Tem de preencher as caixas de texto!", Toast.LENGTH_LONG).show();
                } else {
                    // call AsynTask to perform network operation on separate thread
                    new HttpAsyncTask().execute("http://" + u.getIp() + ":8080/Restful/cliente/verificaLogin", edEmail.getText().toString(), edPaswword.getText().toString());
                }
                break;
            case R.id.btnregistar:
                Intent it = new Intent(MainActivity.this, RegistoActivity.class);
                startActivity(it);
                break;
        }

    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            Utils u = Utils.getInstance();

            usr = new UsuariaRegisto();

            usr.setEmail(urls[1]);
            usr.setPassword(urls[2]);


            u.setEmail(urls[1]);    //GLOBAL
            u.setPassword(urls[2]);

            return POST(urls[0], usr);

        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {


            try {
                JSONObject json = new JSONObject(result);
                //Log.d("OBJETO JSON", json + "");

                String sresp = json.getString("tipoDeUtilizador");

                Log.d("RESULTADO", result + "");


                if (!sresp.trim().equals("")) {
                    Utils u = Utils.getInstance();
                    if (result.equals("{\"tipoDeUtilizador\":\"Usuaria\"}")) {

                        u.setEmail(edEmail.getText().toString());
                        u.setPassword(edPaswword.getText().toString());
                        u.setTipoDeUsuario("Usuaria");

                        Intent it = new Intent(MainActivity.this, TelaPrincipal.class);
                        startActivity(it);
                        Toast.makeText(getBaseContext(), "Fez login com sucesso! Usuária", Toast.LENGTH_LONG).show();
                    } else if (result.equals("{\"tipoDeUtilizador\":\"Medico\"}")) {
                        u.setEmail(edEmail.getText().toString());
                        u.setPassword(edPaswword.getText().toString());
                        u.setTipoDeUsuario("Medico");

                        Intent it = new Intent(MainActivity.this, TelaPrincipalCompEMedico.class);
                        startActivity(it);
                        Toast.makeText(getBaseContext(), "Fez login com sucesso! Medico", Toast.LENGTH_LONG).show();
                    } else if (result.equals("{\"tipoDeUtilizador\":\"Companheiro\"}")) {
                        u.setEmail(edEmail.getText().toString());
                        u.setPassword(edPaswword.getText().toString());
                        u.setTipoDeUsuario("Companheiro");

                        Intent it = new Intent(MainActivity.this, TelaPrincipalCompEMedico.class);
                        startActivity(it);
                        Toast.makeText(getBaseContext(), "Fez login com sucesso! Companheiro", Toast.LENGTH_LONG).show();
                    }
                } else {
                    //Toast.makeText(getBaseContext(), "Não iniciou sessão!", Toast.LENGTH_LONG).show();
                }

            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(getBaseContext(), "Não iniciou sessão!", Toast.LENGTH_LONG).show();
            }

        }
    }

    //ver se esta alguma vazia
    private boolean validate() {

        if (edEmail.getText().toString().trim().equals(""))
            return false;
        else if (edPaswword.getText().toString().trim().equals(""))
            return false;
        else
            return true;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while ((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

}

