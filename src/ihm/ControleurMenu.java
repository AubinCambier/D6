package ihm;

import javafx.event.ActionEvent;


public class ControleurMenu {
    
    public void buttonEtudiants(ActionEvent event){   
        AppIhm.stageA.setScene(AppIhm.sceneListEtudiants);
    }

    public void buttonListAppariements(ActionEvent event){
        AppIhm.stageA.setScene(AppIhm.sceneListAppariements);
    }

    public void buttonCriteres(ActionEvent event){
        AppIhm.stageA.setScene(AppIhm.sceneCriteres);
    }
}
