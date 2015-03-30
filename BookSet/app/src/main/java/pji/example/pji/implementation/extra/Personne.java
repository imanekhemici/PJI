package pji.example.pji.implementation.extra;

/**
 * Created by imane khemici on 28/03/15.
 */
public class Personne {

    private String name;
    private String prenom;


    public Personne(String name, String prenom){
        this.name = name;
        this.prenom = prenom;
    }

    public String getName() {
        return this.name;
    }

    public String getPrenom() {
        return this.prenom;
    }


    public void setName(String n) {
        this.name= n;
    }

    public void setPrenom(String p) {
        this.prenom = p;
    }
}
