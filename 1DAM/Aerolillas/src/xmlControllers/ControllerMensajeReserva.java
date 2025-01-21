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
import javafx.stage.Stage;

/**
 *
 * @author Angel
 */
public class ControllerMensajeReserva {
    
    @FXML
    private Button botonIdaVuelta;
    
    @FXML
    private void goToScreenIdaVuelta() {
        try {
            // Carga la nueva pantalla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/IdaVuelta.fxml"));
            Parent idaVueltaPantalla = loader.load();
            
            // Configura una nueva escena con la pantalla cargada
            Scene scene = new Scene(idaVueltaPantalla);
            
            // Obtiene el escenario (Stage) actual y establecer la nueva escena
            Stage stage = (Stage) botonIdaVuelta.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException e) {
        }
    }
    
}
