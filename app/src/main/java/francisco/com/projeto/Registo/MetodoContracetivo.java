package francisco.com.projeto.Registo;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
import francisco.com.projeto.Global.Utils;
import francisco.com.projeto.R;
import francisco.com.projeto.TelaPrincipal;

import static francisco.com.projeto.R.id.spinnerMetodo;


public class MetodoContracetivo extends MenuActivity implements View.OnClickListener {

    MaterialBetterSpinner mySpinner;
    Button btn_InserirMetodo;

    String[] SPINNERLIST = {"Pilula", "VRing", "Adesivo", "Injecao"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metodo_contracetivo);
        setTitle("Método Contracetivo");

        btn_InserirMetodo = (Button) findViewById(R.id.btn_InserirMetodo);
        btn_InserirMetodo.setOnClickListener(this);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SPINNERLIST);
        MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner) findViewById(spinnerMetodo);
        betterSpinner.setAdapter(arrayAdapter);


        mySpinner = (MaterialBetterSpinner) findViewById(spinnerMetodo);

    }


    public void onClick(View view) {

        Utils u = Utils.getInstance();
        String em = u.getEmail();

        switch (view.getId()) {
            case R.id.btn_InserirMetodo:
                new MetodoContracetivo.HttpAsyncTask().execute("http://" + u.getIp() + ":8080/Restful/cliente/insereMetodoContracetivo", em, mySpinner.getText().toString());
                break;
        }

    }

    public static String POST(String url, Utils u) {
        InputStream inputStream = null;
        String result = "";

        try {

            HttpClient httpclient = new DefaultHttpClient();

            HttpPost httpPost = new HttpPost(url);

            String json = "";

            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();

            jsonObject.accumulate("email", u.getEmail());
            jsonObject.accumulate("nome_metodo", u.getNome_metodo());


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

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            Utils u = new Utils();

            u.setEmail(urls[1]);
            u.setNome_metodo(urls[2]);


            return POST(urls[0], u);

        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            if (result.equals("{\"verifica\":\"exito\"}")) {
                Toast.makeText(getBaseContext(), "Inserido com sucesso!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getBaseContext(), "Erro a inserir!", Toast.LENGTH_LONG).show();
            }
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
