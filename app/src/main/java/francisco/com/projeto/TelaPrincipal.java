package francisco.com.projeto;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import francisco.com.projeto.Calendario.IrCalendarioActivity;
import francisco.com.projeto.Calendario.VerMedicoECompActivity;
import francisco.com.projeto.Contactos.Lista_ContactosActivity;
import francisco.com.projeto.EstadosUsuaria.HumorActivity;
import francisco.com.projeto.EstadosUsuaria.SintomasActivity;
import francisco.com.projeto.Global.MenuActivity;
import francisco.com.projeto.Global.Utils;
import francisco.com.projeto.Registo.Anotacoes;
import francisco.com.projeto.Registo.MetodoContracetivo;
import francisco.com.projeto.Weka.GraficosActivity;
import francisco.com.projeto.Weka.IrGraficosActivity;

public class TelaPrincipal extends MenuActivity implements View.OnClickListener {
    Button btnCalendario, btn_Contactos, btnSintomas, btnLembretes, btnGrafico, btn_Metodo, btn_Anotacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        btnCalendario = (Button) findViewById(R.id.btnCalendario);
        btn_Contactos = (Button) findViewById(R.id.btn_Contactos);
        btnSintomas = (Button) findViewById(R.id.btnSintomas);
        btnLembretes = (Button) findViewById(R.id.btnLembretes);
        btnGrafico = (Button) findViewById(R.id.btn_Graficos);
        btn_Metodo = (Button) findViewById(R.id.btn_Metodo);
        btn_Anotacoes = (Button) findViewById(R.id.btn_Anotacoes);

        btnCalendario.setOnClickListener((View.OnClickListener) this);
        btn_Contactos.setOnClickListener((View.OnClickListener) this);
        btnSintomas.setOnClickListener((View.OnClickListener) this);
        btnLembretes.setOnClickListener((View.OnClickListener) this);
        btnGrafico.setOnClickListener((View.OnClickListener) this);
        btn_Metodo.setOnClickListener(this);
        btn_Anotacoes.setOnClickListener(this);

        Utils u = new Utils();

        Log.d("GLOBAL EMAIL", u.getEmail() + "");
        Log.d("GLOBAL PASSWORD", u.getPassword() + "");
        Log.d("GLOBAL TIPO", u.getTipoDeUsuario() + "");
    }


    public void onClick(View view) {
        Utils u = Utils.getInstance();
        String em = u.getEmail();
        String tipo = u.getTipoDeUsuario();


        switch (view.getId()) {
            case R.id.btnCalendario:
                if (tipo.equals("Medico")) {
                    Intent it = new Intent(TelaPrincipal.this, VerMedicoECompActivity.class);
                    startActivity(it);
                    break;
                } else if (tipo.equals("Companheiro")) {
                    Intent it = new Intent(TelaPrincipal.this, VerMedicoECompActivity.class);
                    startActivity(it);
                    break;
                } else {
                    Intent it = new Intent(TelaPrincipal.this, IrCalendarioActivity.class);
                    startActivity(it);
                    break;
                }
            case R.id.btn_Contactos:
                Intent it2 = new Intent(TelaPrincipal.this, Lista_ContactosActivity.class);
                startActivity(it2);
                break;
            case R.id.btnSintomas:
                Intent it3 = new Intent(TelaPrincipal.this, SintomasActivity.class);
                startActivity(it3);
                break;
            case R.id.btnLembretes:
                Intent it4 = new Intent(TelaPrincipal.this, HumorActivity.class);
                startActivity(it4);
                break;
            case R.id.btn_Graficos:
                Intent it5 = new Intent(TelaPrincipal.this, IrGraficosActivity.class);
                startActivity(it5);
                break;
            case R.id.btn_Metodo:
                Intent it6 = new Intent(TelaPrincipal.this, MetodoContracetivo.class);
                startActivity(it6);
                break;
            case R.id.btn_Anotacoes:
                Intent it7 = new Intent(TelaPrincipal.this, Anotacoes.class);
                startActivity(it7);
                break;

        }

    }

}
