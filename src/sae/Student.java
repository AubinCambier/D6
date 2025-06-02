package sae;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.lang.Math;

public class Student {
    /**atribu permettant de donné d'associé les information d'un etudiants, c'est cette hashMap qui est initialisé par le constructeur */
    private Map<String, String> information;

    // on instancie tous les criètès d'un étudiant

    /**liste static permettant de donner le type de chacune des clée */
    public static Map<String, String> critere = new HashMap<String, String>();

    /**initialisation du tableau des information du clients avec du coté clé les critère et du coté valeurs, le type */
    static {
        critere.put("prenom", "T");
        critere.put("nom", "T");
        critere.put("dateNaissance", "D");      // format "AAAA,MM,JJ"
        critere.put("pays", "T");
        critere.put("gender", "B");             // true = garçon 
        critere.put("pairGender", "B");         // true = garçon
        critere.put("guestAnimalAllergy", "B");
        critere.put("hostHasAnimal", "B");
        critere.put("guestFood", "T");
        critere.put("hostFood", "T");
        critere.put("history", "T");
        critere.put("hobbies", "T");
    }

    /**  constructeur du HashMap (s'il n'existe pas)*/
    public Student() {
        information = new HashMap<>();
    }

    /**  constructeur ajoutant un Student dans la liste HashMap d'étudiants */
    public Student(String prenom, String nom, String dateNaissance, String pays, String gender, String pairGender,
            String guestAnimalAllergy, String hostHasAnimal, String guestFood, String hostFood, String history,
            String hobbies) {
        // appel le constructeur student();
        this();
        try{
            if(!(prenom instanceof String)){
                throw new WrongInformationException("prenom invalide");
            }
            else {information.put("prenom", prenom);}
        }catch(WrongInformationException e){
            System.out.println(e);
        }
        information.put("nom", nom);
        try{
            @SuppressWarnings("unused")
            LocalDate ld=LocalDate.parse(dateNaissance);
            information.put("dateNaissance", dateNaissance);

        }catch(DateTimeParseException e){
            System.out.println("WrongInformationException : date invalide");
        }
        try{

            if(!(pays instanceof String)){
                throw new WrongInformationException("pays invalide");
            }
            information.put("pays", pays);
        }catch(WrongInformationException e){
            System.out.println(e);
        }
        try{
            if(!(gender instanceof String)){
                throw new WrongInformationException("genre invalide");
            }
            information.put("gender", gender);
        }catch(WrongInformationException e){
            System.out.println(e);
        }
        try{
            if((!"true".equals(pairGender)) && (!"false".equals(pairGender))){
                throw new WrongInformationException("pairGender invalide");
            }
            information.put("pairGender", pairGender);
        }catch(WrongInformationException e){
            System.out.println(e);
        }
        try{
            if((!"true".equals(guestAnimalAllergy)) && (!"false".equals(guestAnimalAllergy))){
                throw new WrongInformationException("guestAnimalAllergy invalide");
            }
            information.put("guestAnimalAllergy", guestAnimalAllergy);
        }catch(WrongInformationException e){
            System.out.println(e);
        }
        try{
            if((!"true".equals(hostHasAnimal)) && (!"false".equals(hostHasAnimal))){
                throw new WrongInformationException("hostHasAnimal invalide");
            }
            information.put("hostHasAnimal", hostHasAnimal);
        }catch(WrongInformationException e){
            System.out.println(e);
        }
        try{
            if(!(gender instanceof String)){
                throw new WrongInformationException("guestFood invalide");
            }
            information.put("guestFood", guestFood);
        }catch(WrongInformationException e){
            System.out.println(e);
        }
        try{
            if(!(hostFood instanceof String)){
                throw new WrongInformationException("hostFood invalide");
            }
            information.put("hostFood", hostFood);
        }catch(WrongInformationException e){
            System.out.println(e);
        }
        try{
            if(!(history instanceof String)){
                throw new WrongInformationException("history invalide");
            }
            information.put("history", history);
        }catch(WrongInformationException e){
            System.out.println(e);
        }
        try{
            if(!(hobbies instanceof String)){
                throw new WrongInformationException("hobbies invalide");
            }
            information.put("hobbies", hobbies);
        }catch(WrongInformationException e){
            System.out.println(e);
        }
    }



    /** Définit le prénom de l'étudiant. */
    public void setPrenom(String prenom) {
        information.put("prenom", prenom);
    }

    /** Définit le nom de l'étudiant. */
    public void setNom(String nom) {
        information.put("nom", nom);
    }

    /** Définit la date de naissance de l'étudiant au format ISO (yyyy-MM-dd). */
    public void setDateNaissance(String dateNaissance) {
        information.put("dateNaissance", dateNaissance);
    }

    /** Définit le pays d'origine de l'étudiant. */
    public void setPays(String pays) {
        information.put("pays", pays);
    }

    /** Définit le genre de l'étudiant. */
    public void setGender(String gender) {
        information.put("gender", gender);
    }

    /** Définit le genre du partenaire. */
    public void setPairGender(String pairGender) {
        information.put("pairGender", pairGender);
    }

