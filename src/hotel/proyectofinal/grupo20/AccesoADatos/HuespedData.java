/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.proyectofinal.grupo20.AccesoADatos;

import hotel.proyectofinal.grupo20.Entidades.Huesped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
        
        if (buscarHuespedPorDni(huesped.getDni()) == null) {
            
            String sql = "INSERT INTO huesped (dni, apellido, nombre, domicilio, correo, celular) "
                    + "VALUES (?,?,?,?,?,?)";

            try {

                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, huesped.getDni());
                ps.setString(2, huesped.getApellido());
                ps.setString(3, huesped.getNombre());
                ps.setString(4, huesped.getDomicilio());
                ps.setString(5, huesped.getCorreo());
                ps.setInt(6, huesped.getCelular());
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "HUESPED GUARDADO EXITOSAMENTE");
                }
                ps.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER EN LA TABLA HUESPED. " + ex.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null, "YA EXISTE EL HUESPED");
        }
    }
    
    public void modificarHuesped(Huesped huesped){
        
        String sql = "UPDATE huesped SET apellido=?, nombre=?, domicilio=?, correo=?, celular=? "
                + "WHERE dni=?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, huesped.getApellido());
            ps.setString(2, huesped.getNombre());
            ps.setString(3, huesped.getDomicilio());
            ps.setString(4, huesped.getCorreo());
            ps.setInt(5, huesped.getCelular());
            ps.setInt(6, huesped.getDni());
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "HUESPED MODIFICADO EXITOSAMENTE");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER EN LA TABLA HUESPED. " + ex.getMessage());
        }
    }
    
    public Huesped buscarHuespedPorDni(int dni){
        
        String sql = "SELECT apellido, nombre, domicilio, correo, celular "
                + "FROM huesped WHERE dni=?";
        Huesped huesped = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                huesped = new Huesped();
                huesped.setDni(dni);
                huesped.setApellido(rs.getString("apellido"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setDomicilio(rs.getString("domicilio"));
                huesped.setCorreo(rs.getString("correo"));
                huesped.setCelular(rs.getInt("celular"));
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE EL HUESPED");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER EN LA TABLA HUESPED. " + ex.getMessage());
        }
        return huesped;
    }
    
    public List<Huesped> listarHistorialDeHuespedes(){
        
        String sql = "SELECT dni, apellido, nombre, domicilio, correo, celular "
                + "FROM huesped";
        ArrayList<Huesped> huespedes = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Huesped huesped = new Huesped();
                huesped.setDni(rs.getInt("dni"));
                huesped.setApellido(rs.getString("apellido"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setDomicilio(rs.getString("domicilio"));
                huesped.setCorreo(rs.getString("correo"));
                huesped.setCelular(rs.getInt("celular"));
                
                huespedes.add(huesped);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER EN LA TABLA HUESPED. " + ex.getMessage());
        }
        return huespedes;
    }
    //PROBAR listarHuespedesConReserva() CUANDO HAYA RESERVAS
    public List<Huesped> listarHuespedesConReservas(){
        
        String sql = "SELECT dni, apellido, nombre, domicilio, correo, celular "
                + "FROM huesped, reserva WHERE huesped.dni = reserva.dniHuesped "
                + "AND reserva.estado = 1";
        ArrayList<Huesped> huespedes = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Huesped huesped = new Huesped();
                huesped.setDni(rs.getInt("dni"));
                huesped.setApellido(rs.getString("apellido"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setDomicilio(rs.getString("domicilio"));
                huesped.setCorreo(rs.getString("correo"));
                huesped.setCelular(rs.getInt("celular"));
                
                huespedes.add(huesped);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER EN LA TABLA HUESPED. " + ex.getMessage());
        }
        return huespedes;
    }
    
    
}
