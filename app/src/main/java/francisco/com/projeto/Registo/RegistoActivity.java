package francisco.com.projeto.Registo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import android.os.AsyncTask;
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
import francisco.com.projeto.TelaPrincipalCompEMedico;

import static francisco.com.projeto.R.id.et_dataNascimento_registar;
import static francisco.com.projeto.R.id.spinnerTipoUsuario;
import static java.lang.Integer.parseInt;

public class RegistoActivity extends AppCompatActivity implements View.OnClickListener{


    EditText edEmail, edNome, edTelemovel, edPaswword, et_dataNascimento_registar;
    Button btnRegisto;
    MaterialBetterSpinner mySpinner;

    String [] SPINNERLIST = {"Usuaria","Companheiro", "Medico"};
    UsuariaRegisto usr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registo);
        setTitle("Registar");

        edEmail = (EditText) findViewById(R.id.et_email_registar);
        edNome = (EditText) findViewById(R.id.et_nome);
        edTelemovel = (EditText) findViewById(R.id.et_telemovel);
        edPaswword = (EditText) findViewById(R.id.et_password_registar);
        et_dataNascimento_registar = (EditText) findViewById(R.id.et_dataNascimento_registar);
        btnRegisto = (Button) findViewById(R.id.btnregistar_Mesmo);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SPINNERLIST);
        MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner)findViewById(spinnerTipoUsuario);
        betterSpinner.setAdapter(arrayAdapter);


        mySpinner=(MaterialBetterSpinner) findViewById(R.id.spinnerTipoUsuario);
        btnRegisto.setOnClickListener(this);

    }

    public static String POST(String url, UsuariaRegisto usr){
        InputStream inputStream = null;
        String result = "";

        try {

            HttpClient httpclient = new DefaultHttpClient();

            HttpPost httpPost = new HttpPost(url);

            String json = "";

            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();

            jsonObject.accumulate("email", usr.getEmail());
            jsonObject.accumulate("nomeUtilizadora", usr.getNomeUtilizadora());
            jsonObject.accumulate("telUtilizadora", usr.getTelUtilizadora());
            jsonObject.accumulate("password", usr.getPassword());
            jsonObject.accumulate("tipoDeUtilizador", usr.getTipoDeUsuario());
            jsonObject.accumulate("dataNascimento", usr.getDataNascimento());


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
            if(inputStream != null)
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

        switch(view.getId()){
            case R.id.btnregistar_Mesmo:
                if(!validate())
                    Toast.makeText(getBaseContext(), "Tem dados errados ou Tem de preencher as caixas de texto!", Toast.LENGTH_LONG).show();
                // call AsynTask to perform network operation on separate thread
                else if(mySpinner.getText().toString().equals("Medico")){
                    new HttpAsyncTask().execute("http://"+u.getIp()+":8080/Restful/cliente/inserirMedico", edEmail.getText().toString(), edNome.getText().toString(), edTelemovel.getText().toString(),  edPaswword.getText().toString(), mySpinner.getText().toString(), et_dataNascimento_registar.getText().toString());
                } else if(mySpinner.getText().toString().equals("Companheiro")){
                    new HttpAsyncTask().execute("http://"+u.getIp()+":8080/Restful/cliente/inserirCompanheiro", edEmail.getText().toString(), edNome.getText().toString(), edTelemovel.getText().toString(),  edPaswword.getText().toString(), mySpinner.getText().toString(), et_dataNascimento_registar.getText().toString());
                } else {  //USUARIA
                    new HttpAsyncTask().execute("http://"+u.getIp()+":8080/Restful/cliente/inserirUsuaria", edEmail.getText().toString(), edNome.getText().toString(), edTelemovel.getText().toString(),  edPaswword.getText().toString(), mySpinner.getText().toString(), et_dataNascimento_registar.getText().toString());
                }

                break;
        }

    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            Utils u = Utils.getInstance();

            usr = new UsuariaRegisto();

            usr.setEmail(urls[1]);
            usr.setNomeUtilizadora(urls[2]);
            usr.setTelUtilizadora(urls[3]);
            usr.setPassword(urls[4]);
            usr.setTipoDeUsuario(urls[5]);
            usr.setDataNascimento(urls[6]);

            //GLOBAL PARA ACEDER MAIS TARDE

            u.setEmail(urls[1]);
            u.setPassword(urls[4]);
            u.setTipoDeUsuario(urls[5]);

            return POST(urls[0],usr);

        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            //Toast.makeText(getBaseContext(), "RESULT!" + result, Toast.LENGTH_LONG).show();
            //VERIFICA NO REST SE JÁ EXISTE O EMAIL QUE QUER REGISTAR, SE SIM PEDE NOVAMENTE, SE AINDA NÃO EXISTIR, AVANÇA
            if(result.equals("{\"verifica\":\"jaexiste\"}")){
                Toast.makeText(getBaseContext(), "Email já registado!", Toast.LENGTH_LONG).show();
            }
            else{

                Utils u = Utils.getInstance();
                u.setEmail(edEmail.getText().toString());
                u.setPassword(edPaswword.getText().toString());

                if(mySpinner.getText().toString().equals("Medico") || mySpinner.getText().toString().equals("Companheiro")){
                    Intent it = new Intent(RegistoActivity.this, TelaPrincipalCompEMedico.class);
                    startActivity(it);
                } else {
                    Intent it = new Intent(RegistoActivity.this, QuestionsAfterRegisto.class);
                    startActivity(it);
                }
            }
        }
    }

    //ver se esta alguma vazia
    private boolean validate(){

        if(edEmail.getText().toString().trim().equals(""))
            return false;
        else if(edNome.getText().toString().trim().equals(""))
            return false;
        else if(edTelemovel.getText().toString().trim().equals(""))
            return false;
        else if(edPaswword.getText().toString().trim().equals(""))
            return false;
        else if(et_dataNascimento_registar.getText().toString().trim().equals(""))
            return false;
        else if(!isValidEmail(edEmail.getText().toString()))
            return false;
        else if(!isValidTelemovel(edTelemovel.getText().toString()))
            return false;
        else
            return true;
    }


    private boolean isValidEmail(String email) {
        String email_PATTERN = "[A-Za-z0-9\\._-]+@[A-Za-z]+\\.[A-Za-z]+";

        Pattern pattern = Pattern.compile(email_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidTelemovel(String telUtilizadora) {

        String telUtilizadora_PATTERN = "9[1236][0-9]{7}\\b";

        Pattern pattern = Pattern.compile(telUtilizadora_PATTERN);
        Matcher matcher = pattern.matcher(telUtilizadora);
        return matcher.matches();
    }


    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

}
















