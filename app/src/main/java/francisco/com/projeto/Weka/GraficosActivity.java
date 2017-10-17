package francisco.com.projeto.Weka;


import android.content.res.Resources;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;


import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

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
import francisco.com.projeto.R;
import francisco.com.projeto.Registo.UsuariaRegisto;



public class GraficosActivity extends MenuActivity implements View.OnClickListener {

    Button btnDatas;
    UsuariaRegisto usr;

    String [] data = new String[]{};
    String [] probabilidade = new String[]{};
    MaterialBetterSpinner mySpinnerDe,mySpinnerAte;

    String [] SPINNERLIST = {"Sem Resultados"};

    DataPoint [] graficoData = new DataPoint[]{};
    DataPoint [] graficoData2 = new DataPoint[]{};
    int valor = 0;

    GraphView graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficos);
        setTitle("Gráfico");

        mySpinnerDe=(MaterialBetterSpinner) findViewById(R.id.spinnerDataDe);
        mySpinnerAte=(MaterialBetterSpinner) findViewById(R.id.spinnerDataAte);
        btnDatas = (Button) findViewById(R.id.btnDatas);

        btnDatas.setOnClickListener(this);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SPINNERLIST);

        mySpinnerDe.setAdapter(arrayAdapter);
        mySpinnerAte.setAdapter(arrayAdapter);

        //GRAFICO
        graph = (GraphView) findViewById(R.id.grafico);

        Utils u = Utils.getInstance();
        String em = u.getEmail();

        new GraficosActivity.HttpAsyncTask().execute("http://" + u.getIp() + ":8080/Restful/weka/listarDatas", em);
    }

    public void onClick(View view) {

        Utils u = Utils.getInstance();
        String em = u.getEmail();

        switch(view.getId()){
            case R.id.btnDatas:
                //HISTÓRICO ENTRE DUAS DATAS
                new GraficosActivity.HttpAsyncTask2().execute("http://" + u.getIp() + ":8080/Restful/weka/recebeDatas", em, mySpinnerDe.getText().toString(), mySpinnerAte.getText().toString());
                break;
        }
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

    public static String POST2(String url, UsuariaRegisto usr){
        InputStream inputStream = null;
        String result = "";

        try {

            HttpClient httpclient = new DefaultHttpClient();

            HttpPost httpPost = new HttpPost(url);

            String json = "";

            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();

            jsonObject.accumulate("email", usr.getEmail());
            jsonObject.accumulate("date1", usr.getDate1());
            jsonObject.accumulate("date2", usr.getDate2());

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

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            Utils u = Utils.getInstance();

            usr = new UsuariaRegisto();
            usr.setEmail(urls[1]);
            //METE NA GLOBAL
            u.setEmail(urls[1]);    //GLOBAL
            return POST(urls[0],usr);

        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            Log.d("RESULT: ", result + "");
            //VERIFICA NO REST SE JÁ EXISTE O EMAIL QUE QUER REGISTAR, SE SIM PEDE NOVAMENTE, SE AINDA NÃO EXISTIR, AVANÇA
            if(result.equals("{\"weka\":\"SemResultados\"}")){
                //CHAMAR SPINNER SEM RESULTADOS
                Toast.makeText(getBaseContext(), "NAO EXISTEM RESULTADOS!", Toast.LENGTH_LONG).show();
            }
            else{
                //CARREGAR PARA O ARRAY ADAPTER
                JSONObject jar = null;
                try {

                    jar = new JSONObject(result);
                    JSONArray arr = jar.getJSONArray("weka");
                    data = new String[arr.length()];


                    Resources res = getResources();

                    for(int k = 0; k< arr.length(); k++){
                        JSONObject ccc =  arr.getJSONObject(k);
                        data[k] = ccc.getString("data_Inicio_Ultima_Menstruacao");

                    }

                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(GraficosActivity.this,
                            android.R.layout.simple_dropdown_item_1line, data);
                    mySpinnerDe.setAdapter(arrayAdapter);
                    mySpinnerAte.setAdapter(arrayAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    private class HttpAsyncTask2 extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            Utils u = Utils.getInstance();

            usr = new UsuariaRegisto();
            usr.setEmail(urls[1]);
            usr.setDate1(urls[2]);
            usr.setDate2(urls[3]);
            //METE NA GLOBAL
            u.setEmail(urls[1]);    //GLOBAL

            return POST2(urls[0],usr);

        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            Log.d("RESULT: ", result + "");
            //VERIFICA NO REST SE JÁ EXISTE O EMAIL QUE QUER REGISTAR, SE SIM PEDE NOVAMENTE, SE AINDA NÃO EXISTIR, AVANÇA
            if(result.equals("{\"weka\":\"SemResultados\"}")){
                //Toast.makeText(getBaseContext(), "O email que inseriu ja esta registado" + result, Toast.LENGTH_LONG).show();
                //CHAMAR SPINNER SEM RESULTADOS
                Toast.makeText(getBaseContext(), "NAO EXISTEM RESULTADOS!", Toast.LENGTH_LONG).show();
            }
            else{
                //CARREGAR PARA O ARRAY ADAPTER
                JSONObject jar = null;
                try {

                    jar = new JSONObject(result);
                    JSONArray arr = jar.getJSONArray("weka");
                    data = new String[arr.length()];
                    probabilidade = new String[arr.length()];
                    graficoData = new DataPoint[arr.length()];
                    valor = arr.length();

                    Resources res = getResources();

                    for(int k = 0; k< arr.length(); k++){
                        JSONObject ccc =  arr.getJSONObject(k);
                        data[k] = ccc.getString("data");
                        probabilidade[k] = ccc.getString("probabilidade");


                        graficoData[k] = new DataPoint(k+1, Double.valueOf(probabilidade[k]));

                    }

                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(GraficosActivity.this,
                            android.R.layout.simple_dropdown_item_1line, data);
                    mySpinnerDe.setAdapter(arrayAdapter);
                    mySpinnerAte.setAdapter(arrayAdapter);


                    BarGraphSeries<DataPoint> barSeries = new BarGraphSeries<DataPoint>(graficoData);

                    graph.addSeries(barSeries);

                    barSeries.setSpacing(10);

// draw values on top
                    barSeries.setDrawValuesOnTop(true);
                    barSeries.setValuesOnTopColor(Color.RED);
//series.setValuesOnTopSize(50);
                    Toast.makeText(getBaseContext(), "VALOR:" + valor, Toast.LENGTH_LONG).show();

                    //COLOCAR DATAS NA LEGENDA DE BAIXO
                    graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
                        @Override
                        public String formatLabel(double value, boolean isValueX) {
                            if (isValueX) {
                                int indice = (int) value;
                                // show normal x values
                                if(indice != 0 && indice != valor +1 && (value%1 == 0)){
                                    return data[indice-1].substring(5,data[indice-1].length());
                                }
                                return "";

                            } else {
                                // show currency for y values
                                return super.formatLabel(value, isValueX) + " %";
                            }
                        }
                    });

                    graph.getViewport().setXAxisBoundsManual(true);
                    graph.getViewport().setYAxisBoundsManual(true);
                    graph.getViewport().setMaxX(valor + 1);
                    graph.getViewport().setMinX(0);
                    graph.getViewport().setMaxY(100);
                    graph.getViewport().setMinY(0);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }

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
