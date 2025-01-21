
package xmlControllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.apache.commons.codec.digest.DigestUtils;
import utilidades.bbdd.Bd;
import utilidades.bbdd.Gestor_conexion_POSTGRE;

/**
 *
 * @author Angel
 */
public class ControllerLogin2 {
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private Button botonAnterior1;
    
    @FXML
    private Label labelNoTrabajadores;
     
    @FXML
    private TextField inputUsuarioTrabajadores;
    
    @FXML
    private PasswordField inputPasswordTrabajadores;
    
    @FXML
    private void goToScreenAnterior1() {
        try {
            // Carga la nueva pantalla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/IdaVuelta.fxml"));
            Parent idaVueltaPantalla = loader.load();
            
            // Configura una nueva escena con la pantalla cargada
            Scene scene = new Scene(idaVueltaPantalla);
            
            // Obtiene el escenario (Stage) actual y establecer la nueva escena
            Stage stage = (Stage) botonAnterior1.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
        }
    }
    
    @FXML
    private void goToScreenVuelosAzafata() {
        try {
            // Carga la nueva pantalla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/VuelosAzafata.fxml"));
            Parent vuelosAzafataPantalla = loader.load();
            
            // Configura una nueva escena con la pantalla cargada
            Scene scene = new Scene(vuelosAzafataPantalla);
            
            // Crea un nuevo escenario (Stage) y establece la nueva escena
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void primerEstilo(ActionEvent event) {
       anchorPane.getStylesheets().clear();
       anchorPane.getStylesheets().add("/styles/estilo.css");
    } 
    
    public void MostrarImagenLogin(ImageView i){
        //las imagenes estarán todas en la carpeta img
        Image login = new Image (getClass().getResourceAsStream("/img/log.png"));
        i.setImage(login);
        i.setVisible(true);
    }
    
    
    @FXML
    private void goToScreenVuelosPiloto() {
        try {
            // Carga la nueva pantalla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/VuelosPiloto.fxml"));
            Parent vuelosPilotoPantalla = loader.load();

            // Configura una nueva escena con la pantalla cargada
            Scene scene = new Scene(vuelosPilotoPantalla);

            // Crea un nuevo escenario (Stage) y establece la nueva escena
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void inicioSesionPilotoAzafata(){
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego", false); 
        String vecpiloto[][];
        String vecazafata[][];
        try{
            String passwordTrabajadores = DigestUtils.sha256Hex(inputPasswordTrabajadores.getText());
            String contrasenaBdPiloto = "select passwdCorreoPiloto from piloto where correopiloto = '" +inputUsuarioTrabajadores.getText() + "'";
            String contrasenaBdAzafata = "select passwdCorreo from azafata where correo ='" + inputUsuarioTrabajadores.getText() + "'";
            vecazafata=Bd.consultaSelect(gest,contrasenaBdAzafata);
            vecpiloto=Bd.consultaSelect(gest,contrasenaBdPiloto);

                if (vecpiloto==null && vecazafata!=null) {
                    if (passwordTrabajadores.equals(vecazafata[0][0])) {
                        System.out.println("estamos dentro azafata");
                        goToScreenVuelosAzafata(); 
                    }
                }
                else if(vecpiloto!=null && vecazafata==null){
                    if (passwordTrabajadores.equals(vecpiloto[0][0])) {
                        System.out.println("estamos dentor piloto");
                        goToScreenVuelosPiloto();
                    }
                }
        }
        
        catch(NullPointerException n){
            labelNoTrabajadores.setVisible(true);
        }
        gest.cerrar_Conexion(true);
    }

    
}
