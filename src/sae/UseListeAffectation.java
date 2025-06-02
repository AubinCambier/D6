package sae;

public class UseListeAffectation {
    public static void main(String[] args) {
        System.out.println("--On charge le fichier des étudiants--");
        ListAffectation list = new ListAffectation();
        list.chargerCSV("infoetu.csv");

        System.out.println("--On peut affichier les étudiants--");
        System.out.println(list.toStringStudents());
        System.out.println("------\n");

        System.out.println("--On calcul le nombre d'étudiant hote et visiteur--");
        list.calculerNbStudent();
        System.out.println("--Puis on peut supprimer des élèves si nécessaire--");
        // a faire une methode pour retirer un élève qui possèdes un critère en particulier. (qui est de France ou Italie) pour avoir le meme nombre

        System.out.println("--On créé toutes les affectation entre les étudiants puis on les affiches--");
        list.affectationStudents();
        System.out.println(list.toStringAffectation());
        System.out.println("------\n");

        System.out.println("--on réalise les meilleurs affectations entre les étudiants--");
        // a finir trouver la meilleur affectation possible avec l'aide du parcour de graphe CalculAffectation<S> du .jar dans graphe        
        list.trieAffectation();     
        System.out.println(list.toStringAffectation());

        System.out.println("--retirer des étudiants si besoins--");
        list.selectionStudents(2);

        // apres modification, faut refaire les affectations


        // — Afficher les contraintes rédhibitoires non satisfaites.        a faire

        System.out.println("--créé un fichier csv des affectation entre les étudiants--");
        list.exportLisAffectation("affectation.csv");
        System.out.println(list.toStringStudents());
    }
}
