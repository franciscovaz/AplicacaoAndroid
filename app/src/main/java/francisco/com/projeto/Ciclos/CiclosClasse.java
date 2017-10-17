package francisco.com.projeto.Ciclos;

import android.util.Log;
import android.widget.Toast;

import com.riontech.calendar.CustomCalendar;
import com.riontech.calendar.dao.EventData;
import com.riontech.calendar.dao.dataAboutDate;
import com.riontech.calendar.utils.CalendarUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import francisco.com.projeto.Calendario.CalendarioActivity;
import francisco.com.projeto.Global.Utils;
import francisco.com.projeto.R;


import static francisco.com.projeto.R.id.customCalendar;

/**
 * Created by ftoma on 13/06/2017.
 */

public class CiclosClasse {


    public static void ciclo24() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Utils u = Utils.getInstance();
            Log.d("DATA RECEBIDA", String.valueOf(u.getData()));
            Log.d("NUMERO RECEBIDo", String.valueOf(u.getNumeroAreceber()));

            Date date = sdf.parse(u.getData());
            Log.d("DATA RECEBIDA", String.valueOf(date));

            int i = 1;
            //4 primeiros dias //Dia 1 da Menstruação
            date.setDate(date.getDate());
            //Toast.makeText(getBaseContext(), "DATA!" + date, Toast.LENGTH_LONG).show();
            SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");
            String result1 = out.format(date);

            String[] arr1 = {result1};
            for (int j = 0; j < 1; j++) {
                int eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr1[j], eventCount, getEventDataList(eventCount));
            }

            int eventCount = 2;
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat out2 = new SimpleDateFormat("yyyy-MM-dd");
            Date data;
            int total_dias = Integer.parseInt(u.getNumeroAreceber()); //se for 4 dias
            total_dias = total_dias - 1;

            //PRIMEIROS DIAS
            for (int k = 1; k <= total_dias; k++) {
                data = sdf2.parse(result1);
                data.setDate(data.getDate() + 1);

                String result2 = out2.format(data);

                String[] arr2 = {result2};
                result1 = result2;
                if (k == 1) {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                } else if (k == 2) { //dia 3
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia3(eventCount));
                } else if (k == 3) {  //dia 4
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia4(eventCount));
                } else if (k == 4) {  //dia 5
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia5(eventCount));
                } else if (k == 5) {  //dia 6
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia6(eventCount));
                } else if (k == 6) {  //dia 7
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia7(eventCount));
                } else if (k == 7) {  //dia 8
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia8(eventCount));
                } else if (k == 8) {  //dia 9
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia9(eventCount));
                } else {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                }
            }
            String resultado = "";
            Log.d("TOTAL DIAS", u.getNumeroAreceber());
            total_dias = total_dias + 1; //porque esta a -1
            if (total_dias == 1) {

            } else if (total_dias == 2) {

            } else if (total_dias == 3) {

            } else if (total_dias == 4) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }

                SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                Date date_ = sdf_.parse(result5);
                date_.setDate(date_.getDate() + i);
                SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                String result = out_.format(date_);


                String[] arr = {result};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                }
                result5 = result;
                resultado = result5;


            } else if (total_dias == 5) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }
                resultado = result5;


            } else if (total_dias == 6) {
                resultado = result1;
            } else if (total_dias == 7) {
                resultado = result1;
            } else if (total_dias == 8) {
                resultado = result1;
            } else if (total_dias == 9) {
                resultado = result1;
            } else if (total_dias == 10) {
                resultado = result1;
            } else if (total_dias == 11) {
                resultado = result1;
            } else if (total_dias == 12) {
                resultado = result1;
            }

//Risco MEDIO
            for (int f = 0; f < 3; f++) {
                SimpleDateFormat sdf13 = new SimpleDateFormat("yyyy-MM-dd");
                Date date13 = sdf13.parse(resultado);
                date13.setDate(date13.getDate() + i);
                SimpleDateFormat out13 = new SimpleDateFormat("yyyy-MM-dd");
                String result13 = out13.format(date13);

                String[] arr13 = {result13};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                resultado = result13;
            }

//15 Risco ALTO
            SimpleDateFormat sdf15 = new SimpleDateFormat("yyyy-MM-dd");
            Date date15 = sdf15.parse(resultado);
            date15.setDate(date15.getDate() + i);
            SimpleDateFormat out15 = new SimpleDateFormat("yyyy-MM-dd");
            String result15 = out15.format(date15);

            String[] arr15 = {result15};
            //os eventos a seguir ao diferente já nao estao assinalados
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr15[j], eventCount, getEventDataList4(eventCount));
            }
//16 Risco ALTO   Dia da Ovulação
            SimpleDateFormat sdf16 = new SimpleDateFormat("yyyy-MM-dd");
            Date date16 = sdf16.parse(result15);
            date16.setDate(date16.getDate() + i);
            SimpleDateFormat out16 = new SimpleDateFormat("yyyy-MM-dd");
            String result16 = out16.format(date16);

            String[] arr16 = {result16};
            //os eventos a seguir ao diferente já nao estao assinalados
            for (int j = 0; j < 1; j++) {
                eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr16[j], eventCount, getEventDataListDiaOvulacao(eventCount));
            }

//17 Risco ALTO
            SimpleDateFormat sdf17 = new SimpleDateFormat("yyyy-MM-dd");
            Date date17 = sdf17.parse(result16);
            date17.setDate(date17.getDate() + i);
            SimpleDateFormat out17 = new SimpleDateFormat("yyyy-MM-dd");
            String result17 = out17.format(date17);

            String[] arr17 = {result17};
            //os eventos a seguir ao diferente já nao estao assinalados
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr17[j], eventCount, getEventDataList4(eventCount));
            }


//Risco MEDIO

            for (int f = 0; f < 4; f++) {
                SimpleDateFormat sdfMedio = new SimpleDateFormat("yyyy-MM-dd");
                Date dateMedio = sdfMedio.parse(result17);
                dateMedio.setDate(dateMedio.getDate() + i);
                SimpleDateFormat outMedio = new SimpleDateFormat("yyyy-MM-dd");
                String resultMedio = outMedio.format(dateMedio);

                String[] arr13 = {resultMedio};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                result17 = resultMedio;
            }

// Risco Baixo
            for (int j = 0; j < 5; j++) {
                SimpleDateFormat sdfBaixo = new SimpleDateFormat("yyyy-MM-dd");
                Date dateBaixo = sdfBaixo.parse(result17);
                dateBaixo.setDate(dateBaixo.getDate() + i);
                SimpleDateFormat outBaixo = new SimpleDateFormat("yyyy-MM-dd");
                String resultBaixo = outBaixo.format(dateBaixo);

                String[] arr22 = {resultBaixo};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int k = 0; k < 1; k++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr22[k], eventCount, getEventDataList2(eventCount));
                }
                result17 = resultBaixo;
            }

// Risco Baixo
            SimpleDateFormat sdf_global = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global = sdf_global.parse(result17);
            date_global.setDate(date_global.getDate() + i);
            SimpleDateFormat out_global = new SimpleDateFormat("yyyy-MM-dd");
            String resultGlobal = out_global.format(date_global);

            String[] arr_global = {resultGlobal};
            CalendarioActivity.global = resultGlobal;


            //os eventos a seguir ao diferente já nao estao assinalados
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }

// Risco Baixo
            SimpleDateFormat sdf_global2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global2 = sdf_global2.parse(resultGlobal);
            date_global2.setDate(date_global2.getDate() + i);
            SimpleDateFormat out_global2 = new SimpleDateFormat("yyyy-MM-dd");
            String resultGlobal2 = out_global2.format(date_global2);

            String[] arr_global2 = {resultGlobal2};
            CalendarioActivity.global2 = resultGlobal2;


            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global2[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }

//29 Risco Baixo
            SimpleDateFormat sdf_global3 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global3 = sdf_global3.parse(resultGlobal2);
            date_global3.setDate(date_global3.getDate() + i);
            SimpleDateFormat out_global3 = new SimpleDateFormat("yyyy-MM-dd");
            String result_global3 = out_global3.format(date_global3);

            String[] arr_global3 = {result_global3};
            CalendarioActivity.global3 = result_global3;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global3[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //PREVISAO DE CICLO!!!!!!!!!!!!!!!!
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            sdf = new SimpleDateFormat("yyyy-MM-dd");

            Log.d("DATA RECEBIDA", String.valueOf(u.getData()));
            Log.d("NUMERO RECEBIDo", String.valueOf(u.getNumeroAreceber()));

            date = sdf.parse(result_global3);
            Log.d("DATA A COMEÇAR", String.valueOf(date));

            i = 1;
            //4 primeiros dias //Dia 1 da Menstruação
            date.setDate(date.getDate());
            //Toast.makeText(getBaseContext(), "DATA!" + date, Toast.LENGTH_LONG).show();
            out = new SimpleDateFormat("yyyy-MM-dd");
            result1 = out.format(date);

            eventCount = 2;
            sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            out2 = new SimpleDateFormat("yyyy-MM-dd");
            total_dias = Integer.parseInt(u.getNumeroAreceber()); //se for 4 dias
            //total_dias = total_dias - 1;

            //PRIMEIROS DIAS
            for (int k = 1; k <= total_dias; k++) {
                data = sdf2.parse(result1);
                data.setDate(data.getDate() + 1);

                String result2 = out2.format(data);

                String[] arr2 = {result2};
                result1 = result2;

                if (k == 1) {  //dia 1
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataList(eventCount));
                    CalendarioActivity.global4 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 2) { //dia 2
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                    CalendarioActivity.global10 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 3) {  //dia 3
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia3(eventCount));
                    CalendarioActivity.global11 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 4) {  //dia 4
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia4(eventCount));
                    //CalendarioActivity.enviar = 1;
                } else if (k == 5) {  //dia 5
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia5(eventCount));
                    //CalendarioActivity.enviar = 1;
                } else if (k == 6) {  //dia 6
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia6(eventCount));
                    //CalendarioActivity.enviar = 1;
                } else if (k == 7) {  //dia 7
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia7(eventCount));
                } else if (k == 8) {  //dia 8
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia8(eventCount));
                } else if (k == 9) {  //dia 9
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia9(eventCount));
                } else if (k == 10) {  //dia 10
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia10(eventCount));
                } else if (k == 11) {  //dia 11
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia11(eventCount));
                } else {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                }
            }
            resultado = "";
            Log.d("TOTAL DIAS", u.getNumeroAreceber());
            //total_dias = total_dias + 1; //porque esta a -1

            if (total_dias == 1) {

            } else if (total_dias == 2) {

            } else if (total_dias == 3) {

            } else if (total_dias == 4) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }

                SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                Date date_ = sdf_.parse(result5);
                date_.setDate(date_.getDate() + i);
                SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                String result = out_.format(date_);


                String[] arr = {result};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                }
                result5 = result;
                resultado = result5;

            } else if (total_dias == 5) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }
                resultado = result5;

            } else if (total_dias == 6) {
                resultado = result1;
            } else if (total_dias == 7) {
                resultado = result1;
            } else if (total_dias == 8) {
                resultado = result1;
            } else if (total_dias == 9) {
                resultado = result1;
            } else if (total_dias == 10) {
                resultado = result1;
            } else if (total_dias == 11) {
                resultado = result1;
            } else if (total_dias == 12) {
                resultado = result1;
            }

//Risco MEDIO
            for (int f = 0; f < 3; f++) {
                SimpleDateFormat sdf13 = new SimpleDateFormat("yyyy-MM-dd");
                Date date13 = sdf13.parse(resultado);
                date13.setDate(date13.getDate() + i);
                SimpleDateFormat out13 = new SimpleDateFormat("yyyy-MM-dd");
                String result13 = out13.format(date13);

                String[] arr13 = {result13};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                resultado = result13;
            }

//15 Risco ALTO
            SimpleDateFormat sdf_novo_ciclo = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novo_ciclo = sdf_novo_ciclo.parse(resultado);
            date_novo_ciclo.setDate(date_novo_ciclo.getDate() + i);
            SimpleDateFormat out111 = new SimpleDateFormat("yyyy-MM-dd");
            String result111 = out111.format(date_novo_ciclo);

            String[] arr111 = {result111};
            //os eventos a seguir ao diferente já nao estao assinalados
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr111[j], eventCount, getEventDataList4(eventCount));
            }
//16 Risco ALTO   Dia da Ovulação
            SimpleDateFormat sdf_novoCiclo = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novoCiclo = sdf_novoCiclo.parse(result111);
            date_novoCiclo.setDate(date_novoCiclo.getDate() + i);
            SimpleDateFormat out_novoCiclo = new SimpleDateFormat("yyyy-MM-dd");
            String result_novoCiclo = out_novoCiclo.format(date_novoCiclo);

            String[] arr_novoCiclo = {result_novoCiclo};
            //os eventos a seguir ao diferente já nao estao assinalados
            for (int j = 0; j < 1; j++) {
                eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr_novoCiclo[j], eventCount, getEventDataListDiaOvulacao(eventCount));
            }

//17 Risco ALTO
            SimpleDateFormat sdf_novoCiclo2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novoCiclo2 = sdf_novoCiclo2.parse(result_novoCiclo);
            date_novoCiclo2.setDate(date_novoCiclo2.getDate() + i);
            SimpleDateFormat out_novoCiclo2 = new SimpleDateFormat("yyyy-MM-dd");
            String result_novoCiclo2 = out_novoCiclo2.format(date_novoCiclo2);

            String[] arr_nocoCiclo2 = {result_novoCiclo2};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_nocoCiclo2[j], eventCount, getEventDataList4(eventCount));
            }


//Risco MEDIO

            for (int f = 0; f < 4; f++) {
                SimpleDateFormat sdfMedio = new SimpleDateFormat("yyyy-MM-dd");
                Date dateMedio = sdfMedio.parse(result_novoCiclo2);
                dateMedio.setDate(dateMedio.getDate() + i);
                SimpleDateFormat outMedio = new SimpleDateFormat("yyyy-MM-dd");
                String resultMedio = outMedio.format(dateMedio);

                String[] arr13 = {resultMedio};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                result_novoCiclo2 = resultMedio;
                resultado = result_novoCiclo2;
            }

// Risco Baixo
            for (int j = 0; j < 8; j++) {
                SimpleDateFormat sdfBaixo = new SimpleDateFormat("yyyy-MM-dd");
                Date dateBaixo = sdfBaixo.parse(resultado);
                dateBaixo.setDate(dateBaixo.getDate() + i);
                SimpleDateFormat outBaixo = new SimpleDateFormat("yyyy-MM-dd");
                String resultBaixo = outBaixo.format(dateBaixo);

                String[] arr22 = {resultBaixo};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int k = 0; k < 1; k++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr22[k], eventCount, getEventDataList2(eventCount));
                }
                resultado = resultBaixo;
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void ciclo25() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Utils u = Utils.getInstance();
            Log.d("DATA RECEBIDA", String.valueOf(u.getData()));
            Log.d("NUMERO RECEBIDo", String.valueOf(u.getNumeroAreceber()));

            Date date = sdf.parse(u.getData());
            Log.d("DATA RECEBIDA", String.valueOf(date));

            int i = 1;
            //4 primeiros dias //Dia 1 da Menstruação
            date.setDate(date.getDate());
            //Toast.makeText(getBaseContext(), "DATA!" + date, Toast.LENGTH_LONG).show();
            SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");
            String result1 = out.format(date);

            String[] arr1 = {result1};
            for (int j = 0; j < 1; j++) {
                int eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr1[j], eventCount, getEventDataList(eventCount));
            }

            int eventCount = 2;
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat out2 = new SimpleDateFormat("yyyy-MM-dd");
            Date data;
            int total_dias = Integer.parseInt(u.getNumeroAreceber()); //se for 4 dias
            total_dias = total_dias - 1;

            //PRIMEIROS DIAS
            for (int k = 1; k <= total_dias; k++) {
                data = sdf2.parse(result1);
                data.setDate(data.getDate() + 1);

                String result2 = out2.format(data);

                String[] arr2 = {result2};
                result1 = result2;
                if (k == 1) {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                } else if (k == 2) { //dia 3
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia3(eventCount));
                } else if (k == 3) {  //dia 4
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia4(eventCount));
                } else if (k == 4) {  //dia 5
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia5(eventCount));
                } else if (k == 5) {  //dia 6
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia6(eventCount));
                } else if (k == 6) {  //dia 7
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia7(eventCount));
                } else if (k == 7) {  //dia 8
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia8(eventCount));
                } else if (k == 8) {  //dia 9
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia9(eventCount));
                }/*else if (k == 9) {  //dia 10
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia10(eventCount));
                }else if (k == 10) {  //dia 11
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia11(eventCount));
                }else if (k == 11) {  //dia 12
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia12(eventCount));
                }*/ else {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                }
            }
            String resultado = "";
            Log.d("TOTAL DIAS", u.getNumeroAreceber());
            total_dias = total_dias + 1; //porque esta a -1
            if (total_dias == 1) {

            } else if (total_dias == 2) {

            } else if (total_dias == 3) {

            } else if (total_dias == 4) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 2; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 5) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                Date date_ = sdf_.parse(result5);
                date_.setDate(date_.getDate() + i);
                SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                String result = out_.format(date_);


                String[] arr = {result};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                }
                resultado = result5;


            } else if (total_dias == 6) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }
                resultado = result5;


            } else if (total_dias == 7) {
                resultado = result1;
            } else if (total_dias == 8) {
                resultado = result1;
            } else if (total_dias == 9) {
                resultado = result1;
            } else if (total_dias == 10) {
                resultado = result1;
            } else if (total_dias == 11) {
                resultado = result1;
            } else if (total_dias == 12) {
                resultado = result1;
            }

//Risco MEDIO
            for (int f = 0; f < 3; f++) {
                SimpleDateFormat sdf13 = new SimpleDateFormat("yyyy-MM-dd");
                Date date13 = sdf13.parse(resultado);
                date13.setDate(date13.getDate() + i);
                SimpleDateFormat out13 = new SimpleDateFormat("yyyy-MM-dd");
                String result13 = out13.format(date13);

                String[] arr13 = {result13};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                resultado = result13;
            }

//15 Risco ALTO
            SimpleDateFormat sdf15 = new SimpleDateFormat("yyyy-MM-dd");
            Date date15 = sdf15.parse(resultado);
            date15.setDate(date15.getDate() + i);
            SimpleDateFormat out15 = new SimpleDateFormat("yyyy-MM-dd");
            String result15 = out15.format(date15);

            String[] arr15 = {result15};
            //os eventos a seguir ao diferente já nao estao assinalados
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr15[j], eventCount, getEventDataList4(eventCount));
            }
//16 Risco ALTO   Dia da Ovulação
            SimpleDateFormat sdf16 = new SimpleDateFormat("yyyy-MM-dd");
            Date date16 = sdf16.parse(result15);
            date16.setDate(date16.getDate() + i);
            SimpleDateFormat out16 = new SimpleDateFormat("yyyy-MM-dd");
            String result16 = out16.format(date16);

            String[] arr16 = {result16};
            //os eventos a seguir ao diferente já nao estao assinalados
            for (int j = 0; j < 1; j++) {
                eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr16[j], eventCount, getEventDataListDiaOvulacao(eventCount));
            }

