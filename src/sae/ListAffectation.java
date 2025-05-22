package sae;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ListAffectation {
    /**liste d'etudiants */
    private ArrayList<Student> students;
    /**liste d'affectation */
    private ArrayList<Affectation> affectations;

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

    public void chargerCSV(String fichiercsv) {
        StringBuilder sb = new StringBuilder();

        sb.append(System.getProperty("user.dir")).append(File.separator).append("doc").append(File.separator).append(fichiercsv);

        File csvFile = new File(sb.toString());

         try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] colonnes = ligne.split(";"); 
                this.students.add(new Student(colonnes[0],colonnes[1],colonnes[2],colonnes[3],colonnes[4],colonnes[5],colonnes[6],colonnes[7],colonnes[8],colonnes[9],colonnes[10],colonnes[11]));
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //supprimer la première ligne car elle sert à se repérer dans les valeurs à ajouter
        students.remove(0);

    }

    /**methode permettant de verifier si le critère est valide */
    public void verifierValiditeCritere() {
        // ...
    }
    
    public void main(String[] args) {
        chargerCSV("infoetu.csv");

    }
}
