package ihm;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;


public class ControleurListAparaiement{
    @FXML
    private Button boutonCalculerApparaiement;

    @FXML
    private ComboBox<String> comboBoxCritere1;
    @FXML
    private ComboBox<String> comboBoxCritere2;
    @FXML
    private ComboBox<String> comboBoxCritere3;
    @FXML
    private ComboBox<String> comboBoxCritere4;
    @FXML
    private ComboBox<String> comboBoxCritere5;
    @FXML
    public void initialize() {
        System.out.println("Contrôleur initialisé !");
        comboBoxCritere1.getItems().addAll("1","2","3","4","5");
        comboBoxCritere2.getItems().addAll("1","2","3","4","5");
        comboBoxCritere3.getItems().addAll("1","2","3","4","5");
        comboBoxCritere4.getItems().addAll("1","2","3","4","5");
        comboBoxCritere5.getItems().addAll("1","2","3","4","5");
    }
    /**
     * methode permettant de dire ce qu'on dois faire quand le critere 1 a été coché
     * @param event
     */
    @FXML
    public void CheckboxCritere1Dropped(javafx.scene.input.DragEvent event){

    }
    @FXML
    private void handleButtonClick() {
        System.out.println("Bouton cliqué !");
    }
}
