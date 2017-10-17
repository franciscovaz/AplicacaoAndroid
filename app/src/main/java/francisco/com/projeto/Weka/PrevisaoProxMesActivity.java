package francisco.com.projeto.Weka;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

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

public class PrevisaoProxMesActivity extends MenuActivity {

    UsuariaRegisto usr;
    String data = "";
    String probabilidade = "";

    DataPoint[] graficoData = new DataPoint[]{};

    GraphView graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previsao_prox_mes);
        setTitle("Previsão");

        //GRAFICO
        graph = (GraphView) findViewById(R.id.grafico_previsao);

        Utils u = Utils.getInstance();
        String em = u.getEmail();

        //PROBABILIDADE DO PROXIMO MES
        new PrevisaoProxMesActivity.HttpAsyncTask().execute("http://" + u.getIp() + ":8080/Restful/weka/calculaProbabilidadeMesSeguinte", em, "2017-08-05");

    }

    public static String POST(String url, UsuariaRegisto usr) {
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
            Utils u = Utils.getInstance();

            usr = new UsuariaRegisto();
            usr.setEmail(urls[1]);
            usr.setDate1(urls[2]);

            //METE NA GLOBAL
            u.setEmail(urls[1]);    //GLOBAL

            return POST(urls[0], usr);

        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            Log.d("RESULT: ", result + "");
            //VERIFICA NO REST SE JÁ EXISTE O EMAIL QUE QUER REGISTAR, SE SIM PEDE NOVAMENTE, SE AINDA NÃO EXISTIR, AVANÇA
            if (result.equals("{\"weka\":\"SemResultados\"}")) {
                //Toast.makeText(getBaseContext(), "O email que inseriu ja esta registado" + result, Toast.LENGTH_LONG).show();
                //CHAMAR SPINNER SEM RESULTADOS
                Toast.makeText(getBaseContext(), "NAO EXISTEM RESULTADOS!", Toast.LENGTH_LONG).show();
            } else {
                //CARREGAR PARA O ARRAY ADAPTER
                JSONObject jar = null;
                try {
                    jar = new JSONObject(result);

                    data = jar.getJSONObject("weka").getString("data");
                    probabilidade = jar.getJSONObject("weka").getString("probabilidade");

                    BarGraphSeries<DataPoint> barSeries = new BarGraphSeries<>(new DataPoint[]{
                            new DataPoint(1, Double.valueOf(probabilidade))
                    });

                    graph.addSeries(barSeries);

                    // styling
                    barSeries.setValueDependentColor(new ValueDependentColor<DataPoint>() {
                        @Override
                        public int get(DataPoint data) {
                            return Color.rgb((int) data.getX() * 255 / 4, (int) Math.abs(data.getY() * 255 / 6), 100);
                        }
                    });

                    barSeries.setSpacing(50);

// draw values on top
                    barSeries.setDrawValuesOnTop(true);
                    barSeries.setValuesOnTopColor(Color.RED);
//series.setValuesOnTopSize(50);

                    //COLOCAR DATAS NA LEGENDA DE BAIXO
                    graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
                        @Override
                        public String formatLabel(double value, boolean isValueX) {
                            if (isValueX) {
                                // show normal x values
                                int indice = (int) value;
                                // show normal x values
                                if (indice != 0 && indice != 2 && value % 1 == 0)
                                    return data.substring(5, data.length());
                                return "";
                            } else {
                                // show currency for y values
                                return super.formatLabel(value, isValueX) + " %";
                            }
                        }
                    });

                    graph.getViewport().setXAxisBoundsManual(true);
                    graph.getViewport().setYAxisBoundsManual(true);
                    graph.getViewport().setMaxX(2);
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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while ((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }
}
