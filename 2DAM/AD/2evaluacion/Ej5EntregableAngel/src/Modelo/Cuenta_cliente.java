/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Angel
 */
public class Cuenta_cliente {
    
    private long codigo;//primary key esta bien lo de long
    private String tipo;
    private double saldo;

    public Cuenta_cliente(long codigo, String tipo, double saldo) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.saldo = saldo;
    }

    public Cuenta_cliente(long codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }
    

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta_cliente{" + "codigo=" + codigo + ", tipo=" + tipo + ", saldo=" + saldo + '}';
    }
    
}
