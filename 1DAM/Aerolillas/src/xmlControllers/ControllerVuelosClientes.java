/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlControllers;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import utilidades.bbdd.Bd;
import utilidades.bbdd.Gestor_conexion_POSTGRE;

/**
 *
 * @author Angel
 */
public class ControllerVuelosClientes {
    
    private String idaSeleccionada;
    private String vueltaSeleccionada;
    
    @FXML
    private Button botonLogin1;
    
    @FXML
    private Button botonAnterior1;
    
    @FXML
    private Button botonVerVuelos;
    
    @FXML
    private TableView<Object> tableview;
    
    @FXML
    private TableColumn<Object,String> origen;
    private TableColumn<Object,String> destino;
    private TableColumn<Object,String> km;
    private TableColumn<Object,Integer> puertaEmbarque;
    
    //ObservableList<Object> listaVuelos=FXCollections.observableArrayList;
    
    public void initData(String ida, String vuelta) {
        this.idaSeleccionada = ida;
        this.vueltaSeleccionada = vuelta;
    }

    @FXML
    public void vuelosDisponibles() {
        // Tu lógica aquí para manejar los vuelos disponibles
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego", false);
        String vec[][];
        String listaVuelos[][];

        String consulta1 = "select idvuelo from vuelo where origen LIKE '" + idaSeleccionada + "' and destino like '" + vueltaSeleccionada + "'";
        vec = Bd.consultaSelect(gest, consulta1);
        String consulta2 = "SELECT billete.idbillete, billete.nasiento, vuelo.origen, vuelo.destino,vuelo.km, vuelo.puertaembarque FROM billete LEFT JOIN vuelo ON billete.idvuelo = vuelo.idvuelo where vuelo.idvuelo='" + vec[0][0] + "' and dnipersona is null order by nasiento";
        System.out.println(consulta1);
        System.out.println(consulta2);
        
        listaVuelos = Bd.consultaSelect(gest, consulta2);

        // vuelosListView.getItems().clear();
        try {
            if (listaVuelos != null) {
                for (int i = 0; i < listaVuelos.length; i++) {
                    for (int j = 0; j < listaVuelos[0].length; j++) {
                        tableview.getItems().addAll(listaVuelos[i][j]);
                        System.out.println(tableview.getItems());

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @FXML
    private void goToScreenLogin1() {
        try {
            // Carga la nueva pantalla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/login.fxml"));
            Parent login2Pantalla = loader.load();
            
            // Configura una nueva escena con la pantalla cargada
            Scene scene = new Scene(login2Pantalla);
            
            // Obtiene el escenario (Stage) actual y establecer la nueva escena
            Stage stage = (Stage) botonLogin1.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException e) {
        }
    }

        @FXML
    private void goToScreenAnterior1() {
        try {
            // Carga la nueva pantalla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/IdaVuelta.fxml"));
            Parent login2Pantalla = loader.load();
            
            // Configura una nueva escena con la pantalla cargada
            Scene scene = new Scene(login2Pantalla);
            
            // Obtiene el escenario (Stage) actual y establecer la nueva escena
            Stage stage = (Stage) botonAnterior1.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException e) {
        }
    }
    
   
}
