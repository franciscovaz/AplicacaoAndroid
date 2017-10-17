package francisco.com.projeto.Registo;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import francisco.com.projeto.R;
import francisco.com.projeto.TelaPrincipal;
import francisco.com.projeto.Global.Utils;

import static francisco.com.projeto.R.id.spinnerCiclo;
import static francisco.com.projeto.R.id.spinnerDuracao;


public class QuestionsAfterRegisto extends AppCompatActivity implements View.OnClickListener {

    EditText edInicioUltima;
    Button btnInserirDados;
    MaterialBetterSpinner mySpinner, mySpinner2;

    String[] SPINNERLIST = {"24", "25", "26", "27", "28", "29", "30", "31", "32"};

    String[] SPINNERLIST2 = {"4", "5", "6", "7", "8", "9"};

    QuestoesClass quest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_after_registo);
        setTitle("Questões");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SPINNERLIST);
        MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner) findViewById(spinnerCiclo);
        betterSpinner.setAdapter(arrayAdapter);

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SPINNERLIST2);
        MaterialBetterSpinner betterSpinner2 = (MaterialBetterSpinner) findViewById(spinnerDuracao);
        betterSpinner2.setAdapter(arrayAdapter2);


        btnInserirDados = (Button) findViewById(R.id.btnDadosQuestoes);
        edInicioUltima = (EditText) findViewById(R.id.etDataInicio);


        btnInserirDados.setOnClickListener((View.OnClickListener) this);


        mySpinner = (MaterialBetterSpinner) findViewById(R.id.spinnerCiclo);
        mySpinner2 = (MaterialBetterSpinner) findViewById(R.id.spinnerDuracao);

        Utils u = new Utils();

        Toast.makeText(getBaseContext(), "EMAIL GLOBAL: " + u.getEmail(), Toast.LENGTH_LONG).show();
        Toast.makeText(getBaseContext(), "PASS GLOBAL: " + u.getPassword(), Toast.LENGTH_LONG).show();
        Toast.makeText(getBaseContext(), "TIPO GLOBAL: " + u.getTipoDeUsuario(), Toast.LENGTH_LONG).show();
    }


    public String POST(String url, QuestoesClass quest) {
        //Utils u = Utils.getInstance();
        InputStream inputStream = null;
        String result = "";

        try {

            HttpClient httpclient = new DefaultHttpClient();

            HttpPost httpPost = new HttpPost(url);

            String json = "";

            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();


            jsonObject.accumulate("duracaoCicloMenstrual", quest.getDuracaoCicloMenstrual());
            jsonObject.accumulate("duracaoUltimaMenstruacao", quest.getDuracaoUltimaMenstruacao());
            jsonObject.accumulate("email", quest.getEmail());
            jsonObject.accumulate("data_Inicio_Ultima_Menstruacao", quest.getData_Inicio_Ultima_Menstruacao());
            //Log.d("JSON", jsonObject + "");

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

    public void onClick(View view) {
        Utils u = Utils.getInstance();

        switch (view.getId()) {
            case R.id.btnDadosQuestoes:
                if (!validate())
                    Toast.makeText(getBaseContext(), "Tem de preencher as caixas de texto!", Toast.LENGTH_LONG).show();
                    // call AsynTask to perform network operation on separate thread
                else {
                    new QuestionsAfterRegisto.HttpAsyncTask().execute("http://" + u.getIp() + ":8080/Restful/questoes/inserirDadosPrincipais", mySpinner.getText().toString(), mySpinner2.getText().toString(), u.getEmail(), edInicioUltima.getText().toString());
                    Intent it = new Intent(QuestionsAfterRegisto.this, TelaPrincipal.class);
                    startActivity(it);
                }

                break;
        }

    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            //Utils u = Utils.getInstance();

            quest = new QuestoesClass();

            quest.setDuracaoCicloMenstrual(urls[1]);
            //Log.d("Duraçao Ciclo", quest + "");
            quest.setDuracaoUltimaMenstruacao(urls[2]);
            //Log.d("Duraçao Ultima", quest + "");
            quest.setEmail(urls[3]);
            //Log.d("GLOBAL EMAIL ASYNC", quest + "");
            quest.setData_Inicio_Ultima_Menstruacao(urls[4]);

            Utils u = (Utils) getApplication();
            u.setEmail(urls[3]);    //GLOBAL
            Log.d("GLOBAL EMAIL", u.getEmail() + "");

            return POST(urls[0], quest);

        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Dados Inseridos!", Toast.LENGTH_LONG).show();

        }
    }

    //ver se esta alguma vazia
    private boolean validate() {

        if (edInicioUltima.getText().toString().trim().equals(""))
            return false;
        else if (!isValidDate(edInicioUltima.getText().toString()))
            return false;
        else
            return true;
    }


    //validar data
    private boolean isValidDate(String data_Inicio_Ultima_Menstruacao) {

        String data_PATTERN = "^(19[4-9][0-9]|200[0-9]|201[0-7])-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$";

        Pattern pattern = Pattern.compile(data_PATTERN);
        Matcher matcher = pattern.matcher(data_Inicio_Ultima_Menstruacao);
        return matcher.matches();
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