    /** Définit si l'invité est allergique aux animaux ("true" ou "false"). */
    public void setGuestAnimalAllergy(String guestAnimalAllergy) {
        information.put("guestAnimalAllergy", guestAnimalAllergy);
    }

    /** Définit si l'hôte possède des animaux ("true" ou "false"). */
    public void setHostHasAnimal(String hostHasAnimal) {
        information.put("hostHasAnimal", hostHasAnimal);
    }

    /** Définit les préférences alimentaires de l'invité. */
    public void setGuestFood(String guestFood) {
        information.put("guestFood", guestFood);
    }

    /** Définit les préférences alimentaires de l'hôte. */
    public void setHostFood(String hostFood) {
        information.put("hostFood", hostFood);
    }

    /** Définit l'historique de l'étudiant. */
    public void setHistory(String history) {
        information.put("history", history);
    }

    /** Définit les hobbies de l'étudiant. */
    public void setHobbies(String hobbies){
        information.put("hobbies", hobbies);
    }

    /** Retourne le prénom de l'étudiant. */
    public String getPrenom() {
        return information.get("prenom");
    }

    /** Retourne le nom de l'étudiant. */
    public String getNom() {
        return information.get("nom");
    }

    /** Retourne la date de naissance sous forme d'objet LocalDate. */
    public LocalDate getDateNaissance() {
        return LocalDate.parse(information.get("dateNaissance"));
    }
    public String getDateNaissance(LocalDate dateNaissance){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateNaissance.format(formatter);
    }

    /** Retourne le pays d'origine de l'étudiant. */
    public String getPays() {
        return information.get("pays");
    }

    /** Retourne le genre de l'étudiant. */
    public String getGender() {
        return information.get("gender");
    }

    /** Retourne le genre du partenaire. */
    public String getPairGender() {
        return information.get("pairGender");
    }

    /** Indique si l'invité est allergique aux animaux. */
    public boolean getGuestAnimalAllergy() {
        return information.get("guestAnimalAllergy").equals("true");
    }

    /** Indique si l'hôte possède des animaux. */
    public boolean getHostHasAnimal() {
        return information.get("hostHasAnimal").equals("true");
    }

    /** Retourne les préférences alimentaires de l'invité. */
    public String getGuestFood() {
        return information.get("guestFood");
    }

    /** Retourne les préférences alimentaires de l'hôte. */
    public String getHostFood() {
        return information.get("hostFood");
    }

    /** Retourne l'historique de l'étudiant. */
    public String getHistory() {
        return information.get("history");
    }

    /**retourn la liste de tout les hobbies de l'etudiant */
    public ArrayList<String> getHobbies() {

    ArrayList<String> hobbies = new ArrayList<>();
    String[] hobbie = information.get("hobbies").split(",");

        for (String valeur : hobbie){
            hobbies.add(valeur);
        }
    return hobbies;
    }

    // calculer l'affinité entre deux étudiants (lui avec un autre.)
    public double calculAffinite(Student student) {
        double affinite = 0;

        // Calcul de l'affinité basée sur les genres : 
        // si le genre partenaire correspond au genre de l'autre personne, on ajoute 1.5

        if (this.getPairGender() == student.getGender()) {
            affinite = affinite + 1.5;
        }
        // pareille dans l'autre sens
        if (this.getGender() == student.getPairGender()) {
            affinite = affinite + 1.5;
        }

        // Calcul du nombre de hobbies communs
        int nbCommonHobbies = 0;
        for (int i = 0; i < this.getHobbies().size(); i = i + 1) {
            for (int j = 0; j < student.getHobbies().size(); j = j + 1) {
                // Si un hobby est commun, on ajoute un au compteur
                if (this.getHobbies().get(i).equals(student.getHobbies().get(j))) {
                    nbCommonHobbies = nbCommonHobbies + 1;
                }
            }
        }
        // Selon le nombre de hobbies communs, on augmente l'affinité
        if (nbCommonHobbies == 1) {
            affinite = affinite + 1;
        }
        if (nbCommonHobbies >= 2) {
            affinite = affinite + 2;
        }

        // Calcul de la proximité des dates de naissance (en jours)
        int jourlimit = (int) (365 * 1.5);
        int thisDate = this.getDateNaissance().getYear() * 365 + this.getDateNaissance().getDayOfYear();
        int stdDate = student.getDateNaissance().getYear() * 365 + student.getDateNaissance().getDayOfYear();

        // Si la différence est inférieure à 1.5 an, on ajoute 1 à l'affinité
        if (Math.abs(thisDate - stdDate) < jourlimit) {
            affinite++;
        }

        // Retourne le score total d'affinité calculé
        return affinite;
    }
    
    public String toString(){
        return ""+getPrenom()+"--"+getNom()+"--"+getDateNaissance(getDateNaissance())+"--"+getPays()+"--"+getGender()+"--"+getPairGender()+"--"+getGuestAnimalAllergy()+"--"+getHostHasAnimal()+"--"+getGuestFood()+"--"+getHostFood()+"--"+getHistory()+"--"+getHobbies();
    }
}
