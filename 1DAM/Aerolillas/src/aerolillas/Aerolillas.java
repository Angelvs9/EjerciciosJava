package aerolillas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.image.ImageView;


public class Aerolillas extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/scenes/IdaVuelta.fxml"));//escena 1 de ida y de vuelta
        stage.setResizable(false);
        
        
        stage.setTitle("Aerolillas");
        Image icono = new Image("/img/avionIcono.png");
        stage.getIcons().add(icono);

        
        
        Scene scene = new Scene(root);
       
        stage.setScene(scene); //escena 1
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
