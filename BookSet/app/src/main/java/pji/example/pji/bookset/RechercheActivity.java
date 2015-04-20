package pji.example.pji.bookset;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.sql.SQLException;

import pji.example.pji.implementation.Collection.Livre;
import pji.example.pji.implementation.base.DatabaseManager;


public class RechercheActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recherche, menu);
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
    public void rechercheResultat(View view) throws SQLException {
        EditText titreedit = (EditText) findViewById(R.id.titreRecherche);
        String titre = titreedit.getText().toString();

        EditText isbnedit = (EditText) findViewById(R.id.isbnRecherche);
        String isbn = isbnedit.getText().toString();
        Livre livre = null;

        if(titre != null){
            livre = DatabaseManager.getInstance().getHelper().getLivreDao().findByTitle(titre);

        }
        if(isbn != null){
            livre = DatabaseManager.getInstance().getHelper().getLivreDao().findByIsbn(isbn);
        }
            Intent intent = new Intent(this, ResulatActivity.class);
            intent.putExtra("livre",livre);
            startActivity(intent);
    }
}
