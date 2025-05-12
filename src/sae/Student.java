package sae;

import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

public class Student {
    private Map<String, String> information;

    public static Map<String, String> critere = new HashMap<String, String>();

    static {
        critere.put("prenom", "T");
        critere.put("nom", "T");
        critere.put("dateNaissance", "D");
        critere.put("pays", "T");
        critere.put("gender", "B");
        critere.put("pairGender", "B");
        critere.put("guestAnimalAllergy", "B");
        critere.put("hostHasAnimal", "B");
        critere.put("guestFood", "T");
        critere.put("hostFood", "T");
        critere.put("history", "T");
    }

    public Student() {
        information = new HashMap<>();
    }

    public Student(String prenom, String nom, String dateNaissance,
            String pays, String gender, String pairGender,
            String guestAnimalAllergy, String hostHasAnimal,
            String guestFood, String hostFood, String history) {
        this();
        information.put("prenom", prenom);
        information.put("nom", nom);
        information.put("dateNaissance", dateNaissance);
        information.put("pays", pays);
        information.put("gender", gender);
        information.put("pairGender", pairGender);
        information.put("guestAnimalAllergy", guestAnimalAllergy);
        information.put("hostHasAnimal", hostHasAnimal);
        information.put("guestFood", guestFood);
        information.put("hostFood", hostFood);
        information.put("history", history);
    }

    public void setPrenom(String prenom) {
        information.put("prenom", prenom);
    }

    public void setNom(String nom) {
        information.put("nom", nom);
    }

    public void setDateNaissance(String dateNaissance) {
        information.put("dateNaissance", dateNaissance);
    }

    public void setPays(String pays) {
        information.put("pays", pays);
    }

    public void setGender(String gender) {
        information.put("gender", gender);
    }

    public void setPairGender(String pairGender) {
        information.put("pairGender", pairGender);
    }

    public void setGuestAnimalAllergy(String guestAnimalAllergy) {
        information.put("guestAnimalAllergy", guestAnimalAllergy);
    }

    public void setHostHasAnimal(String hostHasAnimal) {
        information.put("hostHasAnimal", hostHasAnimal);
    }

    public void setGuestFood(String guestFood) {
        information.put("guestFood", guestFood);
    }

    public void setHostFood(String hostFood) {
        information.put("hostFood", hostFood);
    }

    public void setHistory(String history) {
        information.put("history", history);
    }

    public String getPrenom() {
        return information.get("prenom");
    }

    public String getNom() {
        return information.get("nom");
    }

    public LocalDate getDateNaissance() {
        return LocalDate.parse(information.get("dateNaissance"));
    }

    public String getPays() {
        return information.get("pays");
    }

    public String getGender() {
        return information.get("gender");
    }

    public String getPairGender() {
        return information.get("pairGender");
    }

    public boolean getGuestAnimalAllergy() {
        return information.get("guestAnimalAllergy").equals("true");
    }

    public boolean getHostHasAnimal() {
        return information.get("hostHasAnimal").equals("true");
    }

    public String getGuestFood() {
        return information.get("guestFood");
    }

    public String getHostFood() {
        return information.get("hostFood");
    }

    public String getHistory() {
        return information.get("history");
    }

    public int calculAffinite(Student student) {
        // ....
        return 0;
    }
}
