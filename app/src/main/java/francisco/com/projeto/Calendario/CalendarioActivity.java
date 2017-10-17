package francisco.com.projeto.Calendario;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.riontech.calendar.CustomCalendar;
import com.riontech.calendar.dao.EventData;
import com.riontech.calendar.dao.dataAboutDate;
import com.riontech.calendar.utils.CalendarUtils;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import francisco.com.projeto.Ciclos.CiclosClasse;
import francisco.com.projeto.Global.MenuActivity;
import francisco.com.projeto.MainActivity;
import francisco.com.projeto.Partilha.PartilhaCalendarioActivity;
import francisco.com.projeto.R;
import francisco.com.projeto.Global.Utils;
import francisco.com.projeto.Registo.RegistoActivity;
import francisco.com.projeto.TelaPrincipal;

import static com.riontech.calendar.CustomCalendar.data_global;


public class CalendarioActivity extends MenuActivity implements View.OnClickListener {

    public static CustomCalendar customCalendar;
    Switch switch_data;
    public static Integer enviar = 0;
    public static String global = "";
    public static String global2 = "";
    public static String global3 = "";
    public static String global4 = "";
    public static String global10 = "";
    public static String global11 = "";
    String global5 = "";
    String global6 = "";
    Button btn_editar;

    Utils u;
    String dataRecebida = "";
    boolean para = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
        setTitle("Calendario");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.ic_share_white_18dp);
        actionBar.setDisplayUseLogoEnabled(true);
        switch_data = (Switch) findViewById(R.id.switch_novo_inicio);

        btn_editar = (Button) findViewById(R.id.btn_editar);

        btn_editar.setOnClickListener(this);


        customCalendar = (CustomCalendar) findViewById(R.id.customCalendar);


        Utils u = Utils.getInstance();

        String numero = u.getDuracaoCicloMenstrual();
        Integer num = Integer.parseInt(numero);
        Toast.makeText(getBaseContext(), "RECEBES ----->" + num, Toast.LENGTH_LONG).show();

        if (num == 24) {
            CiclosClasse.ciclo24();
        } else if (num == 25) {
            CiclosClasse.ciclo25();
        } else if (num == 26) {
            CiclosClasse.ciclo26();
        } else if (num == 27) {
            CiclosClasse.ciclo27();
        } else if (num == 28) {
            CiclosClasse.ciclo28();
        } else if (num == 29) {
            CiclosClasse.ciclo29();
        } else if (num == 30) {
            CiclosClasse.ciclo30();
        } else if (num == 31) {
            CiclosClasse.ciclo31();
        } else if (num == 32) {
            CiclosClasse.ciclo32();
        } else if (num == 33) {
            CiclosClasse.ciclo33();
        }

    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_editar:
                if (data_global.toString().equals(global) || data_global.toString().equals(global2) || data_global.toString().equals(global3) || data_global.toString().equals(global4) || data_global.toString().equals(global10) || data_global.toString().equals(global11)) {
                    switch_data.setVisibility(View.VISIBLE);
                }
                switch_data.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        // do something, the isChecked will be
                        // true if the switch is in the On position
                        Log.d("CHECKED ? ->", "" + isChecked);

                        Utils u = Utils.getInstance();
                        String em = u.getEmail();
                        if (isChecked) {
                            //CHAMAR REST, ENVIANDO A DATA SELECIONADA (GLOBAL)
                            new CalendarioActivity.HttpAsyncTask().execute("http://" + u.getIp() + ":8080/Restful/calendario/inserirNovaDataInicioEDiferenca", data_global, em);
                        } else {
                            Toast.makeText(getBaseContext(), "NAO ESTA CHECKED" + global, Toast.LENGTH_LONG).show();
                        }
                    }
                });
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_calendario_action, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.procura_id:
                Intent it = new Intent(CalendarioActivity.this, PartilhaCalendarioActivity.class);
                startActivity(it);
                return true;


            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                if (data_global.toString().equals(global) || data_global.toString().equals(global2) || data_global.toString().equals(global3) || data_global.toString().equals(global4) || data_global.toString().equals(global10) || data_global.toString().equals(global11)) {
                    switch_data.setVisibility(View.VISIBLE);
                }

                switch_data.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        // do something, the isChecked will be
                        // true if the switch is in the On position
                        Log.d("DATA CHECKED:", "" + global);

                        Utils u = Utils.getInstance();
                        String em = u.getEmail();
                        if (isChecked) {
                            //CHAMAR REST, ENVIANDO A DATA SELECIONADA (GLOBAL)
                            new CalendarioActivity.HttpAsyncTask().execute("http://" + u.getIp() + ":8080/Restful/calendario/inserirNovaDataInicioEDiferenca", data_global, em);
                        } else {
                            Toast.makeText(getBaseContext(), "NAO ESTA CHECKED" + global, Toast.LENGTH_LONG).show();
                        }
                    }
                });

                return super.onOptionsItemSelected(item);

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
            jsonObject.accumulate("diaInicioMenstruacao", u.getDiaInicioMenstruacao());
            jsonObject.accumulate("email", u.getEmail());
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
            HttpResponse httpResponse = httpclient.execute(httpPost);
            // 9. receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();
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

            u.setDiaInicioMenstruacao(urls[1]);
            u.setEmail(urls[2]);

            return POST(urls[0], u);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "RESULT!" + result, Toast.LENGTH_LONG).show();
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

