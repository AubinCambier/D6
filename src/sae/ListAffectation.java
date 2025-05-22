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

    public static void chargerCSV() {
        StringBuilder sb = new StringBuilder();

        sb.append(System.getProperty("user.dir")).append(File.separator).append("doc").append(File.separator).append("infoetu.csv");

        System.out.println(""+sb.toString());

        File csvFile = new File(sb.toString());

         try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] colonnes = ligne.split(";"); 
                for (String valeur : colonnes) {
                    System.out.print(valeur.trim() + " | ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**methode permettant de verifier si le critère est valide */
    public void verifierValiditeCritere() {
        // ...
    }
    public static void main(String[] args) {
        chargerCSV();
    }
}
