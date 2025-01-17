
package Modelo;

/**
 *
 * @author Angel
 */
public class Cliente {
    private int codigo;
    private int Dato_fiscal;// clave ajena a codigo de Datos_fiscales
    private long Telf_contacto;

    public Cliente(int codigo, int Dato_fiscal, long Telf_contacto) {
        this.codigo = codigo;
        this.Dato_fiscal = Dato_fiscal;
        this.Telf_contacto = Telf_contacto;
    }

    public Cliente(int codigo, int Dato_fiscal) {
        this.codigo = codigo;
        this.Dato_fiscal = Dato_fiscal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDato_fiscal() {
        return Dato_fiscal;
    }

    public void setDato_fiscal(int Dato_fiscal) {
        this.Dato_fiscal = Dato_fiscal;
    }

    public long getTelf_contacto() {
        return Telf_contacto;
    }

    public void setTelf_contacto(long Telf_contacto) {
        this.Telf_contacto = Telf_contacto;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", Dato_fiscal=" + Dato_fiscal + ", Telf_contacto=" + Telf_contacto + '}';
    }
    
    
}
