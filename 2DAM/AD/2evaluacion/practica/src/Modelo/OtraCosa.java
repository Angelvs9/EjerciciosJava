/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class OtraCosa implements Serializable{

    private String modelo="otraCosa";
    private String info;
    
    public OtraCosa(String info) {
        this.info=info;
    }

    @Override
    public String toString() {
        return "OtraCosa{" + "modelo=" + modelo + ", info=" + info + "}\n";
    }


    

}