//17 Risco ALTO
            SimpleDateFormat sdf17 = new SimpleDateFormat("yyyy-MM-dd");
            Date date17 = sdf17.parse(result16);
            date17.setDate(date17.getDate() + i);
            SimpleDateFormat out17 = new SimpleDateFormat("yyyy-MM-dd");
            String result17 = out17.format(date17);

            String[] arr17 = {result17};
            //os eventos a seguir ao diferente já nao estao assinalados
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr17[j], eventCount, getEventDataList4(eventCount));
            }


//Risco MEDIO

            for (int f = 0; f < 4; f++) {
                SimpleDateFormat sdfMedio = new SimpleDateFormat("yyyy-MM-dd");
                Date dateMedio = sdfMedio.parse(result17);
                dateMedio.setDate(dateMedio.getDate() + i);
                SimpleDateFormat outMedio = new SimpleDateFormat("yyyy-MM-dd");
                String resultMedio = outMedio.format(dateMedio);

                String[] arr13 = {resultMedio};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                result17 = resultMedio;
            }

// Risco Baixo
            for (int j = 0; j < 5; j++) {
                SimpleDateFormat sdfBaixo = new SimpleDateFormat("yyyy-MM-dd");
                Date dateBaixo = sdfBaixo.parse(result17);
                dateBaixo.setDate(dateBaixo.getDate() + i);
                SimpleDateFormat outBaixo = new SimpleDateFormat("yyyy-MM-dd");
                String resultBaixo = outBaixo.format(dateBaixo);

                String[] arr22 = {resultBaixo};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int k = 0; k < 1; k++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr22[k], eventCount, getEventDataList2(eventCount));
                }
                result17 = resultBaixo;
            }

// Risco Baixo
            SimpleDateFormat sdf_global = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global = sdf_global.parse(result17);
            date_global.setDate(date_global.getDate() + i);
            SimpleDateFormat out_global = new SimpleDateFormat("yyyy-MM-dd");
            String resultGlobal = out_global.format(date_global);

            String[] arr_global = {resultGlobal};
            CalendarioActivity.global = resultGlobal;


            //os eventos a seguir ao diferente já nao estao assinalados
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }

// Risco Baixo
            SimpleDateFormat sdf_global2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global2 = sdf_global2.parse(resultGlobal);
            date_global2.setDate(date_global2.getDate() + i);
            SimpleDateFormat out_global2 = new SimpleDateFormat("yyyy-MM-dd");
            String resultGlobal2 = out_global2.format(date_global2);

            String[] arr_global2 = {resultGlobal2};
            CalendarioActivity.global2 = resultGlobal2;


            //os eventos a seguir ao diferente já nao estao assinalados
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global2[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }

//29 Risco Baixo
            SimpleDateFormat sdf_global3 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global3 = sdf_global3.parse(resultGlobal2);
            date_global3.setDate(date_global3.getDate() + i);
            SimpleDateFormat out_global3 = new SimpleDateFormat("yyyy-MM-dd");
            String result_global3 = out_global3.format(date_global3);

            String[] arr_global3 = {result_global3};
            CalendarioActivity.global3 = result_global3;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global3[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //PREVISAO DE CICLO!!!!!!!!!!!!!!!!
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            sdf = new SimpleDateFormat("yyyy-MM-dd");

            Log.d("DATA RECEBIDA", String.valueOf(u.getData()));
            Log.d("NUMERO RECEBIDo", String.valueOf(u.getNumeroAreceber()));

            date = sdf.parse(result_global3);
            Log.d("DATA A COMEÇAR", String.valueOf(date));

            i = 1;
            //4 primeiros dias //Dia 1 da Menstruação
            date.setDate(date.getDate());
            //Toast.makeText(getBaseContext(), "DATA!" + date, Toast.LENGTH_LONG).show();
            out = new SimpleDateFormat("yyyy-MM-dd");
            result1 = out.format(date);

            eventCount = 2;
            sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            out2 = new SimpleDateFormat("yyyy-MM-dd");
            total_dias = Integer.parseInt(u.getNumeroAreceber()); //se for 4 dias
            //total_dias = total_dias - 1;

            //PRIMEIROS DIAS
            for (int k = 1; k <= total_dias; k++) {
                data = sdf2.parse(result1);
                data.setDate(data.getDate() + 1);

                String result2 = out2.format(data);

                String[] arr2 = {result2};
                result1 = result2;
                if (k == 1) {  //dia 1
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataList(eventCount));
                    CalendarioActivity.global4 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 2) { //dia 2
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                    CalendarioActivity.global10 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 3) {  //dia 3
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia3(eventCount));
                    CalendarioActivity.global11 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 4) {  //dia 4
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia4(eventCount));
                } else if (k == 5) {  //dia 5
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia5(eventCount));
                } else if (k == 6) {  //dia 6
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia6(eventCount));
                } else if (k == 7) {  //dia 7
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia7(eventCount));
                } else if (k == 8) {  //dia 8
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia8(eventCount));
                } else if (k == 9) {  //dia 9
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia9(eventCount));
                } else if (k == 10) {  //dia 10
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia10(eventCount));
                } else if (k == 11) {  //dia 11
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia11(eventCount));
                } else {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                }
            }
            resultado = "";
            Log.d("TOTAL DIAS", u.getNumeroAreceber());
            //total_dias = total_dias + 1; //porque esta a -1

            if (total_dias == 1) {

            } else if (total_dias == 2) {

            } else if (total_dias == 3) {

            } else if (total_dias == 4) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 2; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 5) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }
                SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                Date date_ = sdf_.parse(result5);
                date_.setDate(date_.getDate() + i);
                SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                String result = out_.format(date_);


                String[] arr = {result};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                }
                result5 = result;
                resultado = result5;

            } else if (total_dias == 6) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }
                resultado = result5;


            } else if (total_dias == 7) {
                resultado = result1;
            } else if (total_dias == 8) {
                resultado = result1;
            } else if (total_dias == 9) {
                resultado = result1;
            } else if (total_dias == 10) {
                resultado = result1;
            } else if (total_dias == 11) {
                resultado = result1;
            } else if (total_dias == 12) {
                resultado = result1;
            }

//Risco MEDIO
            for (int f = 0; f < 3; f++) {
                SimpleDateFormat sdf13 = new SimpleDateFormat("yyyy-MM-dd");
                Date date13 = sdf13.parse(resultado);
                date13.setDate(date13.getDate() + i);
                SimpleDateFormat out13 = new SimpleDateFormat("yyyy-MM-dd");
                String result13 = out13.format(date13);

                String[] arr13 = {result13};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                resultado = result13;
            }

//15 Risco ALTO
            SimpleDateFormat sdf_novo_ciclo = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novo_ciclo = sdf_novo_ciclo.parse(resultado);
            date_novo_ciclo.setDate(date_novo_ciclo.getDate() + i);
            SimpleDateFormat out111 = new SimpleDateFormat("yyyy-MM-dd");
            String result111 = out111.format(date_novo_ciclo);

            String[] arr111 = {result111};
            //os eventos a seguir ao diferente já nao estao assinalados
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr111[j], eventCount, getEventDataList4(eventCount));
            }
//16 Risco ALTO   Dia da Ovulação
            SimpleDateFormat sdf_novoCiclo = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novoCiclo = sdf_novoCiclo.parse(result111);
            date_novoCiclo.setDate(date_novoCiclo.getDate() + i);
            SimpleDateFormat out_novoCiclo = new SimpleDateFormat("yyyy-MM-dd");
            String result_novoCiclo = out_novoCiclo.format(date_novoCiclo);

            String[] arr_novoCiclo = {result_novoCiclo};
            //os eventos a seguir ao diferente já nao estao assinalados
            for (int j = 0; j < 1; j++) {
                eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr_novoCiclo[j], eventCount, getEventDataListDiaOvulacao(eventCount));
            }

//17 Risco ALTO
            SimpleDateFormat sdf_novoCiclo2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novoCiclo2 = sdf_novoCiclo2.parse(result_novoCiclo);
            date_novoCiclo2.setDate(date_novoCiclo2.getDate() + i);
            SimpleDateFormat out_novoCiclo2 = new SimpleDateFormat("yyyy-MM-dd");
            String result_novoCiclo2 = out_novoCiclo2.format(date_novoCiclo2);

            String[] arr_nocoCiclo2 = {result_novoCiclo2};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_nocoCiclo2[j], eventCount, getEventDataList4(eventCount));
            }


//Risco MEDIO

            for (int f = 0; f < 4; f++) {
                SimpleDateFormat sdfMedio = new SimpleDateFormat("yyyy-MM-dd");
                Date dateMedio = sdfMedio.parse(result_novoCiclo2);
                dateMedio.setDate(dateMedio.getDate() + i);
                SimpleDateFormat outMedio = new SimpleDateFormat("yyyy-MM-dd");
                String resultMedio = outMedio.format(dateMedio);

                String[] arr13 = {resultMedio};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                result_novoCiclo2 = resultMedio;
                resultado = result_novoCiclo2;
            }

// Risco Baixo
            for (int j = 0; j < 8; j++) {
                SimpleDateFormat sdfBaixo = new SimpleDateFormat("yyyy-MM-dd");
                Date dateBaixo = sdfBaixo.parse(resultado);
                dateBaixo.setDate(dateBaixo.getDate() + i);
                SimpleDateFormat outBaixo = new SimpleDateFormat("yyyy-MM-dd");
                String resultBaixo = outBaixo.format(dateBaixo);

                String[] arr22 = {resultBaixo};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int k = 0; k < 1; k++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr22[k], eventCount, getEventDataList2(eventCount));
                }
                resultado = resultBaixo;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void ciclo26() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Utils u = Utils.getInstance();
            Log.d("DATA RECEBIDA", String.valueOf(u.getData()));
            Log.d("NUMERO RECEBIDo", String.valueOf(u.getNumeroAreceber()));

            Date date = sdf.parse(u.getData());
            Log.d("DATA RECEBIDA", String.valueOf(date));

            int i = 1;
            //4 primeiros dias //Dia 1 da Menstruação
            date.setDate(date.getDate());
            //Toast.makeText(getBaseContext(), "DATA!" + date, Toast.LENGTH_LONG).show();
            SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");
            String result1 = out.format(date);

            String[] arr1 = {result1};
            for (int j = 0; j < 1; j++) {
                int eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr1[j], eventCount, getEventDataList(eventCount));
            }

            int eventCount = 2;
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat out2 = new SimpleDateFormat("yyyy-MM-dd");
            Date data;
            int total_dias = Integer.parseInt(u.getNumeroAreceber()); //se for 4 dias
            total_dias = total_dias - 1;

            //PRIMEIROS DIAS
            for (int k = 1; k <= total_dias; k++) {
                data = sdf2.parse(result1);
                data.setDate(data.getDate() + 1);

                String result2 = out2.format(data);

                String[] arr2 = {result2};
                result1 = result2;
                if (k == 1) {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                } else if (k == 2) { //dia 3
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia3(eventCount));
                } else if (k == 3) {  //dia 4
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia4(eventCount));
                } else if (k == 4) {  //dia 5
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia5(eventCount));
                } else if (k == 5) {  //dia 6
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia6(eventCount));
                } else if (k == 6) {  //dia 7
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia7(eventCount));
                } else if (k == 7) {  //dia 8
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia8(eventCount));
                } else if (k == 8) {  //dia 9
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia9(eventCount));
                }/*else if (k == 9) {  //dia 10
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia10(eventCount));
                }else if (k == 10) {  //dia 11
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia11(eventCount));
                }else if (k == 11) {  //dia 12
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia12(eventCount));
                }*/ else {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                }
            }
            String resultado = "";
            Log.d("TOTAL DIAS", u.getNumeroAreceber());
            total_dias = total_dias + 1; //porque esta a -1
            if (total_dias == 1) {

            } else if (total_dias == 2) {

            } else if (total_dias == 3) {

            } else if (total_dias == 4) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }
                for (int k = 0; k < 3; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 5) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }

                for (int k = 0; k < 2; k++) {
                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 6) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }

                SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                Date date_ = sdf_.parse(result5);
                date_.setDate(date_.getDate() + i);
                SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                String result = out_.format(date_);


                String[] arr = {result};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                }
                result5 = result;
                resultado = result5;


            } else if (total_dias == 7) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }

                resultado = result5;


            } else if (total_dias == 8) {
                resultado = result1;
            } else if (total_dias == 9) {
                resultado = result1;
            } else if (total_dias == 10) {
                resultado = result1;
            } else if (total_dias == 11) {
                resultado = result1;
            } else if (total_dias == 12) {
                resultado = result1;
            }

//Risco MEDIO
            for (int f = 0; f < 3; f++) {
                SimpleDateFormat sdf13 = new SimpleDateFormat("yyyy-MM-dd");
                Date date13 = sdf13.parse(resultado);
                date13.setDate(date13.getDate() + i);
                SimpleDateFormat out13 = new SimpleDateFormat("yyyy-MM-dd");
                String result13 = out13.format(date13);

                String[] arr13 = {result13};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                resultado = result13;
            }

//15 Risco ALTO
            SimpleDateFormat sdf15 = new SimpleDateFormat("yyyy-MM-dd");
            Date date15 = sdf15.parse(resultado);
            date15.setDate(date15.getDate() + i);
            SimpleDateFormat out15 = new SimpleDateFormat("yyyy-MM-dd");
            String result15 = out15.format(date15);

            String[] arr15 = {result15};
            //os eventos a seguir ao diferente já nao estao assinalados
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr15[j], eventCount, getEventDataList4(eventCount));
            }
//16 Risco ALTO   Dia da Ovulação
            SimpleDateFormat sdf16 = new SimpleDateFormat("yyyy-MM-dd");
            Date date16 = sdf16.parse(result15);
            date16.setDate(date16.getDate() + i);
            SimpleDateFormat out16 = new SimpleDateFormat("yyyy-MM-dd");
            String result16 = out16.format(date16);

            String[] arr16 = {result16};
            //os eventos a seguir ao diferente já nao estao assinalados
            for (int j = 0; j < 1; j++) {
                eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr16[j], eventCount, getEventDataListDiaOvulacao(eventCount));
            }

//17 Risco ALTO
            SimpleDateFormat sdf17 = new SimpleDateFormat("yyyy-MM-dd");
            Date date17 = sdf17.parse(result16);
            date17.setDate(date17.getDate() + i);
            SimpleDateFormat out17 = new SimpleDateFormat("yyyy-MM-dd");
            String result17 = out17.format(date17);

            String[] arr17 = {result17};
            //os eventos a seguir ao diferente já nao estao assinalados
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr17[j], eventCount, getEventDataList4(eventCount));
            }


//Risco MEDIO

            for (int f = 0; f < 4; f++) {
                SimpleDateFormat sdfMedio = new SimpleDateFormat("yyyy-MM-dd");
                Date dateMedio = sdfMedio.parse(result17);
                dateMedio.setDate(dateMedio.getDate() + i);
                SimpleDateFormat outMedio = new SimpleDateFormat("yyyy-MM-dd");
                String resultMedio = outMedio.format(dateMedio);

                String[] arr13 = {resultMedio};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                result17 = resultMedio;
            }

// Risco Baixo
            for (int j = 0; j < 5; j++) {
                SimpleDateFormat sdfBaixo = new SimpleDateFormat("yyyy-MM-dd");
                Date dateBaixo = sdfBaixo.parse(result17);
                dateBaixo.setDate(dateBaixo.getDate() + i);
                SimpleDateFormat outBaixo = new SimpleDateFormat("yyyy-MM-dd");
                String resultBaixo = outBaixo.format(dateBaixo);

                String[] arr22 = {resultBaixo};
                for (int k = 0; k < 1; k++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr22[k], eventCount, getEventDataList2(eventCount));
                }
                result17 = resultBaixo;
            }

// Risco Baixo
            SimpleDateFormat sdf_global = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global = sdf_global.parse(result17);
            date_global.setDate(date_global.getDate() + i);
            SimpleDateFormat out_global = new SimpleDateFormat("yyyy-MM-dd");
            String resultGlobal = out_global.format(date_global);

            String[] arr_global = {resultGlobal};
            CalendarioActivity.global = resultGlobal;


            //os eventos a seguir ao diferente já nao estao assinalados
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }

// Risco Baixo
            SimpleDateFormat sdf_global2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global2 = sdf_global2.parse(resultGlobal);
            date_global2.setDate(date_global2.getDate() + i);
            SimpleDateFormat out_global2 = new SimpleDateFormat("yyyy-MM-dd");
            String resultGlobal2 = out_global2.format(date_global2);

            String[] arr_global2 = {resultGlobal2};
            CalendarioActivity.global2 = resultGlobal2;


            //os eventos a seguir ao diferente já nao estao assinalados
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global2[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }

//29 Risco Baixo
            SimpleDateFormat sdf_global3 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global3 = sdf_global3.parse(resultGlobal2);
            date_global3.setDate(date_global3.getDate() + i);
            SimpleDateFormat out_global3 = new SimpleDateFormat("yyyy-MM-dd");
            String result_global3 = out_global3.format(date_global3);

            String[] arr_global3 = {result_global3};
            CalendarioActivity.global3 = result_global3;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global3[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //PREVISAO DE CICLO!!!!!!!!!!!!!!!!
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            sdf = new SimpleDateFormat("yyyy-MM-dd");

            Log.d("DATA RECEBIDA", String.valueOf(u.getData()));
            Log.d("NUMERO RECEBIDo", String.valueOf(u.getNumeroAreceber()));

            date = sdf.parse(result_global3);
            Log.d("DATA A COMEÇAR", String.valueOf(date));

            i = 1;
            //4 primeiros dias //Dia 1 da Menstruação
            date.setDate(date.getDate());
            //Toast.makeText(getBaseContext(), "DATA!" + date, Toast.LENGTH_LONG).show();
            out = new SimpleDateFormat("yyyy-MM-dd");
            result1 = out.format(date);
/*

            String[] arr_novo = {result1};
            for (int j = 0; j < 1; j++) {
                eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr_novo[j], eventCount, getEventDataList(eventCount));
            }
*/

            eventCount = 2;
            sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            out2 = new SimpleDateFormat("yyyy-MM-dd");
            total_dias = Integer.parseInt(u.getNumeroAreceber()); //se for 4 dias
            //total_dias = total_dias - 1;

            //PRIMEIROS DIAS
            for (int k = 1; k <= total_dias; k++) {
                data = sdf2.parse(result1);
                data.setDate(data.getDate() + 1);

                String result2 = out2.format(data);

                String[] arr2 = {result2};
                result1 = result2;
                if (k == 1) {  //dia 1
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataList(eventCount));
                    CalendarioActivity.global4 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 2) { //dia 2
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                    CalendarioActivity.global10 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 3) {  //dia 3
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia3(eventCount));
                    CalendarioActivity.global11 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 4) {  //dia 4
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia4(eventCount));
                } else if (k == 5) {  //dia 5
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia5(eventCount));
                } else if (k == 6) {  //dia 6
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia6(eventCount));
                } else if (k == 7) {  //dia 7
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia7(eventCount));
                } else if (k == 8) {  //dia 8
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia8(eventCount));
                } else if (k == 9) {  //dia 9
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia9(eventCount));
                } else if (k == 10) {  //dia 10
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia10(eventCount));
                } else if (k == 11) {  //dia 11
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia11(eventCount));
                } else {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                }
            }
            resultado = "";
            Log.d("TOTAL DIAS", u.getNumeroAreceber());
            //total_dias = total_dias + 1; //porque esta a -1

            if (total_dias == 1) {

            } else if (total_dias == 2) {

            } else if (total_dias == 3) {

            } else if (total_dias == 4) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 3; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 5) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 2; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    //os eventos a seguir ao diferente já nao estao assinalados
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 6) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }

                SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                Date date_ = sdf_.parse(result5);
                date_.setDate(date_.getDate() + i);
                SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                String result = out_.format(date_);


                String[] arr = {result};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                }
                result5 = result;
                resultado = result5;


            } else if (total_dias == 7) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }
                resultado = result5;


            } else if (total_dias == 8) {
                resultado = result1;
            } else if (total_dias == 9) {
                resultado = result1;
            } else if (total_dias == 10) {
                resultado = result1;
            } else if (total_dias == 11) {
                resultado = result1;
            } else if (total_dias == 12) {
                resultado = result1;
            }

