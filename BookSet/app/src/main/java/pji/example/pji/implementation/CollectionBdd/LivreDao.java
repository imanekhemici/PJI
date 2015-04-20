package pji.example.pji.implementation.CollectionBdd;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import pji.example.pji.implementation.Collection.Livre;

/**
 * Created by imane khemici on 08/04/15.
 */
public interface LivreDao extends Dao<Livre, Integer> {

    public List findAll() ;


    public Livre findById(int id);

    public int addData(Livre livre)throws SQLException;

    public Livre findByTitle(String titre) throws SQLException;

    }
