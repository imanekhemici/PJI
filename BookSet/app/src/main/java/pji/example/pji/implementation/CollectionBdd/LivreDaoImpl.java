package pji.example.pji.implementation.CollectionBdd;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

import pji.example.pji.implementation.Collection.Livre;

/**
 * Created by imane khemici on 08/04/15.
 */
public class LivreDaoImpl extends BaseDaoImpl<Livre,Integer> implements  LivreDao{


 public LivreDaoImpl(ConnectionSource connectionSource)
            throws SQLException {

     super(connectionSource, Livre.class);
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

    public Livre findById(int id) {
        Livre livres = null;
        try {
            livres = (Livre) queryForId(id);
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return livres
                ;
    }

    public Livre findByTitle(String titre) throws SQLException {
        Livre livre = null;
        List<Livre> all = queryForAll();

        for(Livre livre1 : all){
            if(livre1.getTitre().equals(titre)){
                livre = livre1;
            }

        }
        return livre;

    }
    public Livre findByIsbn(String isbn) throws SQLException {
        Livre livre = null;
        List<Livre> all = queryForAll();

        for(Livre livre1 : all){
            if(livre1.getIsbn().equals(isbn)){
                livre = livre1;
            }

        }
        return livre;

    }
    public boolean existe(String titre) throws SQLException {
        List<Livre> all = queryForAll();
        boolean existe = false;
        for(Livre livre1 : all){
            if(livre1.getTitre().equals(titre)){
                existe = true;
            }

        }
        return existe;

    }
    public int addData(Livre livre) throws SQLException {
        return this.create(livre);
    }

}