//Risco MEDIO
            for (int f = 0; f < 3; f++) {
                SimpleDateFormat sdf13 = new SimpleDateFormat("yyyy-MM-dd");
                Date date13 = sdf13.parse(resultado);
                date13.setDate(date13.getDate() + i);
                SimpleDateFormat out13 = new SimpleDateFormat("yyyy-MM-dd");
                String result13 = out13.format(date13);

                String[] arr13 = {result13};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                resultado = result13;
            }

//15 Risco ALTO
            SimpleDateFormat sdf_novo_ciclo = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novo_ciclo = sdf_novo_ciclo.parse(resultado);
            date_novo_ciclo.setDate(date_novo_ciclo.getDate() + i);
            SimpleDateFormat out111 = new SimpleDateFormat("yyyy-MM-dd");
            String result111 = out111.format(date_novo_ciclo);

            String[] arr111 = {result111};
            //os eventos a seguir ao diferente já nao estao assinalados
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr111[j], eventCount, getEventDataList4(eventCount));
            }
//16 Risco ALTO   Dia da Ovulação
            SimpleDateFormat sdf_novoCiclo = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novoCiclo = sdf_novoCiclo.parse(result111);
            date_novoCiclo.setDate(date_novoCiclo.getDate() + i);
            SimpleDateFormat out_novoCiclo = new SimpleDateFormat("yyyy-MM-dd");
            String result_novoCiclo = out_novoCiclo.format(date_novoCiclo);

            String[] arr_novoCiclo = {result_novoCiclo};
            //os eventos a seguir ao diferente já nao estao assinalados
            for (int j = 0; j < 1; j++) {
                eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr_novoCiclo[j], eventCount, getEventDataListDiaOvulacao(eventCount));
            }

//17 Risco ALTO
            SimpleDateFormat sdf_novoCiclo2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novoCiclo2 = sdf_novoCiclo2.parse(result_novoCiclo);
            date_novoCiclo2.setDate(date_novoCiclo2.getDate() + i);
            SimpleDateFormat out_novoCiclo2 = new SimpleDateFormat("yyyy-MM-dd");
            String result_novoCiclo2 = out_novoCiclo2.format(date_novoCiclo2);

            String[] arr_nocoCiclo2 = {result_novoCiclo2};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_nocoCiclo2[j], eventCount, getEventDataList4(eventCount));
            }


//Risco MEDIO

            for (int f = 0; f < 4; f++) {
                SimpleDateFormat sdfMedio = new SimpleDateFormat("yyyy-MM-dd");
                Date dateMedio = sdfMedio.parse(result_novoCiclo2);
                dateMedio.setDate(dateMedio.getDate() + i);
                SimpleDateFormat outMedio = new SimpleDateFormat("yyyy-MM-dd");
                String resultMedio = outMedio.format(dateMedio);

                String[] arr13 = {resultMedio};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                result_novoCiclo2 = resultMedio;
                resultado = result_novoCiclo2;
            }

// Risco Baixo
            for (int j = 0; j < 8; j++) {
                SimpleDateFormat sdfBaixo = new SimpleDateFormat("yyyy-MM-dd");
                Date dateBaixo = sdfBaixo.parse(resultado);
                dateBaixo.setDate(dateBaixo.getDate() + i);
                SimpleDateFormat outBaixo = new SimpleDateFormat("yyyy-MM-dd");
                String resultBaixo = outBaixo.format(dateBaixo);

                String[] arr22 = {resultBaixo};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int k = 0; k < 1; k++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr22[k], eventCount, getEventDataList2(eventCount));
                }
                resultado = resultBaixo;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void ciclo27() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Utils u = Utils.getInstance();
            Log.d("DATA RECEBIDA", String.valueOf(u.getData()));
            Log.d("NUMERO RECEBIDo", String.valueOf(u.getNumeroAreceber()));

            Date date = sdf.parse(u.getData());
            Log.d("DATA RECEBIDA", String.valueOf(date));

            int i = 1;
            //4 primeiros dias //Dia 1 da Menstruação
            date.setDate(date.getDate());
            //Toast.makeText(getBaseContext(), "DATA!" + date, Toast.LENGTH_LONG).show();
            SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");
            String result1 = out.format(date);

            String[] arr1 = {result1};
            for (int j = 0; j < 1; j++) {
                int eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr1[j], eventCount, getEventDataList(eventCount));
            }

            int eventCount = 2;
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat out2 = new SimpleDateFormat("yyyy-MM-dd");
            Date data;
            int total_dias = Integer.parseInt(u.getNumeroAreceber()); //se for 4 dias
            total_dias = total_dias - 1;

            //PRIMEIROS DIAS
            for (int k = 1; k <= total_dias; k++) {
                data = sdf2.parse(result1);
                data.setDate(data.getDate() + 1);

                String result2 = out2.format(data);

                String[] arr2 = {result2};
                result1 = result2;
                if (k == 1) {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                } else if (k == 2) { //dia 3
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia3(eventCount));
                } else if (k == 3) {  //dia 4
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia4(eventCount));
                } else if (k == 4) {  //dia 5
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia5(eventCount));
                } else if (k == 5) {  //dia 6
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia6(eventCount));
                } else if (k == 6) {  //dia 7
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia7(eventCount));
                } else if (k == 7) {  //dia 8
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia8(eventCount));
                } else if (k == 8) {  //dia 9
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia9(eventCount));
                }/*else if (k == 9) {  //dia 10
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia10(eventCount));
                }else if (k == 10) {  //dia 11
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia11(eventCount));
                }else if (k == 11) {  //dia 12
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia12(eventCount));
                }*/ else {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                }
            }
            String resultado = "";
            Log.d("TOTAL DIAS", u.getNumeroAreceber());
            total_dias = total_dias + 1; //porque esta a -1
            if (total_dias == 1) {

            } else if (total_dias == 2) {

            } else if (total_dias == 3) {

            } else if (total_dias == 4) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 4; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }
            } else if (total_dias == 5) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }
                for (int k = 0; k < 3; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 6) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }

                for (int k = 0; k < 2; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 7) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                Date date_ = sdf_.parse(result5);
                date_.setDate(date_.getDate() + i);
                SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                String result = out_.format(date_);


                String[] arr = {result};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                }
                result5 = result;
                resultado = result5;


            } else if (total_dias == 8) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }
                resultado = result5;


            } else if (total_dias == 9) {
                resultado = result1;
            } else if (total_dias == 10) {
                resultado = result1;
            } else if (total_dias == 11) {
                resultado = result1;
            } else if (total_dias == 12) {
                resultado = result1;
            }

//Risco MEDIO
            for (int f = 0; f < 3; f++) {
                SimpleDateFormat sdf13 = new SimpleDateFormat("yyyy-MM-dd");
                Date date13 = sdf13.parse(resultado);
                date13.setDate(date13.getDate() + i);
                SimpleDateFormat out13 = new SimpleDateFormat("yyyy-MM-dd");
                String result13 = out13.format(date13);

                String[] arr13 = {result13};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                resultado = result13;
            }

//15 Risco ALTO
            SimpleDateFormat sdf15 = new SimpleDateFormat("yyyy-MM-dd");
            Date date15 = sdf15.parse(resultado);
            date15.setDate(date15.getDate() + i);
            SimpleDateFormat out15 = new SimpleDateFormat("yyyy-MM-dd");
            String result15 = out15.format(date15);

            String[] arr15 = {result15};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr15[j], eventCount, getEventDataList4(eventCount));
            }
//16 Risco ALTO   Dia da Ovulação
            SimpleDateFormat sdf16 = new SimpleDateFormat("yyyy-MM-dd");
            Date date16 = sdf16.parse(result15);
            date16.setDate(date16.getDate() + i);
            SimpleDateFormat out16 = new SimpleDateFormat("yyyy-MM-dd");
            String result16 = out16.format(date16);

            String[] arr16 = {result16};
            for (int j = 0; j < 1; j++) {
                eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr16[j], eventCount, getEventDataListDiaOvulacao(eventCount));
            }

//17 Risco ALTO
            SimpleDateFormat sdf17 = new SimpleDateFormat("yyyy-MM-dd");
            Date date17 = sdf17.parse(result16);
            date17.setDate(date17.getDate() + i);
            SimpleDateFormat out17 = new SimpleDateFormat("yyyy-MM-dd");
            String result17 = out17.format(date17);

            String[] arr17 = {result17};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr17[j], eventCount, getEventDataList4(eventCount));
            }


//Risco MEDIO

            for (int f = 0; f < 4; f++) {
                SimpleDateFormat sdfMedio = new SimpleDateFormat("yyyy-MM-dd");
                Date dateMedio = sdfMedio.parse(result17);
                dateMedio.setDate(dateMedio.getDate() + i);
                SimpleDateFormat outMedio = new SimpleDateFormat("yyyy-MM-dd");
                String resultMedio = outMedio.format(dateMedio);

                String[] arr13 = {resultMedio};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                result17 = resultMedio;
            }

// Risco Baixo
            for (int j = 0; j < 5; j++) {
                SimpleDateFormat sdfBaixo = new SimpleDateFormat("yyyy-MM-dd");
                Date dateBaixo = sdfBaixo.parse(result17);
                dateBaixo.setDate(dateBaixo.getDate() + i);
                SimpleDateFormat outBaixo = new SimpleDateFormat("yyyy-MM-dd");
                String resultBaixo = outBaixo.format(dateBaixo);

                String[] arr22 = {resultBaixo};
                for (int k = 0; k < 1; k++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr22[k], eventCount, getEventDataList2(eventCount));
                }
                result17 = resultBaixo;
            }

// Risco Baixo
            SimpleDateFormat sdf_global = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global = sdf_global.parse(result17);
            date_global.setDate(date_global.getDate() + i);
            SimpleDateFormat out_global = new SimpleDateFormat("yyyy-MM-dd");
            String resultGlobal = out_global.format(date_global);

            String[] arr_global = {resultGlobal};
            CalendarioActivity.global = resultGlobal;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }

// Risco Baixo
            SimpleDateFormat sdf_global2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global2 = sdf_global2.parse(resultGlobal);
            date_global2.setDate(date_global2.getDate() + i);
            SimpleDateFormat out_global2 = new SimpleDateFormat("yyyy-MM-dd");
            String resultGlobal2 = out_global2.format(date_global2);

            String[] arr_global2 = {resultGlobal2};
            CalendarioActivity.global2 = resultGlobal2;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global2[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }

//29 Risco Baixo
            SimpleDateFormat sdf_global3 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global3 = sdf_global3.parse(resultGlobal2);
            date_global3.setDate(date_global3.getDate() + i);
            SimpleDateFormat out_global3 = new SimpleDateFormat("yyyy-MM-dd");
            String result_global3 = out_global3.format(date_global3);

            String[] arr_global3 = {result_global3};
            CalendarioActivity.global3 = result_global3;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global3[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //PREVISAO DE CICLO!!!!!!!!!!!!!!!!
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            sdf = new SimpleDateFormat("yyyy-MM-dd");

            Log.d("DATA RECEBIDA", String.valueOf(u.getData()));
            Log.d("NUMERO RECEBIDo", String.valueOf(u.getNumeroAreceber()));

            date = sdf.parse(result_global3);
            Log.d("DATA A COMEÇAR", String.valueOf(date));

            i = 1;
            //4 primeiros dias //Dia 1 da Menstruação
            date.setDate(date.getDate());
            //Toast.makeText(getBaseContext(), "DATA!" + date, Toast.LENGTH_LONG).show();
            out = new SimpleDateFormat("yyyy-MM-dd");
            result1 = out.format(date);

            eventCount = 2;
            sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            out2 = new SimpleDateFormat("yyyy-MM-dd");
            total_dias = Integer.parseInt(u.getNumeroAreceber()); //se for 4 dias
            //total_dias = total_dias - 1;

            //PRIMEIROS DIAS
            for (int k = 1; k <= total_dias; k++) {
                data = sdf2.parse(result1);
                data.setDate(data.getDate() + 1);

                String result2 = out2.format(data);

                String[] arr2 = {result2};
                result1 = result2;
                if (k == 1) {  //dia 1
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataList(eventCount));
                    CalendarioActivity.global4 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 2) { //dia 2
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                    CalendarioActivity.global10 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 3) {  //dia 3
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia3(eventCount));
                    CalendarioActivity.global11 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 4) {  //dia 4
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia4(eventCount));
                } else if (k == 5) {  //dia 5
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia5(eventCount));
                } else if (k == 6) {  //dia 6
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia6(eventCount));
                } else if (k == 7) {  //dia 7
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia7(eventCount));
                } else if (k == 8) {  //dia 8
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia8(eventCount));
                } else if (k == 9) {  //dia 9
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia9(eventCount));
                } else if (k == 10) {  //dia 10
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia10(eventCount));
                } else if (k == 11) {  //dia 11
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia11(eventCount));
                } else {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                }
            }
            resultado = "";
            Log.d("TOTAL DIAS", u.getNumeroAreceber());
            //total_dias = total_dias + 1; //porque esta a -1

            if (total_dias == 1) {

            } else if (total_dias == 2) {

            } else if (total_dias == 3) {

            } else if (total_dias == 4) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 4; k++) {
                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 5) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 3; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 6) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 2; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 7) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }

                SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                Date date_ = sdf_.parse(result5);
                date_.setDate(date_.getDate() + i);
                SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                String result = out_.format(date_);


                String[] arr = {result};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                }
                result5 = result;
                resultado = result5;


            } else if (total_dias == 8) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }
                resultado = result5;


            } else if (total_dias == 9) {
                resultado = result1;

            } else if (total_dias == 10) {
                resultado = result1;
            } else if (total_dias == 11) {
                resultado = result1;
            } else if (total_dias == 12) {
                resultado = result1;
            }

//Risco MEDIO
            for (int f = 0; f < 3; f++) {
                SimpleDateFormat sdf13 = new SimpleDateFormat("yyyy-MM-dd");
                Date date13 = sdf13.parse(resultado);
                date13.setDate(date13.getDate() + i);
                SimpleDateFormat out13 = new SimpleDateFormat("yyyy-MM-dd");
                String result13 = out13.format(date13);

                String[] arr13 = {result13};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                resultado = result13;
            }

//15 Risco ALTO
            SimpleDateFormat sdf_novo_ciclo = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novo_ciclo = sdf_novo_ciclo.parse(resultado);
            date_novo_ciclo.setDate(date_novo_ciclo.getDate() + i);
            SimpleDateFormat out111 = new SimpleDateFormat("yyyy-MM-dd");
            String result111 = out111.format(date_novo_ciclo);

            String[] arr111 = {result111};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr111[j], eventCount, getEventDataList4(eventCount));
            }
//16 Risco ALTO   Dia da Ovulação
            SimpleDateFormat sdf_novoCiclo = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novoCiclo = sdf_novoCiclo.parse(result111);
            date_novoCiclo.setDate(date_novoCiclo.getDate() + i);
            SimpleDateFormat out_novoCiclo = new SimpleDateFormat("yyyy-MM-dd");
            String result_novoCiclo = out_novoCiclo.format(date_novoCiclo);

            String[] arr_novoCiclo = {result_novoCiclo};
            for (int j = 0; j < 1; j++) {
                eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr_novoCiclo[j], eventCount, getEventDataListDiaOvulacao(eventCount));
            }

//17 Risco ALTO
            SimpleDateFormat sdf_novoCiclo2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novoCiclo2 = sdf_novoCiclo2.parse(result_novoCiclo);
            date_novoCiclo2.setDate(date_novoCiclo2.getDate() + i);
            SimpleDateFormat out_novoCiclo2 = new SimpleDateFormat("yyyy-MM-dd");
            String result_novoCiclo2 = out_novoCiclo2.format(date_novoCiclo2);

            String[] arr_nocoCiclo2 = {result_novoCiclo2};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_nocoCiclo2[j], eventCount, getEventDataList4(eventCount));
            }


//Risco MEDIO

            for (int f = 0; f < 4; f++) {
                SimpleDateFormat sdfMedio = new SimpleDateFormat("yyyy-MM-dd");
                Date dateMedio = sdfMedio.parse(result_novoCiclo2);
                dateMedio.setDate(dateMedio.getDate() + i);
                SimpleDateFormat outMedio = new SimpleDateFormat("yyyy-MM-dd");
                String resultMedio = outMedio.format(dateMedio);

                String[] arr13 = {resultMedio};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                result_novoCiclo2 = resultMedio;
                resultado = result_novoCiclo2;
            }

// Risco Baixo
            for (int j = 0; j < 8; j++) {
                SimpleDateFormat sdfBaixo = new SimpleDateFormat("yyyy-MM-dd");
                Date dateBaixo = sdfBaixo.parse(resultado);
                dateBaixo.setDate(dateBaixo.getDate() + i);
                SimpleDateFormat outBaixo = new SimpleDateFormat("yyyy-MM-dd");
                String resultBaixo = outBaixo.format(dateBaixo);

                String[] arr22 = {resultBaixo};
                for (int k = 0; k < 1; k++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr22[k], eventCount, getEventDataList2(eventCount));
                }
                resultado = resultBaixo;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void ciclo28() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Utils u = Utils.getInstance();
            Log.d("DATA RECEBIDA", String.valueOf(u.getData()));
            Log.d("NUMERO RECEBIDo", String.valueOf(u.getNumeroAreceber()));

            Date date = sdf.parse(u.getData());
            Log.d("DATA RECEBIDA", String.valueOf(date));

            int i = 1;
            //4 primeiros dias //Dia 1 da Menstruação
            date.setDate(date.getDate());
            //Toast.makeText(getBaseContext(), "DATA!" + date, Toast.LENGTH_LONG).show();
            SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");
            String result1 = out.format(date);

            String[] arr1 = {result1};
            for (int j = 0; j < 1; j++) {
                int eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr1[j], eventCount, getEventDataList(eventCount));
            }

            int eventCount = 2;
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat out2 = new SimpleDateFormat("yyyy-MM-dd");
            Date data;
            int total_dias = Integer.parseInt(u.getNumeroAreceber()); //se for 4 dias
            total_dias = total_dias - 1;

            //PRIMEIROS DIAS
            for (int k = 1; k <= total_dias; k++) {
                data = sdf2.parse(result1);
                data.setDate(data.getDate() + 1);

                String result2 = out2.format(data);

                String[] arr2 = {result2};
                result1 = result2;
                if (k == 1) {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                } else if (k == 2) { //dia 3
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia3(eventCount));
                } else if (k == 3) {  //dia 4
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia4(eventCount));
                } else if (k == 4) {  //dia 5
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia5(eventCount));
                } else if (k == 5) {  //dia 6
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia6(eventCount));
                } else if (k == 6) {  //dia 7
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia7(eventCount));
                } else if (k == 7) {  //dia 8
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia8(eventCount));
                } else if (k == 8) {  //dia 9
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia9(eventCount));
                }/*else if (k == 9) {  //dia 10
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia10(eventCount));
                }else if (k == 10) {  //dia 11
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia11(eventCount));
                }else if (k == 11) {  //dia 12
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia12(eventCount));
                }*/ else {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                }
            }
            String resultado = "";
            Log.d("TOTAL DIAS", u.getNumeroAreceber());
            total_dias = total_dias + 1; //porque esta a -1
            if (total_dias == 1) {

            } else if (total_dias == 2) {

            } else if (total_dias == 3) {

            } else if (total_dias == 4) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 5; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 5) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 4; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 6) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 3; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 7) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 2; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 8) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }

                SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                Date date_ = sdf_.parse(result5);
                date_.setDate(date_.getDate() + i);
                SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                String result = out_.format(date_);


                String[] arr = {result};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                }
                resultado = result;


            } else if (total_dias == 9) {
//Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                resultado = result5;

            } else if (total_dias == 10) {
                resultado = result1;
            } else if (total_dias == 11) {
                resultado = result1;
            } else if (total_dias == 12) {
                resultado = result1;
            }

