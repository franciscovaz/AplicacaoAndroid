package francisco.com.projeto.EstadosUsuaria;

import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import francisco.com.projeto.Calendario.CalendarioActivity;
import francisco.com.projeto.Contactos.AdicionarUsuarioActivity;
import francisco.com.projeto.Contactos.Lista_ContactosActivity;
import francisco.com.projeto.Contactos.RegistoEmails;
import francisco.com.projeto.Global.MenuActivity;
import francisco.com.projeto.Global.Utils;
import francisco.com.projeto.Partilha.PartilhaCalendarioActivity;
import francisco.com.projeto.R;
import francisco.com.projeto.Registo.UsuariaRegisto;

import static android.support.v7.appcompat.R.id.text;
import static francisco.com.projeto.R.id.btn_sintomas_feito;
import static francisco.com.projeto.R.id.parent;
import static francisco.com.projeto.R.id.rb_sintomas;
import static francisco.com.projeto.R.id.tv_nomeSintoma;


public class SintomasActivity extends MenuActivity implements View.OnClickListener {

    private ListView lvSintomas;
    Button btnFeito;
    RatingBar ratingBar;
    EstadosClasse est;
    UsuariaRegisto Usu;
    String[] id = new String[]{};
    String[] nome_sintoma = new String[]{};
    String[] nome_sintoma2 = new String[]{};
    ArrayAdapter<String> adpUsr;
    TextView value, sintomas;
    String[] valor_sintoma = new String[]{};
    int indice_selecionado;
    int tamanho = 0;
    String ids = "";//variavel que guarda os ids dos sintomas que receberam valores
    String valores = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintomas);
        setTitle("Sintomas");

        lvSintomas = (ListView) findViewById(R.id.lvSintomas);

        Utils u = Utils.getInstance();
        String em = u.getEmail();
        String tipo = u.getTipoDeUsuario();
        ratingBar = (RatingBar) findViewById(rb_sintomas);
        ratingBar.setNumStars(5);
        //value = (TextView) findViewById(R.id.tvValue);
        sintomas = (TextView) findViewById(R.id.tv_nomeSintoma);
        btnFeito = (Button) findViewById(btn_sintomas_feito);

        btnFeito.setOnClickListener(this);


        //AO SELECIONAR As ESTRELAS QUE SE QUER FAZ:
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                //so vai colocar o valor que selecionou a frente do sintoma se for diferente de zero
                if (!String.valueOf(rating).substring(0, 1).equals("0")) {
                    valor_sintoma[indice_selecionado] = String.valueOf(rating).substring(0, 1);
                    nome_sintoma2[indice_selecionado] = nome_sintoma[indice_selecionado] + "  " + String.valueOf(rating).substring(0, 1);

                    adpUsr.clear();

                    for (int k = 0; k < tamanho; k++) {
                        adpUsr.add(nome_sintoma2[k]);
                        //Log.d("DADOS DO ARRAY:", nome_sintoma2[k]);
                    }

                    lvSintomas.setAdapter(adpUsr);

                }

            }

        });


        adpUsr = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        if (tipo.equals("Usuaria")) {
            new HttpAsyncTask().execute("http://" + u.getIp() + ":8080/Restful/cliente/listarSintomas", em, "", "");
        } else {
            //FAZER HttpAsyncTask PARA NOVA FUNÇÃO COM A PARTILHA QUE FOI FEITA COM O COMPANHEIRO OU MEDICO
            ratingBar.setVisibility(View.INVISIBLE);
            btnFeito.setVisibility(View.INVISIBLE);
            Toast.makeText(getBaseContext(), "NÃO TEM NENHUMA PARTILHA DISPONIVEL!", Toast.LENGTH_LONG).show();
        }


        // ListView on item selected listener.
        lvSintomas.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                indice_selecionado = position;
                sintomas.setText(nome_sintoma[position]);
                ratingBar.setRating(Float.parseFloat(valor_sintoma[indice_selecionado]));
            }
        });

    }

    public void onClick(View view) {

        Utils u = Utils.getInstance();
        String em = u.getEmail();

        switch (view.getId()) {
            case btn_sintomas_feito:
                //FAZER HTTP Á FUNCAO adicionarAtualizarSintomas
                for (int k = 0; k < tamanho; k++) {
                    if (!nome_sintoma[k].equals(nome_sintoma2[k])) {
                        //estao diferentes, ou seja, o sintoma k ja tem valor
                        ids += id[k] + ",";
                        valores += valor_sintoma[k] + ",";
                    }
                }


                Toast.makeText(getBaseContext(), "IDs:" + ids, Toast.LENGTH_LONG).show();
                Toast.makeText(getBaseContext(), "Valores:" + valores, Toast.LENGTH_LONG).show();


                new SintomasActivity.HttpAsyncTask().execute("http://" + u.getIp() + ":8080/Restful/cliente/adicionarSintomas", em, ids, valores); //ENVIAR O ARRAY TAMBEM
                //Toast.makeText(getBaseContext(), "Dados Inseridos com Sucesso!", Toast.LENGTH_LONG).show();
                // call AsynTask to perform network operation on separate thread
        }
    }


    public static String POST(String url, UsuariaRegisto usu) {
        InputStream inputStream = null;
        String result = "";

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            String json = "";
            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();

            jsonObject.accumulate("email", usu.getEmail());
            jsonObject.accumulate("ids_sintomas", usu.getIds_sintomas());
            jsonObject.accumulate("valores_sintomas", usu.getValores_sintomas());


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

            Usu = new UsuariaRegisto();

            Usu.setEmail(urls[1]);
            Usu.setIds_sintomas(urls[2]);
            Usu.setValores_sintomas(urls[3]);

            return POST(urls[0], Usu);

        }
        // onPostExecute displays the results of the AsyncTask.

        @Override
        protected void onPostExecute(String result) {
            //Toast.makeText(getBaseContext(), "Received!"+ result , Toast.LENGTH_LONG).show();
            Log.d("JSON", result);

            JSONObject jar = null;
            try {
                jar = new JSONObject(result);
                JSONArray arr = jar.getJSONArray("estadoUsuaria");

                id = new String[arr.length()];
                nome_sintoma = new String[arr.length()];
                nome_sintoma2 = new String[arr.length()];
                //para alocar o array dos sintomas para o REST
                valor_sintoma = new String[arr.length()];

                tamanho = arr.length();

                Resources res = getResources();

                for (int k = 0; k < arr.length(); k++) {
                    JSONObject ccc = arr.getJSONObject(k);

                    id[k] = ccc.getString("idSintomas");
                    nome_sintoma[k] = ccc.getString("nome_sintoma");
                    valor_sintoma[k] = ccc.getString("valor");

                    if (!valor_sintoma[k].equals("0.0"))
                        nome_sintoma2[k] = nome_sintoma[k] + "  " + valor_sintoma[k];
                    else
                        nome_sintoma2[k] = ccc.getString("nome_sintoma");

                    adpUsr.add(nome_sintoma2[k]);


                }
                lvSintomas.setAdapter(adpUsr);
            } catch (JSONException e) {
                e.printStackTrace();
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
