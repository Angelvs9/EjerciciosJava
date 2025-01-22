package xmlControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import org.apache.commons.codec.digest.DigestUtils;
import utilidades.bbdd.Bd;
import utilidades.bbdd.Gestor_conexion_POSTGRE;
/**
 *
 * @author Angel
 */

public class ControllerLogin1 {

    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private Button botonInicioSesion;

    @FXML
    private Button botonAnterior2;

    @FXML
    private Button botonIrRegistro;

    @FXML
    private PasswordField inputPassword;

    @FXML
    private TextField inputUsuario;

    @FXML
    private Label labelNo;

    @FXML
    private ImageView loginImg;

    @FXML
    void accionBotonInicioSesion1(ActionEvent event) {
        String usuario = inputUsuario.getText();
        String password = inputPassword.getText();

        if (usuario.isEmpty() || password.isEmpty()) {
            labelNo.setText("Por favor, complete todos los campos.");
            labelNo.setVisible(true);
        } else if (validarCredenciales(usuario, password)) {
            labelNo.setText("¡Inicio de sesión exitoso!");
            goToScreenMensajeReserva();
            labelNo.setVisible(true);
            
        } else {
            labelNo.setText("El usuario no es correcto o no existe.");
            labelNo.setVisible(true);
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
    private void goToScreenAnterior2() {
        try {
            // Carga la nueva pantalla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VuelosClientes.fxml"));
            Parent vuelosClientesPantalla = loader.load();
            
            // Configura una nueva escena con la pantalla cargada
            Scene scene = new Scene(vuelosClientesPantalla);
            
            // Obtiene el escenario (Stage) actual y establecer la nueva escena
            Stage stage = (Stage) botonAnterior2.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
        }
    }
    
    
    
    

@FXML
    private void goToScreenRegistro() {
        try {
            // Carga la nueva pantalla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/Registro.fxml"));
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

    @FXML
    private void goToScreenMensajeReserva() {
        try {
            // Carga la nueva pantalla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/MensajeReserva.fxml"));
            Parent vuelosPilotoPantalla = loader.load();

            // Configura una nueva escena
            Scene scene = new Scene(vuelosPilotoPantalla);

            // Obtiene el escenario (Stage) actual y establecer la nueva escena
            Stage stage = (Stage) botonInicioSesion.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    

    private boolean validarCredenciales(String usuario, String password) {
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego", true);
        String[][] vec;
        boolean booleano = false;

        try {
            String hashedPassword = DigestUtils.sha256Hex(password);
            String consulta = "select * from persona where correo='" + usuario + "' and passwdcorreo='" + hashedPassword + "'";
            String contrasenaBd = "select passwdCorreo from persona where correo = '" + usuario + "'";

            vec = Bd.consultaSelect(gest, contrasenaBd);
            if (hashedPassword.equals(vec[0][0])) {
                booleano = true;
            }
        } catch (NullPointerException n) {
            labelNo.setVisible(true);
        } finally {
            gest.cerrar_Conexion(true);
        }

        return booleano;
    }
}
