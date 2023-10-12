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
import java.util.ArrayList;
import java.util.List;
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
        
        String sql = "SELECT ocupada, tipoHabitacion "
                + "FROM habitacion WHERE num=?";
        Habitacion hab = null;
        TipoHabitacionData thd = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, num);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                hab = new Habitacion();
                thd = new TipoHabitacionData();
                hab.setNum(num);
                hab.setOcupada(rs.getBoolean("ocupada"));
                hab.setTipoHabitacion(thd.buscarTipoHabitacionPorCodigo(rs.getInt("tipoHabitacion")));
            }else{
                JOptionPane.showMessageDialog(null, "HABITACION INEXISTENTE");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER EN LA TABLA HABITACION. " + ex.getMessage());
        }
        return hab;
    }
    
    public void modificarHabitacion(Habitacion hab){
        
        String sql = "UPDATE habitacion SET tipoHabitacion = ?, ocupada = ? WHERE num = ? ";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, hab.getTipoHabitacion().getCodigo());
            ps.setBoolean(2, hab.isOcupada());
            ps.setInt(3, hab.getNum());
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "HABITACION MODIFICADA");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER EN LA TABLA HABITACION. " + ex.getMessage());
        }
    }
    
    public List<Habitacion> listarHabitaciones(){
        
        String sql = "SELECT num, ocupada, tipoHabitacion FROM habitacion";
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Habitacion hab = new Habitacion();
                hab.setNum(rs.getInt("num"));
                hab.setOcupada(rs.getBoolean("ocupada"));
                TipoHabitacionData tipoHabData = new TipoHabitacionData();
                hab.setTipoHabitacion(tipoHabData.buscarTipoHabitacionPorCodigo(rs.getInt("tipoHabitacion")));
                habitaciones.add(hab);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER EN LA TABLA HABITACION. " + ex.getMessage());
        }
        return habitaciones;
    }
    
    public List<Habitacion> listarDisponibles(){
        
        String sql = "SELECT num, tipoHabitacion FROM habitacion WHERE ocupada = 0 ";
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Habitacion hab = new Habitacion();
                hab.setNum(rs.getInt("num"));
                hab.setOcupada(false);
                TipoHabitacionData tipoHabData = new TipoHabitacionData();
                hab.setTipoHabitacion(tipoHabData.buscarTipoHabitacionPorCodigo(rs.getInt("tipoHabitacion")));
                habitaciones.add(hab);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER EN LA TABLA HABITACION. " + ex.getMessage());
        }
        return habitaciones;
    }
    
    public List<Habitacion> listarPorCantidadPersonas(int cantPers){
        
        //PRIMERA MANERA
        List<Habitacion> habitaciones = listarDisponibles();
        ArrayList<Habitacion> disponibles = new ArrayList<>();
        for(Habitacion hab : habitaciones){
            if(hab.getTipoHabitacion().getMaxPersonas() == cantPers){
                disponibles.add(hab);
            }
        }
        //SEGUNDA MANERA
//        String sql = "SELECT num, tipoHabitacion FROM habitacion WHERE ocupada = 0 ";
//        ArrayList<Habitacion> disponibles = new ArrayList<>();
//        
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                Habitacion hab = new Habitacion();
//                hab.setNum(rs.getInt("num"));
//                hab.setOcupada(false);
//                TipoHabitacionData tipoHabData = new TipoHabitacionData();
//                hab.setTipoHabitacion(tipoHabData.buscarTipoHabitacionPorCodigo(rs.getInt("tipoHabitacion")));
//                if(hab.getTipoHabitacion().getMaxPersonas() == cantPers){
//                    disponibles.add(hab);
//                }
//            }
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER EN LA TABLA HABITACION. " + ex.getMessage());
//        }
        return disponibles;
    }
    
    public int cantidadHabiSegunTipo (int cantPers){
        
        List<Habitacion> habitaciones = listarHabitaciones();
        int cantHab = 0;
        for(Habitacion hab : habitaciones){
            if(hab.getTipoHabitacion().getMaxPersonas() == cantPers){
                cantHab++;
            }
        }
        return cantHab;
    }
    
    
    
    
}
