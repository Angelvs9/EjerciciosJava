
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Angel
 */
public class Cliente implements Serializable{
    private String cnombre;
    private String capellidos;
    private String cnif;

    public Cliente(String cnombre, String capellidos, String cnif) {
        this.cnombre = cnombre;
        this.capellidos = capellidos;
        this.cnif = cnif;
    }

    public String getCnombre() {
        return cnombre;
    }

    public String getCapellidos() {
        return capellidos;
    }

    public String getCnif() {
        return cnif;
    }

    @Override
    public String toString() {
        return "\nCliente{" + "cnombre=" + cnombre + ", capellidos=" + capellidos + ", cnif=" + cnif + "}\n";
    }




    
}
