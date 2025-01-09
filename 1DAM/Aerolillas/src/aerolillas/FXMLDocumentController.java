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
    
    @FXML
    private PasswordField inputPasswordTrabajadores;
    
    @FXML
    private TextField inputUsuarioTrabajadores;
    
    //PARA EL METODO QUE REGISTRA EL USUARIO
    @FXML
    private Label lblRelleneCampo;
    
    @FXML
    private Label labelNoTrabajadores;
     
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
    
    //BOTONES DE LAS PANTALLAS PARA LOS CAMBIOS DE ESCENA
    @FXML
    private Button botonVuelosClientes;
    
    @FXML
    private Button botonLogin1;
    
    @FXML
    private Button botonLogin2;
    
    @FXML
    private Button botonInicioSesion;
    
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
    private Button botonIdaVuelta;
    
    @FXML
    private ListView<String> vuelosListView;
    
    
    //PARA LOS ESTILOS
    @FXML
    private AnchorPane anchorPane;
    
    //COMPONENTES DE LA PANTALLA 1
    @FXML
    private ChoiceBox<String> Ida;
    
    @FXML
    private ChoiceBox<String> Vuelta;
    
    @FXML
    private DatePicker DatePicker;
    
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
    
    
    //ESTOS METODOS SE USAN PARA IR DE PANTALLA EN PANTALLA
    @FXML
    private void goToScreenVuelosClientes() {
        try {
            // Carga la nueva pantalla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VuelosClientes.fxml"));
            Parent vuelosClientesPantalla = loader.load();
            
            // Configura una nueva escena con la pantalla cargada
            Scene scene = new Scene(vuelosClientesPantalla);
            
            // Obtiene el escenario (Stage) actual y establecer la nueva escena
            Stage stage = (Stage) botonVuelosClientes.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            
        } 
        catch (IOException e) {
        }
    }

    /*@FXML
    private void goToSceneVuelosClientes() {
        try {

            // Carga la nueva pantalla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MensajeReserva.fxml"));
            Parent mensajeReservaPantalla = loader.load();
            
            // Configura una nueva escena con la pantalla cargada
            Scene scene = new Scene(mensajeReservaPantalla);
            
            // Obtiene el escenario (Stage) actual y establecer la nueva escena
            Stage stage = (Stage) botonVuelosClientes.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
        }
        catch (NullPointerException e) {

        }
    }*/
    
    
    
    @FXML
    private void goToScreenIdaVuelta() {
        try {
            // Carga la nueva pantalla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("IdaVuelta.fxml"));
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
    
    
    
    //ESTE LOGIN ES PARA LOS CLIENTES QUE COMPRAN VUELOS
    @FXML
    private void goToScreenLogin1() {
        try {
            // Carga la nueva pantalla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
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
    
    
    
    //ESTE LOGIN 2 ES PARA LOS PILOTOS Y AZAFATAS
    @FXML
    private void goToScreenLogin2() {
        try {
            // Carga la nueva pantalla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login2.fxml"));
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
    private void goToScreenAnterior1() {
        try {
            // Carga la nueva pantalla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("IdaVuelta.fxml"));
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
    private void goToScreenVuelosPiloto() {
        try {
            // Carga la nueva pantalla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VuelosPiloto.fxml"));
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
    
    
    
@FXML
    private void goToScreenVuelosAzafata() {
        try {
            // Carga la nueva pantalla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VuelosAzafata.fxml"));
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
    
    
    @FXML
    private void goToScreenMensajeReserva() {
        try {
            // Carga la nueva pantalla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MensajeReserva.fxml"));
            Parent vuelosPilotoPantalla = loader.load();
            
            // Configura una nueva escena con la pantalla cargada
            Scene scene = new Scene(vuelosPilotoPantalla);
            
            // Obtiene el escenario (Stage) actual y establecer la nueva escena
            Stage stage = (Stage) botonInicioSesion.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
        }
    }
    
    
   
    @FXML
    private void accionBotonInicioSesion1(ActionEvent event) {
        
        if (inicioSesionPersona()==true) {
            goToScreenMensajeReserva(); 
        }  
    }
    
    @FXML
    private void accionBotonInicioSesion2(ActionEvent event) {
        inicioSesionPilotoAzafata();
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

    
    public void RegistrarUsuario(){
       // Verificar si todos los campos están completos
        if (inputRegistroDNI.getText().isEmpty() || inputRegistroNombre.getText().isEmpty() || inputRegistroApellido.getText().isEmpty() || inputRegistroTelefono.getText().isEmpty() || inputRegistroCorreo.getText().isEmpty() || inputRegistroPassword.getText().isEmpty()) {
            lblRelleneCampo.setVisible(true);
            return; // Salir del método si los campos no están completos
        }

        // Todos los campos están completos, intentar registrar el usuario
        try {
            String passwordCorreo = DigestUtils.sha256Hex(inputRegistroPassword.getText());
            Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego", true);
            String consultaRegistrar = "INSERT INTO persona (dni, nombre, primerApellido, telefono, correo, passwdcorreo) VALUES ('" + inputRegistroDNI.getText() + "', '" + inputRegistroNombre.getText() + "', '" + inputRegistroApellido.getText() + "', " + inputRegistroTelefono.getText() + ", '" + inputRegistroCorreo.getText() + "', '" + passwordCorreo + "')";
            Bd.consultaModificacion(gest, consultaRegistrar);
            gest.cerrar_Conexion(true);
            lblRegistroCorrecto.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
    public boolean inicioSesionPersona() {
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego", true); 
        String vec[][];
        boolean booleano=false;
       
        try{
            String password = DigestUtils.sha256Hex(inputPassword.getText());
            String consulta="select * from persona where correo='"+inputUsuario.getText()+"' and passwdcorreo='"+password+"'";
            String contrasenaBd = "select passwdCorreo from persona where correo = " + "'" + inputUsuario.getText() + "'";

            vec=Bd.consultaSelect(gest,contrasenaBd);
                if (password.equals(vec[0][0])) {
                    booleano=true;
                }
        }
        
        catch(NullPointerException n){
            labelNo.setVisible(true);
        }
        gest.cerrar_Conexion(true);
        
        return booleano;
    }
   
    @FXML
    public void vuelosDisponibles(){
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego", false);
        String vec[][];
        String listaVuelos[][];
        System.out.println("hasta qui llega");
        System.out.println(Ida.getId() + Vuelta.getId());
        String IdaSeleccionado = Ida.getId();
        String VueltaSeleccionado = Vuelta.getId();

        String consulta1="select idvuelo from vuelo where origen LIKE "+"'"+IdaSeleccionado+"'"+" and destino like "+"'"+VueltaSeleccionado+"'";
        vec=Bd.consultaSelect(gest, consulta1);
        String consulta2="SELECT billete.idbillete, billete.nasiento, vuelo.origen, vuelo.destino, vuelo.puertaembarque FROM billete LEFT JOIN vuelo ON billete.idvuelo = vuelo.idvuelo where vuelo.idvuelo='"+vec[0][0]+"' and dnipersona is null order by nasiento";
        System.out.println(consulta1);
        System.out.println(consulta2);
        listaVuelos=Bd.consultaSelect(gest, consulta2);

        //vuelosListView.getItems().clear();
        try{
            if (listaVuelos!=null){
                for (int i = 0; i < listaVuelos.length; i++) {
                    for (int j = 0; j < listaVuelos[0].length; j++) {
                        vuelosListView.getItems().addAll(listaVuelos[i][j]);
                        System.out.println(vuelosListView.getItems());
                        System.out.println(listaVuelos[i][j]);
                    }
                }
            }
        }
        catch(NullPointerException n){
        }  
    }
}