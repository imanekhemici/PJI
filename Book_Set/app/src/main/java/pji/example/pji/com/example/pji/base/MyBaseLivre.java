package com.example.pji.com.example.pji.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by imane on 09/03/15.
 */
public class MyBaseLivre extends SQLiteOpenHelper {

    private static final String TABLE_LIVRES = "livres";
    private static final String COL_ID = "id";
    private static final String COL_TITRE ="titre";
    private static final String COL_ISBN = "isbn";
    private static final String COL_AUTEUR = "auteur";
    private static final String COL_GENRE ="genre";
    private static final String COL_LANG ="langue";

    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_LIVRES
            + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_ISBN + " TEXT NOT NULL, "
            + COL_TITRE + " TEXT NOT NULL,"
            + COL_AUTEUR + "'',"
            + COL_GENRE+ "'',"
            + COL_LANG + "'');";

    public MyBaseLivre(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**Create a table
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_BDD);
    }

    /**Drop a table
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_LIVRES + ";");
        onCreate(db);
    }
}
