package sae;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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



    public void affectationStudents(){
        for (Student visiteur : students){
            for (Student hote : students ){
                if(visiteur.getPays().equals("France") && hote.getPays().equals("Italie")){
                    Affectation aff = new Affectation(visiteur,hote);
                    this.affectations.add(aff);
                }
            }
        }
    }



    public StringBuilder chemin(String fichiercsv){
        StringBuilder sb = new StringBuilder();

        sb.append(System.getProperty("user.dir")).append(File.separator).append("doc").append(File.separator).append(fichiercsv);
        return sb;
    }

    public void chargerCSV(String fichiercsv) {
        StringBuilder sb = new StringBuilder();

        sb = chemin(fichiercsv);

        File csvFile = new File(sb.toString());

         try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] colonnes = ligne.split(";"); 
                this.students.add(new Student(colonnes[0],colonnes[1],colonnes[2],colonnes[3],colonnes[4],colonnes[5],colonnes[6],colonnes[7],colonnes[8],colonnes[9],colonnes[10],colonnes[11]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //supprimer la première ligne car elle sert à se repérer dans les valeurs à ajouter
        students.remove(0);
    }

    /**methode permettant de verifier si le critère est valide */
    public void verifierValiditeCritere() {
        // ... vois si les valeurs sont correctes et afficher les lignes et les erreurs éventuelles
    }
    
    public void exportLisAffectation(String fichiercsv){
        StringBuilder sb = new StringBuilder();

        sb = chemin(fichiercsv);

        File csvFile = new File(sb.toString());

        String format = "Nom_Visiteur;Prenom_Visiteur;Nom_Hote;PrenomHote;Valeur_Affectation";

        try(FileWriter fw = new FileWriter(sb.toString());BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(format);
            bw.newLine();
            for (Affectation aff : affectations){
                String ligne = "";
                ligne = ""+aff.getVisiteur().getNom()+";"+aff.getVisiteur().getPrenom()+";"+aff.getHote().getNom()+";"+aff.getVisiteur().getPrenom()+";"+aff.getAffinite();
                bw.write(ligne);
                bw.newLine();

            }
        }catch (IOException e){
            System.out.println(e);
        }

        // renvoie un fichier csv de toutes les affectations ...
    }
    /*
    public void ajouterStudent(String prenom, String nom, String dateNaissance, String pays, String gender, String pairGender,String guestAnimalAllergy, String hostHasAnimal, String guestFood, String hostFood, String history, String hobbies){
        String[] nouvelleLigne = {prenom,nom,dateNaissance,pays,gender,pairGender,guestAnimalAllergy,hostHasAnimal,guestFood,hostFood,history,hobbies};
        try (FileWriter writer = new FileWriter("infoetu.csv",true)){
            for (String e: nouvelleLigne){
                String ligne = String.join(';');
            }
            
            writer.write(ligne + "\n"); 
            System.out.println("Ligne ajoutée avec succès !");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
            */
        public String toStringStudents(){
        String txt = "";
        for (Student student : students){
            txt= txt + student.toString() + "\n";
        }
        return txt;
    }
    public String toStringAffectation(){
        String txt = "";
        for (Affectation affectation : affectations){
            txt = txt + affectation.toString() + "\n";
        }
        return txt;
    }
    }
