
package ejercicio2;


public class Bicicleta extends Vehiculo{
    private String identificador;
    private boolean carretera;
    private double pesoMaximo;

    public Bicicleta(String identificador, boolean carretera, double pesoMaximo, String color, int npuertas, String nbastidor, double peso) {
        super(color, npuertas, nbastidor, peso);
        this.identificador = identificador;
        this.carretera = carretera;
        this.pesoMaximo = pesoMaximo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public boolean isCarretera() {
        return carretera;
    }

    public void setCarretera(boolean carretera) {
        this.carretera = carretera;
    }

    @Override
    public String toString() {
        return super.toString()+" Bicicleta{" + "identificador=" + identificador + ", es de carretera?=" + carretera + ", Peso Maximo="+pesoMaximo+ "}\n_____________________________________________\n";
    }
    
}
    
