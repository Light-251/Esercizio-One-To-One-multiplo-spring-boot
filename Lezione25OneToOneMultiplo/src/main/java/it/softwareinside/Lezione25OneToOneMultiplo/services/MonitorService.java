package it.softwareinside.Lezione25OneToOneMultiplo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.softwareinside.Lezione25OneToOneMultiplo.models.Monitor;
import it.softwareinside.Lezione25OneToOneMultiplo.repository.MonitorRepo;
import jakarta.validation.Valid;

@Service
public class MonitorService {
    @Autowired
    MonitorRepo monitorRepo;

    /**
     * Aggiunge un monitor al DB
     * 
     * @param monitor
     * @return
     */
    public String addMonitor(@Valid Monitor monitor) {
        try {
            monitorRepo.save(monitor);
            return "Monitor aggiunto";
        } catch (Exception e) {
            return "Monitor NON aggiunto";
        }
    }

    /**
     * Ritorna la lista di tutti i monitor nel DB
     * 
     * @return
     */
    public Iterable<Monitor> getAllMonitor() {
        try {
            return monitorRepo.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Rimuove tutti i monitor dal DB
     * 
     * @param id
     * @return
     */
    public Monitor deleteMonitorById(int id) {
        try {
            Monitor monitorRimosso = monitorRepo.findById(id).get();
            monitorRepo.deleteById(id);
            return monitorRimosso;
        } catch (Exception e) {
            System.err.println("ERRORE RIMOZIONE MONITOR: " + e);
            return null;
        }
    }

    /**
     * Rimuove tutti monitor dal DB
     * 
     * @return
     */
    public boolean deleteAllMonitor() {
        try {
            monitorRepo.deleteAll();
            ;
            return true;
        } catch (Exception e) {
            System.err.println("ERRORE RIMOZIONE TUTTI I MONITOR: " + e);
            return false;
        }
    }

    /**
     * Ritorna un monitor presente nel DB
     * 
     * @param id
     * @return
     */
    public Monitor getMonitorById(int id) {
        try {
            return monitorRepo.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

}