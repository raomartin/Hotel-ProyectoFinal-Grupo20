/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.proyectofinal.grupo20.Entidades;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 *
 * @author marti
 */
public class Reserva {
    private int idReserva;
    private Huesped huesped;
    private Habitacion habitacion;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private int cantDias;
    private int cantPersonas;
    private double precioTotal;
    private boolean estado;

    public Reserva() {
    }

    public Reserva(Huesped huesped, Habitacion habitacion, LocalDate fechaIngreso, LocalDate fechaSalida, int cantPersonas, boolean estado) {
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.cantDias = (int) DAYS.between(fechaIngreso, fechaSalida);
        this.cantPersonas = cantPersonas;
        this.precioTotal = cantDias*habitacion.getTipoHabitacion().getPrecio();
        this.estado = estado;
    }

    public Reserva(int idReserva, Huesped huesped, Habitacion habitacion, LocalDate fechaIngreso, LocalDate fechaSalida, int cantPersonas, boolean estado) {
        this.idReserva = idReserva;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.cantDias = (int) DAYS.between(fechaIngreso, fechaSalida);
        this.cantPersonas = cantPersonas;
        this.precioTotal = cantDias*habitacion.getTipoHabitacion().getPrecio();
        this.estado = estado;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reserva Nro. " + idReserva 
                + "\nHuesped: " + huesped.getApellido() + ", " + huesped.getNombre() 
                + "\nHabitacion Nro. " + habitacion.getNum() 
                + "\nCantidad de Personas: " + cantPersonas 
                + "\nFecha de Ingreso: " + fechaIngreso 
                + "\nFecha de Salida: " + fechaSalida 
                + "\nCantidad de Dias: " + cantDias
                + "\nPrecio por Dia: $ " + habitacion.getTipoHabitacion().getPrecio()
                + "\nPrecio Total: $ " + precioTotal 
                + "\nEstado: " + (estado==true ? "Activa" : "Inactiva");
    }
    
    
    
}
