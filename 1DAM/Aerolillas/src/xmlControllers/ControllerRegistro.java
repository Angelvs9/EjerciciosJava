/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlControllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.commons.codec.digest.DigestUtils;
import utilidades.bbdd.Bd;
import utilidades.bbdd.Gestor_conexion_POSTGRE;

/**
 *
 * @author Angel
 */
public class ControllerRegistro {
    
    @FXML
    private Label lblRegistroCorrecto;
    
    @FXML
    private TextField inputRegistroDNI;
    
    @FXML
    private TextField inputRegistroNombre;
    
    @FXML
    private TextField inputRegistroApellido;
        
    @FXML
    private TextField inputRegistroTelefono;
    
    @FXML
    private TextField inputRegistroCorreo;   
    
    @FXML
    private PasswordField inputRegistroPassword; 
    
    @FXML
    private Label lblRelleneCampo;
    
    
    
    @FXML
    private Button botonLogin1;
    
    @FXML
    private void goToScreenLogin1() {
        try {
            // Carga la nueva pantalla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/login.fxml"));
            Parent loginPantalla = loader.load();
            
            // Configura una nueva escena con la pantalla cargada
            Scene scene = new Scene(loginPantalla);
            
            // Obtiene el escenario (Stage) actual y establecer la nueva escena
            Stage stage = (Stage) botonLogin1.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException e) {
        }
    }
    
    
    
    
     public void RegistrarUsuario(){
       // Verifica si todos los campos están completos
        if (inputRegistroDNI.getText().isEmpty() || inputRegistroNombre.getText().isEmpty() || inputRegistroApellido.getText().isEmpty() || inputRegistroTelefono.getText().isEmpty() || inputRegistroCorreo.getText().isEmpty() || inputRegistroPassword.getText().isEmpty()) {
            lblRelleneCampo.setVisible(true);
            lblRegistroCorrecto.setVisible(false);
            return; 
        }

        // Verifica si el teléfono contiene solo números
        if (!inputRegistroTelefono.getText().matches("\\d+")) {
            lblRelleneCampo.setText("El teléfono solo debe contener números");
            lblRelleneCampo.setVisible(true);
            lblRegistroCorrecto.setVisible(false);
            return; // Salir del método si el teléfono contiene caracteres no numéricos
        }

        // Todos los campos están completos, intentar registrar el usuario
        try {
            String passwordCorreo = DigestUtils.sha256Hex(inputRegistroPassword.getText());
            Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego", true);
            String consultaRegistrar = "INSERT INTO persona (dni, nombre, primerApellido, telefono, correo, passwdcorreo) VALUES ('" + inputRegistroDNI.getText() + "', '" + inputRegistroNombre.getText() + "', '" + inputRegistroApellido.getText() + "', " + inputRegistroTelefono.getText() + ", '" + inputRegistroCorreo.getText() + "', '" + passwordCorreo + "') ON CONFLICT DO NOTHING";
            //el ignore es por si tiene algun problema con el algun campo no lo cree
            Bd.consultaModificacion(gest, consultaRegistrar);
            gest.cerrar_Conexion(true);
            lblRegistroCorrecto.setVisible(true);
            lblRelleneCampo.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    
    
    
    
}
