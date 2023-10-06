/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.proyectofinal.grupo20.AccesoADatos;

import hotel.proyectofinal.grupo20.Entidades.Habitacion;
import hotel.proyectofinal.grupo20.Entidades.TipoCama;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

/**
 *
 * @author marti
 */
public class HabitacionData {
    private Connection con = null;

    public HabitacionData() {
        this.con = Conexion.getConexion();
    }
    
    public void guardarHabitacion(Habitacion hab){
        
        String sql = "INSERT INTO habitacion (ocupada, tipoHabitacion) "
                + "VALUES (?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setBoolean(1, hab.isOcupada());
            ps.setInt(2, hab.getTipoHabitacion().getCodigo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                hab.setNum(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "HABITACION GUARDADA");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER EN LA TABLA HABITACION. " + ex.getMessage());
        }
        
    }
    
    public Habitacion buscarHabitacion(int num){
        
        String sql = "SELECT ocupada, tipoHabitacion FROM habitacion "
                + "WHERE num=?";
        Habitacion hab = null;
        TipoHabitacionData thd = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, num);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                thd = new TipoHabitacionData();
                hab.setNum(num);
                hab.setOcupada(rs.getBoolean("ocupada"));
                hab.setTipoHabitacion(thd.buscarTipoHabitacion(rs.getInt("tipoHabitacion")));
            }else{
                JOptionPane.showMessageDialog(null, "HABITACION INEXISTENTE");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER EN LA TABLA HABITACION. " + ex.getMessage());
        }
        return hab;
    }
    
    
}
