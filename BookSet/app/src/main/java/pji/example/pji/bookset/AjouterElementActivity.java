package pji.example.pji.bookset;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import pji.example.pji.implementation.Collection.Livre;

/**
 * Created by imane khemici on 22/03/15.
 */
public class AjouterElementActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajouter_element_man_activity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ajouter_element, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void suivant(View view){

        EditText text = (EditText) findViewById(R.id.titre);
        String titre = text.getText().toString();
        text = (EditText) findViewById(R.id.auteur);
        String auteur = text.getText().toString();
        text = (EditText) findViewById(R.id.isbn);
        String isbn = text.getText().toString();
        text = (EditText) findViewById(R.id.genre);
        String genre =  text.getText().toString();

        Variable.livre = new Livre(titre,auteur,isbn,genre);


        Intent intent = new Intent(this, AjoutElementSuiteActivity.class);
        startActivity(intent);
    }

}
