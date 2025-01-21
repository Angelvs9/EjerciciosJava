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
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import utilidades.bbdd.Bd;
import utilidades.bbdd.Gestor_conexion_POSTGRE;



public class ControllerIdaVuelta {

    private static ControllerIdaVuelta instance;
    
    @FXML
    private ChoiceBox<String> Ida;

    @FXML
    private ChoiceBox<String> Vuelta;

    @FXML
    private DatePicker DatePicker;

    @FXML
    private Button botonVuelosClientes;
    
        
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
    private void goToScreenVuelosClientes(ActionEvent event) {
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


    @FXML
    public void vuelosDisponibles() {
        // Tu lógica aquí para manejar los vuelos disponibles
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego", false);
        String vec[][];
        String listaVuelos[][];
        
        System.out.println(Ida.getId() + Vuelta.getId());
        String IdaSeleccionado = Ida.getId();
        String VueltaSeleccionado = Vuelta.getId();

        String consulta1 = "select idvuelo from vuelo where origen LIKE '" + IdaSeleccionado + "' and destino like '" + VueltaSeleccionado + "'";
        vec = Bd.consultaSelect(gest, consulta1);
        String consulta2 = "SELECT billete.idbillete, billete.nasiento, vuelo.origen, vuelo.destino, vuelo.puertaembarque FROM billete LEFT JOIN vuelo ON billete.idvuelo = vuelo.idvuelo where vuelo.idvuelo='" + vec[0][0] + "' and dnipersona is null order by nasiento";
        System.out.println(consulta1);
        System.out.println(consulta2);
        
        listaVuelos = Bd.consultaSelect(gest, consulta2);

        // vuelosListView.getItems().clear();
        try {
            if (listaVuelos != null) {
                for (int i = 0; i < listaVuelos.length; i++) {
                    for (int j = 0; j < listaVuelos[0].length; j++) {
                        vuelosListView.getItems().addAll(listaVuelos[i][j]);
                        System.out.println(vuelosListView.getItems());

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
