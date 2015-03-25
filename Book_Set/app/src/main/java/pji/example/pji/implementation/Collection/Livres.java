package pji.example.pji.implementation.Collection;

import pji.example.pji.implementation.TypeGenre.GenreLivre;

/**
 * Created by imane on 09/03/15.
 */
public class Livres extends Collection {

    private int id;
    private String isbn;
    private String titre;
    private String auteur;
    private GenreLivre genre;
    private String langue;
    public Livres(){}

    public Livres(String isbn, String titre){
        this.isbn = isbn;
        this.titre = titre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String toString(){
        return "ID : "+id+"\nISBN : "+isbn+"\nTitre : "+titre;
    }

    public void setAuteur(String auteur){
        this.auteur = auteur;
    }

    public String getAuteur(){
        return this.auteur;
    }

    public void setGenre(GenreLivre genre){
        this.genre = genre;
    }

    public GenreLivre getGenre(){
        return this.genre;
    }

    public void setLangue(String langue){
        this.langue = langue;
    }

    public String getLangue(){
        return this.langue;
    }
}
