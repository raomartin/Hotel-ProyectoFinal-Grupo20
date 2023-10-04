/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.proyectofinal.grupo20.Entidades;

/**
 *
 * @author marti
 */
public class Habitacion {
    private int num;
    private boolean ocupada;
    private TipoHabitacion tipoHabitacion;

    public Habitacion() {
    }

    public Habitacion(boolean ocupada, TipoHabitacion tipoHabitacion) {
        this.ocupada = ocupada;
        this.tipoHabitacion = tipoHabitacion;
    }

    public Habitacion(int num, boolean ocupada, TipoHabitacion tipoHabitacion) {
        this.num = num;
        this.ocupada = ocupada;
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    @Override
    public String toString() {
        return "Habitacion Nro: " + num 
                + (ocupada==false ? ", Libre. " : ", Ocupada. ") 
                + tipoHabitacion;
    }
    
    
    
}
