package it.softwareinside.Lezione25OneToOneMultiplo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.softwareinside.Lezione25OneToOneMultiplo.models.Computer;
import it.softwareinside.Lezione25OneToOneMultiplo.repository.ComputerRepo;
import jakarta.validation.Valid;

@Service
public class ComputerService {
    @Autowired
    ComputerRepo computerRepo;

    /**
     * Aggiunge unComputer al DB
     * 
     * @param persona
     * @return
     */
    public String addComputer(@Valid Computer computer) {
        try {
            computerRepo.save(computer);
            return "Computer Aggiunto.";
        } catch (Exception e) {
            return "Computer NON Aggiunto.";
        }
    }

    /**
     * Ritorna la lista di tutti i computer nel DB
     * 
     * @return
     */
    public Iterable<Computer> getAllComputer() {
        try {
            return computerRepo.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Rimuove tutti i computer dal DB
     * 
     * @param id
     * @return
     */
    public Computer deleteComputerById(int id) {
        try {
            Computer computerRimosso = computerRepo.findById(id).get();
            computerRepo.deleteById(id);
            return computerRimosso;
        } catch (Exception e) {
            System.err.println("ERRORE RIMOZIONE COMPUTER: " + e);
            return null;
        }
    }

    /**
     * Rimuove tutti i computer dal DB
     * 
     * @return
     */
    public boolean deleteAllComputer() {
        try {
            computerRepo.deleteAll();
            ;
            return true;
        } catch (Exception e) {
            System.err.println("ERRORE RIMOZIONE TUTTI COMPUTER: " + e);
            return false;
        }
    }

    /**
     * Ritorna un Computer tramite id
     * 
     * @param id
     * @return
     */
    public Computer getComputerById(int id) {
        try {
            return computerRepo.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }
}
