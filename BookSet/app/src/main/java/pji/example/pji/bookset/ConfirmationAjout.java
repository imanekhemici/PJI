package pji.example.pji.bookset;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.sql.SQLException;

import pji.example.pji.implementation.Collection.Livre;
import pji.example.pji.implementation.base.DatabaseManager;


public class ConfirmationAjout extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_ajout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_confirmation_ajout, menu);
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

    public void annuler(View view) {

        Intent intent = new Intent(this, AccueilActivity.class);
        startActivity(intent);


    }

    public void ajouter(View view) throws SQLException {
        Livre livre =(Livre) getIntent().getSerializableExtra("livre2");
        Intent intent = new Intent(this, Confirmation.class);
        Livre livreTest = DatabaseManager.getInstance().getHelper().getLivreDao().findByTitle(livre.getTitre());

        if(livreTest == null){
            intent.putExtra("message","Ce livre existe deja dans votre base");
            startActivity(intent);

        }
        else{

            DatabaseManager.getInstance().getHelper().getLivreDao().addData(livre);
            intent.putExtra("message","Ce livre a été bien ajouté");
            startActivity(intent);
        }

    }

    public String afficher(){

        Livre livre =(Livre) getIntent().getSerializableExtra("livre2");
        String details = "";

        details = "Titre: "+livre.getTitre()+"\n"
                + "Auteur: "+livre.getAuteur()+"\n"
                + "Isbn: "+livre.getIsbn()+"\n"
                + "Genre: "+livre.getGenre()+"\n"
                + "Langue: "+livre.get

    }
}
