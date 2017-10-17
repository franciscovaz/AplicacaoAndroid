package francisco.com.projeto.Partilha;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import francisco.com.projeto.Calendario.CalendarioActivity;
import francisco.com.projeto.Contactos.AdicionarUsuarioActivity;
import francisco.com.projeto.Contactos.Lista_ContactosActivity;
import francisco.com.projeto.Global.MenuActivity;
import francisco.com.projeto.Global.Utils;
import francisco.com.projeto.R;
import francisco.com.projeto.Registo.UsuariaRegisto;
import francisco.com.projeto.TelaPrincipal;

//extends AppCompatActivity
public class PartilhaCalendarioActivity extends MenuActivity {

    Utils uti;
    ListView list;
    String[] nome = new String[]{};
    String[] email = new String[]{};
    String[] tipo = new String[]{};
    int[] imgs = new int[]{};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partilha_calendario);
        setTitle("Partilhar com:");

        Resources res = getResources();

        nome = res.getStringArray(R.array.nome);
        email = res.getStringArray(R.array.email);
        tipo = res.getStringArray(R.array.tipo);

        list = (ListView) findViewById(R.id.listContactosPartilha);

        Utils u = Utils.getInstance();
        String em = u.getEmail();

        new PartilhaCalendarioActivity.HttpAsyncTask().execute("http://" + u.getIp() + ":8080/Restful/cliente/listarContactos", em, "", "");

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                TextView text = (TextView) view.findViewById(R.id.text2);
                TextView text3 = (TextView) view.findViewById(R.id.text3);

                Utils u = Utils.getInstance();
                String em = u.getEmail();
                new PartilhaCalendarioActivity.HttpAsyncTask().execute("http://" + u.getIp() + ":8080/Restful/partilha/partilharCalendario", em, text.getText().toString(), text3.getText().toString());

                Intent it = new Intent(PartilhaCalendarioActivity.this, CalendarioActivity.class);
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

            String teste = "";
            //Lista os contactos existentes
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

                PartilhaCalendarioActivity.MyAdapter adapter = new PartilhaCalendarioActivity.MyAdapter(PartilhaCalendarioActivity.this, nome, imgs, email, tipo);
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
}
