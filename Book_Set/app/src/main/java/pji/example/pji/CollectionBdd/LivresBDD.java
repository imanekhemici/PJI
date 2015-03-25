package pji.example.pji.CollectionBdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import pji.example.pji.implementation.base.*;

import pji.example.pji.implementation.Collection.Livres;
/**
 * Created by imane on 18/03/15.
 */
public class LivresBDD {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "collections.db";

    private static final String TABLE_LIVRES = "Livres";
    private static final String COL_ID = "id";
    private static final int NUM_COL_ID = 0;

    private static final String COL_TITRE ="titre";
    private static final int NUM_COL_TITRE = 1;

    private static final String COL_ISBN = "isbn";
    private static final int NUM_COL_ISBN = 2;

    private static final String COL_AUTEUR = "auteur";
    private static final int NUM_COL_AUTEUR = 3;

    private static final String COL_GENRE ="genre";
    private static final int NUM_COL_GENRE = 4;

    private static final String COL_LANG ="langue";
    private static final int NUM_COL_LANG = 5;


    private SQLiteDatabase bdd;

    private MyBaseLivre baseLivre;

    public LivresBDD(Context context){
        //creation de la table livres dans la base de données collections
        baseLivre = new MyBaseLivre(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open(){
        //on ouvre la BDD en écriture
        bdd = baseLivre.getWritableDatabase();
    }

    public void close(){
        //on ferme l'accès à la BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD(){
        return bdd;
    }

    public long insertLivre(Livres livre){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_ISBN, livre.getIsbn());
        values.put(COL_TITRE, livre.getTitre());
        values.put(COL_AUTEUR, livre.getAuteur());
        values.put(COL_GENRE, livre.getGenre().toString());
        values.put(COL_LANG, livre.getLangue());
        //on insere la value dans la table livres
        return bdd.insert(TABLE_LIVRES, null, values);
    }

    public int updateLivre(int id, Livres livre){
        //La mise à jour d'un livre dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simple préciser quelle livre on doit mettre à jour grâce à l'ID

        ContentValues values = new ContentValues();
        values.put(COL_ISBN, livre.getIsbn());
        values.put(COL_TITRE, livre.getTitre());
        values.put(COL_AUTEUR, livre.getAuteur());
        values.put(COL_GENRE, livre.getGenre().toString());
        values.put(COL_LANG, livre.getLangue());
        return bdd.update(TABLE_LIVRES, values, COL_ID + " = " +id, null);
    }

    public int removeLivreWithID(int id){
        //Suppression d'un livre de la BDD grâce à l'ID
        return bdd.delete(TABLE_LIVRES, COL_ID + " = " +id, null);
    }

    public Livres getLivreWithTitre(String titre){
        //Récupère dans un Cursor les valeur correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor c = bdd.query(TABLE_LIVRES, new String[] {COL_ID, COL_ISBN, COL_TITRE,COL_AUTEUR,COL_GENRE,COL_LANG}, COL_TITRE + " LIKE \"" + titre +"\"", null, null, null, null);
        return cursorToLivre(c);
    }

    //Cette méthode permet de convertir un cursor en un livre
    private Livres cursorToLivre(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé un livre
        Livres livre = new Livres();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        livre.setId(c.getInt(NUM_COL_ID));
        livre.setIsbn(c.getString(NUM_COL_ISBN));
        livre.setTitre(c.getString(NUM_COL_TITRE));
        livre.setTitre(c.getString(NUM_COL_AUTEUR));
        livre.setTitre(c.getString(NUM_COL_GENRE));
        livre.setTitre(c.getString(NUM_COL_LANG));

        //On ferme le cursor
        c.close();

        //On retourne le livre
        return livre;
    }
}
