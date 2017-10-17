package francisco.com.projeto.Registo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
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

import francisco.com.projeto.Calendario.CalendarioActivity;
import francisco.com.projeto.Global.MenuActivity;
import francisco.com.projeto.Global.Utils;
import francisco.com.projeto.R;

import static com.riontech.calendar.CustomCalendar.data_global;


public class Anotacoes extends MenuActivity implements View.OnClickListener {

    MaterialBetterSpinner mySpinner;
    EditText et_peso;
    Switch switch_agua;
    Button btn_InserirAnotacoes;
    String aux_valor_boleano = "";

    String[] SPINNERLIST = {"0.5", "0.75", "1", "1.5", "1.75", "2", "2.5", "2.75", "3", "3.5", "3.75", "4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anotacoes);
        setTitle("Anotações");

        et_peso = (EditText) findViewById(R.id.et_peso);
        switch_agua = (Switch) findViewById(R.id.switch_agua);
        btn_InserirAnotacoes = (Button) findViewById(R.id.btn_InserirAnotacoes);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SPINNERLIST);
        MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner) findViewById(R.id.spinnerAgua);
        betterSpinner.setAdapter(arrayAdapter);


        mySpinner = (MaterialBetterSpinner) findViewById(R.id.spinnerAgua);

        btn_InserirAnotacoes.setOnClickListener(this);

        switch_agua.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
                Log.d("CHECKED????????", "" + isChecked);
                if (isChecked) {
                    aux_valor_boleano = "1";
                    Toast.makeText(getBaseContext(), "ESTA CHECKED!!!!!!" + aux_valor_boleano, Toast.LENGTH_LONG).show();
                } else {
                    aux_valor_boleano = "0";
                    Toast.makeText(getBaseContext(), "NAO ESTA CHECKED" + aux_valor_boleano, Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    public void onClick(View view) {

        Utils u = Utils.getInstance();
        String em = u.getEmail();

        switch (view.getId()) {
            case R.id.btn_InserirAnotacoes:
                String peso = et_peso.getText().toString();
                Toast.makeText(getBaseContext(), "PESO A ENVIAR: " + peso, Toast.LENGTH_LONG).show();
                new Anotacoes.HttpAsyncTask().execute("http://" + u.getIp() + ":8080/Restful/cliente/insereAnotacoes", em, aux_valor_boleano, peso, mySpinner.getText().toString());
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
            jsonObject.accumulate("relacoesSexuais", u.getRelacoesSexuais());
            jsonObject.accumulate("peso_diario", u.getPeso_diario());
            jsonObject.accumulate("consumoAgua", u.getConsumoAgua());


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
            u.setRelacoesSexuais(urls[2]);
            u.setPeso_diario(urls[3]);
            u.setConsumoAgua(urls[4]);


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
