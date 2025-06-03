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
import sae.Affectation;

public class ControleurListAppariements {
    @FXML
    Button buttonMenu;
    @FXML
    Button buttonRetour;
    @FXML
    ListView<BorderPane> appariements;

    public void initialize(){
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

        for(Affectation a: AppIhm.affectations){
            addAppariements(a);
        }
    }

    public void pressedButtonMenu(ActionEvent event){
        AppIhm.stageA.setScene(AppIhm.sceneMenu);
    }

    public void pressedButtonRetour(ActionEvent event){
        AppIhm.stageA.setScene(AppIhm.sceneMenu);
    }

    public void pressedButtonReload(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        URL fxmlFileUrl = getClass().getResource("fxml/listAppariements.fxml");
        if (fxmlFileUrl == null) {
                System.out.println("Impossible de charger le fichier fxml");
                System.exit(-1);
        }
        loader.setLocation(fxmlFileUrl);
        Parent root = null;
        try{
                root = loader.load();
        }catch(IOException e){
                e.printStackTrace();
        }

        AppIhm.sceneListAppariements = new Scene(root);
        AppIhm.stageA.setScene(AppIhm.sceneListAppariements);
    }

    public void addAppariements(Affectation a){
        BorderPane bp = new BorderPane();
        Label nomHote = new Label(a.getHote().toString());
        Label nomVisiteur = new Label(a.getVisiteur().toString());
        Label affinite = new Label("" + a.getAffinite());

        bp.setLeft(nomHote);
        bp.setCenter(nomVisiteur);
        bp.setRight(affinite);

        appariements.getItems().add(bp);
    }
}
