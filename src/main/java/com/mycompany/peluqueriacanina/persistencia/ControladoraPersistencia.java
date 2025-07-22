
package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascoJpa = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota masco) {
        // crear en la BD el duenio
       duenioJpa.create(duenio);
       
        // crear en la BD la mascota
       mascoJpa.create(masco);
    }

  

    public List<Mascota> traerMascotas() {
       return mascoJpa.findMascotaEntities();
    }

    public void borrarMascota(int num_cliente) {
        try {
            mascoJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mascota traerUnaMascota(int num_cliente) {
       return mascoJpa.findMascota(num_cliente);
    }
    
    public void actualizarMascota(Mascota mascota){
        try{
            mascoJpa.edit(mascota);
        }catch (Exception exc) {
        // TODO: handle exception
        }
    
    }

    public void actualizarDuenio(Duenio duenio) {
         try{
            duenioJpa.edit(duenio);
        }catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Duenio traerDuenio(int id_duenio) {
        return duenioJpa.findDuenio(id_duenio);
    }

   
    
    
}
