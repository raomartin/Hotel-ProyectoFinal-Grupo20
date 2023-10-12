/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.proyectofinal.grupo20.AccesoADatos;

import hotel.proyectofinal.grupo20.Entidades.TipoCama;
import hotel.proyectofinal.grupo20.Entidades.TipoHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author marti
 */
public class TipoHabitacionData {
    private Connection con = null;
    
    public TipoHabitacionData(){
        this.con = Conexion.getConexion();
    }
    
    public void guardarTipoHabitacion(TipoHabitacion tipoHab){
        
        if (!existeTipo(tipoHab)) {
            
            String sql = "INSERT INTO tipohabitacion (maxPersonas, cantCamas, tipoCama, precio) "
                    + "VALUES (?,?,?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, tipoHab.getMaxPersonas());
                ps.setInt(2, tipoHab.getCantCamas());
                ps.setString(3, tipoHab.getTipoDeCama().toString());
                ps.setDouble(4, tipoHab.getPrecio());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    tipoHab.setCodigo(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "TIPO DE HABITACION GUARDADA EXITOSAMENTE");
                }
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER EN LA TABLA TIPOHABITACION. " + ex.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null, "YA EXISTE ESTE TIPO DE HABITACION");
        }
    }
    
    public void cambiarPrecio(int codigo, double precioNvo){
        
        String sql = "UPDATE tipohabitacion SET precio=? WHERE codigo=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, precioNvo);
            ps.setInt(2, codigo);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "PRECIO MODIFICADO EXITOSAMENTE");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER EN LA TABLA TIPOHABITACION. " + ex.getMessage());
        }
        
    }
    
    public void cambiarPrecio(TipoHabitacion tipoHab){
        
        String sql = "UPDATE tipohabitacion SET precio=? WHERE codigo=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, tipoHab.getPrecio());
            ps.setInt(2, tipoHab.getCodigo());
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "PRECIO MODIFICADO EXITOSAMENTE");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER EN LA TABLA TIPOHABITACION. " + ex.getMessage());
        }
        
    }
    
    public TipoHabitacion buscarTipoHabitacionPorCodigo(int codigo){
        
        String sql = "SELECT maxPersonas, cantCamas, tipoCama, precio FROM tipohabitacion "
                + "WHERE codigo=?";
        TipoHabitacion tipoHab = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                tipoHab = new TipoHabitacion();
                tipoHab.setCodigo(codigo);
                tipoHab.setMaxPersonas(rs.getInt("maxPersonas"));
                tipoHab.setCantCamas(rs.getInt("cantCamas"));
                tipoHab.setTipoDeCama(TipoCama.valueOf(rs.getString("tipoCama")));
                tipoHab.setPrecio(rs.getDouble("precio"));
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE EL TIPO DE HABITACION");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER EN LA TABLA TIPOHABITACION. " + ex.getMessage());
        }
        return tipoHab;
    }
    
    private void eliminarTipoHabitacion(int codigo){
        
        String sql = "DELETE FROM tipohabitacion WHERE codigo=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "TIPO DE HABITACION ELIMINADA EXITOSAMENTE");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER EN LA TABLA TIPOHABITACION. " + ex.getMessage());
        }
    }
    
    public List<TipoHabitacion> listarTiposDeHabitaciones(){
        
        String sql = "SELECT codigo, maxPersonas, cantCamas, tipoCama, precio "
                + "FROM tipohabitacion";
        ArrayList<TipoHabitacion> tipos = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TipoHabitacion th = new TipoHabitacion();
                th.setCodigo(rs.getInt("codigo"));
                th.setMaxPersonas(rs.getInt("maxPersonas"));
                th.setCantCamas(rs.getInt("cantCamas"));
                th.setTipoDeCama(TipoCama.valueOf(rs.getString("tipoCama")));
                th.setPrecio(rs.getDouble("precio"));
                
                tipos.add(th);
            }
        ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER EN LA TABLA TIPOHABITACION. " + ex.getMessage());
        }
        return tipos;
    }
    
    public List<TipoHabitacion> listarTipoHabitacion(int maxPersonas){
        
        String sql = "SELECT codigo, cantCamas, tipoCama, precio FROM tipohabitacion "
                + "WHERE maxPersonas=?";
        ArrayList<TipoHabitacion> tipos = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, maxPersonas);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TipoHabitacion th = new TipoHabitacion();
                th.setCodigo(rs.getInt("codigo"));
                th.setMaxPersonas(maxPersonas);
                th.setCantCamas(rs.getInt("cantCamas"));
                th.setTipoDeCama(TipoCama.valueOf(rs.getString("tipoCama")));
                th.setPrecio(rs.getDouble("precio"));
                
                tipos.add(th);
            }
        ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER EN LA TABLA TIPOHABITACION. " + ex.getMessage());
        }
        return tipos;
    }
    
    private boolean existeTipo(TipoHabitacion tipoHab){
        boolean valor = false;
        List<TipoHabitacion> tipos = listarTiposDeHabitaciones();
        for(TipoHabitacion aux : tipos){
            if(aux.getMaxPersonas() == tipoHab.getMaxPersonas() 
                && aux.getCantCamas() == tipoHab.getCantCamas()
                    && aux.getTipoDeCama().equals(tipoHab.getTipoDeCama())){
                valor = true;
            }
        }
        return valor;
    }
    
    
    
}
