package ihm;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import sae.ListAffectation;
import sae.Student;

public class ControleurListEtudiants {
    @FXML
    ListView<BorderPane> etudiants;

    public void initialize() {
        ListAffectation list = new ListAffectation();
        list.chargerCSV("infoetu.csv");
        ArrayList<Student> students = list.getStudents();

        for(Student s: students){
            addListStudent(s);
        }
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
        etudiants.getItems().add(bp);
    }
}
