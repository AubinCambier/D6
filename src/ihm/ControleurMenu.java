package ihm;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ControleurMenu {
    
    public void buttonEtudiants(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        URL fxmlFileUrl = getClass().getResource("fxml/ListEtudiants.fxml");
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
        
        AppIhm.sceneListEtudiants = new Scene(root);
        
        AppIhm.stageA.setScene(AppIhm.sceneListEtudiants);
    }

    public void buttonCriteres(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        URL fxmlFileUrl = getClass().getResource("fxml/critere.fxml");
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
        
        AppIhm.sceneCriteres = new Scene(root);
        
        AppIhm.stageA.setScene(AppIhm.sceneCriteres);
    }
}
