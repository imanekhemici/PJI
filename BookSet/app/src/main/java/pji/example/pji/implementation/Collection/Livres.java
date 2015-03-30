package pji.example.pji.implementation.Collection;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

import pji.example.pji.implementation.CollectionBdd.LivresDao;
import pji.example.pji.implementation.TypeGenre.GenreLivre;
import pji.example.pji.implementation.extra.Auteur;
import pji.example.pji.implementation.extra.OuiNon;
import pji.example.pji.implementation.extra.Personne;

/**
 * Created by imane on 09/03/15.
 */

@DatabaseTable(tableName = "Livres", daoClass = LivresDao.class)
public class Livres extends Collection {

    /**
     * l'identifiant du livre dans la base de données
     */
    @DatabaseField(generatedId = true, canBeNull = false)
    private int id;

    /**
     * l'isbn_10 du livre
     */
    @DatabaseField(canBeNull = true)
    private String isbn_10;

    /**
     * l'isbn 13 du livre
     */
    @DatabaseField(canBeNull = true)
    private String isbn_13;

    /**
     * le titre du livre
     */
    @DatabaseField(canBeNull = false)
    private String titre;

    /**
     * la liste des auteurs du livre
     */
    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true)
    private List<Auteur> auteur;

    /**
     * la liste des genre du livre
     */
    @DatabaseField(canBeNull = true, foreign = true, foreignAutoRefresh = true)
    private List<GenreLivre> genre;

    /**
     * la langue dans la quelle le livre est écrit
     */
    @DatabaseField(canBeNull = true)
    private String langue;

    /**
     * l'éditeur du livre
     */
    @DatabaseField(canBeNull = true)
    private String editeur;

    /**
     * l'état de lecture du livre
     */

    @DatabaseField(canBeNull = true)
    private OuiNon lu;

    /**
     * la note /5 du livre
     */
    @DatabaseField(canBeNull = true)
    private int note;

    /**
     * le résumé du livre
     */
    @DatabaseField(canBeNull = true)
    private String resume;

    /**
     * l'état de possession du livre
     */

    @DatabaseField(canBeNull = true)
    private OuiNon enPossession;

    /**
     * la personne à qui le livre est prêté
     */
    @DatabaseField(canBeNull = true)
    private Personne prete;

    /**
     * le livre est dans les favoris
     */
    @DatabaseField(canBeNull = true)
    private OuiNon favori;

    /**
     * le constructeur
     * @param isbn
     * @param titre
     */

    public Livres(String isbn, String titre){
        if (isbn.length() == 10){
            this.isbn_10 = isbn;
        }
        else {
            this.isbn_13 = isbn;
        }

        this.titre = titre;
    }

    /**
     * quelle est l'id du livre
     * @return un entier correspondant à l'id du livre
     */

    public int getId() {
        return id;
    }

    /**
     * quel est l'isbn du livre
     * @return une chaine de caractère correspondant à l'isbn du livre
     */
    public String getIsbn() {
        if (isbn_13 == null) {
            return isbn_10;
        }
        else {
            return isbn_13;
        }
    }

    /**
     * renseigner l'isbn du livre
     * @param isbn du livre
     */

    public void setIsbn(String isbn) {
        if (isbn.length()==10) {
            this.isbn_10 = isbn;
        }
        else {
            this.isbn_13 = isbn;
        }
    }

    /**
     * quel est le titre du livre
     * @return une chaine de caractère correspondant au titre du livre
     */

    public String getTitre() {
        if (this.titre != null) {
            return this.titre;
        }
        else {
            return "non renseigne";
        }

    }

    /**
     * renseigner le titre du livre
     * @param titre le titre du livre
     */

    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * la déscription du livre
     * @return une chaine de caractère correspondant à la déscription du livre
     */
    public String toString(){
            return "ID : "+id+"\nISBN_13 : "+isbn_13+"\nISBN_10 : "+isbn_10+"\nTitre : "+titre;


    }

    /**
     * renseigner l'auteur du livre
     * @param auteur l'auteur du livre
     */

    public void setAuteur(Auteur auteur){
        this.auteur.add(auteur);
    }

    /**
     * quel(s) sont les ou  l'auteur(s) de ce livre
     * @return une chaine de caractère indiquant les ou l'auteur du livre
     */
    public String getAuteur(){
        if (this.auteur.size()==1) {
            return this.auteur.get(0).toString();
        }
        else if (this.auteur.size()>1) {
            String res = "";
            for(int i=0; i<= this.auteur.size()-2; i++){
                res = res+this.auteur.get(i).toString()+" , " ;
            }
            res = res + this.auteur.get(this.auteur.size()-1);
            return res;
        }
        else {
            return "non rensigne";
        }

    }

    /**
     * renseigner le genre du livre
     * @param genre le genre du livre
     */
    public void setGenre(GenreLivre genre){

        this.genre.add(genre);
    }

    /**
     * le livre est de quel(s) genre(s)
     * @return le genre du livre
     */
    public String getGenre(){
        if (this.genre.size() == 1) {
            return this.genre.get(0).toString();
        }
        else if (this.genre.size() >1) {
            String res = "";
            for (int i=0; i<=this.genre.size()-2; i++){
                res = res + this.genre.get(i)+" , ";
            }
            res = res + this.genre.get(this.genre.size()-1) ;
            return res;
        }
        else {
            return "non renseigne";
        }

    }

    /**
     * renseigner la langue dans laquelle ce livre est écrit
     * @param langue une chaine de caractère correspondant à la langued'écriture
     * du livre
     */

    public void setLangue(String langue){
        this.langue = langue;
    }

    /**
     * la langue dans laquelle ce livre est écrit
     * @return une chaine de caractère indiquant la langue d'écriture du livre
     */

    public String getLangue(){
        if (this.langue != null) {
            return this.langue;
        }
        else {
            return "non renseignee";
        }

    }

    /**
     *vérifie si ce livre a été lu
     * @return true si ce livre a déjà été lu et false sinon
     */

    public Boolean estLu() {
        if (this.lu == OuiNon.Oui) {
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * vérifie si ce livre est dans les livres favoris
     * @return true si ce  livre est dans les livres favoris et false sinon
     */

    public Boolean estFavori() {
        if (this.favori == OuiNon.Oui) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * donne le résumé du livre
     * @return une chaine de caractère correspondant au résumé du livre
     */

    public String getResume(){
        if (this.resume != null) {
            return this.resume;
        }
        else {
            return "non renseigne" ;
        }
    }

    /**
     * renseigner l résumé du livre
     * @param resume le résumé du livre
     */
    public void setResume(String resume) {
        this.resume = resume;
    }

    /**
     * donne l'éditeur du livre
     * @return une chaine de caractère correspondant à l'éditeur du livre
     */

    public String getEditeur(){
        if (this.editeur != null) {
            return this.editeur;
        }
        else {
            return "non renseigne" ;
        }
    }

    /**
     * renseigne l'editeur du livre
     * @param editeur l'éditeur du livre
     */

    public void setEditeur(String editeur){
        this.editeur = editeur;
    }

    /**
     * donne la note du livre
     * @return un entier correspondant à la note du livre
     */

    public int getNote(){
            return this.note;

    }

    /**
     * renseigne la note du livre
     * @param note la note attribuée au livre
     */

    public void setNote(String note){
        this.editeur = note;
    }

    /**
     * vérifie si ce livre est dans en la possession de l'utilisateur
     * @return true si ce  livre est dans les livres possédés par
     * l'utilisteur et false sinon
     */

    public Boolean estEnPossession() {
        if (this.enPossession == OuiNon.Oui) {
            return true;
        }
        else {
            return false;
        }
    }
}
