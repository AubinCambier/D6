package ihm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
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
    }

    public void pressedButtonMenu(ActionEvent event){
        AppIhm.stageA.setScene(AppIhm.sceneMenu);
    }

    public void pressedButtonRetour(ActionEvent event){
        AppIhm.stageA.setScene(AppIhm.sceneMenu);
    }

    public void pressedFixerAjouter(ActionEvent event){
        HBox h = new HBox();
        ChoiceBox<Student> choiceBox1 = new ChoiceBox<Student>();
        ChoiceBox<Student> choiceBox2 = new ChoiceBox<Student>();
        
        choiceBox1.getItems().addAll(AppIhm.students);
        choiceBox2.getItems().addAll(AppIhm.students);

        h.getChildren().addAll(choiceBox1,choiceBox2);

        listViewFixer.getItems().add(h);
    }

    public void pressedEviterAjouter(ActionEvent event){
        HBox h = new HBox();
        ChoiceBox<Student> choiceBox1 = new ChoiceBox<Student>();
        ChoiceBox<Student> choiceBox2 = new ChoiceBox<Student>();
        
        choiceBox1.getItems().addAll(AppIhm.students);
        choiceBox2.getItems().addAll(AppIhm.students);

        h.getChildren().addAll(choiceBox1,choiceBox2);

        listViewEviter.getItems().add(h);
    }
}
