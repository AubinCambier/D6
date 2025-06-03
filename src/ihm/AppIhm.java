
package ihm;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sae.Affectation;
import sae.ListAffectation;
import sae.Student;

public class AppIhm extends Application {
        public static Stage stageA = new Stage();
        public static Scene sceneMenu;
        public static Scene sceneListEtudiants;
        public static Scene sceneEtudiant;
        public static Scene sceneCriteres;
        public static Scene sceneListAppariements;

        public static ListAffectation listAffectation;
        public static ArrayList<Student> students;
        public static ArrayList<Affectation> affectations;
        public static ArrayList<Affectation> affectationsFixer;
        public static ArrayList<Affectation> affectationsEviter;

        public static Student selectedEtudiant;

        public void start(Stage stage) throws IOException {
                FXMLLoader loader = new FXMLLoader();
                URL fxmlFileUrl = getClass().getResource("fxml/menu.fxml");
                if (fxmlFileUrl == null) {
                        System.out.println("Impossible de charger le fichier fxml");
                        System.exit(-1);
                }
                loader.setLocation(fxmlFileUrl);
                Parent root = loader.load();

                sceneMenu = new Scene(root);
                
                stageA.setScene(sceneMenu);
                stageA.setTitle("Sae");
                stageA.show();

                ListAffectation list = new ListAffectation();
                list.chargerCSV("infoetu.csv");
                students = list.getStudents();
                affectations = list.getAffectations();

                affectations.add(new Affectation(students.get(3),students.get(6)));

                affectationsFixer = new ArrayList<>();
                affectationsEviter = new ArrayList<>();

                //Initialisation Stage
                loader = new FXMLLoader();
                fxmlFileUrl = getClass().getResource("fxml/critere.fxml");
                if (fxmlFileUrl == null) {
                        System.out.println("Impossible de charger le fichier fxml");
                        System.exit(-1);
                }
                loader.setLocation(fxmlFileUrl);
                Parent root2 = null;
                try{
                        root2 = loader.load();
                }catch(IOException e){
                        e.printStackTrace();
                }
                sceneCriteres = new Scene(root2);

                loader = new FXMLLoader();
                fxmlFileUrl = getClass().getResource("fxml/listAppariements.fxml");
                if (fxmlFileUrl == null) {
                        System.out.println("Impossible de charger le fichier fxml");
                        System.exit(-1);
                }
                loader.setLocation(fxmlFileUrl);
                Parent root3 = null;
                try{
                        root3 = loader.load();
                }catch(IOException e){
                        e.printStackTrace();
                }
                sceneListAppariements = new Scene(root3);
        
                loader = new FXMLLoader();
                fxmlFileUrl = getClass().getResource("fxml/listEtudiants.fxml");
                if (fxmlFileUrl == null) {
                        System.out.println("Impossible de charger le fichier fxml");
                        System.exit(-1);
                }
                loader.setLocation(fxmlFileUrl);
                Parent root4 = null;
                try{
                        root4 = loader.load();
                }catch(IOException e){
                        e.printStackTrace();
                }
                sceneListEtudiants = new Scene(root4);
        }

        public static void main(String[] args) {
                Application.launch(args);
        }
}