
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String alergico, String especial, 
            String nombreDuenio, String celDuenio, String observaciones) {
        
        // Creamos al duenio y asignamos sus valores
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelular(celDuenio);
        
        // Creamos la mascota y asignamos sus valores
        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencionEspecial(especial);
        masco.setObservaciones(observaciones);
        masco.setDuenio(duenio);
        
        controlPersis.guardar(duenio, masco);
    }

    

    public List<Mascota> traerMascotas() {
       return controlPersis.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
       controlPersis.borrarMascota(num_cliente);
    }

    public Mascota traerUnaMascota(int num_cliente) {
       return controlPersis.traerUnaMascota(num_cliente);
    }
    
    
    public void actualizarMascota(Mascota mascota,String nombreMasco, String raza,String color,String alergico,String especial,String observaciones, String nombreDuenio, String celDuenio){
        
        // Seteando los nuevos datos a modificar de la mascota
        mascota.setNombre(nombreMasco);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setAlergico(alergico);
        mascota.setAtencionEspecial(especial);
        mascota.setObservaciones(observaciones);
        
        //Editando la mascota
        controlPersis.actualizarMascota(mascota);
        
        // Seteo nuevos valores del duenio
        Duenio duenio = this.buscarDuenio(mascota.getDuenio().getId_duenio());
        duenio.setNombre(nombreDuenio);
        duenio.setCelular(celDuenio);
        
        //Editando al duenio
        this.modificarDuenio(duenio);
    }
    



    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
        controlPersis.actualizarDuenio(duenio);
    }
    
    
    

   
}
