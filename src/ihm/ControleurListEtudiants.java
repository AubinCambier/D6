package ihm;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import sae.Student;

public class ControleurListEtudiants {

    @FXML
    Button buttonMenu;
    @FXML
    Button buttonRetour;
    @FXML
    ListView<BorderPane> etudiants;
    @FXML
    HBox boxListEtudiants;

    public void initialize() {
        for(Student s: AppIhm.students){
            addListStudent(s);
        }

        ImageView imageMenu = null;
        try{
            imageMenu = new ImageView(new Image("file:doc/img/Menu.png"));
            imageMenu.setFitWidth(30);
            imageMenu.setFitHeight(30);
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        buttonMenu.setGraphic(imageMenu);
        buttonMenu.setText("");

        ImageView imageRetour = null;
        try{
            imageRetour = new ImageView(new Image("file:doc/img/retour.png"));
            imageRetour.setFitWidth(30);
            imageRetour.setFitHeight(30);
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        buttonRetour.setGraphic(imageRetour);
        buttonRetour.setText("");
    }

    public void addListStudent(Student student){
        BorderPane bp = new BorderPane();
        Label nom = new Label(student.getNom() + " " + student.getPrenom());
        ImageView image = null;
        try{
            image = new ImageView(new Image("file:doc/img/icone_personne.jpg"));
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        image.setFitWidth(50);
        image.setFitHeight(50);

        bp.setCenter(nom);
        bp.setRight(image);

        bp.setOnMouseClicked(e -> {
            int i = etudiants.getSelectionModel().getSelectedIndices().get(0);
            AppIhm.selectedEtudiant = AppIhm.students.get(i);

            FXMLLoader loader = new FXMLLoader();
            URL fxmlFileUrl = getClass().getResource("fxml/etudiant.fxml");
            if (fxmlFileUrl == null) {
                    System.out.println("Impossible de charger le fichier fxml");
                    System.exit(-1);
            }
            loader.setLocation(fxmlFileUrl);
            Parent root = null;
            try{
                root = loader.load();
            }catch(IOException io){
                io.printStackTrace();
            }
            
            AppIhm.sceneEtudiant = new Scene(root);
            
            AppIhm.lastScenes.add(AppIhm.sceneListEtudiants);
            AppIhm.stageA.setScene(AppIhm.sceneEtudiant);
        });

        etudiants.getItems().add(bp);
    }

    public void pressedButtonMenu(ActionEvent event){
        AppIhm.lastScenes.add(AppIhm.sceneListEtudiants);
        AppIhm.stageA.setScene(AppIhm.sceneMenu);
    }

    public void pressedButtonRetour(ActionEvent event){
        if(!AppIhm.lastScenes.isEmpty())
        {
            AppIhm.stageA.setScene(AppIhm.lastScenes.getLast());
            AppIhm.lastScenes.removeLast();
        }
    }

    public void pressedEtudiants(ActionEvent event){

    }

    public void pressedListeAppariements(ActionEvent event){
        AppIhm.lastScenes.add(AppIhm.sceneListEtudiants);
        AppIhm.stageA.setScene(AppIhm.sceneListAppariements);
    }

    public void pressedCriteres(ActionEvent event){
        AppIhm.lastScenes.add(AppIhm.sceneListEtudiants);
        AppIhm.stageA.setScene(AppIhm.sceneCriteres);
    }
}
