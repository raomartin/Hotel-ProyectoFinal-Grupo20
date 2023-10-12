/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.proyectofinal.grupo20.AccesoADatos;

import hotel.proyectofinal.grupo20.Entidades.Reserva;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

/**
 *
 * @author marti
 */
public class ReservaData {
    private Connection con = null;
    
    public ReservaData(){
        this.con = Conexion.getConexion();
    }
    
    public void crearReserva(Reserva res){
        
        String sql = "INSERT INTO reserva (dniHuesped, numHabitacion, fechaIngreso, fechaSalida, "
                + "cantDias, cantPersonas, precioTotal, estado) VALUES (?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, res.getHuesped().getDni());
            ps.setInt(2, res.getHabitacion().getNum());
            ps.setDate(3, Date.valueOf(res.getFechaIngreso()));
            ps.setDate(4, Date.valueOf(res.getFechaSalida()));
            ps.setInt(5, res.getCantDias());
            ps.setInt(6, res.getCantPersonas());
            ps.setDouble(7, res.getPrecioTotal());
            ps.setBoolean(8, res.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                res.setIdReserva(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "RESERVA CREADA EXITOSAMENTE");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA RESERVA. " + ex.getMessage());
        }
    }
    
    public Reserva buscarPorId(int id){
        
        String sql = "SELECT dniHuesped, numHabitacion, fechaIngreso, fechaSalida, "
                + "cantDias, cantPersonas, precioTotal, estado FROM reserva WHERE idReserva = ?";
        Reserva reserva = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                reserva = new Reserva();
                HuespedData huesData = new HuespedData();
                HabitacionData habData = new HabitacionData();
                reserva.setIdReserva(id);
                reserva.setHuesped(huesData.buscarHuespedPorDni(rs.getInt("dniHuesped")));
                reserva.setHabitacion(habData.buscarHabitacion(rs.getInt("numHabitacion")));
                reserva.setFechaIngreso(rs.getDate("fechaIngreso").toLocalDate());
                reserva.setFechaSalida(rs.getDate("fechaSAlida").toLocalDate());
                reserva.setCantDias(rs.getInt("cantDias"));
                reserva.setCantPersonas(rs.getInt("cantPersonas"));
                reserva.setPrecioTotal(rs.getDouble("precioTotal"));
                reserva.setEstado(rs.getBoolean("estado"));
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE LA RESERVA Nro." + id);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA RESERVA. " + ex.getMessage());
        }
        return reserva;
    }
    
    public Reserva buscarPorDni(int dni){
        
        String sql = "SELECT idReserva, numHabitacion, fechaIngreso, fechaSalida, "
                + "cantDias, cantPersonas, precioTotal, estado FROM reserva WHERE dniHuesped = ?";
        Reserva reserva = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                reserva = new Reserva();
                HuespedData huesData = new HuespedData();
                HabitacionData habData = new HabitacionData();
                reserva.setIdReserva(rs.getInt("idReserva"));
                reserva.setHuesped(huesData.buscarHuespedPorDni(dni));
                reserva.setHabitacion(habData.buscarHabitacion(rs.getInt("numHabitacion")));
                reserva.setFechaIngreso(rs.getDate("fechaIngreso").toLocalDate());
                reserva.setFechaSalida(rs.getDate("fechaSAlida").toLocalDate());
                reserva.setCantDias(rs.getInt("cantDias"));
                reserva.setCantPersonas(rs.getInt("cantPersonas"));
                reserva.setPrecioTotal(rs.getDouble("precioTotal"));
                reserva.setEstado(rs.getBoolean("estado"));
            }else{
                JOptionPane.showMessageDialog(null, "EL DNI INGRESADO NO TIENE RESERVAS");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA RESERVA. " + ex.getMessage());
        }
        return reserva;
    }
    
    public Reserva buscarPorFecha(LocalDate fecha){
        
        String sql = "SELECT idReserva, dniHuesped, numHabitacion, fechaSalida, "
                + "cantDias, cantPersonas, precioTotal, estado FROM reserva WHERE fechaIngreso = ?";
        Reserva reserva = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                reserva = new Reserva();
                HuespedData huesData = new HuespedData();
                HabitacionData habData = new HabitacionData();
                reserva.setIdReserva(rs.getInt("idReserva"));
                reserva.setHuesped(huesData.buscarHuespedPorDni(rs.getInt("dniHuesped")));
                reserva.setHabitacion(habData.buscarHabitacion(rs.getInt("numHabitacion")));
                reserva.setFechaIngreso(fecha);
                reserva.setFechaSalida(rs.getDate("fechaSAlida").toLocalDate());
                reserva.setCantDias(rs.getInt("cantDias"));
                reserva.setCantPersonas(rs.getInt("cantPersonas"));
                reserva.setPrecioTotal(rs.getDouble("precioTotal"));
                reserva.setEstado(rs.getBoolean("estado"));
            }else{
                JOptionPane.showMessageDialog(null, "NO TIENE RESERVAS EN ESA FECHA");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA RESERVA. " + ex.getMessage());
        }
        return reserva;
    }
    
    public void cancelarReserva(int idRes){
        
        String sql = "UPDATE reserva SET estado = 0 WHERE idReserva = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idRes);
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "RESERVA Nro." + idRes + " CANCELADA");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA RESERVA. " + ex.getMessage());
        }
    }
    
    public void finReserva(int dni){
        
        
        
        
    }
    
    
    
    
    
    
    
}
