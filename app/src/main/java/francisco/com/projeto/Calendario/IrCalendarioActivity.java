package francisco.com.projeto.Calendario;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
public class IrCalendarioActivity extends MenuActivity implements View.OnClickListener {

    Button btnAvanca;

    Utils u;
    String dataRecebida = "";
    String numeroRecebido = "";
    String numeroDiasCiclo = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ir_calendario);
        setTitle("");
        btnAvanca = (Button) findViewById(R.id.btnAvancar);

        btnAvanca.setOnClickListener((View.OnClickListener) this);

        Utils u = Utils.getInstance();
        String em = u.getEmail();
        Log.d("EMAIL::::::", u.getEmail());
        String pass = u.getPassword();
        Log.d("PASWORD::::::", u.getPassword());
        String tipo = u.getTipoDeUsuario();
        Log.d("TIPO::::::", u.getTipoDeUsuario());
        if (tipo.equals("Usuaria")) {
            new IrCalendarioActivity.HttpAsyncTask().execute("http://" + u.getIp() + ":8080/Restful/calendario/verDataCalendario", em, "");
        }
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnAvancar:
                Intent it = new Intent(IrCalendarioActivity.this, CalendarioActivity.class);
                startActivity(it);
                break;
        }
    }

    public String POST(String url, Utils u) {
        InputStream inputStream = null;
        String result = "";

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            String json = "";
            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("email", u.getEmail());
            jsonObject.accumulate("password", u.getPassword());
            // 4. convert JSONObject to JSON to String
            json = jsonObject.toString();
            // 5. set json to StringEntity
            StringEntity se = new StringEntity(json);
            // 6. set httpPost Entity
            httpPost.setEntity(se);
            Log.d("SE", se + "");
            // 7. Set some headers to inform server about the type of the content 
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            // 8. Execute POST request to the given URL
            HttpResponse httpResponse = httpclient.execute(httpPost);      //PROBLEMA
            //Log.d("HttpResponse", httpResponse + "");
            // 9. receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();
            //Log.d("INPUTSTREAM", inputStream + "");
            // 10. convert inputstream to string
            if (inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Não funciona!";

        } catch (Exception e) {
            e.printStackTrace();
            //Log.d("InputStream", e.getLocalizedMessage());
        }
        // 11. return result
        return result;
    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            u = new Utils();
            u.setEmail(urls[1]);
            //Log.d("Duraçao Ciclo", quest + "");
            u.setPassword(urls[2]);
            //Log.d("Duraçao Ultima", quest + "");
            return POST(urls[0], u);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "RESULT!" + result, Toast.LENGTH_LONG).show();
            Log.d("RESULTADO", result);
            //34 a lenght -2
            dataRecebida = result.substring(35, 45);
            Log.d("RESULTADO CORTADO", dataRecebida);

            numeroDiasCiclo = result.substring(72, 74);
            Log.d("NUMERO", numeroDiasCiclo);

            numeroRecebido = result.substring(104, 105);
            Log.d("DIAS DO CICLO", numeroRecebido);


            Utils u = Utils.getInstance();
            u.setData(dataRecebida);
            u.setNumeroAreceber(numeroRecebido);
            u.setDuracaoCicloMenstrual(numeroDiasCiclo);
        }
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
