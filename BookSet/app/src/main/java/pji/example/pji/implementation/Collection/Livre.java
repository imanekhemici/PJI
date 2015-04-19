package pji.example.pji.implementation.Collection;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;

import pji.example.pji.implementation.CollectionBdd.LivreDaoImpl;

/**
 * Created by imane khemici on 01/04/15.
 */
@DatabaseTable(tableName = "livre", daoClass = LivreDaoImpl.class)
public class Livre implements Serializable{

    public Livre() {}
    public Livre(String titre, String auteur, String isbn, String genre) {
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
        this.genre = genre;
    }

    /** Getter/Setter
     *
     */
    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    public Date getPublie_le() {
        return publie_le;
    }

    public float getNote() {
        return note;
    }

    public float getNotePerso() {
        return notePerso;
    }

    public boolean isFavori() {
        return favori;
    }

    public boolean isPanier() {
        return panier;
    }

    public boolean isLu() {
        return lu;
    }

    public boolean isMappartient() {
        return mappartient;
    }

    public String getEmprunte() {
        return emprunte;
    }

    public String getPrete() {
        return prete;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPublie_le(Date publie_le) {
        this.publie_le = publie_le;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public void setNotePerso(float notePerso) {
        this.notePerso = notePerso;
    }

    public void setPanier(boolean panier) {
        this.panier = panier;
    }

    public void setFavori(boolean favori) {
        this.favori = favori;
    }

    public void setLu(boolean lu) {
        this.lu = lu;
    }

    public void setMappartient(boolean    /** Getter/Setter
     *
     */mappartient) {
        this.mappartient = mappartient;
    }

    public void setEmprunte(String emprunte) {
        this.emprunte = emprunte;
    }

    public void setPrete(String prete) {
        this.prete = prete;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }
    /** A/D
     *
     */

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "titre", canBeNull = false)
    private String titre;
    @DatabaseField(columnName = "auteur", canBeNull = false)
    private String auteur;
    @DatabaseField(columnName = "isbn", canBeNull = false)
    private String isbn;
    @DatabaseField (columnName = "genre", canBeNull = false)
    private String genre;
    @DatabaseField (columnName = "publie", canBeNull = true)
    private Date publie_le;
    @DatabaseField (columnName = "note", canBeNull = true)
    private float note;
    @DatabaseField (columnName = "notePerso", canBeNull = true)
    private float notePerso;
    @DatabaseField (columnName = "favori", canBeNull = true)
    private boolean favori;
    @DatabaseField (columnName = "panier",canBeNull = true)
     private  boolean panier;
    @DatabaseField (columnName = "lu", canBeNull = true)
    private boolean lu;
    @DatabaseField (columnName = "mappartient", canBeNull = true)
    private boolean mappartient;
    @DatabaseField (columnName = "emprunte", canBeNull = true)
    private String emprunte;
    @DatabaseField (columnName = "prete", canBeNull = true)
    private String prete;
    @DatabaseField (columnName = "langue", canBeNull = true)
    private String langue;


}
