
package ihm;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sae.Student;

public class AppIhm extends Application {
        public static Stage stageA = new Stage();
        public static Scene sceneMenu;
        public static Scene sceneListEtudiants;
        public static Scene sceneEtudiant;

        public static Student selectedEtudiant;

        public void start(Stage stage) throws IOException {
                FXMLLoader loader = new FXMLLoader();
                URL fxmlFileUrl = getClass().getResource("menu.fxml");
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
        }

        public static void main(String[] args) {
                Application.launch(args);
        }
}