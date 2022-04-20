package pakote;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controler implements Initializable {

    @FXML
    private Label lblalt;

    @FXML
    private Label lblpes;    

    @FXML
    private ListView<String> list;

    @FXML
    private AnchorPane criar;

    @FXML
    private AnchorPane home;

    @FXML
    private TextField alt;

    @FXML
    private TextField peso;

    @FXML
    private AnchorPane open;
        
    private arquivo arq = new arquivo();

    @FXML
    private void Save(ActionEvent e){
        String nome;
        TextInputDialog dialogoNome = new TextInputDialog();
            dialogoNome.setTitle("");
            dialogoNome.setHeaderText("Digite o nome do arquivo");
            dialogoNome.setContentText("Nome:");
            dialogoNome.showAndWait();

        nome = dialogoNome.getResult();
        System.out.println(nome);
        arq.CreateFile(nome);
        arq.WriteFile("Altura", alt.getText());
        arq.WriteFile("Peso", peso.getText());
    }
    @FXML
    public void SetPath(MouseEvent e) {
        arq.SetPath();
    }
    @FXML
    private void ircriar(ActionEvent e){
        criar.setVisible(true);
        home.setVisible(false);
        open.setVisible(false);
    }
    @FXML
    private void irhome(ActionEvent e){
        criar.setVisible(false);
        home.setVisible(true);
        open.setVisible(false);
        list.getItems().clear();
        arq.ListFile(list);
    }
    @FXML
    private void atlz(ActionEvent e) {
        list.getItems().clear();
        arq.ListFile(list);
    }
    @FXML
    private void delfile(ActionEvent e){
        arq.DeleteFile(list.getSelectionModel().getSelectedItem());
        list.getItems().remove(list.getSelectionModel().getSelectedItem());
    }
    @FXML
    private void EdFeli(ActionEvent e){
        criar.setVisible(true);
        home.setVisible(false);
        open.setVisible(false);

        arq.SetFile(list.getSelectionModel().getSelectedItem());
        
        alt.setText(arq.ReadFile("Altura"));
        peso.setText(arq.ReadFile("Peso"));
    }
    @FXML
    private void OpenFile(ActionEvent e) {
        open.setVisible(true);
        criar.setVisible(false);
        home.setVisible(false);
        arq.SetFile(list.getSelectionModel().getSelectedItem());
        
        lblalt.setText(arq.ReadFile("Altura"));
        lblpes.setText(arq.ReadFile("Peso"));
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        arq.ExisPath();
        arq.ListFile(list);
        criar.setVisible(false);
        home.setVisible(true);
    }    
    
}
