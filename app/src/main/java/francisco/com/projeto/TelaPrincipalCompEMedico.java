package francisco.com.projeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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
import francisco.com.projeto.Weka.IrGraficosActivity;

public class TelaPrincipalCompEMedico extends MenuActivity implements View.OnClickListener {

    Button btnCalendario, btn_Contactos_Outro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal_comp_emedico);
        btnCalendario = (Button) findViewById(R.id.btnCalendario);
        btn_Contactos_Outro = (Button) findViewById(R.id.btn_Contactos_Outro);

        btnCalendario.setOnClickListener(this);
        btn_Contactos_Outro.setOnClickListener(this);

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
                    Intent it = new Intent(TelaPrincipalCompEMedico.this, VerMedicoECompActivity.class);
                    startActivity(it);
                    break;
                } else if (tipo.equals("Companheiro")) {
                    Intent it = new Intent(TelaPrincipalCompEMedico.this, VerMedicoECompActivity.class);
                    startActivity(it);
                    break;
                } else {
                    Intent it = new Intent(TelaPrincipalCompEMedico.this, IrCalendarioActivity.class);
                    startActivity(it);
                    break;
                }
            case R.id.btn_Contactos_Outro:
                Intent it2 = new Intent(TelaPrincipalCompEMedico.this, Lista_ContactosActivity.class);
                startActivity(it2);
                break;

        }

    }

}
