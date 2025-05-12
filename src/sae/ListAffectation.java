package sae;

import java.util.ArrayList;

public class ListAffectation {
    private ArrayList<Student> students;
    private ArrayList<Affectation> affectations;

    public ListAffectation() {
        this.students = new ArrayList<Student>();
        this.affectations = new ArrayList<Affectation>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Affectation> getAffectations() {
        return affectations;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void chargerCSV() {
        // ...
    }

    public void verifierValiditeCritere() {
        // ...
    }
}
