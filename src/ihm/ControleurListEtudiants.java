package ihm;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import sae.ListAffectation;
import sae.Student;

public class ControleurListEtudiants {
    @FXML
    ListView<HBox> etudiants;

    public void initialize() {
        ListAffectation list = new ListAffectation();
        list.chargerCSV("infoetu.csv");
        ArrayList<Student> students = list.getStudents();

        for(Student s: students){
            addListStudent(s);
        }
    }

    public void addListStudent(Student student){
        HBox h = new HBox();
        Label nom = new Label(student.getNom());
        Label prenom = new Label(student.getPrenom());
        ImageView image = null;
        try{
            image = new ImageView(new Image("file:doc/img/icone_personne.jpg"));
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        

        h.getChildren().addAll(nom,prenom,image);
        etudiants.getItems().add(h);
    }
}
