/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.proyectofinal.grupo20.AccesoADatos;

import hotel.proyectofinal.grupo20.Entidades.Huesped;
import java.sql.Connection;

/**
 *
 * @author marti
 */
public class HuespedData {
    
    private Connection con = null;

    public HuespedData() {
        this.con = Conexion.getConexion();
    }
    
    public void guardarHuesped(Huesped huesped){
        
        
    }
    
    
}
