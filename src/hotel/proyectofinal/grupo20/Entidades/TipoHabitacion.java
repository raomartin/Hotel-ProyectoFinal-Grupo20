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
public class TipoHabitacion {
    private int codigo;
    private int maxPersonas;
    private int cantCamas;
    private TipoCama tipoDeCama;
    private double precio;

    public TipoHabitacion() {
    }

    public TipoHabitacion(int codigo, int maxPersonas, int cantCamas, TipoCama tipoDeCama, double precio) {
        this.codigo = codigo;
        this.maxPersonas = maxPersonas;
        this.cantCamas = cantCamas;
        this.tipoDeCama = tipoDeCama;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getMaxPersonas() {
        return maxPersonas;
    }

    public void setMaxPersonas(int maxPersonas) {
        this.maxPersonas = maxPersonas;
    }

    public int getCantCamas() {
        return cantCamas;
    }

    public void setCantCamas(int cantCamas) {
        this.cantCamas = cantCamas;
    }

    public TipoCama getTipoDeCama() {
        return tipoDeCama;
    }

    public void setTipoDeCama(TipoCama tipoDeCama) {
        this.tipoDeCama = tipoDeCama;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return (codigo==1 ? "Habitacion Simple, " : codigo==2 ? "Habitacion Doble, " : codigo == 3 ? "Habitacion Triple, " : "Suite de Lujo, ")
        + "maximo " + maxPersonas + " personas, tiene " + cantCamas + " camas, todas tipo " + tipoDeCama + ". Precio: $ " + precio;
    }
    
    
    
}
