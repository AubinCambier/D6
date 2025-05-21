package sae;

public class Affectation {
    private Student hote;
    private Student visiteur;
    private double affinite;

    public Affectation(Student hote, Student visiteur) {
        this.hote = hote;
        this.visiteur = visiteur;
        this.affinite = hote.calculAffinite(visiteur);
    }

    public Student getHote() {
        return hote;
    }

    public Student getVisiteur() {
        return visiteur;
    }

    public double getAffinite() {
        return affinite;
    }

    public void setAffinite(int affinite) {
        this.affinite = affinite;
    }
}
