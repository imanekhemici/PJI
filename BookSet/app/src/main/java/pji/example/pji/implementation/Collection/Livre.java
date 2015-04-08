package pji.example.pji.implementation.Collection;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by imane khemici on 01/04/15.
 */
@DatabaseTable(tableName = "livre")
public class Livre {

    public Livre() {}
    public Livre(String titre, String auteur, String isbn) {
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
    }

    /** Getter/Setter
     *
     */


    /** A/D
     *
     */

    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField(columnName = "titre", canBeNull = false)
    private String titre;
    @DatabaseField(columnName = "auteur", canBeNull = false)
    private String auteur;
    @DatabaseField(columnName = "isbn", canBeNull = false)
    private String isbn;

}
