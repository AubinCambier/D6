package ihm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sae.Student;

public class ControleurEtudiant {
    @FXML
    Button buttonMenu;
    @FXML
    Button buttonRetour;
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

    public void pressedButtonMenu(ActionEvent event){
        AppIhm.lastScenes.add(AppIhm.sceneEtudiant);
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
        AppIhm.lastScenes.add(AppIhm.sceneEtudiant);
        AppIhm.stageA.setScene(AppIhm.sceneListEtudiants);
    }

    public void pressedListeAppariements(ActionEvent event){
        AppIhm.lastScenes.add(AppIhm.sceneEtudiant);
        AppIhm.stageA.setScene(AppIhm.sceneListAppariements);
    }

    public void pressedCriteres(ActionEvent event){
        AppIhm.lastScenes.add(AppIhm.sceneEtudiant);
        AppIhm.stageA.setScene(AppIhm.sceneCriteres);
    }
}
