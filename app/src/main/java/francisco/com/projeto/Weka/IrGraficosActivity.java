package francisco.com.projeto.Weka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import francisco.com.projeto.Global.MenuActivity;
import francisco.com.projeto.Global.Utils;
import francisco.com.projeto.MainActivity;
import francisco.com.projeto.R;
import francisco.com.projeto.Registo.RegistoActivity;

public class IrGraficosActivity extends MenuActivity implements View.OnClickListener {

    Button btn_historico, btn_previsao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ir_graficos);
        setTitle("Gráficos Weka");

        btn_historico = (Button) findViewById(R.id.btn_historico);
        btn_previsao = (Button) findViewById(R.id.btn_previsao);

        btn_historico.setOnClickListener(this);
        btn_previsao.setOnClickListener(this);
    }


    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_historico:
                Intent it = new Intent(IrGraficosActivity.this, GraficosActivity.class);
                startActivity(it);
                break;
            case R.id.btn_previsao:
                Intent it2 = new Intent(IrGraficosActivity.this, PrevisaoProxMesActivity.class);
                startActivity(it2);
                break;
        }
    }
}
