package pji.example.pji.bookset;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import pji.example.pji.implementation.Collection.Livre;


public class AjouterElementManSuite2Activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_element_man_suite2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ajouter_element_man_suite2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void suiteMan(View view){

        Livre livre = (Livre)getIntent().getSerializableExtra("livre1");

        EditText emprunte = (EditText)findViewById(R.id.emprunte);
        String emprunte_s = emprunte.getText().toString();

        livre.setEmprunte(emprunte_s);

        EditText prete = (EditText)findViewById(R.id.prete);
        String prete_s = prete.getText().toString();

        livre.setPrete(prete_s);

        Intent intent = new Intent(this, ConfirmationAjout.class);
        intent.putExtra("livre2",livre);

        startActivity(intent);


    }
}
