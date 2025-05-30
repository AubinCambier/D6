package sae;

public class Main {
    public static void main(String[] args) {
        ListAffectation list = new ListAffectation();
        list.chargerCSV("infoetu.csv");
        System.out.println(list.toStringStudents());
        System.out.println("------\n");
        list.affectationStudents();
        System.out.println(list.toStringAffectation());
        System.out.println("------\n");
        
        list.selectionStudents(2);
        list.exportLisAffectation("affectation.csv");
        System.out.println("------\n");
        System.out.println(list.toStringStudents());
    }
}