//Risco MEDIO
            for (int f = 0; f < 3; f++) {
                SimpleDateFormat sdf13 = new SimpleDateFormat("yyyy-MM-dd");
                Date date13 = sdf13.parse(resultado);
                date13.setDate(date13.getDate() + i);
                SimpleDateFormat out13 = new SimpleDateFormat("yyyy-MM-dd");
                String result13 = out13.format(date13);

                String[] arr13 = {result13};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                resultado = result13;
            }

//15 Risco ALTO
            SimpleDateFormat sdf15 = new SimpleDateFormat("yyyy-MM-dd");
            Date date15 = sdf15.parse(resultado);
            date15.setDate(date15.getDate() + i);
            SimpleDateFormat out15 = new SimpleDateFormat("yyyy-MM-dd");
            String result15 = out15.format(date15);

            String[] arr15 = {result15};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr15[j], eventCount, getEventDataList4(eventCount));
            }
//16 Risco ALTO   Dia da Ovulação
            SimpleDateFormat sdf16 = new SimpleDateFormat("yyyy-MM-dd");
            Date date16 = sdf16.parse(result15);
            date16.setDate(date16.getDate() + i);
            SimpleDateFormat out16 = new SimpleDateFormat("yyyy-MM-dd");
            String result16 = out16.format(date16);

            String[] arr16 = {result16};
            for (int j = 0; j < 1; j++) {
                eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr16[j], eventCount, getEventDataListDiaOvulacao(eventCount));
            }

//17 Risco ALTO
            SimpleDateFormat sdf17 = new SimpleDateFormat("yyyy-MM-dd");
            Date date17 = sdf17.parse(result16);
            date17.setDate(date17.getDate() + i);
            SimpleDateFormat out17 = new SimpleDateFormat("yyyy-MM-dd");
            String result17 = out17.format(date17);

            String[] arr17 = {result17};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr17[j], eventCount, getEventDataList4(eventCount));
            }


//Risco MEDIO

            for (int f = 0; f < 4; f++) {
                SimpleDateFormat sdfMedio = new SimpleDateFormat("yyyy-MM-dd");
                Date dateMedio = sdfMedio.parse(result17);
                dateMedio.setDate(dateMedio.getDate() + i);
                SimpleDateFormat outMedio = new SimpleDateFormat("yyyy-MM-dd");
                String resultMedio = outMedio.format(dateMedio);

                String[] arr13 = {resultMedio};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                result17 = resultMedio;
            }

// Risco Baixo
            for (int j = 0; j < 5; j++) {
                SimpleDateFormat sdfBaixo = new SimpleDateFormat("yyyy-MM-dd");
                Date dateBaixo = sdfBaixo.parse(result17);
                dateBaixo.setDate(dateBaixo.getDate() + i);
                SimpleDateFormat outBaixo = new SimpleDateFormat("yyyy-MM-dd");
                String resultBaixo = outBaixo.format(dateBaixo);

                String[] arr22 = {resultBaixo};
                for (int k = 0; k < 1; k++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr22[k], eventCount, getEventDataList2(eventCount));
                }
                result17 = resultBaixo;
            }

// Risco Baixo
            SimpleDateFormat sdf_global = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global = sdf_global.parse(result17);
            date_global.setDate(date_global.getDate() + i);
            SimpleDateFormat out_global = new SimpleDateFormat("yyyy-MM-dd");
            String resultGlobal = out_global.format(date_global);

            String[] arr_global = {resultGlobal};
            CalendarioActivity.global = resultGlobal;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }

// Risco Baixo
            SimpleDateFormat sdf_global2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global2 = sdf_global2.parse(resultGlobal);
            date_global2.setDate(date_global2.getDate() + i);
            SimpleDateFormat out_global2 = new SimpleDateFormat("yyyy-MM-dd");
            String resultGlobal2 = out_global2.format(date_global2);

            String[] arr_global2 = {resultGlobal2};
            CalendarioActivity.global2 = resultGlobal2;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global2[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }

//29 Risco Baixo
            SimpleDateFormat sdf_global3 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global3 = sdf_global3.parse(resultGlobal2);
            date_global3.setDate(date_global3.getDate() + i);
            SimpleDateFormat out_global3 = new SimpleDateFormat("yyyy-MM-dd");
            String result_global3 = out_global3.format(date_global3);

            String[] arr_global3 = {result_global3};
            CalendarioActivity.global3 = result_global3;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global3[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //PREVISAO DE CICLO!!!!!!!!!!!!!!!!
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            sdf = new SimpleDateFormat("yyyy-MM-dd");

            Log.d("DATA RECEBIDA", String.valueOf(u.getData()));
            Log.d("NUMERO RECEBIDo", String.valueOf(u.getNumeroAreceber()));

            date = sdf.parse(result_global3);
            Log.d("DATA A COMEÇAR", String.valueOf(date));

            i = 1;
            //4 primeiros dias //Dia 1 da Menstruação
            date.setDate(date.getDate());
            //Toast.makeText(getBaseContext(), "DATA!" + date, Toast.LENGTH_LONG).show();
            out = new SimpleDateFormat("yyyy-MM-dd");
            result1 = out.format(date);

            eventCount = 2;
            sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            out2 = new SimpleDateFormat("yyyy-MM-dd");
            total_dias = Integer.parseInt(u.getNumeroAreceber()); //se for 4 dias
            //total_dias = total_dias - 1;

            //PRIMEIROS DIAS
            for (int k = 1; k <= total_dias; k++) {
                data = sdf2.parse(result1);
                data.setDate(data.getDate() + 1);

                String result2 = out2.format(data);

                String[] arr2 = {result2};
                result1 = result2;
                if (k == 1) {  //dia 1
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataList(eventCount));
                    CalendarioActivity.global4 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 2) { //dia 2
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                    CalendarioActivity.global10 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 3) {  //dia 3
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia3(eventCount));
                    CalendarioActivity.global11 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 4) {  //dia 4
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia4(eventCount));
                } else if (k == 5) {  //dia 5
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia5(eventCount));
                } else if (k == 6) {  //dia 6
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia6(eventCount));
                } else if (k == 7) {  //dia 7
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia7(eventCount));
                } else if (k == 8) {  //dia 8
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia8(eventCount));
                } else if (k == 9) {  //dia 9
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia9(eventCount));
                } else if (k == 10) {  //dia 10
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia10(eventCount));
                } else if (k == 11) {  //dia 11
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia11(eventCount));
                } else {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                }
            }
            resultado = "";
            Log.d("TOTAL DIAS", u.getNumeroAreceber());
            //total_dias = total_dias + 1; //porque esta a -1

            if (total_dias == 1) {

            } else if (total_dias == 2) {

            } else if (total_dias == 3) {

            } else if (total_dias == 4) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 5; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 5) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 4; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 6) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 3; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 7) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }

                for (int k = 0; k < 2; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 8) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }

                SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                Date date_ = sdf_.parse(result5);
                date_.setDate(date_.getDate() + i);
                SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                String result = out_.format(date_);


                String[] arr = {result};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                }
                resultado = result;


            } else if (total_dias == 9) {
//Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                resultado = result5;

            } else if (total_dias == 10) {
                resultado = result1;
            } else if (total_dias == 11) {
                resultado = result1;
            } else if (total_dias == 12) {
                resultado = result1;
            }

//Risco MEDIO
            for (int f = 0; f < 3; f++) {
                SimpleDateFormat sdf13 = new SimpleDateFormat("yyyy-MM-dd");
                Date date13 = sdf13.parse(resultado);
                date13.setDate(date13.getDate() + i);
                SimpleDateFormat out13 = new SimpleDateFormat("yyyy-MM-dd");
                String result13 = out13.format(date13);

                String[] arr13 = {result13};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                resultado = result13;
            }

//15 Risco ALTO
            SimpleDateFormat sdf_novo_ciclo = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novo_ciclo = sdf_novo_ciclo.parse(resultado);
            date_novo_ciclo.setDate(date_novo_ciclo.getDate() + i);
            SimpleDateFormat out111 = new SimpleDateFormat("yyyy-MM-dd");
            String result111 = out111.format(date_novo_ciclo);

            String[] arr111 = {result111};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr111[j], eventCount, getEventDataList4(eventCount));
            }
//16 Risco ALTO   Dia da Ovulação
            SimpleDateFormat sdf_novoCiclo = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novoCiclo = sdf_novoCiclo.parse(result111);
            date_novoCiclo.setDate(date_novoCiclo.getDate() + i);
            SimpleDateFormat out_novoCiclo = new SimpleDateFormat("yyyy-MM-dd");
            String result_novoCiclo = out_novoCiclo.format(date_novoCiclo);

            String[] arr_novoCiclo = {result_novoCiclo};
            for (int j = 0; j < 1; j++) {
                eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr_novoCiclo[j], eventCount, getEventDataListDiaOvulacao(eventCount));
            }

//17 Risco ALTO
            SimpleDateFormat sdf_novoCiclo2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novoCiclo2 = sdf_novoCiclo2.parse(result_novoCiclo);
            date_novoCiclo2.setDate(date_novoCiclo2.getDate() + i);
            SimpleDateFormat out_novoCiclo2 = new SimpleDateFormat("yyyy-MM-dd");
            String result_novoCiclo2 = out_novoCiclo2.format(date_novoCiclo2);

            String[] arr_nocoCiclo2 = {result_novoCiclo2};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_nocoCiclo2[j], eventCount, getEventDataList4(eventCount));
            }


//Risco MEDIO

            for (int f = 0; f < 4; f++) {
                SimpleDateFormat sdfMedio = new SimpleDateFormat("yyyy-MM-dd");
                Date dateMedio = sdfMedio.parse(result_novoCiclo2);
                dateMedio.setDate(dateMedio.getDate() + i);
                SimpleDateFormat outMedio = new SimpleDateFormat("yyyy-MM-dd");
                String resultMedio = outMedio.format(dateMedio);

                String[] arr13 = {resultMedio};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                result_novoCiclo2 = resultMedio;
                resultado = result_novoCiclo2;
            }

// Risco Baixo
            for (int j = 0; j < 8; j++) {
                SimpleDateFormat sdfBaixo = new SimpleDateFormat("yyyy-MM-dd");
                Date dateBaixo = sdfBaixo.parse(resultado);
                dateBaixo.setDate(dateBaixo.getDate() + i);
                SimpleDateFormat outBaixo = new SimpleDateFormat("yyyy-MM-dd");
                String resultBaixo = outBaixo.format(dateBaixo);

                String[] arr22 = {resultBaixo};
                for (int k = 0; k < 1; k++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr22[k], eventCount, getEventDataList2(eventCount));
                }
                resultado = resultBaixo;
            }

// Risco Baixo
            SimpleDateFormat sdf_global22 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global22 = sdf_global22.parse(resultado);
            date_global22.setDate(date_global22.getDate() + i);
            SimpleDateFormat out_global22 = new SimpleDateFormat("yyyy-MM-dd");
            String resultGlobal22 = out_global22.format(date_global22);

            String[] arr_global22 = {resultGlobal22};
            CalendarioActivity.global = resultGlobal22;
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }

// Risco Baixo
            SimpleDateFormat sdf_global23 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global23 = sdf_global23.parse(resultGlobal22);
            date_global23.setDate(date_global23.getDate() + i);
            SimpleDateFormat out_global23 = new SimpleDateFormat("yyyy-MM-dd");
            String resultGlobal23 = out_global23.format(date_global23);

            String[] arr_global23 = {resultGlobal23};
            CalendarioActivity.global2 = resultGlobal23;


            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global2[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void ciclo29() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Utils u = Utils.getInstance();
            Log.d("DATA RECEBIDA", String.valueOf(u.getData()));
            Log.d("NUMERO RECEBIDo", String.valueOf(u.getNumeroAreceber()));

            Date date = sdf.parse(u.getData());
            Log.d("DATA RECEBIDA", String.valueOf(date));

            int i = 1;
            //4 primeiros dias //Dia 1 da Menstruação
            date.setDate(date.getDate());
            //Toast.makeText(getBaseContext(), "DATA!" + date, Toast.LENGTH_LONG).show();
            SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");
            String result1 = out.format(date);

            String[] arr1 = {result1};
            for (int j = 0; j < 1; j++) {
                int eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr1[j], eventCount, getEventDataList(eventCount));
            }

            int eventCount = 2;
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat out2 = new SimpleDateFormat("yyyy-MM-dd");
            Date data;
            int total_dias = Integer.parseInt(u.getNumeroAreceber()); //se for 4 dias
            total_dias = total_dias - 1;

            //PRIMEIROS DIAS
            for (int k = 1; k <= total_dias; k++) {
                data = sdf2.parse(result1);
                data.setDate(data.getDate() + 1);

                String result2 = out2.format(data);

                String[] arr2 = {result2};
                result1 = result2;
                if (k == 1) {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                } else if (k == 2) { //dia 3
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia3(eventCount));
                } else if (k == 3) {  //dia 4
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia4(eventCount));
                } else if (k == 4) {  //dia 5
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia5(eventCount));
                } else if (k == 5) {  //dia 6
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia6(eventCount));
                } else if (k == 6) {  //dia 7
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia7(eventCount));
                } else if (k == 7) {  //dia 8
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia8(eventCount));
                } else if (k == 8) {  //dia 9
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia9(eventCount));
                }/*else if (k == 9) {  //dia 10
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia10(eventCount));
                }else if (k == 10) {  //dia 11
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia11(eventCount));
                }else if (k == 11) {  //dia 12
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia12(eventCount));
                }*/ else {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                }
            }
            String resultado = "";
            Log.d("TOTAL DIAS", u.getNumeroAreceber());
            total_dias = total_dias + 1; //porque esta a -1
            if (total_dias == 1) {

            } else if (total_dias == 2) {

            } else if (total_dias == 3) {

            } else if (total_dias == 4) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 6; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 5) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 5; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 6) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 4; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 7) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 3; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 8) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 2; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }
            } else if (total_dias == 9) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }

                SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                Date date_ = sdf_.parse(result5);
                date_.setDate(date_.getDate() + i);
                SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                String result = out_.format(date_);


                String[] arr = {result};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                }
                resultado = result;


            } else if (total_dias == 10) {
//Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                resultado = result5;

            } else if (total_dias == 10) {
                resultado = result1;
            } else if (total_dias == 11) {
                resultado = result1;
            } else if (total_dias == 12) {
                resultado = result1;
            }

//Risco MEDIO
            for (int f = 0; f < 3; f++) {
                SimpleDateFormat sdf13 = new SimpleDateFormat("yyyy-MM-dd");
                Date date13 = sdf13.parse(resultado);
                date13.setDate(date13.getDate() + i);
                SimpleDateFormat out13 = new SimpleDateFormat("yyyy-MM-dd");
                String result13 = out13.format(date13);

                String[] arr13 = {result13};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                resultado = result13;
            }

//15 Risco ALTO
            SimpleDateFormat sdf15 = new SimpleDateFormat("yyyy-MM-dd");
            Date date15 = sdf15.parse(resultado);
            date15.setDate(date15.getDate() + i);
            SimpleDateFormat out15 = new SimpleDateFormat("yyyy-MM-dd");
            String result15 = out15.format(date15);

            String[] arr15 = {result15};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr15[j], eventCount, getEventDataList4(eventCount));
            }
//16 Risco ALTO   Dia da Ovulação
            SimpleDateFormat sdf16 = new SimpleDateFormat("yyyy-MM-dd");
            Date date16 = sdf16.parse(result15);
            date16.setDate(date16.getDate() + i);
            SimpleDateFormat out16 = new SimpleDateFormat("yyyy-MM-dd");
            String result16 = out16.format(date16);

            String[] arr16 = {result16};
            for (int j = 0; j < 1; j++) {
                eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr16[j], eventCount, getEventDataListDiaOvulacao(eventCount));
            }

//17 Risco ALTO
            SimpleDateFormat sdf17 = new SimpleDateFormat("yyyy-MM-dd");
            Date date17 = sdf17.parse(result16);
            date17.setDate(date17.getDate() + i);
            SimpleDateFormat out17 = new SimpleDateFormat("yyyy-MM-dd");
            String result17 = out17.format(date17);

            String[] arr17 = {result17};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr17[j], eventCount, getEventDataList4(eventCount));
            }

//Risco MEDIO

            for (int f = 0; f < 4; f++) {
                SimpleDateFormat sdfMedio = new SimpleDateFormat("yyyy-MM-dd");
                Date dateMedio = sdfMedio.parse(result17);
                dateMedio.setDate(dateMedio.getDate() + i);
                SimpleDateFormat outMedio = new SimpleDateFormat("yyyy-MM-dd");
                String resultMedio = outMedio.format(dateMedio);

                String[] arr13 = {resultMedio};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                result17 = resultMedio;
            }

// Risco Baixo
            for (int j = 0; j < 5; j++) {
                SimpleDateFormat sdfBaixo = new SimpleDateFormat("yyyy-MM-dd");
                Date dateBaixo = sdfBaixo.parse(result17);
                dateBaixo.setDate(dateBaixo.getDate() + i);
                SimpleDateFormat outBaixo = new SimpleDateFormat("yyyy-MM-dd");
                String resultBaixo = outBaixo.format(dateBaixo);

                String[] arr22 = {resultBaixo};
                for (int k = 0; k < 1; k++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr22[k], eventCount, getEventDataList2(eventCount));
                }
                result17 = resultBaixo;
            }

// Risco Baixo
            SimpleDateFormat sdf_global = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global = sdf_global.parse(result17);
            date_global.setDate(date_global.getDate() + i);
            SimpleDateFormat out_global = new SimpleDateFormat("yyyy-MM-dd");
            String resultGlobal = out_global.format(date_global);

            String[] arr_global = {resultGlobal};
            CalendarioActivity.global = resultGlobal;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }

