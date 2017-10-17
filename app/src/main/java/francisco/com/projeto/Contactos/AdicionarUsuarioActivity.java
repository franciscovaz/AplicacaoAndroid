package francisco.com.projeto.Contactos;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import francisco.com.projeto.Global.MenuActivity;
import francisco.com.projeto.R;
import francisco.com.projeto.Global.Utils;
import francisco.com.projeto.TelaPrincipal;


//extends AppCompatActivity
public class AdicionarUsuarioActivity extends MenuActivity implements View.OnClickListener {
    MaterialBetterSpinner mySpinner;
    EditText edEmail;
    Button btnAdicionarContacto;

    RegistoEmails reg;

    String[] SPINNERLIST = {"Companheiro", "Medico"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_usuario);
        setTitle("Adicionar Contato");

        edEmail = (EditText) findViewById(R.id.etEmailContacto);
        btnAdicionarContacto = (Button) findViewById(R.id.btnAdicionarContacto);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SPINNERLIST);
        MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner) findViewById(R.id.spinnerTipoUsuario2);
        betterSpinner.setAdapter(arrayAdapter);

        mySpinner = (MaterialBetterSpinner) findViewById(R.id.spinnerTipoUsuario2);
        btnAdicionarContacto.setOnClickListener(this);
    }

    public static String POST(String url, RegistoEmails reg) {
        InputStream inputStream = null;
        String result = "";

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            String json = "";
            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();

            jsonObject.accumulate("email_Utilizadora", reg.getEmail_Utilizadora());
            jsonObject.accumulate("email_Contacto", reg.getEmail_Contacto());
            jsonObject.accumulate("tipoUtilizador", reg.getTipoUtilizador());


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
        String em = u.getEmail();

        switch (view.getId()) {
            case R.id.btnAdicionarContacto:
                if (!validate()) {
                    Toast.makeText(getBaseContext(), "Tem dados errados ou Tem de preencher as caixas de texto!", Toast.LENGTH_LONG).show();
                    // call AsynTask to perform network operation on separate thread
                } else {
                    new AdicionarUsuarioActivity.HttpAsyncTask().execute("http://" + u.getIp() + ":8080/Restful/cliente/adicionarContacto", edEmail.getText().toString(), mySpinner.getText().toString(), em);
                    break;
                }
        }
    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            reg = new RegistoEmails();

            reg.setEmail_Contacto(urls[1]);
            reg.setTipoUtilizador(urls[2]);
            reg.setEmail_Utilizadora(urls[3]);

            return POST(urls[0], reg);

        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            Toast.makeText(getBaseContext(), "RESULT!" + result, Toast.LENGTH_LONG).show();
            //VERIFICA NO REST SE JÁ EXISTE O EMAIL QUE QUER REGISTAR, SE SIM PEDE NOVAMENTE, SE AINDA NÃO EXISTIR, AVANÇA
            if (result.equals("{\"resposta\":\"Nao Existe Companheiro nos Registos\"}")) {
                //Toast.makeText(getBaseContext(), "O email que inseriu ja esta registado" + result, Toast.LENGTH_LONG).show();
                Toast.makeText(getBaseContext(), "Nao Existe Companheiro nos Registos!", Toast.LENGTH_LONG).show();
            } else if (result.equals("{\"resposta\":\"Nao Existe Medico nos Registos\"}")) {
                Toast.makeText(getBaseContext(), "Nao Existe Medico nos Registos!", Toast.LENGTH_LONG).show();
            } else if (result.equals("{\"resposta\":\"Ja existe relacionamento\"}")) {
                Toast.makeText(getBaseContext(), "Ja existe relacionamento!", Toast.LENGTH_LONG).show();
            } else if (result.equals("{\"resposta\":\"Sucesso\"}")) {
                Intent it = new Intent(AdicionarUsuarioActivity.this, Lista_ContactosActivity.class);
                startActivity(it);

            }
        }
    }

    //ver se esta alguma vazia
    private boolean validate() {

        if (edEmail.getText().toString().trim().equals(""))
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


