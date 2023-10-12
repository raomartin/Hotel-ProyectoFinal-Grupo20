/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.proyectofinal.grupo20;

import hotel.proyectofinal.grupo20.AccesoADatos.Conexion;
import hotel.proyectofinal.grupo20.AccesoADatos.HabitacionData;
import hotel.proyectofinal.grupo20.AccesoADatos.HuespedData;
import hotel.proyectofinal.grupo20.AccesoADatos.ReservaData;
import hotel.proyectofinal.grupo20.AccesoADatos.TipoHabitacionData;
import hotel.proyectofinal.grupo20.Entidades.Habitacion;
import hotel.proyectofinal.grupo20.Entidades.Huesped;
import hotel.proyectofinal.grupo20.Entidades.Reserva;
import hotel.proyectofinal.grupo20.Entidades.TipoCama;
import hotel.proyectofinal.grupo20.Entidades.TipoHabitacion;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author marti
 */
public class HotelProyectoFinalGrupo20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        Connection con = Conexion.getConexion();
        
        HuespedData hd = new HuespedData();
//        hd.guardarHuesped(new Huesped(34771759, "Rao", "Martin", "Av. Siempre viva 123", "martin.rao@hotmail.com", 123456789));
//        hd.guardarHuesped(new Huesped(38794649, "Schiaverano", "Michelle", "Libertad 123", "Michelle@hotmail.com", 123456789));
//        hd.guardarHuesped(new Huesped(20622354, "Merlo", "Ruben", "Zapiola 123", "Ruben@hotmail.com", 123456789));
//        hd.guardarHuesped(new Huesped(12345678, "Miranda", "Enzo", "Av. Siempre viva 123", "enzo.miranda@hotmail.com", 123456789));
//        hd.modificarHuesped(new Huesped(34771759, "Rao", "Martin", "Cochabamba 123", "martin@hotmail.com", 123456789));
//        hd.modificarHuesped(new Huesped(12345678, "Miranda", "Enzo", "Av. Curupaiti 123", "enzo.miranda@hotmail.com", 123456789));
//        System.out.println(hd.buscarHuespedPorDni(38794649));
//        List<Huesped> huespedes = hd.listarHistorialDeHuespedes();
//        for(Huesped huesped : huespedes){
//            System.out.println(huesped);
//        }
        
        TipoHabitacionData thd = new TipoHabitacionData();
//        thd.guardarTipoHabitacion(new TipoHabitacion(1, 1, TipoCama.SIMPLE, 9500.00));
//        thd.guardarTipoHabitacion(new TipoHabitacion(2, 2, TipoCama.SIMPLE, 16500.00));
//        thd.guardarTipoHabitacion(new TipoHabitacion(2, 1, TipoCama.QUEEN, 15000.00));
//        thd.guardarTipoHabitacion(new TipoHabitacion(2, 1, TipoCama.KING_SIZE, 16000.00));
//        thd.guardarTipoHabitacion(new TipoHabitacion(3, 3, TipoCama.SIMPLE, 27500.00));
//        thd.guardarTipoHabitacion(new TipoHabitacion(3, 2, TipoCama.QUEEN, 25000.00));
//        thd.guardarTipoHabitacion(new TipoHabitacion(4, 4, TipoCama.SIMPLE, 36000.00));
//        thd.guardarTipoHabitacion(new TipoHabitacion(4, 2, TipoCama.KING_SIZE, 30000.00));
//        System.out.println(thd.buscarTipoHabitacion(2));
//        thd.cambiarPrecio(2, 17500.00);
//        thd.cambiarPrecio(new TipoHabitacion(4, 2, 1, TipoCama.KING_SIZE, 16500.00));
//        List<TipoHabitacion> tipos = thd.listarTiposDeHabitaciones();
//        for(TipoHabitacion th : tipos){
//            System.out.println(th);
//        }
//        List<TipoHabitacion> tipos = thd.listarTipoHabitacion(2);
//        for(TipoHabitacion th : tipos){
//            System.out.println(th);
//        }
        
        HabitacionData habData = new HabitacionData();
//        habData.guardarHabitacion(new Habitacion(false, thd.buscarTipoHabitacionPorCodigo(1)));
//        habData.guardarHabitacion(new Habitacion(false, thd.buscarTipoHabitacionPorCodigo(1)));
//        habData.guardarHabitacion(new Habitacion(false, thd.buscarTipoHabitacionPorCodigo(2)));
//        habData.guardarHabitacion(new Habitacion(false, thd.buscarTipoHabitacionPorCodigo(3)));
//        habData.guardarHabitacion(new Habitacion(false, thd.buscarTipoHabitacionPorCodigo(4)));
//        habData.guardarHabitacion(new Habitacion(false, thd.buscarTipoHabitacionPorCodigo(5)));
//        habData.guardarHabitacion(new Habitacion(false, thd.buscarTipoHabitacionPorCodigo(6)));
//        habData.guardarHabitacion(new Habitacion(false, thd.buscarTipoHabitacionPorCodigo(7)));
//        habData.guardarHabitacion(new Habitacion(false, thd.buscarTipoHabitacionPorCodigo(8)));
//        habData.modificarHabitacion(new Habitacion(1, true, thd.buscarTipoHabitacionPorCodigo(1)));
//        habData.modificarHabitacion(new Habitacion(3, true, thd.buscarTipoHabitacionPorCodigo(2)));
//        habData.modificarHabitacion(new Habitacion(5, true, thd.buscarTipoHabitacionPorCodigo(4)));
//        habData.modificarHabitacion(new Habitacion(7, true, thd.buscarTipoHabitacionPorCodigo(6)));
//        habData.modificarHabitacion(new Habitacion(9, true, thd.buscarTipoHabitacionPorCodigo(8)));
//        List<Habitacion> habitaciones = habData.listarHabitaciones();
//        for(Habitacion hab : habitaciones){
//            System.out.println(hab);
//        }
//        List<Habitacion> habitaciones = habData.listarDisponibles();
//        for(Habitacion hab : habitaciones){
//            System.out.println(hab);
//        }
//        System.out.println("Hay " + habData.cantidadHabiSegunTipo(2) + " habitaciones para 2 personas.");
//        System.out.println("Disponibles las siguientes: ");
//        List<Habitacion> habitaciones = habData.listarPorCantidadPersonas(2);
//        for(Habitacion hab : habitaciones){
//            System.out.println(hab);
//        }
//        System.out.println(habData.buscarHabitacion(1));
        
        ReservaData resData = new ReservaData();
//        resData.crearReserva(new Reserva(hd.buscarHuespedPorDni(34771759), habData.buscarHabitacion(2), 
//            LocalDate.now(), LocalDate.now().plusDays(4), 1, true));
//        resData.crearReserva(new Reserva(hd.buscarHuespedPorDni(20622354), habData.buscarHabitacion(6), 
//            LocalDate.now(), LocalDate.now().plusDays(2), 4, true));
//        resData.crearReserva(new Reserva(hd.buscarHuespedPorDni(38794649), habData.buscarHabitacion(4), 
//            LocalDate.now(), LocalDate.now().plusDays(3), 3, true));
//        System.out.println(resData.buscarPorId(1));
//        System.out.println(resData.buscarPorDni(20622354));
//        System.out.println(resData.buscarPorFecha(LocalDate.now()));
//        resData.cancelarReserva(1);
        
        
    }
    
}
