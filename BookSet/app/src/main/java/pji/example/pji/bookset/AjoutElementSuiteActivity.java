package pji.example.pji.bookset;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import pji.example.pji.implementation.Collection.Livre;



public class AjoutElementSuiteActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_element_man_suite);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ajout_element_suite, menu);
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

    public void suite(View view){
        Livre livre = (Livre) getIntent().getSerializableExtra("livre");


        EditText publie = (EditText) findViewById(R.id.publie);
        String publie_s = publie.getText().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        try {
            Date d = sdf.parse(publie_s);
            livre.setPublie_le(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        RatingBar note_tex = (RatingBar) findViewById(R.id.note);
        float note = note_tex.getRating();

        livre.setNote(note);

        RatingBar note_perso_tex = (RatingBar) findViewById(R.id.noteperso);
        float noteperso = note_perso_tex.getRating();

        livre.setNotePerso(noteperso);

        CheckBox favoris = (CheckBox) findViewById(R.id.favoris);
        boolean favori = favoris.isChecked();

        livre.setFavori(favori);

        CheckBox lu_c = (CheckBox) findViewById(R.id.lu);
        boolean lu = lu_c.isChecked();

        livre.setLu(lu);

        CheckBox mappartient_c = (CheckBox) findViewById(R.id.mappartient);
        boolean mappartient = mappartient_c.isChecked();

        livre.setMappartient(mappartient);

        Intent intent = new Intent(this, AjouterElementManSuite2Activity.class);

        intent.putExtra("livre1", livre);

        startActivity(intent);
    }
    public void annuler(View view){
        Intent intent = new Intent(this, AccueilActivity.class);
        startActivity(intent);

    }
}
