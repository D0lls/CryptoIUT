package iut.calais.cryptoiut.beans;

public class Resultat implements Comparable<Resultat>{


    private Integer id;
    private String scoreDonneur;
    private String scoreJoueur;

    public Resultat(Integer id, String scoreDonneur, String scoreJoueur) {
        this.id = id;
        this.scoreDonneur = scoreDonneur;
        this.scoreJoueur = scoreJoueur;
    }

    /**
     * Constructeur
     */
    public Resultat(String scoreDonneur, String scoreJoueur) {
        this.scoreDonneur = scoreDonneur;
        this.scoreJoueur = scoreJoueur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return scoreDonneur;
    }

    public void setNom(String scoreDonneur) {
        this.scoreDonneur = scoreDonneur;
    }

    public String getValeur() {
        return scoreJoueur;
    }

    public void setValeur(String scoreJoueur) {
        this.scoreJoueur = scoreJoueur;
    }

    @Override
    public int compareTo(Resultat o) {
        return id.compareTo(o.getId());
    }

}
