package ihm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import sae.Affectation;
import sae.Student;

public class ControleurCriteres {
    @FXML
    Button buttonMenu;
    @FXML
    Button buttonRetour;
    @FXML
    ListView<HBox> listViewFixer;
    @FXML
    ListView<HBox> listViewEviter;
    @FXML
    CheckBox checkboxHobbies;
    @FXML
    CheckBox checkboxGender;
    @FXML
    CheckBox checkboxBirthDate;
    @FXML
    CheckBox checkboxAnimalAllergy;
    @FXML
    CheckBox checkboxFood;

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

        checkboxHobbies.setSelected(true);
        checkboxGender.setSelected(true);
        checkboxBirthDate.setSelected(true);
        checkboxAnimalAllergy.setSelected(true);
        checkboxFood.setSelected(true);
    }

    public void pressedButtonMenu(ActionEvent event){
        AppIhm.lastScenes.add(AppIhm.sceneCriteres);
        AppIhm.stageA.setScene(AppIhm.sceneMenu);
    }

    public void pressedButtonRetour(ActionEvent event){
        if(!AppIhm.lastScenes.isEmpty())
        {
            AppIhm.stageA.setScene(AppIhm.lastScenes.getLast());
            AppIhm.lastScenes.removeLast();
        }
    }

    public void pressedFixerAjouter(ActionEvent event){
        HBox h = new HBox();
        ChoiceBox<Student> choiceBox1 = new ChoiceBox<Student>();
        ChoiceBox<Student> choiceBox2 = new ChoiceBox<Student>();
        Button buttonPlus = new Button("+");
        
        choiceBox1.getItems().addAll(AppIhm.students);
        choiceBox2.getItems().addAll(AppIhm.students);
        
        h.getChildren().addAll(choiceBox1,choiceBox2,buttonPlus);

        buttonPlus.setOnAction(e -> {
            Student student1 = choiceBox1.getValue();
            Student student2 = choiceBox2.getValue();

            Affectation affect = new Affectation(student1, student2);

            AppIhm.affectations.add(affect);
            AppIhm.affectationsFixer.add(affect);

            h.getChildren().removeAll(choiceBox1,choiceBox2,buttonPlus);
            Label labelStudent1 = new Label(student1.toString());
            Label labelStudent2 = new Label(student2.toString());
            h.getChildren().addAll(labelStudent1,new Label("     "),labelStudent2);
        });

        listViewFixer.getItems().add(h);
    }

    public void pressedEviterAjouter(ActionEvent event){
        HBox h = new HBox();
        ChoiceBox<Student> choiceBox1 = new ChoiceBox<Student>();
        ChoiceBox<Student> choiceBox2 = new ChoiceBox<Student>();
        Button buttonPlus = new Button("+");
        
        choiceBox1.getItems().addAll(AppIhm.students);
        choiceBox2.getItems().addAll(AppIhm.students);
        
        h.getChildren().addAll(choiceBox1,choiceBox2,buttonPlus);

        buttonPlus.setOnAction(e -> {
            Student student1 = choiceBox1.getValue();
            Student student2 = choiceBox2.getValue();

            Affectation affect = new Affectation(student1, student2);

            AppIhm.affectationsEviter.add(affect);

            h.getChildren().removeAll(choiceBox1,choiceBox2,buttonPlus);
            Label labelStudent1 = new Label(student1.toString());
            Label labelStudent2 = new Label(student2.toString());
            h.getChildren().addAll(labelStudent1,new Label("     "),labelStudent2);
        });

        listViewEviter.getItems().add(h);
    }

    public void pressedFixerSupprimer(ActionEvent event){
        if(!listViewFixer.getItems().isEmpty())
        {
            listViewFixer.getItems().removeLast();
            if(!AppIhm.affectationsFixer.isEmpty()){
                AppIhm.affectations.remove(AppIhm.affectationsFixer.getLast());
                AppIhm.affectationsFixer.removeLast();
            }
            
        }
        
    }

    public void pressedEviterSupprimer(ActionEvent event){
        if(!listViewEviter.getItems().isEmpty())
        {
            listViewEviter.getItems().removeLast();
            if(!AppIhm.affectationsEviter.isEmpty()){
                AppIhm.affectationsEviter.removeLast();
            }
            
        }
    }

    public void pressedEtudiants(ActionEvent event){
        AppIhm.lastScenes.add(AppIhm.sceneCriteres);
        AppIhm.stageA.setScene(AppIhm.sceneListEtudiants);
    }

    public void pressedListeAppariements(ActionEvent event){
        AppIhm.lastScenes.add(AppIhm.sceneCriteres);
        AppIhm.stageA.setScene(AppIhm.sceneListAppariements);
    }

    public void pressedCheckboxHobbies(ActionEvent event){
        AppIhm.enableCriteres.put("hobbies",checkboxHobbies.isSelected());
    }

    public void pressedCheckboxGender(ActionEvent event){
        AppIhm.enableCriteres.put("gender",checkboxGender.isSelected());
    }

    public void pressedCheckboxBirthDate(ActionEvent event){
        AppIhm.enableCriteres.put("birthDate",checkboxBirthDate.isSelected());
    }

    public void pressedCheckboxAnimalAllergy(ActionEvent event){
        AppIhm.enableCriteres.put("animalAllergy",checkboxAnimalAllergy.isSelected());
    }

    public void pressedCheckboxFood(ActionEvent event){
        AppIhm.enableCriteres.put("food",checkboxFood.isSelected());
    }
}
