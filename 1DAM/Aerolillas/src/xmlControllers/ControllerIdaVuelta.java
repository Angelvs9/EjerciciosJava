package xmlControllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import utilidades.bbdd.Bd;
import utilidades.bbdd.Gestor_conexion_POSTGRE;



public class ControllerIdaVuelta {

    private static ControllerIdaVuelta instance;
    
    @FXML
    public ChoiceBox<String> Ida;

    @FXML
    public ChoiceBox<String> Vuelta;

    @FXML
    private DatePicker DatePicker;

    @FXML
    private Button botonVuelosClientes;
    
    @FXML
    private Label lblRellenar;
    
    @FXML
    private Button botonLogin2;
    
    @FXML
    private ListView<String> vuelosListView;
    
    @FXML
    private void goToScreenLogin2() {
        try {
            // Carga la nueva pantalla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/login2.fxml"));
            Parent login2Pantalla = loader.load();
            
            // Configura una nueva escena con la pantalla cargada
            Scene scene = new Scene(login2Pantalla);
            
            // Obtiene el escenario (Stage) actual y establecer la nueva escena
            Stage stage = (Stage) botonLogin2.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException e) {
        }
    }
    
    @FXML
    public void initialize() {
        instance = this;
    }

    public static ControllerIdaVuelta getInstance() {
        return instance;
    }
    

    @FXML
    private void comprarBilletes(ActionEvent event) {
        String idaSeleccionada = Ida.getValue();
        String vueltaSeleccionada = Vuelta.getValue();

        if (idaSeleccionada == null || idaSeleccionada.isEmpty() || vueltaSeleccionada == null || vueltaSeleccionada.isEmpty()) {
            lblRellenar.setVisible(true);
        } else if (idaSeleccionada != null && vueltaSeleccionada != null) {
            try {
                // Cargar la nueva pantalla
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/VuelosClientes.fxml"));
                Parent vuelosClientesPantalla = loader.load();

                // Configurar una nueva escena con la pantalla cargada
                Scene scene = new Scene(vuelosClientesPantalla);

                // Obtener el escenario (Stage) actual y establecer la nueva escena
                Stage stage = (Stage) botonVuelosClientes.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
