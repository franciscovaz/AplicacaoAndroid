package francisco.com.projeto.Calendario;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
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

import francisco.com.projeto.Global.MenuActivity;
import francisco.com.projeto.Global.Utils;
import francisco.com.projeto.Partilha.PartilhaCalendarioActivity;
import francisco.com.projeto.R;
import francisco.com.projeto.TelaPrincipal;

public class VerMedicoECompActivity extends MenuActivity {

    String dataRecebida = "";
    String numeroRecebido = "";
    String numeroDiasCiclo = "";

    Utils uti;
    //EditText editteste;
    ListView list;
    String[] nome = new String[]{};
    String[] email = new String[]{};
    String[] tipo = new String[]{};
    int[] imgs = new int[]{};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_medico_ecomp);
        setTitle("");

        Resources res = getResources();

        nome = res.getStringArray(R.array.nome);
        email = res.getStringArray(R.array.email);
        tipo = res.getStringArray(R.array.tipo);

        list = (ListView) findViewById(R.id.listContactosVisualizar);

        Utils u = Utils.getInstance();
        String em = u.getEmail();
        String tipo = u.getTipoDeUsuario();

        if (tipo.equals("Medico")) {
            Toast.makeText(getBaseContext(), "REQUEST AO MEDICO:", Toast.LENGTH_LONG).show();
            new VerMedicoECompActivity.HttpAsyncTask().execute("http://" + u.getIp() + ":8080/Restful/calendario/listarContactosdoMedico", em, "", "");
        } else if (tipo.equals("Companheiro")) {
            Toast.makeText(getBaseContext(), "REQUEST AO COMPANHEIRO:", Toast.LENGTH_LONG).show();
            new VerMedicoECompActivity.HttpAsyncTask().execute("http://" + u.getIp() + ":8080/Restful/calendario/listarContactosdoCompanheiro", em, "", "");
        }

        // new VerMedicoECompActivity.HttpAsyncTask().execute("http://" + u.getIp() + ":8080/Restful/calendario/listarContactosdoMedico", em, "", "");

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Utils u = Utils.getInstance();

                //Vou buscar o email para fazer httpRequest e mostrar o calendario
                String tex = list.getItemAtPosition(position).toString().trim();//busca nome
                Toast.makeText(getBaseContext(), "EMAIL SELECIONADO:" + tex, Toast.LENGTH_LONG).show();

                //MOSTRAR CALENDARIO DA USUARIA QUE SE ESCOLHEU
                new VerMedicoECompActivity.HttpAsyncTask2().execute("http://" + u.getIp() + ":8080/Restful/calendario/verDataCalendario", tex, "");

                Intent it = new Intent(VerMedicoECompActivity.this, IrCalendarioActivity.class);
                startActivity(it);

            }
        });

    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        int[] imgs;
        String meusNomes[];
        String meusEmails[];
        String meusTipos[];

        MyAdapter(Context c, String[] nome, int[] imgs, String[] email, String[] tipo) {
            super(c, R.layout.linha, R.id.text1, nome);
            this.context = c;
            this.imgs = imgs;
            this.meusEmails = email;
            this.meusNomes = nome;
            this.meusTipos = tipo;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View linha = layoutInflater.inflate(R.layout.linha, parent, false);
            ImageView imagens = (ImageView) linha.findViewById(R.id.img_icon);
            TextView meuNome = (TextView) linha.findViewById(R.id.text1);
            TextView meuEmail = (TextView) linha.findViewById(R.id.text2);
            TextView meuTipo = (TextView) linha.findViewById(R.id.text3);

            meuNome.setText(nome[position]);
            meuEmail.setText(email[position]);
            meuTipo.setText(tipo[position]);
            imagens.setImageResource(imgs[position]);


            return linha;

        }
    }


    public static String POST(String url, Utils uti) {
        InputStream inputStream = null;
        String result = "";

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            String json = "";
            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();

            jsonObject.accumulate("email", uti.getEmail());
            jsonObject.accumulate("telemovel", uti.getTelemovel());
            jsonObject.accumulate("tipoDeUtilizador", uti.getTipoDeUsuario());


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

            uti = new Utils();

            uti.setEmail(urls[1]);
            uti.setTelemovel(urls[2]);
            uti.setTipoDeUsuario(urls[3]);

            return POST(urls[0], uti);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            //editteste.setText(result);
            String teste = "";
            //Lista os contactos existentes
            //Toast.makeText(getBaseContext(), "RESULT!" + result, Toast.LENGTH_LONG).show();
            try {
                JSONObject jar = new JSONObject(result);


                JSONArray arr = jar.getJSONArray("contacto");

                nome = new String[arr.length()];
                email = new String[arr.length()];
                tipo = new String[arr.length()];
                imgs = new int[arr.length()];

                Resources res = getResources();

                for (int k = 0; k < arr.length(); k++) {
                    JSONObject ccc = arr.getJSONObject(k);

                    nome[k] = ccc.getString("nomeContacto");
                    email[k] = ccc.getString("telemovelContacto");
                    tipo[k] = ccc.getString("tipoUtilizador");
                    imgs[k] = res.getIdentifier("ic_person_black_48dp", "drawable", getPackageName());

                }

                VerMedicoECompActivity.MyAdapter adapter = new VerMedicoECompActivity.MyAdapter(VerMedicoECompActivity.this, nome, imgs, email, tipo);
                list.setAdapter(adapter);

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

    public String POST2(String url, Utils u) {
        //Utils u = Utils.getInstance();
        InputStream inputStream = null;
        String result = "";

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            String json = "";
            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("email", u.getEmail());
            //jsonObject.accumulate("password", u.getPassword());
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

    private class HttpAsyncTask2 extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            uti = new Utils();
            uti.setEmail(urls[1]);
            //Log.d("Duraçao Ciclo", quest + "");
            uti.setPassword(urls[2]);
            //Log.d("Duraçao Ultima", quest + "");
            return POST(urls[0], uti);
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

}
