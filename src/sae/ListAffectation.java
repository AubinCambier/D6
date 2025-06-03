package sae;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class ListAffectation implements Serializable{
    /**liste d'etudiants */
    private ArrayList<Student> students;
    /**liste d'affectation */
    private ArrayList<Affectation> affectations;

    private int nbVisiteur = 0;
    private int nbHote = 0;

    private final static String PAYSVISITEUR = "France";
    private final static String PAYSHOTE = "Italie";

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
    public int getNbHote() {
        return nbHote;
    }
    public int getNbVisiteur() {
        return nbVisiteur;
    }
    /**ajoute un étudiants a la liste d'étudiants */
    public void addStudent(Student student) {
        this.students.add(student);
    }
    public void trieAffectation(){
        // cherche la meilleur combinaison possible pour valider un maximum de critères
        try(FileWriter writer = new FileWriter(chemin("tableauAffectation").toString())){
            
        }catch(IOException e){
            e.printStackTrace();
        }
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
                String[] student = ligne.split(";"); 
                if(verifierValiditeCritere(student)){
                    this.students.add(new Student(student[0],student[1],student[2],student[3],student[4],student[5],student[6],student[7],student[8],student[9],student[10],student[11]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**methode permettant de verifier si l'étudiant est valide */
    private boolean verifierValiditeCritere(String[] st) {
        //conditions 
        if(st.length != 12){
            System.out.println("Il manque des valeur à "+st[1]);
            return false;
        }
        for (int i =4; i<7 ; i++){
            if (!(st[i].equals("true")||st[i].equals("false"))){
                System.out.println("Erreur valeur boolean à " +st[1]);
                return false;
            }   
        }
        // ... vois si les valeurs sont correctes et afficher les lignes et les erreurs éventuelles
        return true;
    }
    
    public void exportLisAffectation(String fichiercsv){
        StringBuilder sb = new StringBuilder();

        sb = chemin(fichiercsv);

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

    public void selectionStudents(){
        String paysTrop;
        int quantite =0;
        if (this.nbHote < this.nbVisiteur) {
            quantite = this.nbVisiteur - this.nbHote;
            paysTrop = "France";
        }
        else if (this.nbHote >  this.nbVisiteur){
            quantite = this.nbHote - this.nbVisiteur;
            paysTrop = "Italie";
        }
        else{
            System.out.println("il y a autant d'étudiant Hote et Visiteur");
            return;
        }

        if (students.size()!=0){

            //on élimine students qui ont des valeurs incohérentes 
            int longueur = students.size();
            for (int i=longueur -1;i>=0;i=i-1){
                if(students.get(i).getHostHasAnimal()&& students.get(i).getGuestAnimalAllergy() && quantite != 0 && students.get(i).getPays().equals(paysTrop)){
                    System.out.println("Cet étudiant comprend des valeurs incohérentes sur les animaux "+ students.get(i).toString());
                    students.remove(i);
                    quantite --;
                }
            }
            //on élimine aléatoirement des élèves
            Random rand = new Random();
            while (quantite >0 && students.size() != 0){
                int index = rand.nextInt(students.size());
                if (students.get(index).getPays().equals(paysTrop)){
                    System.out.println("l'étudiant est supprimé "+ students.get(index).toString());
                    students.remove(index);
                    quantite = quantite -1;
                }
            }
        }
    }

    public void calculerNbStudent(){
        this.nbVisiteur = 0;
        this.nbHote =0;
        for (Student stu : students){
            if (stu.getPays().equals(ListAffectation.PAYSVISITEUR)){
                this.nbVisiteur += 1;
            }else if (stu.getPays().equals(ListAffectation.PAYSHOTE)){
                this.nbHote += 1;
            }
        }
    }

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
