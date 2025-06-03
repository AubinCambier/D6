package ihm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sae.Student;

public class ControleurEtudiant {
    @FXML
    Label labelName;
    @FXML
    Label labelForename;
    @FXML
    Label labelCountry;
    @FXML
    Label labelBirthDate;

    public void initialize(){
        Student s = AppIhm.selectedEtudiant;
        labelName.setText(s.getNom());
        labelForename.setText(s.getPrenom());
        labelCountry.setText(s.getPays());
        labelBirthDate.setText(s.getDateNaissance().toString());
    }

    public void pressedButtonMenu(ActionEvent event){
        AppIhm.stageA.setScene(AppIhm.sceneMenu);
    }

    public void pressedButtonRetour(ActionEvent event){
        AppIhm.stageA.setScene(AppIhm.sceneListEtudiants);
    }
}
