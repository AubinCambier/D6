package ihm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
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
    @FXML
    Label labelGender;
    @FXML
    Label labelPairGender;
    @FXML
    Label labelFood;
    @FXML
    Label labelGuestFoodConstraint;
    @FXML
    Label labelHobbies;
    @FXML
    CheckBox boxHasAnimal;
    @FXML
    CheckBox boxGuestAnimalAllergy;

    public void initialize(){
        Student s = AppIhm.selectedEtudiant;
        labelName.setText(s.getNom());
        labelForename.setText(s.getPrenom());
        labelCountry.setText(s.getPays());
        labelBirthDate.setText(s.getDateNaissance().toString());
        if("true".equals(s.getGender())){
            labelGender.setText("Male");
        }else{
            labelGender.setText("Female");
        }
        if("true".equals(s.getPairGender())){
            labelPairGender.setText("Male");
        }else{
            labelPairGender.setText("Female");
        }
        labelFood.setText(s.getHostFood());
        labelGuestFoodConstraint.setText(s.getHostFood());
        labelHobbies.setText(s.getHobbies().toString());
        boxHasAnimal.setSelected(s.getHostHasAnimal());
        boxGuestAnimalAllergy.setSelected(s.getGuestAnimalAllergy());
        boxHasAnimal.setDisable(true);
        boxGuestAnimalAllergy.setDisable(true);
    }

    public void pressedButtonMenu(ActionEvent event){
        AppIhm.stageA.setScene(AppIhm.sceneMenu);
    }

    public void pressedButtonRetour(ActionEvent event){
        AppIhm.stageA.setScene(AppIhm.sceneListEtudiants);
    }
}
