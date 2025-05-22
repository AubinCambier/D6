package sae;

import java.util.ArrayList;
import java.nio.file.Paths;

public class ListAffectation {
    /**liste d'etudiants */
    private ArrayList<Student> students;
    /**liste d'affectation */
    private ArrayList<Affectation> affectations;
    private final static String RESSOURCES_PATH = Paths.get("","");

    /**constructeur principale initialisant la liste d'étudiants et la liste d'affectation */
    public ListAffectation() {
        this.students = new ArrayList<Student>();
        this.affectations = new ArrayList<Affectation>();
    }
    /** retourne la liste d'étudiants */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**retourne la liste d'affectation */
    public ArrayList<Affectation> getAffectations() {
        return affectations;
    }
    /**ajoute un étudiants a la liste d'étudiants */
    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void chargerCSV() {
        // ...
    }

    /**methode permettant de verifier si le critère est valide */
    public void verifierValiditeCritere() {
        // ...
    }
}