// Risco Baixo
            SimpleDateFormat sdf_global2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global2 = sdf_global2.parse(resultGlobal);
            date_global2.setDate(date_global2.getDate() + i);
            SimpleDateFormat out_global2 = new SimpleDateFormat("yyyy-MM-dd");
            String resultGlobal2 = out_global2.format(date_global2);

            String[] arr_global2 = {resultGlobal2};
            CalendarioActivity.global2 = resultGlobal2;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global2[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }

//29 Risco Baixo
            SimpleDateFormat sdf_global3 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global3 = sdf_global3.parse(resultGlobal2);
            date_global3.setDate(date_global3.getDate() + i);
            SimpleDateFormat out_global3 = new SimpleDateFormat("yyyy-MM-dd");
            String result_global3 = out_global3.format(date_global3);

            String[] arr_global3 = {result_global3};
            CalendarioActivity.global3 = result_global3;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global3[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //PREVISAO DE CICLO!!!!!!!!!!!!!!!!
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            sdf = new SimpleDateFormat("yyyy-MM-dd");

            Log.d("DATA RECEBIDA", String.valueOf(u.getData()));
            Log.d("NUMERO RECEBIDo", String.valueOf(u.getNumeroAreceber()));

            date = sdf.parse(result_global3);
            Log.d("DATA A COMEÇAR", String.valueOf(date));

            i = 1;
            //4 primeiros dias //Dia 1 da Menstruação
            date.setDate(date.getDate());
            //Toast.makeText(getBaseContext(), "DATA!" + date, Toast.LENGTH_LONG).show();
            out = new SimpleDateFormat("yyyy-MM-dd");
            result1 = out.format(date);

            eventCount = 2;
            sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            out2 = new SimpleDateFormat("yyyy-MM-dd");
            total_dias = Integer.parseInt(u.getNumeroAreceber()); //se for 4 dias
            //total_dias = total_dias - 1;

            //PRIMEIROS DIAS
            for (int k = 1; k <= total_dias; k++) {
                data = sdf2.parse(result1);
                data.setDate(data.getDate() + 1);

                String result2 = out2.format(data);

                String[] arr2 = {result2};
                result1 = result2;
                if (k == 1) {  //dia 1
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataList(eventCount));
                    CalendarioActivity.global4 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 2) { //dia 2
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                    CalendarioActivity.global10 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 3) {  //dia 3
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia3(eventCount));
                    CalendarioActivity.global11 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 4) {  //dia 4
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia4(eventCount));
                } else if (k == 5) {  //dia 5
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia5(eventCount));
                } else if (k == 6) {  //dia 6
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia6(eventCount));
                } else if (k == 7) {  //dia 7
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia7(eventCount));
                } else if (k == 8) {  //dia 8
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia8(eventCount));
                } else if (k == 9) {  //dia 9
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia9(eventCount));
                } else if (k == 10) {  //dia 10
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia10(eventCount));
                } else if (k == 11) {  //dia 11
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia11(eventCount));
                } else {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                }
            }
            resultado = "";
            Log.d("TOTAL DIAS", u.getNumeroAreceber());
            //total_dias = total_dias + 1; //porque esta a -1

            if (total_dias == 1) {

            } else if (total_dias == 2) {

            } else if (total_dias == 3) {

            } else if (total_dias == 4) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 6; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 5) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 5; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 6) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }

                for (int k = 0; k < 4; k++) {
                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 7) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 3; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 8) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 2; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }


            } else if (total_dias == 9) {
//Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }

                SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                Date date_ = sdf_.parse(result5);
                date_.setDate(date_.getDate() + i);
                SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                String result = out_.format(date_);


                String[] arr = {result};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                }
                resultado = result;


            } else if (total_dias == 10) {
                resultado = result1;
            } else if (total_dias == 11) {
                resultado = result1;
            } else if (total_dias == 12) {
                resultado = result1;
            }

//Risco MEDIO
            for (int f = 0; f < 3; f++) {
                SimpleDateFormat sdf13 = new SimpleDateFormat("yyyy-MM-dd");
                Date date13 = sdf13.parse(resultado);
                date13.setDate(date13.getDate() + i);
                SimpleDateFormat out13 = new SimpleDateFormat("yyyy-MM-dd");
                String result13 = out13.format(date13);

                String[] arr13 = {result13};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                resultado = result13;
            }

//15 Risco ALTO
            SimpleDateFormat sdf_novo_ciclo = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novo_ciclo = sdf_novo_ciclo.parse(resultado);
            date_novo_ciclo.setDate(date_novo_ciclo.getDate() + i);
            SimpleDateFormat out111 = new SimpleDateFormat("yyyy-MM-dd");
            String result111 = out111.format(date_novo_ciclo);

            String[] arr111 = {result111};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr111[j], eventCount, getEventDataList4(eventCount));
            }
//16 Risco ALTO   Dia da Ovulação
            SimpleDateFormat sdf_novoCiclo = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novoCiclo = sdf_novoCiclo.parse(result111);
            date_novoCiclo.setDate(date_novoCiclo.getDate() + i);
            SimpleDateFormat out_novoCiclo = new SimpleDateFormat("yyyy-MM-dd");
            String result_novoCiclo = out_novoCiclo.format(date_novoCiclo);

            String[] arr_novoCiclo = {result_novoCiclo};
            for (int j = 0; j < 1; j++) {
                eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr_novoCiclo[j], eventCount, getEventDataListDiaOvulacao(eventCount));
            }

//17 Risco ALTO
            SimpleDateFormat sdf_novoCiclo2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novoCiclo2 = sdf_novoCiclo2.parse(result_novoCiclo);
            date_novoCiclo2.setDate(date_novoCiclo2.getDate() + i);
            SimpleDateFormat out_novoCiclo2 = new SimpleDateFormat("yyyy-MM-dd");
            String result_novoCiclo2 = out_novoCiclo2.format(date_novoCiclo2);

            String[] arr_nocoCiclo2 = {result_novoCiclo2};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_nocoCiclo2[j], eventCount, getEventDataList4(eventCount));
            }


//Risco MEDIO

            for (int f = 0; f < 4; f++) {
                SimpleDateFormat sdfMedio = new SimpleDateFormat("yyyy-MM-dd");
                Date dateMedio = sdfMedio.parse(result_novoCiclo2);
                dateMedio.setDate(dateMedio.getDate() + i);
                SimpleDateFormat outMedio = new SimpleDateFormat("yyyy-MM-dd");
                String resultMedio = outMedio.format(dateMedio);

                String[] arr13 = {resultMedio};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                result_novoCiclo2 = resultMedio;
                resultado = result_novoCiclo2;
            }

// Risco Baixo
            for (int j = 0; j < 8; j++) {
                SimpleDateFormat sdfBaixo = new SimpleDateFormat("yyyy-MM-dd");
                Date dateBaixo = sdfBaixo.parse(resultado);
                dateBaixo.setDate(dateBaixo.getDate() + i);
                SimpleDateFormat outBaixo = new SimpleDateFormat("yyyy-MM-dd");
                String resultBaixo = outBaixo.format(dateBaixo);

                String[] arr22 = {resultBaixo};
                for (int k = 0; k < 1; k++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr22[k], eventCount, getEventDataList2(eventCount));
                }
                resultado = resultBaixo;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void ciclo30() {


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Utils u = Utils.getInstance();
            Log.d("DATA RECEBIDA", String.valueOf(u.getData()));
            Log.d("NUMERO RECEBIDo", String.valueOf(u.getNumeroAreceber()));

            Date date = sdf.parse(u.getData());
            Log.d("DATA RECEBIDA", String.valueOf(date));

            int i = 1;
            //4 primeiros dias //Dia 1 da Menstruação
            date.setDate(date.getDate());
            //Toast.makeText(getBaseContext(), "DATA!" + date, Toast.LENGTH_LONG).show();
            SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");
            String result1 = out.format(date);

            String[] arr1 = {result1};
            for (int j = 0; j < 1; j++) {
                int eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr1[j], eventCount, getEventDataList(eventCount));
            }

            int eventCount = 2;
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat out2 = new SimpleDateFormat("yyyy-MM-dd");
            Date data;
            int total_dias = Integer.parseInt(u.getNumeroAreceber()); //se for 4 dias
            total_dias = total_dias - 1;

            //PRIMEIROS DIAS
            for (int k = 1; k <= total_dias; k++) {
                data = sdf2.parse(result1);
                data.setDate(data.getDate() + 1);

                String result2 = out2.format(data);

                String[] arr2 = {result2};
                result1 = result2;
                if (k == 1) {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                } else if (k == 2) { //dia 3
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia3(eventCount));
                } else if (k == 3) {  //dia 4
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia4(eventCount));
                } else if (k == 4) {  //dia 5
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia5(eventCount));
                } else if (k == 5) {  //dia 6
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia6(eventCount));
                } else if (k == 6) {  //dia 7
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia7(eventCount));
                } else if (k == 7) {  //dia 8
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia8(eventCount));
                } else if (k == 8) {  //dia 9
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia9(eventCount));
                }/*else if (k == 9) {  //dia 10
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia10(eventCount));
                }else if (k == 10) {  //dia 11
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia11(eventCount));
                }else if (k == 11) {  //dia 12
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia12(eventCount));
                }*/ else {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                }
            }
            String resultado = "";
            Log.d("TOTAL DIAS", u.getNumeroAreceber());
            total_dias = total_dias + 1; //porque esta a -1
            if (total_dias == 1) {

            } else if (total_dias == 2) {

            } else if (total_dias == 3) {

            } else if (total_dias == 4) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 7; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 5) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 6; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 6) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 5; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 7) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 4; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 8) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 3; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }
            } else if (total_dias == 9) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 2; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }


            } else if (total_dias == 10) {
//Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                Date date_ = sdf_.parse(result5);
                date_.setDate(date_.getDate() + i);
                SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                String result = out_.format(date_);


                String[] arr = {result};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                }


                resultado = result;

            } else if (total_dias == 10) {
                resultado = result1;
            } else if (total_dias == 11) {
                resultado = result1;
            } else if (total_dias == 12) {
                resultado = result1;
            }

//Risco MEDIO
            for (int f = 0; f < 3; f++) {
                SimpleDateFormat sdf13 = new SimpleDateFormat("yyyy-MM-dd");
                Date date13 = sdf13.parse(resultado);
                date13.setDate(date13.getDate() + i);
                SimpleDateFormat out13 = new SimpleDateFormat("yyyy-MM-dd");
                String result13 = out13.format(date13);

                String[] arr13 = {result13};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                resultado = result13;
            }

//15 Risco ALTO
            SimpleDateFormat sdf15 = new SimpleDateFormat("yyyy-MM-dd");
            Date date15 = sdf15.parse(resultado);
            date15.setDate(date15.getDate() + i);
            SimpleDateFormat out15 = new SimpleDateFormat("yyyy-MM-dd");
            String result15 = out15.format(date15);

            String[] arr15 = {result15};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr15[j], eventCount, getEventDataList4(eventCount));
            }
//16 Risco ALTO   Dia da Ovulação
            SimpleDateFormat sdf16 = new SimpleDateFormat("yyyy-MM-dd");
            Date date16 = sdf16.parse(result15);
            date16.setDate(date16.getDate() + i);
            SimpleDateFormat out16 = new SimpleDateFormat("yyyy-MM-dd");
            String result16 = out16.format(date16);

            String[] arr16 = {result16};
            for (int j = 0; j < 1; j++) {
                eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr16[j], eventCount, getEventDataListDiaOvulacao(eventCount));
            }

//17 Risco ALTO
            SimpleDateFormat sdf17 = new SimpleDateFormat("yyyy-MM-dd");
            Date date17 = sdf17.parse(result16);
            date17.setDate(date17.getDate() + i);
            SimpleDateFormat out17 = new SimpleDateFormat("yyyy-MM-dd");
            String result17 = out17.format(date17);

            String[] arr17 = {result17};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr17[j], eventCount, getEventDataList4(eventCount));
            }


//Risco MEDIO

            for (int f = 0; f < 4; f++) {
                SimpleDateFormat sdfMedio = new SimpleDateFormat("yyyy-MM-dd");
                Date dateMedio = sdfMedio.parse(result17);
                dateMedio.setDate(dateMedio.getDate() + i);
                SimpleDateFormat outMedio = new SimpleDateFormat("yyyy-MM-dd");
                String resultMedio = outMedio.format(dateMedio);

                String[] arr13 = {resultMedio};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                result17 = resultMedio;
            }

// Risco Baixo
            for (int j = 0; j < 5; j++) {
                SimpleDateFormat sdfBaixo = new SimpleDateFormat("yyyy-MM-dd");
                Date dateBaixo = sdfBaixo.parse(result17);
                dateBaixo.setDate(dateBaixo.getDate() + i);
                SimpleDateFormat outBaixo = new SimpleDateFormat("yyyy-MM-dd");
                String resultBaixo = outBaixo.format(dateBaixo);

                String[] arr22 = {resultBaixo};
                for (int k = 0; k < 1; k++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr22[k], eventCount, getEventDataList2(eventCount));
                }
                result17 = resultBaixo;
            }

// Risco Baixo
            SimpleDateFormat sdf_global = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global = sdf_global.parse(result17);
            date_global.setDate(date_global.getDate() + i);
            SimpleDateFormat out_global = new SimpleDateFormat("yyyy-MM-dd");
            String resultGlobal = out_global.format(date_global);

            String[] arr_global = {resultGlobal};
            CalendarioActivity.global = resultGlobal;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }

// Risco Baixo
            SimpleDateFormat sdf_global2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global2 = sdf_global2.parse(resultGlobal);
            date_global2.setDate(date_global2.getDate() + i);
            SimpleDateFormat out_global2 = new SimpleDateFormat("yyyy-MM-dd");
            String resultGlobal2 = out_global2.format(date_global2);

            String[] arr_global2 = {resultGlobal2};
            CalendarioActivity.global2 = resultGlobal2;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global2[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }

//29 Risco Baixo
            SimpleDateFormat sdf_global3 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global3 = sdf_global3.parse(resultGlobal2);
            date_global3.setDate(date_global3.getDate() + i);
            SimpleDateFormat out_global3 = new SimpleDateFormat("yyyy-MM-dd");
            String result_global3 = out_global3.format(date_global3);

            String[] arr_global3 = {result_global3};
            CalendarioActivity.global3 = result_global3;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global3[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //PREVISAO DE CICLO!!!!!!!!!!!!!!!!
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            sdf = new SimpleDateFormat("yyyy-MM-dd");

            Log.d("DATA RECEBIDA", String.valueOf(u.getData()));
            Log.d("NUMERO RECEBIDo", String.valueOf(u.getNumeroAreceber()));

            date = sdf.parse(result_global3);
            Log.d("DATA A COMEÇAR", String.valueOf(date));

            i = 1;
            //4 primeiros dias //Dia 1 da Menstruação
            date.setDate(date.getDate());
            //Toast.makeText(getBaseContext(), "DATA!" + date, Toast.LENGTH_LONG).show();
            out = new SimpleDateFormat("yyyy-MM-dd");
            result1 = out.format(date);

            eventCount = 2;
            sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            out2 = new SimpleDateFormat("yyyy-MM-dd");
            total_dias = Integer.parseInt(u.getNumeroAreceber()); //se for 4 dias
            //total_dias = total_dias - 1;

            //PRIMEIROS DIAS
            for (int k = 1; k <= total_dias; k++) {
                data = sdf2.parse(result1);
                data.setDate(data.getDate() + 1);

                String result2 = out2.format(data);

                String[] arr2 = {result2};
                result1 = result2;
                if (k == 1) {  //dia 1
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataList(eventCount));
                    CalendarioActivity.global4 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 2) { //dia 2
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                    CalendarioActivity.global10 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 3) {  //dia 3
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia3(eventCount));
                    CalendarioActivity.global11 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 4) {  //dia 4
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia4(eventCount));
                } else if (k == 5) {  //dia 5
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia5(eventCount));
                } else if (k == 6) {  //dia 6
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia6(eventCount));
                } else if (k == 7) {  //dia 7
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia7(eventCount));
                } else if (k == 8) {  //dia 8
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia8(eventCount));
                } else if (k == 9) {  //dia 9
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia9(eventCount));
                } else if (k == 10) {  //dia 10
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia10(eventCount));
                } else if (k == 11) {  //dia 11
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia11(eventCount));
                } else {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                }
            }
            resultado = "";
            Log.d("TOTAL DIAS", u.getNumeroAreceber());
            //total_dias = total_dias + 1; //porque esta a -1

            if (total_dias == 1) {

            } else if (total_dias == 2) {

            } else if (total_dias == 3) {

            } else if (total_dias == 4) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 7; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 5) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 6; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    //os eventos a seguir ao diferente já nao estao assinalados
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 6) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 5; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    //os eventos a seguir ao diferente já nao estao assinalados
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 7) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 4; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 8) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 3; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }


            } else if (total_dias == 9) {
//Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 2; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }


            } else if (total_dias == 10) {
                resultado = result1;
            } else if (total_dias == 11) {
                resultado = result1;
            } else if (total_dias == 12) {
                resultado = result1;
            }

//Risco MEDIO
            for (int f = 0; f < 3; f++) {
                SimpleDateFormat sdf13 = new SimpleDateFormat("yyyy-MM-dd");
                Date date13 = sdf13.parse(resultado);
                date13.setDate(date13.getDate() + i);
                SimpleDateFormat out13 = new SimpleDateFormat("yyyy-MM-dd");
                String result13 = out13.format(date13);

                String[] arr13 = {result13};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                resultado = result13;
            }

//15 Risco ALTO
            SimpleDateFormat sdf_novo_ciclo = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novo_ciclo = sdf_novo_ciclo.parse(resultado);
            date_novo_ciclo.setDate(date_novo_ciclo.getDate() + i);
            SimpleDateFormat out111 = new SimpleDateFormat("yyyy-MM-dd");
            String result111 = out111.format(date_novo_ciclo);

            String[] arr111 = {result111};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr111[j], eventCount, getEventDataList4(eventCount));
            }
//16 Risco ALTO   Dia da Ovulação
            SimpleDateFormat sdf_novoCiclo = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novoCiclo = sdf_novoCiclo.parse(result111);
            date_novoCiclo.setDate(date_novoCiclo.getDate() + i);
            SimpleDateFormat out_novoCiclo = new SimpleDateFormat("yyyy-MM-dd");
            String result_novoCiclo = out_novoCiclo.format(date_novoCiclo);

            String[] arr_novoCiclo = {result_novoCiclo};
            for (int j = 0; j < 1; j++) {
                eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr_novoCiclo[j], eventCount, getEventDataListDiaOvulacao(eventCount));
            }

//17 Risco ALTO
            SimpleDateFormat sdf_novoCiclo2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novoCiclo2 = sdf_novoCiclo2.parse(result_novoCiclo);
            date_novoCiclo2.setDate(date_novoCiclo2.getDate() + i);
            SimpleDateFormat out_novoCiclo2 = new SimpleDateFormat("yyyy-MM-dd");
            String result_novoCiclo2 = out_novoCiclo2.format(date_novoCiclo2);

            String[] arr_nocoCiclo2 = {result_novoCiclo2};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_nocoCiclo2[j], eventCount, getEventDataList4(eventCount));
            }


