package aerolillas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
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
import javafx.scene.control.ListView;

public class FXMLDocumentController implements Initializable {

    //PARA EL METODO QUE VERIFICA EL INICIO DE SESION
    @FXML
    private Label lblNo;
    
    @FXML
    private Label labelNo;
    
    @FXML
    private PasswordField inputPassword;
    
    @FXML
    private TextField inputUsuario;
    

       
    //PARA EL METODO QUE REGISTRA EL USUARIO


      
    
    //BOTONES DE LAS PANTALLAS PARA LOS CAMBIOS DE ESCENA

    
    @FXML
    private Button botonAnterior1;
    
    @FXML
    private Button botonAnterior2;
    
    @FXML
    private Button botonVuelosPiloto;
    
    @FXML
    private Button botonVuelosAzafata;
    
    @FXML
    private Button botonIrRegistro;
   

    
    @FXML
    private ListView<String> vuelosListView;
    
    
    //PARA LOS ESTILOS
    @FXML
    private AnchorPane anchorPane;

    
    /*@FXML
    ImageView loginImg = new ImageView();*/
    @FXML
    private Button botonmilagroso;
    
   /* 
    @FXML
    private void handleButtonAction(ActionEvent event) {
        String idaSeleccionado = Ida.getValue();
        String vueltaSeleccionado = Vuelta.getValue();
        
        try {
            // Carga el archivo FXML de VuelosClientes.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VuelosClientes.fxml"));
            Parent vuelosClientesPantalla = loader.load();
            
            // Obtiene el controlador de la nueva pantalla
            FXMLDocumentController vuelosClientesController = loader.getController();
            
            // Establece los valores de los Label en la nueva pantalla
            Label idaLabel = (Label) vuelosClientesPantalla.lookup("#idaLabel");
            //idaLabel.setText("Origen: " + idaSeleccionado);
            
            Label vueltaLabel = (Label) vuelosClientesPantalla.lookup("#vueltaLabel");
            //vueltaLabel.setText("Destino: " + vueltaSeleccionado);
            
            // Configura una nueva escena con la pantalla cargada
            Scene scene = new Scene(vuelosClientesPantalla);
            
            // Obtiene el escenario (Stage) actual y establece la nueva escena
            Stage stage = (Stage) Ida.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
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
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    

    
    //ESTE LOGIN ES PARA LOS CLIENTES QUE COMPRAN VUELOS
    

    
    
    
    
        
    @FXML
    private void goToScreenInformacionPiloto() {
        try {
            // Carga la nueva pantalla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InformacionPiloto.fxml"));
            Parent informacionPilotoPantalla = loader.load();
            
            // Configura una nueva escena con la pantalla cargada
            Scene scene = new Scene(informacionPilotoPantalla);
            
            // Obtiene el escenario (Stage) actual y establecer la nueva escena
            Stage stage = (Stage) botonVuelosPiloto.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
        }
    }

    @FXML
    private void goToScreenInformacionAzafata() {
        try {
            // Carga la nueva pantalla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InformacionAzafata.fxml"));
            Parent informacionAzafataPantalla = loader.load();
            
            // Configura una nueva escena con la pantalla cargada
            Scene scene = new Scene(informacionAzafataPantalla);
            
            // Obtiene el escenario (Stage) actual y establecer la nueva escena
            Stage stage = (Stage) botonVuelosAzafata.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
        }
    }
    
    
    
    @FXML
    private void goToScreenRegistro() {
        try {
            // Carga la nueva pantalla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Registro.fxml"));
            Parent registroPantalla = loader.load();
            
            // Configura una nueva escena con la pantalla cargada
            Scene scene = new Scene(registroPantalla);
            
            // Obtiene el escenario (Stage) actual y establecer la nueva escena
            Stage stage = (Stage) botonIrRegistro.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
        }
    }
    
    
    

    

   
}