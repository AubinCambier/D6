package sae;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.lang.Math;

public class Student {
    private Map<String, String> information;

    // on instancie tous les criètès d'un étudiant

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
        critere.put("hobbies", "T");
    }

    // constructeur du HashMap (s'il n'existe pas)
    public Student() {
        information = new HashMap<>();
    }

    // constructeur ajoutant un Student dans la liste HashMap d'étudiants
    public Student(String prenom, String nom, String dateNaissance, String pays, String gender, String pairGender,
            String guestAnimalAllergy, String hostHasAnimal, String guestFood, String hostFood, String history,String hobbies) {
        // appel le constructeur student();
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
        information.put("hobbies", hobbies);
    }

    // les setter de chaque information des students
    public void setPrenom(String prenom) {information.put("prenom", prenom);}
    public void setNom(String nom) {information.put("nom", nom);}
    public void setDateNaissance(String dateNaissance) {information.put("dateNaissance", dateNaissance);}
    public void setPays(String pays) {information.put("pays", pays);}
    public void setGender(String gender) {information.put("gender", gender);}
    public void setPairGender(String pairGender) {information.put("pairGender", pairGender);}
    public void setGuestAnimalAllergy(String guestAnimalAllergy) {information.put("guestAnimalAllergy", guestAnimalAllergy);}
    public void setHostHasAnimal(String hostHasAnimal) {information.put("hostHasAnimal", hostHasAnimal);}
    public void setGuestFood(String guestFood) {information.put("guestFood", guestFood);}
    public void setHostFood(String hostFood) {information.put("hostFood", hostFood);}
    public void setHistory(String history) {information.put("history", history);}

    // les getter de chaques information des students
    public String getPrenom() {return information.get("prenom");}
    public String getNom() {return information.get("nom");}
    public LocalDate getDateNaissance() {return LocalDate.parse(information.get("dateNaissance"));}
    public String getPays() {return information.get("pays");}
    public String getGender() {return information.get("gender");}
    public String getPairGender() {return information.get("pairGender");}
    public boolean getGuestAnimalAllergy() {return information.get("guestAnimalAllergy").equals("true");}
    public boolean getHostHasAnimal() {return information.get("hostHasAnimal").equals("true");}
    public String getGuestFood() {return information.get("guestFood");}
    public String getHostFood() {return information.get("hostFood");}
    public String getHistory() {return information.get("history");}

    public ArrayList<String> getHobbies(){
        ArrayList<String> listHobbies = new ArrayList<>();
        String hobbie = "";
        for (int i = 0; i<this.information.get("hobbie").length();i=i+1){
            if (this.information.get("hobbie").charAt(i) == ','){
                listHobbies.add(hobbie);
                hobbie = "";
            }else{
                hobbie = hobbie +this.information.get("hobbie").charAt(i);
            }
        }
        return listHobbies;
    } 

    // calculer l'affinité entre deux étudiants (lui avec un autre.)
    public double calculAffinite(Student student) {
        double affinite = 0;

        //calcul genre
        if (this.getPairGender().equals(student.getGender())){
            affinite = affinite + 1.5;
        }
        if(this.getGender().equals(student.getPairGender())){
            affinite = affinite + 1.5;
        }

        //calcul hobbies
        int nbCommonHobbies = 0;
        for (int i = 0; i<this.getHobbies().size();i=i+1){
            for (int j=0;j<student.getHobbies().size();j=j+1){
                if(this.getHobbies().get(i).equals(student.getHobbies().get(j))){
                    nbCommonHobbies = nbCommonHobbies +1;
                }
            }
        }
        if (nbCommonHobbies == 1){
            affinite = affinite + 1;
        }
        if (nbCommonHobbies >= 2){
            affinite = affinite + 2;
        }

        //calcul date
        int jourlimit = (int) (365*1.5);
        int thisDate = this.getDateNaissance().getYear()*365 + this.getDateNaissance().getDayOfYear();
        int stdDate = student.getDateNaissance().getYear()*365 + student.getDateNaissance().getDayOfYear();

        if(Math.abs(thisDate - stdDate) < jourlimit){
            affinite++;
        }
        //retourne l'affinité de deux personnes
        return affinite;
    }
}