//Risco MEDIO

            for (int f = 0; f < 4; f++) {
                SimpleDateFormat sdfMedio = new SimpleDateFormat("yyyy-MM-dd");
                Date dateMedio = sdfMedio.parse(result_novoCiclo2);
                dateMedio.setDate(dateMedio.getDate() + i);
                SimpleDateFormat outMedio = new SimpleDateFormat("yyyy-MM-dd");
                String resultMedio = outMedio.format(dateMedio);

                String[] arr13 = {resultMedio};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                result_novoCiclo2 = resultMedio;
                resultado = result_novoCiclo2;
            }

// Risco Baixo
            for (int j = 0; j < 8; j++) {
                SimpleDateFormat sdfBaixo = new SimpleDateFormat("yyyy-MM-dd");
                Date dateBaixo = sdfBaixo.parse(resultado);
                dateBaixo.setDate(dateBaixo.getDate() + i);
                SimpleDateFormat outBaixo = new SimpleDateFormat("yyyy-MM-dd");
                String resultBaixo = outBaixo.format(dateBaixo);

                String[] arr22 = {resultBaixo};
                for (int k = 0; k < 1; k++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr22[k], eventCount, getEventDataList2(eventCount));
                }
                resultado = resultBaixo;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void ciclo31() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Utils u = Utils.getInstance();
            Log.d("DATA RECEBIDA", String.valueOf(u.getData()));
            Log.d("NUMERO RECEBIDo", String.valueOf(u.getNumeroAreceber()));
            Log.d("NUMERO DE DIAS  ----->", String.valueOf(u.getDuracaoCicloMenstrual()));

            Date date = sdf.parse(u.getData());
            Log.d("DATA RECEBIDA", String.valueOf(date));

            int i = 1;
            //4 primeiros dias //Dia 1 da Menstruação
            date.setDate(date.getDate());
            //Toast.makeText(getBaseContext(), "DATA!" + date, Toast.LENGTH_LONG).show();
            SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");
            String result1 = out.format(date);

            String[] arr1 = {result1};
            for (int j = 0; j < 1; j++) {
                int eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr1[j], eventCount, getEventDataList(eventCount));
            }

            int eventCount = 2;
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat out2 = new SimpleDateFormat("yyyy-MM-dd");
            Date data;
            int total_dias = Integer.parseInt(u.getNumeroAreceber()); //se for 4 dias
            total_dias = total_dias - 1;

            //PRIMEIROS DIAS
            for (int k = 1; k <= total_dias; k++) {
                data = sdf2.parse(result1);
                data.setDate(data.getDate() + 1);

                String result2 = out2.format(data);

                String[] arr2 = {result2};
                result1 = result2;
                if (k == 1) {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                } else if (k == 2) { //dia 3
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia3(eventCount));
                } else if (k == 3) {  //dia 4
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia4(eventCount));
                } else if (k == 4) {  //dia 5
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia5(eventCount));
                } else if (k == 5) {  //dia 6
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia6(eventCount));
                } else if (k == 6) {  //dia 7
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia7(eventCount));
                } else if (k == 7) {  //dia 8
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia8(eventCount));
                } else if (k == 8) {  //dia 9
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia9(eventCount));
                }/*else if (k == 9) {  //dia 10
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia10(eventCount));
                }else if (k == 10) {  //dia 11
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia11(eventCount));
                }else if (k == 11) {  //dia 12
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia12(eventCount));
                }*/ else {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                }
            }
            String resultado = "";
            Log.d("TOTAL DIAS", u.getNumeroAreceber());
            total_dias = total_dias + 1; //porque esta a -1
            if (total_dias == 1) {

            } else if (total_dias == 2) {

            } else if (total_dias == 3) {

            } else if (total_dias == 4) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 8; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 5) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 7; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 6) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 6; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 7) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 5; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 8) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 4; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }
            } else if (total_dias == 9) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 3; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }


            } else if (total_dias == 10) {
//Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 2; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 10) {
                resultado = result1;
            } else if (total_dias == 11) {
                resultado = result1;
            } else if (total_dias == 12) {
                resultado = result1;
            }

//Risco MEDIO
            for (int f = 0; f < 3; f++) {
                SimpleDateFormat sdf13 = new SimpleDateFormat("yyyy-MM-dd");
                Date date13 = sdf13.parse(resultado);
                date13.setDate(date13.getDate() + i);
                SimpleDateFormat out13 = new SimpleDateFormat("yyyy-MM-dd");
                String result13 = out13.format(date13);

                String[] arr13 = {result13};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                resultado = result13;
            }

//15 Risco ALTO
            SimpleDateFormat sdf15 = new SimpleDateFormat("yyyy-MM-dd");
            Date date15 = sdf15.parse(resultado);
            date15.setDate(date15.getDate() + i);
            SimpleDateFormat out15 = new SimpleDateFormat("yyyy-MM-dd");
            String result15 = out15.format(date15);

            String[] arr15 = {result15};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr15[j], eventCount, getEventDataList4(eventCount));
            }
//16 Risco ALTO   Dia da Ovulação
            SimpleDateFormat sdf16 = new SimpleDateFormat("yyyy-MM-dd");
            Date date16 = sdf16.parse(result15);
            date16.setDate(date16.getDate() + i);
            SimpleDateFormat out16 = new SimpleDateFormat("yyyy-MM-dd");
            String result16 = out16.format(date16);

            String[] arr16 = {result16};
            for (int j = 0; j < 1; j++) {
                eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr16[j], eventCount, getEventDataListDiaOvulacao(eventCount));
            }

//17 Risco ALTO
            SimpleDateFormat sdf17 = new SimpleDateFormat("yyyy-MM-dd");
            Date date17 = sdf17.parse(result16);
            date17.setDate(date17.getDate() + i);
            SimpleDateFormat out17 = new SimpleDateFormat("yyyy-MM-dd");
            String result17 = out17.format(date17);

            String[] arr17 = {result17};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr17[j], eventCount, getEventDataList4(eventCount));
            }


//Risco MEDIO

            for (int f = 0; f < 4; f++) {
                SimpleDateFormat sdfMedio = new SimpleDateFormat("yyyy-MM-dd");
                Date dateMedio = sdfMedio.parse(result17);
                dateMedio.setDate(dateMedio.getDate() + i);
                SimpleDateFormat outMedio = new SimpleDateFormat("yyyy-MM-dd");
                String resultMedio = outMedio.format(dateMedio);

                String[] arr13 = {resultMedio};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                result17 = resultMedio;
            }

// Risco Baixo
            for (int j = 0; j < 5; j++) {
                SimpleDateFormat sdfBaixo = new SimpleDateFormat("yyyy-MM-dd");
                Date dateBaixo = sdfBaixo.parse(result17);
                dateBaixo.setDate(dateBaixo.getDate() + i);
                SimpleDateFormat outBaixo = new SimpleDateFormat("yyyy-MM-dd");
                String resultBaixo = outBaixo.format(dateBaixo);

                String[] arr22 = {resultBaixo};
                for (int k = 0; k < 1; k++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr22[k], eventCount, getEventDataList2(eventCount));
                }
                result17 = resultBaixo;
            }

// Risco Baixo
            SimpleDateFormat sdf_global = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global = sdf_global.parse(result17);
            date_global.setDate(date_global.getDate() + i);
            SimpleDateFormat out_global = new SimpleDateFormat("yyyy-MM-dd");
            String resultGlobal = out_global.format(date_global);

            String[] arr_global = {resultGlobal};
            CalendarioActivity.global = resultGlobal;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }

// Risco Baixo
            SimpleDateFormat sdf_global2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global2 = sdf_global2.parse(resultGlobal);
            date_global2.setDate(date_global2.getDate() + i);
            SimpleDateFormat out_global2 = new SimpleDateFormat("yyyy-MM-dd");
            String resultGlobal2 = out_global2.format(date_global2);

            String[] arr_global2 = {resultGlobal2};
            CalendarioActivity.global2 = resultGlobal2;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global2[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }

//29 Risco Baixo
            SimpleDateFormat sdf_global3 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global3 = sdf_global3.parse(resultGlobal2);
            date_global3.setDate(date_global3.getDate() + i);
            SimpleDateFormat out_global3 = new SimpleDateFormat("yyyy-MM-dd");
            String result_global3 = out_global3.format(date_global3);

            String[] arr_global3 = {result_global3};
            CalendarioActivity.global3 = result_global3;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global3[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //PREVISAO DE CICLO!!!!!!!!!!!!!!!!
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            sdf = new SimpleDateFormat("yyyy-MM-dd");

            Log.d("DATA RECEBIDA", String.valueOf(u.getData()));
            Log.d("NUMERO RECEBIDo", String.valueOf(u.getNumeroAreceber()));

            date = sdf.parse(result_global3);
            Log.d("DATA A COMEÇAR", String.valueOf(date));

            i = 1;
            //4 primeiros dias //Dia 1 da Menstruação
            date.setDate(date.getDate());
            //Toast.makeText(getBaseContext(), "DATA!" + date, Toast.LENGTH_LONG).show();
            out = new SimpleDateFormat("yyyy-MM-dd");
            result1 = out.format(date);

            eventCount = 2;
            sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            out2 = new SimpleDateFormat("yyyy-MM-dd");
            total_dias = Integer.parseInt(u.getNumeroAreceber()); //se for 4 dias
            //total_dias = total_dias - 1;

            //PRIMEIROS DIAS
            for (int k = 1; k <= total_dias; k++) {
                data = sdf2.parse(result1);
                data.setDate(data.getDate() + 1);

                String result2 = out2.format(data);

                String[] arr2 = {result2};
                result1 = result2;
                if (k == 1) {  //dia 1
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataList(eventCount));
                    CalendarioActivity.global4 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 2) { //dia 2
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                    CalendarioActivity.global10 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 3) {  //dia 3
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia3(eventCount));
                    CalendarioActivity.global11 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 4) {  //dia 4
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia4(eventCount));
                } else if (k == 5) {  //dia 5
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia5(eventCount));
                } else if (k == 6) {  //dia 6
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia6(eventCount));
                } else if (k == 7) {  //dia 7
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia7(eventCount));
                } else if (k == 8) {  //dia 8
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia8(eventCount));
                } else if (k == 9) {  //dia 9
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia9(eventCount));
                } else if (k == 10) {  //dia 10
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia10(eventCount));
                } else if (k == 11) {  //dia 11
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia11(eventCount));
                } else {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                }
            }
            resultado = "";
            Log.d("TOTAL DIAS", u.getNumeroAreceber());
            //total_dias = total_dias + 1; //porque esta a -1

            if (total_dias == 1) {

            } else if (total_dias == 2) {

            } else if (total_dias == 3) {

            } else if (total_dias == 4) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 8; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 5) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 7; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    //os eventos a seguir ao diferente já nao estao assinalados
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 6) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 6; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    //os eventos a seguir ao diferente já nao estao assinalados
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 7) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 5; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 8) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 4; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }


            } else if (total_dias == 9) {
//Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 3; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }


            } else if (total_dias == 10) {
                resultado = result1;
            } else if (total_dias == 11) {
                resultado = result1;
            } else if (total_dias == 12) {
                resultado = result1;
            }

//Risco MEDIO
            for (int f = 0; f < 3; f++) {
                SimpleDateFormat sdf13 = new SimpleDateFormat("yyyy-MM-dd");
                Date date13 = sdf13.parse(resultado);
                date13.setDate(date13.getDate() + i);
                SimpleDateFormat out13 = new SimpleDateFormat("yyyy-MM-dd");
                String result13 = out13.format(date13);

                String[] arr13 = {result13};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                resultado = result13;
            }

//15 Risco ALTO
            SimpleDateFormat sdf_novo_ciclo = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novo_ciclo = sdf_novo_ciclo.parse(resultado);
            date_novo_ciclo.setDate(date_novo_ciclo.getDate() + i);
            SimpleDateFormat out111 = new SimpleDateFormat("yyyy-MM-dd");
            String result111 = out111.format(date_novo_ciclo);

            String[] arr111 = {result111};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr111[j], eventCount, getEventDataList4(eventCount));
            }
//16 Risco ALTO   Dia da Ovulação
            SimpleDateFormat sdf_novoCiclo = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novoCiclo = sdf_novoCiclo.parse(result111);
            date_novoCiclo.setDate(date_novoCiclo.getDate() + i);
            SimpleDateFormat out_novoCiclo = new SimpleDateFormat("yyyy-MM-dd");
            String result_novoCiclo = out_novoCiclo.format(date_novoCiclo);

            String[] arr_novoCiclo = {result_novoCiclo};
            for (int j = 0; j < 1; j++) {
                eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr_novoCiclo[j], eventCount, getEventDataListDiaOvulacao(eventCount));
            }

//17 Risco ALTO
            SimpleDateFormat sdf_novoCiclo2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novoCiclo2 = sdf_novoCiclo2.parse(result_novoCiclo);
            date_novoCiclo2.setDate(date_novoCiclo2.getDate() + i);
            SimpleDateFormat out_novoCiclo2 = new SimpleDateFormat("yyyy-MM-dd");
            String result_novoCiclo2 = out_novoCiclo2.format(date_novoCiclo2);

            String[] arr_nocoCiclo2 = {result_novoCiclo2};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_nocoCiclo2[j], eventCount, getEventDataList4(eventCount));
            }
//Risco MEDIO

            for (int f = 0; f < 4; f++) {
                SimpleDateFormat sdfMedio = new SimpleDateFormat("yyyy-MM-dd");
                Date dateMedio = sdfMedio.parse(result_novoCiclo2);
                dateMedio.setDate(dateMedio.getDate() + i);
                SimpleDateFormat outMedio = new SimpleDateFormat("yyyy-MM-dd");
                String resultMedio = outMedio.format(dateMedio);

                String[] arr13 = {resultMedio};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                result_novoCiclo2 = resultMedio;
                resultado = result_novoCiclo2;
            }

// Risco Baixo
            for (int j = 0; j < 8; j++) {
                SimpleDateFormat sdfBaixo = new SimpleDateFormat("yyyy-MM-dd");
                Date dateBaixo = sdfBaixo.parse(resultado);
                dateBaixo.setDate(dateBaixo.getDate() + i);
                SimpleDateFormat outBaixo = new SimpleDateFormat("yyyy-MM-dd");
                String resultBaixo = outBaixo.format(dateBaixo);

                String[] arr22 = {resultBaixo};
                for (int k = 0; k < 1; k++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr22[k], eventCount, getEventDataList2(eventCount));
                }
                resultado = resultBaixo;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void ciclo32() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Utils u = Utils.getInstance();
            Log.d("DATA RECEBIDA", String.valueOf(u.getData()));
            Log.d("NUMERO RECEBIDo", String.valueOf(u.getNumeroAreceber()));

            Date date = sdf.parse(u.getData());
            Log.d("DATA RECEBIDA", String.valueOf(date));

            int i = 1;
            //4 primeiros dias //Dia 1 da Menstruação
            date.setDate(date.getDate());
            //Toast.makeText(getBaseContext(), "DATA!" + date, Toast.LENGTH_LONG).show();
            SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");
            String result1 = out.format(date);

            String[] arr1 = {result1};
            for (int j = 0; j < 1; j++) {
                int eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr1[j], eventCount, getEventDataList(eventCount));
            }

            int eventCount = 2;
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat out2 = new SimpleDateFormat("yyyy-MM-dd");
            Date data;
            int total_dias = Integer.parseInt(u.getNumeroAreceber()); //se for 4 dias
            total_dias = total_dias - 1;

            //PRIMEIROS DIAS
            for (int k = 1; k <= total_dias; k++) {
                data = sdf2.parse(result1);
                data.setDate(data.getDate() + 1);

                String result2 = out2.format(data);

                String[] arr2 = {result2};
                result1 = result2;
                if (k == 1) {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                } else if (k == 2) { //dia 3
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia3(eventCount));
                } else if (k == 3) {  //dia 4
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia4(eventCount));
                } else if (k == 4) {  //dia 5
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia5(eventCount));
                } else if (k == 5) {  //dia 6
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia6(eventCount));
                } else if (k == 6) {  //dia 7
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia7(eventCount));
                } else if (k == 7) {  //dia 8
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia8(eventCount));
                } else if (k == 8) {  //dia 9
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia9(eventCount));
                }/*else if (k == 9) {  //dia 10
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia10(eventCount));
                }else if (k == 10) {  //dia 11
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia11(eventCount));
                }else if (k == 11) {  //dia 12
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia12(eventCount));
                }*/ else {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                }
            }
            String resultado = "";
            Log.d("TOTAL DIAS", u.getNumeroAreceber());
            total_dias = total_dias + 1; //porque esta a -1
            if (total_dias == 1) {

            } else if (total_dias == 2) {

            } else if (total_dias == 3) {

            } else if (total_dias == 4) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 9; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 5) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 8; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 6) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 7; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 7) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 6; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 8) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 5; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }
            } else if (total_dias == 9) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 4; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }


            } else if (total_dias == 10) {
//Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 3; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 10) {
                resultado = result1;
            } else if (total_dias == 11) {
                resultado = result1;
            } else if (total_dias == 12) {
                resultado = result1;
            }

//Risco MEDIO
            for (int f = 0; f < 3; f++) {
                SimpleDateFormat sdf13 = new SimpleDateFormat("yyyy-MM-dd");
                Date date13 = sdf13.parse(resultado);
                date13.setDate(date13.getDate() + i);
                SimpleDateFormat out13 = new SimpleDateFormat("yyyy-MM-dd");
                String result13 = out13.format(date13);

                String[] arr13 = {result13};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                resultado = result13;
            }

//15 Risco ALTO
            SimpleDateFormat sdf15 = new SimpleDateFormat("yyyy-MM-dd");
            Date date15 = sdf15.parse(resultado);
            date15.setDate(date15.getDate() + i);
            SimpleDateFormat out15 = new SimpleDateFormat("yyyy-MM-dd");
            String result15 = out15.format(date15);

            String[] arr15 = {result15};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr15[j], eventCount, getEventDataList4(eventCount));
            }
//16 Risco ALTO   Dia da Ovulação
            SimpleDateFormat sdf16 = new SimpleDateFormat("yyyy-MM-dd");
            Date date16 = sdf16.parse(result15);
            date16.setDate(date16.getDate() + i);
            SimpleDateFormat out16 = new SimpleDateFormat("yyyy-MM-dd");
            String result16 = out16.format(date16);

            String[] arr16 = {result16};
            for (int j = 0; j < 1; j++) {
                eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr16[j], eventCount, getEventDataListDiaOvulacao(eventCount));
            }

//17 Risco ALTO
            SimpleDateFormat sdf17 = new SimpleDateFormat("yyyy-MM-dd");
            Date date17 = sdf17.parse(result16);
            date17.setDate(date17.getDate() + i);
            SimpleDateFormat out17 = new SimpleDateFormat("yyyy-MM-dd");
            String result17 = out17.format(date17);

            String[] arr17 = {result17};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr17[j], eventCount, getEventDataList4(eventCount));
            }


//Risco MEDIO

            for (int f = 0; f < 4; f++) {
                SimpleDateFormat sdfMedio = new SimpleDateFormat("yyyy-MM-dd");
                Date dateMedio = sdfMedio.parse(result17);
                dateMedio.setDate(dateMedio.getDate() + i);
                SimpleDateFormat outMedio = new SimpleDateFormat("yyyy-MM-dd");
                String resultMedio = outMedio.format(dateMedio);

                String[] arr13 = {resultMedio};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                result17 = resultMedio;
            }

