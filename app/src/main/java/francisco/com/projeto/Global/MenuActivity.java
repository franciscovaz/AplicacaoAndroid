package francisco.com.projeto.Global;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import francisco.com.projeto.MainActivity;
import francisco.com.projeto.R;
import francisco.com.projeto.TelaPrincipal;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    //PARA O MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuprincipal,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.menu_home){
            Intent it = new Intent(MenuActivity.this, TelaPrincipal.class);
            startActivity(it);
        }else if(id == R.id.menu_sair){
            Intent it = new Intent(MenuActivity.this, MainActivity.class);
            startActivity(it);
        }
        return super.onOptionsItemSelected(item);
    }
}
