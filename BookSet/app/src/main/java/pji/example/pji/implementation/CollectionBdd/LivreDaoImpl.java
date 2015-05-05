package pji.example.pji.implementation.CollectionBdd;

import android.database.Cursor;
import android.widget.ListView;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.ArrayList;
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
        List livres = new ArrayList();
        try {
            livres = queryForAll();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return livres;
    }

    public List findAllPanier(){
        List<Livre> resultat = new ArrayList();
        List<Livre> all = new ArrayList();
        all =  findAll();
        for(Livre livre1 : all){
            if(livre1.isPanier() == true){
                resultat.add(livre1);
            }

        }
        return resultat;

    }

    public List findAllFavoris(){

        List<Livre> resultat = new ArrayList();
        List<Livre> all = new ArrayList();
        all =  findAll();
        for(Livre livre1 : all){
            if(livre1.isFavori() == true){
                resultat.add(livre1);
            }

        }
        return resultat;
    }

   /* public void supprimer (String titre){

    }*/


    public Livre findById(int id) {
        Livre livres = new Livre();
        try {
            livres = (Livre) queryForId(id);
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return livres
                ;
    }

    public Livre findByTitle(String titre){
        Livre livre = new Livre();
        List<Livre> all = new ArrayList();
        all =  findAll();
        for(Livre livre1 : all){
            if(livre1.getTitre().equals(titre)){
                livre = livre1;
            }

        }
        return livre;

    }

    public Livre findByIsbn(String isbn) throws SQLException {
        Livre livre = new Livre();
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