// Risco Baixo
            for (int j = 0; j < 5; j++) {
                SimpleDateFormat sdfBaixo = new SimpleDateFormat("yyyy-MM-dd");
                Date dateBaixo = sdfBaixo.parse(result17);
                dateBaixo.setDate(dateBaixo.getDate() + i);
                SimpleDateFormat outBaixo = new SimpleDateFormat("yyyy-MM-dd");
                String resultBaixo = outBaixo.format(dateBaixo);

                String[] arr22 = {resultBaixo};
                for (int k = 0; k < 1; k++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr22[k], eventCount, getEventDataList2(eventCount));
                }
                result17 = resultBaixo;
            }

// Risco Baixo
            SimpleDateFormat sdf_global = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global = sdf_global.parse(result17);
            date_global.setDate(date_global.getDate() + i);
            SimpleDateFormat out_global = new SimpleDateFormat("yyyy-MM-dd");
            String resultGlobal = out_global.format(date_global);

            String[] arr_global = {resultGlobal};
            CalendarioActivity.global = resultGlobal;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }

// Risco Baixo
            SimpleDateFormat sdf_global2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global2 = sdf_global2.parse(resultGlobal);
            date_global2.setDate(date_global2.getDate() + i);
            SimpleDateFormat out_global2 = new SimpleDateFormat("yyyy-MM-dd");
            String resultGlobal2 = out_global2.format(date_global2);

            String[] arr_global2 = {resultGlobal2};
            CalendarioActivity.global2 = resultGlobal2;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global2[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }

//29 Risco Baixo
            SimpleDateFormat sdf_global3 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global3 = sdf_global3.parse(resultGlobal2);
            date_global3.setDate(date_global3.getDate() + i);
            SimpleDateFormat out_global3 = new SimpleDateFormat("yyyy-MM-dd");
            String result_global3 = out_global3.format(date_global3);

            String[] arr_global3 = {result_global3};
            CalendarioActivity.global3 = result_global3;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global3[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //PREVISAO DE CICLO!!!!!!!!!!!!!!!!
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            sdf = new SimpleDateFormat("yyyy-MM-dd");

            Log.d("DATA RECEBIDA", String.valueOf(u.getData()));
            Log.d("NUMERO RECEBIDo", String.valueOf(u.getNumeroAreceber()));

            date = sdf.parse(result_global3);
            Log.d("DATA A COMEÇAR", String.valueOf(date));

            i = 1;
            //4 primeiros dias //Dia 1 da Menstruação
            date.setDate(date.getDate());
            //Toast.makeText(getBaseContext(), "DATA!" + date, Toast.LENGTH_LONG).show();
            out = new SimpleDateFormat("yyyy-MM-dd");
            result1 = out.format(date);

            eventCount = 2;
            sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            out2 = new SimpleDateFormat("yyyy-MM-dd");
            total_dias = Integer.parseInt(u.getNumeroAreceber()); //se for 4 dias
            //total_dias = total_dias - 1;

            //PRIMEIROS DIAS
            for (int k = 1; k <= total_dias; k++) {
                data = sdf2.parse(result1);
                data.setDate(data.getDate() + 1);

                String result2 = out2.format(data);

                String[] arr2 = {result2};
                result1 = result2;
                if (k == 1) {  //dia 1
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataList(eventCount));
                    CalendarioActivity.global4 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 2) { //dia 2
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                    CalendarioActivity.global10 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 3) {  //dia 3
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia3(eventCount));
                    CalendarioActivity.global11 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 4) {  //dia 4
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia4(eventCount));
                } else if (k == 5) {  //dia 5
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia5(eventCount));
                } else if (k == 6) {  //dia 6
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia6(eventCount));
                } else if (k == 7) {  //dia 7
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia7(eventCount));
                } else if (k == 8) {  //dia 8
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia8(eventCount));
                } else if (k == 9) {  //dia 9
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia9(eventCount));
                } else if (k == 10) {  //dia 10
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia10(eventCount));
                } else if (k == 11) {  //dia 11
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia11(eventCount));
                } else {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                }
            }
            resultado = "";
            Log.d("TOTAL DIAS", u.getNumeroAreceber());
            //total_dias = total_dias + 1; //porque esta a -1

            if (total_dias == 1) {

            } else if (total_dias == 2) {

            } else if (total_dias == 3) {

            } else if (total_dias == 4) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 9; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 5) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                //os eventos a seguir ao diferente já nao estao assinalados
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 8; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    //os eventos a seguir ao diferente já nao estao assinalados
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 6) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 7; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    //os eventos a seguir ao diferente já nao estao assinalados
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 7) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 6; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 8) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 5; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }


            } else if (total_dias == 9) {
//Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 4; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }


            } else if (total_dias == 10) {
                resultado = result1;
            } else if (total_dias == 11) {
                resultado = result1;
            } else if (total_dias == 12) {
                resultado = result1;
            }

//Risco MEDIO
            for (int f = 0; f < 3; f++) {
                SimpleDateFormat sdf13 = new SimpleDateFormat("yyyy-MM-dd");
                Date date13 = sdf13.parse(resultado);
                date13.setDate(date13.getDate() + i);
                SimpleDateFormat out13 = new SimpleDateFormat("yyyy-MM-dd");
                String result13 = out13.format(date13);

                String[] arr13 = {result13};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                resultado = result13;
            }

//15 Risco ALTO
            SimpleDateFormat sdf_novo_ciclo = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novo_ciclo = sdf_novo_ciclo.parse(resultado);
            date_novo_ciclo.setDate(date_novo_ciclo.getDate() + i);
            SimpleDateFormat out111 = new SimpleDateFormat("yyyy-MM-dd");
            String result111 = out111.format(date_novo_ciclo);

            String[] arr111 = {result111};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr111[j], eventCount, getEventDataList4(eventCount));
            }
//16 Risco ALTO   Dia da Ovulação
            SimpleDateFormat sdf_novoCiclo = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novoCiclo = sdf_novoCiclo.parse(result111);
            date_novoCiclo.setDate(date_novoCiclo.getDate() + i);
            SimpleDateFormat out_novoCiclo = new SimpleDateFormat("yyyy-MM-dd");
            String result_novoCiclo = out_novoCiclo.format(date_novoCiclo);

            String[] arr_novoCiclo = {result_novoCiclo};
            for (int j = 0; j < 1; j++) {
                eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr_novoCiclo[j], eventCount, getEventDataListDiaOvulacao(eventCount));
            }

//17 Risco ALTO
            SimpleDateFormat sdf_novoCiclo2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novoCiclo2 = sdf_novoCiclo2.parse(result_novoCiclo);
            date_novoCiclo2.setDate(date_novoCiclo2.getDate() + i);
            SimpleDateFormat out_novoCiclo2 = new SimpleDateFormat("yyyy-MM-dd");
            String result_novoCiclo2 = out_novoCiclo2.format(date_novoCiclo2);

            String[] arr_nocoCiclo2 = {result_novoCiclo2};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_nocoCiclo2[j], eventCount, getEventDataList4(eventCount));
            }


//Risco MEDIO

            for (int f = 0; f < 4; f++) {
                SimpleDateFormat sdfMedio = new SimpleDateFormat("yyyy-MM-dd");
                Date dateMedio = sdfMedio.parse(result_novoCiclo2);
                dateMedio.setDate(dateMedio.getDate() + i);
                SimpleDateFormat outMedio = new SimpleDateFormat("yyyy-MM-dd");
                String resultMedio = outMedio.format(dateMedio);

                String[] arr13 = {resultMedio};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                result_novoCiclo2 = resultMedio;
                resultado = result_novoCiclo2;
            }

// Risco Baixo
            for (int j = 0; j < 8; j++) {
                SimpleDateFormat sdfBaixo = new SimpleDateFormat("yyyy-MM-dd");
                Date dateBaixo = sdfBaixo.parse(resultado);
                dateBaixo.setDate(dateBaixo.getDate() + i);
                SimpleDateFormat outBaixo = new SimpleDateFormat("yyyy-MM-dd");
                String resultBaixo = outBaixo.format(dateBaixo);

                String[] arr22 = {resultBaixo};
                for (int k = 0; k < 1; k++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr22[k], eventCount, getEventDataList2(eventCount));
                }
                resultado = resultBaixo;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void ciclo33() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Utils u = Utils.getInstance();
            Log.d("DATA RECEBIDA", String.valueOf(u.getData()));
            Log.d("NUMERO RECEBIDo", String.valueOf(u.getNumeroAreceber()));

            Date date = sdf.parse(u.getData());
            Log.d("DATA RECEBIDA", String.valueOf(date));

            int i = 1;
            //4 primeiros dias //Dia 1 da Menstruação
            date.setDate(date.getDate());
            //Toast.makeText(getBaseContext(), "DATA!" + date, Toast.LENGTH_LONG).show();
            SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");
            String result1 = out.format(date);

            String[] arr1 = {result1};
            for (int j = 0; j < 1; j++) {
                int eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr1[j], eventCount, getEventDataList(eventCount));
            }

            int eventCount = 2;
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat out2 = new SimpleDateFormat("yyyy-MM-dd");
            Date data;
            int total_dias = Integer.parseInt(u.getNumeroAreceber()); //se for 4 dias
            total_dias = total_dias - 1;

            //PRIMEIROS DIAS
            for (int k = 1; k <= total_dias; k++) {
                data = sdf2.parse(result1);
                data.setDate(data.getDate() + 1);

                String result2 = out2.format(data);

                String[] arr2 = {result2};
                result1 = result2;
                if (k == 1) {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                } else if (k == 2) { //dia 3
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia3(eventCount));
                } else if (k == 3) {  //dia 4
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia4(eventCount));
                } else if (k == 4) {  //dia 5
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia5(eventCount));
                } else if (k == 5) {  //dia 6
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia6(eventCount));
                } else if (k == 6) {  //dia 7
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia7(eventCount));
                } else if (k == 7) {  //dia 8
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia8(eventCount));
                } else if (k == 8) {  //dia 9
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia9(eventCount));
                }/*else if (k == 9) {  //dia 10
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia10(eventCount));
                }else if (k == 10) {  //dia 11
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia11(eventCount));
                }else if (k == 11) {  //dia 12
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia12(eventCount));
                }*/ else {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                }
            }
            String resultado = "";
            Log.d("TOTAL DIAS", u.getNumeroAreceber());
            total_dias = total_dias + 1; //porque esta a -1
            if (total_dias == 1) {

            } else if (total_dias == 2) {

            } else if (total_dias == 3) {

            } else if (total_dias == 4) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 10; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 5) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 9; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 6) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 8; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 7) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 7; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 8) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 6; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }
            } else if (total_dias == 9) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 5; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }


            } else if (total_dias == 10) {
//Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 4; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 10) {
                resultado = result1;
            } else if (total_dias == 11) {
                resultado = result1;
            } else if (total_dias == 12) {
                resultado = result1;
            }

//Risco MEDIO
            for (int f = 0; f < 3; f++) {
                SimpleDateFormat sdf13 = new SimpleDateFormat("yyyy-MM-dd");
                Date date13 = sdf13.parse(resultado);
                date13.setDate(date13.getDate() + i);
                SimpleDateFormat out13 = new SimpleDateFormat("yyyy-MM-dd");
                String result13 = out13.format(date13);

                String[] arr13 = {result13};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                resultado = result13;
            }

//15 Risco ALTO
            SimpleDateFormat sdf15 = new SimpleDateFormat("yyyy-MM-dd");
            Date date15 = sdf15.parse(resultado);
            date15.setDate(date15.getDate() + i);
            SimpleDateFormat out15 = new SimpleDateFormat("yyyy-MM-dd");
            String result15 = out15.format(date15);

            String[] arr15 = {result15};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr15[j], eventCount, getEventDataList4(eventCount));
            }
//16 Risco ALTO   Dia da Ovulação
            SimpleDateFormat sdf16 = new SimpleDateFormat("yyyy-MM-dd");
            Date date16 = sdf16.parse(result15);
            date16.setDate(date16.getDate() + i);
            SimpleDateFormat out16 = new SimpleDateFormat("yyyy-MM-dd");
            String result16 = out16.format(date16);

            String[] arr16 = {result16};
            for (int j = 0; j < 1; j++) {
                eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr16[j], eventCount, getEventDataListDiaOvulacao(eventCount));
            }

//17 Risco ALTO
            SimpleDateFormat sdf17 = new SimpleDateFormat("yyyy-MM-dd");
            Date date17 = sdf17.parse(result16);
            date17.setDate(date17.getDate() + i);
            SimpleDateFormat out17 = new SimpleDateFormat("yyyy-MM-dd");
            String result17 = out17.format(date17);

            String[] arr17 = {result17};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr17[j], eventCount, getEventDataList4(eventCount));
            }


//Risco MEDIO

            for (int f = 0; f < 4; f++) {
                SimpleDateFormat sdfMedio = new SimpleDateFormat("yyyy-MM-dd");
                Date dateMedio = sdfMedio.parse(result17);
                dateMedio.setDate(dateMedio.getDate() + i);
                SimpleDateFormat outMedio = new SimpleDateFormat("yyyy-MM-dd");
                String resultMedio = outMedio.format(dateMedio);

                String[] arr13 = {resultMedio};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                result17 = resultMedio;
            }

// Risco Baixo
            for (int j = 0; j < 5; j++) {
                SimpleDateFormat sdfBaixo = new SimpleDateFormat("yyyy-MM-dd");
                Date dateBaixo = sdfBaixo.parse(result17);
                dateBaixo.setDate(dateBaixo.getDate() + i);
                SimpleDateFormat outBaixo = new SimpleDateFormat("yyyy-MM-dd");
                String resultBaixo = outBaixo.format(dateBaixo);

                String[] arr22 = {resultBaixo};
                for (int k = 0; k < 1; k++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr22[k], eventCount, getEventDataList2(eventCount));
                }
                result17 = resultBaixo;
            }

// Risco Baixo
            SimpleDateFormat sdf_global = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global = sdf_global.parse(result17);
            date_global.setDate(date_global.getDate() + i);
            SimpleDateFormat out_global = new SimpleDateFormat("yyyy-MM-dd");
            String resultGlobal = out_global.format(date_global);

            String[] arr_global = {resultGlobal};
            CalendarioActivity.global = resultGlobal;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }

// Risco Baixo
            SimpleDateFormat sdf_global2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global2 = sdf_global2.parse(resultGlobal);
            date_global2.setDate(date_global2.getDate() + i);
            SimpleDateFormat out_global2 = new SimpleDateFormat("yyyy-MM-dd");
            String resultGlobal2 = out_global2.format(date_global2);

            String[] arr_global2 = {resultGlobal2};
            CalendarioActivity.global2 = resultGlobal2;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global2[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }

//29 Risco Baixo
            SimpleDateFormat sdf_global3 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_global3 = sdf_global3.parse(resultGlobal2);
            date_global3.setDate(date_global3.getDate() + i);
            SimpleDateFormat out_global3 = new SimpleDateFormat("yyyy-MM-dd");
            String result_global3 = out_global3.format(date_global3);

            String[] arr_global3 = {result_global3};
            CalendarioActivity.global3 = result_global3;

            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_global3[j], eventCount, getEventDataList2(eventCount));
                CalendarioActivity.enviar = 1;
            }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //PREVISAO DE CICLO!!!!!!!!!!!!!!!!
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            sdf = new SimpleDateFormat("yyyy-MM-dd");

            Log.d("DATA RECEBIDA", String.valueOf(u.getData()));
            Log.d("NUMERO RECEBIDo", String.valueOf(u.getNumeroAreceber()));

            date = sdf.parse(result_global3);
            Log.d("DATA A COMEÇAR", String.valueOf(date));

            i = 1;
            //4 primeiros dias //Dia 1 da Menstruação
            date.setDate(date.getDate());
            //Toast.makeText(getBaseContext(), "DATA!" + date, Toast.LENGTH_LONG).show();
            out = new SimpleDateFormat("yyyy-MM-dd");
            result1 = out.format(date);


            eventCount = 2;
            sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            out2 = new SimpleDateFormat("yyyy-MM-dd");
            total_dias = Integer.parseInt(u.getNumeroAreceber()); //se for 4 dias
            //total_dias = total_dias - 1;

            //PRIMEIROS DIAS
            for (int k = 1; k <= total_dias; k++) {
                data = sdf2.parse(result1);
                data.setDate(data.getDate() + 1);

                String result2 = out2.format(data);

                String[] arr2 = {result2};
                result1 = result2;
                if (k == 1) {  //dia 1
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataList(eventCount));
                    CalendarioActivity.global4 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 2) { //dia 2
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                    CalendarioActivity.global10 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 3) {  //dia 3
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia3(eventCount));
                    CalendarioActivity.global11 = result2;
                    CalendarioActivity.enviar = 1;
                } else if (k == 4) {  //dia 4
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia4(eventCount));
                } else if (k == 5) {  //dia 5
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia5(eventCount));
                } else if (k == 6) {  //dia 6
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia6(eventCount));
                } else if (k == 7) {  //dia 7
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia7(eventCount));
                } else if (k == 8) {  //dia 8
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia8(eventCount));
                } else if (k == 9) {  //dia 9
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia9(eventCount));
                } else if (k == 10) {  //dia 10
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia10(eventCount));
                } else if (k == 11) {  //dia 11
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia11(eventCount));
                } else {
                    CalendarioActivity.customCalendar.addAnEvent(arr2[0], eventCount, getEventDataListDia2(eventCount));
                }
            }
            resultado = "";
            Log.d("TOTAL DIAS", u.getNumeroAreceber());
            //total_dias = total_dias + 1; //porque esta a -1

            if (total_dias == 1) {

            } else if (total_dias == 2) {

            } else if (total_dias == 3) {

            } else if (total_dias == 4) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 10; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 5) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 9; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 6) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 8; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 7) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 7; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }

            } else if (total_dias == 8) {
                //Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 6; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }


            } else if (total_dias == 9) {
//Dia 5 - RISCO BAIXO
                SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                Date date5 = sdf5.parse(result1);
                date5.setDate(date5.getDate() + i);
                SimpleDateFormat out5 = new SimpleDateFormat("yyyy-MM-dd");
                String result5 = out5.format(date5);

                String[] arr5 = {result5};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr5[j], eventCount, getEventDataList2(eventCount));
                }


                for (int k = 0; k < 5; k++) {

                    SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd");
                    Date date_ = sdf_.parse(result5);
                    date_.setDate(date_.getDate() + i);
                    SimpleDateFormat out_ = new SimpleDateFormat("yyyy-MM-dd");
                    String result = out_.format(date_);


                    String[] arr = {result};
                    for (int j = 0; j < 1; j++) {
                        eventCount = 1;
                        CalendarioActivity.customCalendar.addAnEvent(arr[j], eventCount, getEventDataList2(eventCount));
                    }
                    result5 = result;
                    resultado = result5;
                }


            } else if (total_dias == 10) {
                resultado = result1;
            } else if (total_dias == 11) {
                resultado = result1;
            } else if (total_dias == 12) {
                resultado = result1;
            }

