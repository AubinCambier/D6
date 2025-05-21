package sae;

/**
 * Cette classe représente une affectation entre un hôte et un visiteur.
 * Elle stocke aussi le score d'affinité entre eux.
 */
public class Affectation {
    /** l'étudiant qui reçoit */
    private Student hote;

    /** l'étudiant visiteur */
    private Student visiteur;

    /** la valeur d'affinité entre les deux */
    private double affinite;

    /**
     * Constructeur qui initialise l'hôte, le visiteur,
     * et calcule leur affinité.
     */
    public Affectation(Student hote, Student visiteur) {
        this.hote = hote;
        this.visiteur = visiteur;
        this.affinite = hote.calculAffinite(visiteur);
    }

    /** Renvoie l'étudiant hôte.*/
    public Student getHote() {
        return hote;
    }

    /**Renvoie l'étudiant visiteur.*/
    public Student getVisiteur() {
        return visiteur;
    }

    /**Renvoie la valeur d'affinité.*/
    public double getAffinite() {
        return affinite;
    }

    /**Modifie la valeur d'affinité.*/
    public void setAffinite(int affinite) {
        this.affinite = affinite;
    }
}

