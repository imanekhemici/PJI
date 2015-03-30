package pji.example.pji.implementation.CollectionBdd;


import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

import pji.example.pji.implementation.Collection.Livres;

/**
 * Created by imane khemici on 28/03/15.
 */
public class LivresDao extends BaseDaoImpl {
    public LivresDao(ConnectionSource connectionSource)
            throws SQLException {
        super(connectionSource, Livres.class);
    }

    public List findAll() {
        List livres = null;
        try {
            livres = queryForAll();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return livres;
    }

    public Livres findById(int id) {
        Livres livres = null;
        try {
            livres = (Livres) queryForId(id);
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return livres
                ;
    }

    public int addData(Livres livre) throws SQLException {
        int i = create(livre);
        return i;
    }
}