//Risco MEDIO
            for (int f = 0; f < 3; f++) {
                SimpleDateFormat sdf13 = new SimpleDateFormat("yyyy-MM-dd");
                Date date13 = sdf13.parse(resultado);
                date13.setDate(date13.getDate() + i);
                SimpleDateFormat out13 = new SimpleDateFormat("yyyy-MM-dd");
                String result13 = out13.format(date13);

                String[] arr13 = {result13};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                resultado = result13;
            }

//15 Risco ALTO
            SimpleDateFormat sdf_novo_ciclo = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novo_ciclo = sdf_novo_ciclo.parse(resultado);
            date_novo_ciclo.setDate(date_novo_ciclo.getDate() + i);
            SimpleDateFormat out111 = new SimpleDateFormat("yyyy-MM-dd");
            String result111 = out111.format(date_novo_ciclo);

            String[] arr111 = {result111};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr111[j], eventCount, getEventDataList4(eventCount));
            }
//16 Risco ALTO   Dia da Ovulação
            SimpleDateFormat sdf_novoCiclo = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novoCiclo = sdf_novoCiclo.parse(result111);
            date_novoCiclo.setDate(date_novoCiclo.getDate() + i);
            SimpleDateFormat out_novoCiclo = new SimpleDateFormat("yyyy-MM-dd");
            String result_novoCiclo = out_novoCiclo.format(date_novoCiclo);

            String[] arr_novoCiclo = {result_novoCiclo};
            for (int j = 0; j < 1; j++) {
                eventCount = 2;
                CalendarioActivity.customCalendar.addAnEvent(arr_novoCiclo[j], eventCount, getEventDataListDiaOvulacao(eventCount));
            }

//17 Risco ALTO
            SimpleDateFormat sdf_novoCiclo2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date_novoCiclo2 = sdf_novoCiclo2.parse(result_novoCiclo);
            date_novoCiclo2.setDate(date_novoCiclo2.getDate() + i);
            SimpleDateFormat out_novoCiclo2 = new SimpleDateFormat("yyyy-MM-dd");
            String result_novoCiclo2 = out_novoCiclo2.format(date_novoCiclo2);

            String[] arr_nocoCiclo2 = {result_novoCiclo2};
            for (int j = 0; j < 1; j++) {
                eventCount = 1;
                CalendarioActivity.customCalendar.addAnEvent(arr_nocoCiclo2[j], eventCount, getEventDataList4(eventCount));
            }


//Risco MEDIO

            for (int f = 0; f < 4; f++) {
                SimpleDateFormat sdfMedio = new SimpleDateFormat("yyyy-MM-dd");
                Date dateMedio = sdfMedio.parse(result_novoCiclo2);
                dateMedio.setDate(dateMedio.getDate() + i);
                SimpleDateFormat outMedio = new SimpleDateFormat("yyyy-MM-dd");
                String resultMedio = outMedio.format(dateMedio);

                String[] arr13 = {resultMedio};
                for (int j = 0; j < 1; j++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr13[j], eventCount, getEventDataList3(eventCount));
                }
                result_novoCiclo2 = resultMedio;
                resultado = result_novoCiclo2;
            }

// Risco Baixo
            for (int j = 0; j < 8; j++) {
                SimpleDateFormat sdfBaixo = new SimpleDateFormat("yyyy-MM-dd");
                Date dateBaixo = sdfBaixo.parse(resultado);
                dateBaixo.setDate(dateBaixo.getDate() + i);
                SimpleDateFormat outBaixo = new SimpleDateFormat("yyyy-MM-dd");
                String resultBaixo = outBaixo.format(dateBaixo);

                String[] arr22 = {resultBaixo};
                for (int k = 0; k < 1; k++) {
                    eventCount = 1;
                    CalendarioActivity.customCalendar.addAnEvent(arr22[k], eventCount, getEventDataList2(eventCount));
                }
                resultado = resultBaixo;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //DIA 1
    public static ArrayList<EventData> getEventDataList(int count) {
        ArrayList<EventData> eventDataList = new ArrayList();

        for (int i = 0; i < count; i++) {
            EventData dateData = new EventData();
            ArrayList<dataAboutDate> dataAboutDates = new ArrayList();

            //dateData.setSection(CalendarUtils.getNAMES()[new Random().nextInt(CalendarUtils.getNAMES().length)]);
            dateData.setSection(CalendarUtils.getNAMES()[i]);
            dataAboutDate dataAboutDate = new dataAboutDate();

            //int index = new Random().nextInt(CalendarUtils.getEVENTS().length);

            dataAboutDate.setTitle(CalendarUtils.getEVENTS2()[i]);
            dataAboutDate.setSubject(CalendarUtils.getEventsDescription1()[i]);
            dataAboutDates.add(dataAboutDate);

            dateData.setData(dataAboutDates);
            eventDataList.add(dateData);
        }
        return eventDataList;
    }

    //DIA 2
    public static ArrayList<EventData> getEventDataListDia2(int count) {
        ArrayList<EventData> eventDataList = new ArrayList();

        for (int i = 0; i < count; i++) {
            EventData dateData = new EventData();
            ArrayList<dataAboutDate> dataAboutDates = new ArrayList();

            //dateData.setSection(CalendarUtils.getNAMES()[new Random().nextInt(CalendarUtils.getNAMES().length)]);
            dateData.setSection(CalendarUtils.getNAMES()[i]);
            dataAboutDate dataAboutDate = new dataAboutDate();

            //int index = new Random().nextInt(CalendarUtils.getEVENTS().length);

            dataAboutDate.setTitle(CalendarUtils.getEVENTS2()[i]);
            dataAboutDate.setSubject(CalendarUtils.getEventsDescription2()[i]);
            dataAboutDates.add(dataAboutDate);

            dateData.setData(dataAboutDates);
            eventDataList.add(dateData);
        }

        return eventDataList;
    }

    //DIA 3
    public static ArrayList<EventData> getEventDataListDia3(int count) {
        ArrayList<EventData> eventDataList = new ArrayList();

        for (int i = 0; i < count; i++) {
            EventData dateData = new EventData();
            ArrayList<dataAboutDate> dataAboutDates = new ArrayList();

            //dateData.setSection(CalendarUtils.getNAMES()[new Random().nextInt(CalendarUtils.getNAMES().length)]);
            dateData.setSection(CalendarUtils.getNAMES()[i]);
            dataAboutDate dataAboutDate = new dataAboutDate();

            //int index = new Random().nextInt(CalendarUtils.getEVENTS().length);

            dataAboutDate.setTitle(CalendarUtils.getEVENTS2()[i]);
            dataAboutDate.setSubject(CalendarUtils.getEventsDescription3()[i]);
            dataAboutDates.add(dataAboutDate);

            dateData.setData(dataAboutDates);
            eventDataList.add(dateData);
        }

        return eventDataList;
    }

    //DIA 4
    public static ArrayList<EventData> getEventDataListDia4(int count) {
        ArrayList<EventData> eventDataList = new ArrayList();

        for (int i = 0; i < count; i++) {
            EventData dateData = new EventData();
            ArrayList<dataAboutDate> dataAboutDates = new ArrayList();

            //dateData.setSection(CalendarUtils.getNAMES()[new Random().nextInt(CalendarUtils.getNAMES().length)]);
            dateData.setSection(CalendarUtils.getNAMES()[i]);
            dataAboutDate dataAboutDate = new dataAboutDate();

            //int index = new Random().nextInt(CalendarUtils.getEVENTS().length);

            dataAboutDate.setTitle(CalendarUtils.getEVENTS2()[i]);
            dataAboutDate.setSubject(CalendarUtils.getEventsDescription4()[i]);
            dataAboutDates.add(dataAboutDate);

            dateData.setData(dataAboutDates);
            eventDataList.add(dateData);
        }

        return eventDataList;
    }

    //DIA 5 MENSTRUAÇAO
    public static ArrayList<EventData> getEventDataListDia5(int count) {
        ArrayList<EventData> eventDataList = new ArrayList();

        for (int i = 0; i < count; i++) {
            EventData dateData = new EventData();
            ArrayList<dataAboutDate> dataAboutDates = new ArrayList();

            //dateData.setSection(CalendarUtils.getNAMES()[new Random().nextInt(CalendarUtils.getNAMES().length)]);
            dateData.setSection(CalendarUtils.getNAMES()[i]);
            dataAboutDate dataAboutDate = new dataAboutDate();

            //int index = new Random().nextInt(CalendarUtils.getEVENTS().length);

            dataAboutDate.setTitle(CalendarUtils.getEVENTS2()[i]);
            dataAboutDate.setSubject(CalendarUtils.getEventsDescription8()[i]);
            dataAboutDates.add(dataAboutDate);

            dateData.setData(dataAboutDates);
            eventDataList.add(dateData);
        }

        return eventDataList;
    }

    //DIA 6 MENSTRUAÇAO
    public static ArrayList<EventData> getEventDataListDia6(int count) {
        ArrayList<EventData> eventDataList = new ArrayList();

        for (int i = 0; i < count; i++) {
            EventData dateData = new EventData();
            ArrayList<dataAboutDate> dataAboutDates = new ArrayList();

            //dateData.setSection(CalendarUtils.getNAMES()[new Random().nextInt(CalendarUtils.getNAMES().length)]);
            dateData.setSection(CalendarUtils.getNAMES()[i]);
            dataAboutDate dataAboutDate = new dataAboutDate();

            //int index = new Random().nextInt(CalendarUtils.getEVENTS().length);

            dataAboutDate.setTitle(CalendarUtils.getEVENTS2()[i]);
            dataAboutDate.setSubject(CalendarUtils.getEventsDescription9()[i]);
            dataAboutDates.add(dataAboutDate);

            dateData.setData(dataAboutDates);
            eventDataList.add(dateData);
        }

        return eventDataList;
    }

    //DIA 7 MENSTRUAÇAO
    public static ArrayList<EventData> getEventDataListDia7(int count) {
        ArrayList<EventData> eventDataList = new ArrayList();

        for (int i = 0; i < count; i++) {
            EventData dateData = new EventData();
            ArrayList<dataAboutDate> dataAboutDates = new ArrayList();

            //dateData.setSection(CalendarUtils.getNAMES()[new Random().nextInt(CalendarUtils.getNAMES().length)]);
            dateData.setSection(CalendarUtils.getNAMES()[i]);
            dataAboutDate dataAboutDate = new dataAboutDate();

            //int index = new Random().nextInt(CalendarUtils.getEVENTS().length);

            dataAboutDate.setTitle(CalendarUtils.getEVENTS2()[i]);
            dataAboutDate.setSubject(CalendarUtils.getEventsDescription10()[i]);
            dataAboutDates.add(dataAboutDate);

            dateData.setData(dataAboutDates);
            eventDataList.add(dateData);
        }

        return eventDataList;
    }

    //DIA 8 MENSTRUAÇAO
    public static ArrayList<EventData> getEventDataListDia8(int count) {
        ArrayList<EventData> eventDataList = new ArrayList();

        for (int i = 0; i < count; i++) {
            EventData dateData = new EventData();
            ArrayList<dataAboutDate> dataAboutDates = new ArrayList();

            //dateData.setSection(CalendarUtils.getNAMES()[new Random().nextInt(CalendarUtils.getNAMES().length)]);
            dateData.setSection(CalendarUtils.getNAMES()[i]);
            dataAboutDate dataAboutDate = new dataAboutDate();

            //int index = new Random().nextInt(CalendarUtils.getEVENTS().length);

            dataAboutDate.setTitle(CalendarUtils.getEVENTS2()[i]);
            dataAboutDate.setSubject(CalendarUtils.getEventsDescription11()[i]);
            dataAboutDates.add(dataAboutDate);

            dateData.setData(dataAboutDates);
            eventDataList.add(dateData);
        }

        return eventDataList;
    }

    //DIA 9 MENSTRUAÇAO
    public static ArrayList<EventData> getEventDataListDia9(int count) {
        ArrayList<EventData> eventDataList = new ArrayList();

        for (int i = 0; i < count; i++) {
            EventData dateData = new EventData();
            ArrayList<dataAboutDate> dataAboutDates = new ArrayList();

            //dateData.setSection(CalendarUtils.getNAMES()[new Random().nextInt(CalendarUtils.getNAMES().length)]);
            dateData.setSection(CalendarUtils.getNAMES()[i]);
            dataAboutDate dataAboutDate = new dataAboutDate();

            //int index = new Random().nextInt(CalendarUtils.getEVENTS().length);

            dataAboutDate.setTitle(CalendarUtils.getEVENTS2()[i]);
            dataAboutDate.setSubject(CalendarUtils.getEventsDescription12()[i]);
            dataAboutDates.add(dataAboutDate);

            dateData.setData(dataAboutDates);
            eventDataList.add(dateData);
        }

        return eventDataList;
    }

    //DIA 10 MENSTRUAÇAO
    public static ArrayList<EventData> getEventDataListDia10(int count) {
        ArrayList<EventData> eventDataList = new ArrayList();

        for (int i = 0; i < count; i++) {
            EventData dateData = new EventData();
            ArrayList<dataAboutDate> dataAboutDates = new ArrayList();

            //dateData.setSection(CalendarUtils.getNAMES()[new Random().nextInt(CalendarUtils.getNAMES().length)]);
            dateData.setSection(CalendarUtils.getNAMES()[i]);
            dataAboutDate dataAboutDate = new dataAboutDate();

            //int index = new Random().nextInt(CalendarUtils.getEVENTS().length);

            dataAboutDate.setTitle(CalendarUtils.getEVENTS2()[i]);
            dataAboutDate.setSubject(CalendarUtils.getEventsDescription13()[i]);
            dataAboutDates.add(dataAboutDate);

            dateData.setData(dataAboutDates);
            eventDataList.add(dateData);
        }

        return eventDataList;
    }

    //DIA 11 MENSTRUAÇAO
    public static ArrayList<EventData> getEventDataListDia11(int count) {
        ArrayList<EventData> eventDataList = new ArrayList();

        for (int i = 0; i < count; i++) {
            EventData dateData = new EventData();
            ArrayList<dataAboutDate> dataAboutDates = new ArrayList();

            //dateData.setSection(CalendarUtils.getNAMES()[new Random().nextInt(CalendarUtils.getNAMES().length)]);
            dateData.setSection(CalendarUtils.getNAMES()[i]);
            dataAboutDate dataAboutDate = new dataAboutDate();

            //int index = new Random().nextInt(CalendarUtils.getEVENTS().length);

            dataAboutDate.setTitle(CalendarUtils.getEVENTS2()[i]);
            dataAboutDate.setSubject(CalendarUtils.getEventsDescription14()[i]);
            dataAboutDates.add(dataAboutDate);

            dateData.setData(dataAboutDates);
            eventDataList.add(dateData);
        }

        return eventDataList;
    }

    //DIA 12 MENSTRUAÇAO
    public static ArrayList<EventData> getEventDataListDia12(int count) {
        ArrayList<EventData> eventDataList = new ArrayList();

        for (int i = 0; i < count; i++) {
            EventData dateData = new EventData();
            ArrayList<dataAboutDate> dataAboutDates = new ArrayList();

            //dateData.setSection(CalendarUtils.getNAMES()[new Random().nextInt(CalendarUtils.getNAMES().length)]);
            dateData.setSection(CalendarUtils.getNAMES()[i]);
            dataAboutDate dataAboutDate = new dataAboutDate();

            //int index = new Random().nextInt(CalendarUtils.getEVENTS().length);

            dataAboutDate.setTitle(CalendarUtils.getEVENTS2()[i]);
            dataAboutDate.setSubject(CalendarUtils.getEventsDescription15()[i]);
            dataAboutDates.add(dataAboutDate);

            dateData.setData(dataAboutDates);
            eventDataList.add(dateData);
        }

        return eventDataList;
    }


    //O RISCO É BAIXO
    public static ArrayList<EventData> getEventDataList2(int count) {
        ArrayList<EventData> eventDataList = new ArrayList();

        for (int i = 0; i < count; i++) {
            EventData dateData = new EventData();
            ArrayList<dataAboutDate> dataAboutDates = new ArrayList();
            dateData.setSection(CalendarUtils.getNAMES1()[new Random().nextInt(CalendarUtils.getNAMES1().length)]);
            dataAboutDate dataAboutDate = new dataAboutDate();
            dataAboutDate.setTitle(CalendarUtils.getEVENTS0()[i]);
            dataAboutDate.setSubject(CalendarUtils.getEventsDescription7()[i]);
            dataAboutDates.add(dataAboutDate);
            dateData.setData(dataAboutDates);
            eventDataList.add(dateData);
        }
        return eventDataList;
    }

    //O RISCO É MEDIO
    public static ArrayList<EventData> getEventDataList3(int count) {
        ArrayList<EventData> eventDataList = new ArrayList();

        for (int i = 0; i < count; i++) {
            EventData dateData = new EventData();
            ArrayList<dataAboutDate> dataAboutDates = new ArrayList();

            dateData.setSection(CalendarUtils.getNAMES1()[new Random().nextInt(CalendarUtils.getNAMES1().length)]);
            dataAboutDate dataAboutDate = new dataAboutDate();

            //int index = new Random().nextInt(CalendarUtils.getEVENTS2().length);

            dataAboutDate.setTitle(CalendarUtils.getEVENTS01()[i]);
            dataAboutDate.setSubject(CalendarUtils.getEventsDescription5()[i]);
            dataAboutDates.add(dataAboutDate);

            dateData.setData(dataAboutDates);
            eventDataList.add(dateData);
        }

        return eventDataList;
    }
//O RISCO É ALTO

    public static ArrayList<EventData> getEventDataList4(int count) {
        ArrayList<EventData> eventDataList = new ArrayList();

        for (int i = 0; i < count; i++) {
            EventData dateData = new EventData();
            ArrayList<dataAboutDate> dataAboutDates = new ArrayList();

            dateData.setSection(CalendarUtils.getNAMES1()[new Random().nextInt(CalendarUtils.getNAMES1().length)]);
            dataAboutDate dataAboutDate = new dataAboutDate();

            //int index = new Random().nextInt(CalendarUtils.getEVENTS2().length);

            dataAboutDate.setTitle(CalendarUtils.getEVENTS02()[i]);
            dataAboutDate.setSubject(CalendarUtils.getEventsDescription6()[i]);
            dataAboutDates.add(dataAboutDate);

            dateData.setData(dataAboutDates);
            eventDataList.add(dateData);
        }

        return eventDataList;
    }

    //DIA DA OVULAÇÃO
    public static ArrayList<EventData> getEventDataListDiaOvulacao(int count) {
        ArrayList<EventData> eventDataList = new ArrayList();

        for (int i = 0; i < count; i++) {
            EventData dateData = new EventData();
            ArrayList<dataAboutDate> dataAboutDates = new ArrayList();

            //dateData.setSection(CalendarUtils.getNAMES()[new Random().nextInt(CalendarUtils.getNAMES().length)]);
            dateData.setSection(CalendarUtils.getNAMES01()[i]);
            dataAboutDate dataAboutDate = new dataAboutDate();

            //int index = new Random().nextInt(CalendarUtils.getEVENTS().length);

            dataAboutDate.setTitle(CalendarUtils.getEVENTS03()[i]);
            dataAboutDate.setSubject(CalendarUtils.getEventsDescription6()[i]);
            dataAboutDates.add(dataAboutDate);

            dateData.setData(dataAboutDates);
            eventDataList.add(dateData);
        }
        return eventDataList;
    }


}




