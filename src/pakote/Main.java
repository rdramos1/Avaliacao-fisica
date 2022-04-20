package pakote;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    private static Scene scene; 

    private static Stage PStage;

    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFXML("Screen"));
        stage.setScene(scene);
        stage.show();
        PStage = stage;
        stage.setTitle("Avaliaçoes");
        
    }
    public static Stage GetStage(){
        return PStage;
    }
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
   
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
   
    public static void main(String[] args) {
        launch(args);
    }
    
}
