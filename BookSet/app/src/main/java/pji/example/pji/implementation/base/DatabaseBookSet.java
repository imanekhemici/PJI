package pji.example.pji.implementation.base;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import pji.example.pji.implementation.Collection.Livre;

public class DatabaseBookSet extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "bookset.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<Livre,Integer> livresDao = null;

    public DatabaseBookSet(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /** create database bookset
     *
     * @param database
     * @param connectionSource
     */
    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Livre.class);
            System.out.println("Table created");
        } catch (SQLException e) {
            Log.e(DatabaseBookSet.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    /** upgrade the database bookset
     *
     * @param arg0
     * @param arg1
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase arg0, ConnectionSource arg1, int oldVersion,
                          int newVersion) {
        // TODO Auto-generated method stub

    }

    /** create the table livres
     *
     * @return
     */
    public Dao<Livre, Integer> getLivreDao() {
        if(null == livresDao) {
            try {
                livresDao = getDao(Livre.class);
            }catch(java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return livresDao;
    }
}
