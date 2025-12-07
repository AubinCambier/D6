
package ihm;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sae.Affectation;
import sae.ListAffectation;
import sae.Student;
/**
 * Classe principale de m'application Javafx
 * @author <a href="mailto:aubin2109@gmail.com">Aubin B</a>
 * @author <a href="mailto:matheo778@gmail.com ">Mathéo D</a>
 * @author <a href="calmatthieu@yahoo.com ">Mathieu C</a>
 * @author <a href="aymericjacquey@gmail.com  ">Aymeric C</a>
 * @version 21.0.7
 */
public class AppIhm extends Application {

    // Déclaration des scènes et du stage principal
    /**
     * Stage principal de l'application.
     */
    public static Stage primaryStage;

    /**
     * Scènes utilisées dans l'application.
     */
    public static Scene sceneMenu;
    public static Scene sceneListEtudiants;
    public static Scene sceneEtudiant;
    public static Scene sceneCriteres;
    public static Scene sceneListAppariements;

    /**
     * Historique des scènes précédentes.
     * Permet de naviguer en arrière.
     */
    public static ArrayList<Scene> lastScenes = new ArrayList<>();

    // Déclaration des données manipulées par l'application
    /**
     * Liste des affectations.
     */
    public static ListAffectation listAffectation;

    /**
     * Liste des étudiants.
     */
    public static ArrayList<Student> students;

    /**
     * Liste des affectations générales.
     */
    public static ArrayList<Affectation> affectations;

    /**
     * Liste des affectations fixées.
     */
    public static ArrayList<Affectation> affectationsFixer = new ArrayList<>();

    /**
     * Liste des affectations à éviter.
     */
    public static ArrayList<Affectation> affectationsEviter = new ArrayList<>();

    /**
     * Étudiant sélectionné.
     */
    public static Student selectedEtudiant;

    /**
     * Map des critères activés.
     * Permet d'activer ou de désactiver certains filtres.
     */
    public static Map<String, Boolean> enableCriteres = new HashMap<>();

    /**
     * Map des valeurs des critères.
     * Permet de stocker la valeur des critères.
     */
    public static Map<String, Integer> valuesCriteres = new HashMap<>();

    // Initialisation des critères par défaut
    static {
        enableCriteres.put("hobbies", Boolean.TRUE);
        enableCriteres.put("gender", Boolean.TRUE);
        enableCriteres.put("birthDate", Boolean.TRUE);
        enableCriteres.put("animalAllergy", Boolean.TRUE);
        enableCriteres.put("food", Boolean.TRUE);

        valuesCriteres.put("hobbies",1);
        valuesCriteres.put("gender",1);
        valuesCriteres.put("birthDate",1);
        valuesCriteres.put("animalAllergy",1);
        valuesCriteres.put("food",1);
    }

    /**
     * Initialise et affiche l'interface graphique.
     * @param stage Le stage principal de l'application.
     * @throws IOException En cas d'erreur de chargement des fichiers FXML.
     */
    public void start(Stage stage) throws IOException {
        // Assigner le stage principal fourni par JavaFX
        primaryStage = stage;

        // Chargement des données depuis un fichier CSV
        ListAffectation list = new ListAffectation();
        list.chargerCSV("infoetu.csv");
        students = list.getStudents();
        affectations = list.getAffectations();

        // Ajout manuel d'une affectation
        affectations.add(new Affectation(students.get(3), students.get(6)));

        // Initialisation des différentes scènes
        sceneCriteres = initializeScene("fxml/critere.fxml");
        sceneListAppariements = initializeScene("fxml/listAppariements.fxml");
        sceneListEtudiants = initializeScene("fxml/listEtudiants.fxml");

        // Chargement du menu principal
        FXMLLoader loader = new FXMLLoader();
        URL fxmlFileUrl = getClass().getResource("fxml/menu.fxml");
        if (fxmlFileUrl == null) {
            System.out.println("Impossible de charger le fichier fxml: menu.fxml");
            System.exit(-1);
        }
        loader.setLocation(fxmlFileUrl);
        Parent root = loader.load();
        sceneMenu = new Scene(root);

        // Configuration et affichage du stage principal
        primaryStage.setScene(sceneMenu);
        primaryStage.setTitle("Sae");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Charge une scène à partir d'un fichier FXML.
     * @param fxmlPath Le chemin du fichier FXML.
     * @return La scène chargée.
     */
    private Scene initializeScene(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader();
        URL fxmlFileUrl = getClass().getResource(fxmlPath);
        if (fxmlFileUrl == null) {
            System.err.println("Impossible de charger le fichier fxml : " + fxmlPath);
            // Il est préférable de lancer une exception ou de quitter proprement
            // plutôt que de retourner null et de risquer un NullPointerException plus tard.
            System.exit(-1);
            return null; // Inatteignable, mais garde le compilateur content.
        }
        loader.setLocation(fxmlFileUrl);
        try {
            return new Scene(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1); // Quitter si une scène essentielle ne peut être chargée.
            return null;
        }
    }

    /**
     * Point d'entrée de l'application.
     * @param args Arguments de la ligne de commande.
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
