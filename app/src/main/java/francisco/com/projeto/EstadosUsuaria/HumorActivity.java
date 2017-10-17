package francisco.com.projeto.EstadosUsuaria;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.io.SessionOutputBufferImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import francisco.com.projeto.Global.MenuActivity;
import francisco.com.projeto.Global.Utils;
import francisco.com.projeto.R;
import francisco.com.projeto.Registo.UsuariaRegisto;

import static android.R.id.empty;
import static francisco.com.projeto.R.id.btn_humores_feito;
import static francisco.com.projeto.R.id.btn_sintomas_feito;
import static francisco.com.projeto.R.id.checkbox;
import static francisco.com.projeto.R.id.lvHumores;
import static francisco.com.projeto.R.id.parent;
import static francisco.com.projeto.R.id.rb_sintomas;

public class HumorActivity extends MenuActivity implements View.OnClickListener {

    ArrayList<String> selectedItems = new ArrayList<>();
    private ListView lvHumores;
    Button btnFeitoHumor;
    EstadosClasse est;
    UsuariaRegisto Usu;
    String[] id = new String[]{};
    String[] nome_humor = new String[]{};
    String[] nome_humor2 = new String[]{};  // array que guarda os ID's e o valor correspondente a cada um (neste caso 0 ou 1)
    ArrayAdapter<String> adpUsr;
    String[] valor_humor = new String[]{};
    int indice_selecionado;
    int tamanho = 0;
    String ids = "";//variavel que guarda os ids dos sintomas que receberam valores
    SparseBooleanArray humores_checked;
    String valores = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humor);
        setTitle("Estados de Humor");

        Utils u = Utils.getInstance();
        String em = u.getEmail();
        String tipo = u.getTipoDeUsuario();

        lvHumores = (ListView) findViewById(R.id.lvHumores);
        btnFeitoHumor = (Button) findViewById(btn_humores_feito);
        btnFeitoHumor.setOnClickListener(this);
        lvHumores.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        if (tipo.equals("Usuaria")) {
            Log.d("TIPO DE UTILIZADOR:", tipo);
            new HttpAsyncTask().execute("http://" + u.getIp() + ":8080/Restful/cliente/listarHumor", em, "");
        } else {
            //FAZER HttpAsyncTask PARA NOVA FUNÇÃO COM A PARTILHA QUE FOI FEITA COM O COMPANHEIRO OU MEDICO
            Toast.makeText(getBaseContext(), "NÃO TEM NENHUMA PARTILHA DISPONIVEL!", Toast.LENGTH_LONG).show();
            btnFeitoHumor.setVisibility(View.INVISIBLE);
        }

        adpUsr = new ArrayAdapter<String>(this, R.layout.linha_humor, R.id.txt_lan);

        lvHumores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = ((TextView) view).getText().toString();
                indice_selecionado = position + 1; //começa no zero, logo add +1

                if (selectedItems.contains(selectedItem)) {
                    selectedItems.remove(selectedItem); //unckeck item

                    for (int i = 0; i < tamanho; i++)
                        humores_checked = lvHumores.getCheckedItemPositions();

                } else {
                    for (int i = 0; i < tamanho; i++)
                        humores_checked = lvHumores.getCheckedItemPositions();

                    selectedItems.add(selectedItem);
                }

                //Toast.makeText(getBaseContext(), "IDs:" + ids + " Valores:"+valores, Toast.LENGTH_LONG).show();
            }

        });

    }

    public void showSelectedItems(View view) {
        String items = "";
        for (String item : selectedItems) {
            items += "-" + item + "\n";
        }
        Toast.makeText(this, "Selecionou \n" + items, Toast.LENGTH_SHORT).show();
    }


    public void onClick(View view) {

        Utils u = Utils.getInstance();
        String em = u.getEmail();

        switch (view.getId()) {
            case btn_humores_feito:
                new HumorActivity.HttpAsyncTask().execute("http://" + u.getIp() + ":8080/Restful/cliente/adicionarHumor", em, humores_checked.toString()); //ENVIAR O ARRAY TAMBEM
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
            jsonObject.accumulate("humores_checked", usu.getHumores_checked());

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
            Usu.setHumores_checked(urls[2]);

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
                nome_humor = new String[arr.length()];
                nome_humor2 = new String[arr.length()];
                //para alocar o array dos sintomas para o REST
                valor_humor = new String[arr.length()];

                tamanho = arr.length();

                Resources res = getResources();

                for (int k = 0; k < arr.length(); k++) {
                    JSONObject ccc = arr.getJSONObject(k);

                    id[k] = ccc.getString("idHumor");
                    nome_humor[k] = ccc.getString("nome_humor");
                    valor_humor[k] = ccc.getString("valor");

                    adpUsr.add(nome_humor[k]);

                }
                lvHumores.setAdapter(adpUsr);

                //vai selecionar os humores que a estao selecionados no dia corrente
                for (int k = 0; k < arr.length(); k++) {

                    if (!valor_humor[k].equals("0")) {
                        lvHumores.setItemChecked(k, true);
                    }
                }

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
